1.JPS --找到用户进程
2.Jstack PID > xxx.txt
查询 deadlock 关键字

2020-05-16 22:34:00
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.121-b13 mixed mode):

"RMI TCP Connection(2)-192.168.1.5" #21 daemon prio=9 os_prio=31 tid=0x00007fcc7e041000 nid=0xa103 runnable [0x000070000a056000]
   java.lang.Thread.State: RUNNABLE
	at java.net.SocketInputStream.socketRead0(Native Method)
	at java.net.SocketInputStream.socketRead(SocketInputStream.java:116)
	at java.net.SocketInputStream.read(SocketInputStream.java:171)
	at java.net.SocketInputStream.read(SocketInputStream.java:141)
	at java.io.BufferedInputStream.fill(BufferedInputStream.java:246)
	at java.io.BufferedInputStream.read(BufferedInputStream.java:265)
	- locked <0x000000076c0c31d0> (a java.io.BufferedInputStream)
	at java.io.FilterInputStream.read(FilterInputStream.java:83)
	at sun.rmi.transport.tcp.TCPTransport.handleMessages(TCPTransport.java:550)
	at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run0(TCPTransport.java:826)
	at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.lambda$run$0(TCPTransport.java:683)
	at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler$$Lambda$3/69510491.run(Unknown Source)
	at java.security.AccessController.doPrivileged(Native Method)
	at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run(TCPTransport.java:682)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"JMX server connection timeout 20" #20 daemon prio=9 os_prio=31 tid=0x00007fcc7e948800 nid=0x5d03 in Object.wait() [0x0000700009f54000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at com.sun.jmx.remote.internal.ServerCommunicatorAdmin$Timeout.run(ServerCommunicatorAdmin.java:168)
	- locked <0x000000076bc1fb20> (a [I)
	at java.lang.Thread.run(Thread.java:745)

"RMI Scheduler(0)" #19 daemon prio=9 os_prio=31 tid=0x00007fcc7e948000 nid=0xa203 waiting on condition [0x0000700009e51000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000076b7efa50> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1093)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"RMI TCP Connection(1)-192.168.1.5" #18 daemon prio=9 os_prio=31 tid=0x00007fcc7c9ea000 nid=0xa303 runnable [0x0000700009d4d000]
   java.lang.Thread.State: RUNNABLE
	at java.net.SocketInputStream.socketRead0(Native Method)
	at java.net.SocketInputStream.socketRead(SocketInputStream.java:116)
	at java.net.SocketInputStream.read(SocketInputStream.java:171)
	at java.net.SocketInputStream.read(SocketInputStream.java:141)
	at java.io.BufferedInputStream.fill(BufferedInputStream.java:246)
	at java.io.BufferedInputStream.read(BufferedInputStream.java:265)
	- locked <0x000000076bbaa648> (a java.io.BufferedInputStream)
	at java.io.FilterInputStream.read(FilterInputStream.java:83)
	at sun.rmi.transport.tcp.TCPTransport.handleMessages(TCPTransport.java:550)
	at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run0(TCPTransport.java:826)
	at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.lambda$run$0(TCPTransport.java:683)
	at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler$$Lambda$3/69510491.run(Unknown Source)
	at java.security.AccessController.doPrivileged(Native Method)
	at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run(TCPTransport.java:682)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"RMI TCP Accept-0" #17 daemon prio=9 os_prio=31 tid=0x00007fcc7e918800 nid=0xa403 runnable [0x0000700009c4b000]
   java.lang.Thread.State: RUNNABLE
	at java.net.PlainSocketImpl.socketAccept(Native Method)
	at java.net.AbstractPlainSocketImpl.accept(AbstractPlainSocketImpl.java:409)
	at java.net.ServerSocket.implAccept(ServerSocket.java:545)
	at java.net.ServerSocket.accept(ServerSocket.java:513)
	at sun.management.jmxremote.LocalRMIServerSocketFactory$1.accept(LocalRMIServerSocketFactory.java:52)
	at sun.rmi.transport.tcp.TCPTransport$AcceptLoop.executeAcceptLoop(TCPTransport.java:400)
	at sun.rmi.transport.tcp.TCPTransport$AcceptLoop.run(TCPTransport.java:372)
	at java.lang.Thread.run(Thread.java:745)

"Attach Listener" #15 daemon prio=9 os_prio=31 tid=0x00007fcc7d10c800 nid=0x4c0b waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"DestroyJavaVM" #14 prio=5 os_prio=31 tid=0x00007fcc7d10f000 nid=0x1003 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"t3" #13 prio=5 os_prio=31 tid=0x00007fcc7c0c7000 nid=0xa703 waiting for monitor entry [0x0000700009a45000]
   java.lang.Thread.State: BLOCKED (on object monitor)
	at com.swt.jvm.deadlock.DeadLockDemo.run(DeadLockDemo.java:25)
	- waiting to lock <0x000000076adec848> (a java.lang.Object)
	- locked <0x000000076adec868> (a java.lang.Object)
	at java.lang.Thread.run(Thread.java:745)

"t2" #12 prio=5 os_prio=31 tid=0x00007fcc7b0aa800 nid=0x5803 waiting for monitor entry [0x0000700009942000]
   java.lang.Thread.State: BLOCKED (on object monitor)
	at com.swt.jvm.deadlock.DeadLockDemo.run(DeadLockDemo.java:25)
	- waiting to lock <0x000000076adec868> (a java.lang.Object)
	- locked <0x000000076adec858> (a java.lang.Object)
	at java.lang.Thread.run(Thread.java:745)

"t1" #11 prio=5 os_prio=31 tid=0x00007fcc7d10b800 nid=0x5703 waiting for monitor entry [0x000070000983f000]
   java.lang.Thread.State: BLOCKED (on object monitor)
	at com.swt.jvm.deadlock.DeadLockDemo.run(DeadLockDemo.java:25)
	- waiting to lock <0x000000076adec858> (a java.lang.Object)
	- locked <0x000000076adec848> (a java.lang.Object)
	at java.lang.Thread.run(Thread.java:745)

"Monitor Ctrl-Break" #10 daemon prio=5 os_prio=31 tid=0x00007fcc7a8b7800 nid=0x5503 runnable [0x000070000973c000]
   java.lang.Thread.State: RUNNABLE
	at java.net.PlainSocketImpl.socketAccept(Native Method)
	at java.net.AbstractPlainSocketImpl.accept(AbstractPlainSocketImpl.java:409)
	at java.net.ServerSocket.implAccept(ServerSocket.java:545)
	at java.net.ServerSocket.accept(ServerSocket.java:513)
	at com.intellij.rt.execution.application.AppMain$1.run(AppMain.java:90)
	at java.lang.Thread.run(Thread.java:745)

"Service Thread" #9 daemon prio=9 os_prio=31 tid=0x00007fcc7b008800 nid=0x4003 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C1 CompilerThread3" #8 daemon prio=9 os_prio=31 tid=0x00007fcc7c00e800 nid=0x4103 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread2" #7 daemon prio=9 os_prio=31 tid=0x00007fcc7c00e000 nid=0x4303 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread1" #6 daemon prio=9 os_prio=31 tid=0x00007fcc7c818000 nid=0x3a03 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread0" #5 daemon prio=9 os_prio=31 tid=0x00007fcc7c816800 nid=0x4503 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Signal Dispatcher" #4 daemon prio=9 os_prio=31 tid=0x00007fcc7c80d000 nid=0x4703 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Finalizer" #3 daemon prio=8 os_prio=31 tid=0x00007fcc7c812800 nid=0x4f03 in Object.wait() [0x0000700008e1e000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x000000076ab08ec8> (a java.lang.ref.ReferenceQueue$Lock)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
	- locked <0x000000076ab08ec8> (a java.lang.ref.ReferenceQueue$Lock)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:164)
	at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:209)

"Reference Handler" #2 daemon prio=10 os_prio=31 tid=0x00007fcc7c810000 nid=0x3203 in Object.wait() [0x0000700008d1b000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x000000076ab06b68> (a java.lang.ref.Reference$Lock)
	at java.lang.Object.wait(Object.java:502)
	at java.lang.ref.Reference.tryHandlePending(Reference.java:191)
	- locked <0x000000076ab06b68> (a java.lang.ref.Reference$Lock)
	at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:153)

"VM Thread" os_prio=31 tid=0x00007fcc7a833000 nid=0x5103 runnable 

"GC task thread#0 (ParallelGC)" os_prio=31 tid=0x00007fcc7a80c800 nid=0x1907 runnable 

"GC task thread#1 (ParallelGC)" os_prio=31 tid=0x00007fcc7e009000 nid=0x1b03 runnable 

"GC task thread#2 (ParallelGC)" os_prio=31 tid=0x00007fcc7e009800 nid=0x1d03 runnable 

"GC task thread#3 (ParallelGC)" os_prio=31 tid=0x00007fcc7e00a000 nid=0x2a03 runnable 

"GC task thread#4 (ParallelGC)" os_prio=31 tid=0x00007fcc7e00a800 nid=0x5403 runnable 

"GC task thread#5 (ParallelGC)" os_prio=31 tid=0x00007fcc7e00b800 nid=0x5303 runnable 

"GC task thread#6 (ParallelGC)" os_prio=31 tid=0x00007fcc7e00c000 nid=0x2e03 runnable 

"GC task thread#7 (ParallelGC)" os_prio=31 tid=0x00007fcc7e00c800 nid=0x2f03 runnable 

"VM Periodic Task Thread" os_prio=31 tid=0x00007fcc7b026800 nid=0x3f03 waiting on condition 

JNI global references: 374


Found one Java-level deadlock:
=============================
"t3":
  waiting to lock monitor 0x00007fcc7e815958 (object 0x000000076adec848, a java.lang.Object),
  which is held by "t1"
"t1":
  waiting to lock monitor 0x00007fcc7e814408 (object 0x000000076adec858, a java.lang.Object),
  which is held by "t2"
"t2":
  waiting to lock monitor 0x00007fcc7e812eb8 (object 0x000000076adec868, a java.lang.Object),
  which is held by "t3"

Java stack information for the threads listed above:
===================================================
"t3":
	at com.swt.jvm.deadlock.DeadLockDemo.run(DeadLockDemo.java:25)
	- waiting to lock <0x000000076adec848> (a java.lang.Object)
	- locked <0x000000076adec868> (a java.lang.Object)
	at java.lang.Thread.run(Thread.java:745)
"t1":
	at com.swt.jvm.deadlock.DeadLockDemo.run(DeadLockDemo.java:25)
	- waiting to lock <0x000000076adec858> (a java.lang.Object)
	- locked <0x000000076adec848> (a java.lang.Object)
	at java.lang.Thread.run(Thread.java:745)
"t2":
	at com.swt.jvm.deadlock.DeadLockDemo.run(DeadLockDemo.java:25)
	- waiting to lock <0x000000076adec868> (a java.lang.Object)
	- locked <0x000000076adec858> (a java.lang.Object)
	at java.lang.Thread.run(Thread.java:745)

Found 1 deadlock.

