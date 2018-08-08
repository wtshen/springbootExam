package com.swt.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 上午7:53 18/8/8.
 * @Modified By:
 */
public class NIOServer implements Runnable {

    /**
     * 多路复用器,选择器.用于注册通道
     */
    private Selector selector;

    /**
     * 定义了两个缓存,分别用于读和写,初始化空间大小单位为字节
     */
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    public NIOServer(int port) {
        init(port);
    }

    private void init(int port) {
        try {
            System.out.println("server starting at port " + port + "...");
            // 打开多路复用器
            this.selector = Selector.open();
            // 开启服务器通道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 通道设置为非阻塞,如果传递参数为true则为阻塞模式
            serverSocketChannel.configureBlocking(false);
            // 绑定端口
            serverSocketChannel.bind(new InetSocketAddress(port));
            /**
             * 注册,并标记当前服务器通道状态
             * register(selector, int)
             * int - 状态编码
             * OP_ACCEPT : 链接成功的标记位
             * OP_READ : 可以读取数据的标记
             * OP_WRITE : 可以写入数据的标记
             * OP_CONNECT : 链接建立后的标记
             */
            serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT);
            System.out.println("server started.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new NIOServer(9999)).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 阻塞方法,当至少有一个通道被选中,词方法返回
                // 通道是否选择,由注册到多路复用器中的通道标记决定.
                this.selector.select();
                // 返回已选中的通道标记集合,集合中保存的是通道的标记,相当于通道的ID
                Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    SelectionKey key = keys.next();
                    // 将本次要处理的通道从集合中删除,下次循环根据行的通道列表再次执行必要的业务逻辑
                    keys.remove();
                    // 通道是否有效
                    if (key.isValid()) {
                        // 阻塞状态
                        try {
                            if (key.isAcceptable()) {
                                accept(key);
                            }
                        } catch (CancelledKeyException cke) {
                            // 断开链接
                            key.cancel();
                        }
                        // 可读状态
                        try {
                            if (key.isReadable()) {
                                read(key);
                            }
                        } catch (CancelledKeyException cke) {
                            key.cancel();
                        }
                        // 可写状态
                        try {
                            if (key.isWritable()) {
                                write(key);
                            }
                        } catch (CancelledKeyException cke) {
                            key.cancel();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void write(SelectionKey key) {
        this.writeBuffer.clear();
        SocketChannel channel = (SocketChannel) key.channel();
        Scanner reader = new Scanner(System.in);
        try {
            System.out.println("put message for send to client > ");
            String line = reader.nextLine();
            // 将控制台输入的字符串写入Buffer中,写入的数据是一个字节数组
            writeBuffer.put(line.getBytes("UTF-8"));
            writeBuffer.flip();
            channel.register(this.selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read(SelectionKey key) {
        try {
            // 清空读缓存
            this.readBuffer.clear();
            // 获取通道
            SocketChannel channel = (SocketChannel) key.channel();
            // 将通道中的数据读取到缓存中,通道中的数据,就是客户端发送给服务器的数据
            int readLength = channel.read(readBuffer);
            // 检查客户端是否有写入数据
            if (readLength == -1) {
                // 关闭通道
                key.channel().close();
                // 关闭链接
                key.cancel();
                return;
            }
            /**
             * flip,NIO中最负责的操作就是Buffer的控制
             * Buffer中有一个游标,游标信息在操作后不会归零,如果字节访问Buffer大的话,数据有不一致的可能.
             * flip是重置游标的方法,NIO编程中,flip方法是常用方法
             */
            this.readBuffer.flip();
            // 字节数据,保存具体数据的.Buffer.remaining() -> 是获取Buffer中有效数据长度的方法
            byte[] datas = new byte[readBuffer.remaining()];
            // 将Buffer中的有效数据保存到字节数组中
            readBuffer.get(datas);
            System.out.println("from " + channel.getRemoteAddress() + " client : " + new String(datas, "UTF-8"));

            // 注册通道,标记为可写操作
            channel.register(this.selector, SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                key.channel().close();
                key.cancel();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void accept(SelectionKey key) {
        try {
            // 此通道为init方法中注册到selector上的ServerSocketChannel
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            // 阻塞方法,当客户端发起请求后返回,此通道和客户端一一对应.
            SocketChannel channel = serverSocketChannel.accept();
            channel.configureBlocking(false);
            // 设置对应客户端的通道标记状态,此通道为读取数据使用的
            channel.register(this.selector,SelectionKey.OP_READ);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
