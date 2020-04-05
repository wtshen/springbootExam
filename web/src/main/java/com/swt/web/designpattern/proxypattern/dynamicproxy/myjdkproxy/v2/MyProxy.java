package com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v2;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 8:09 PM 2020/4/4.
 * @Modified By:
 */
public class MyProxy {
    public static Object newProxyInstant(JavaClassLoader classLoader,
                                         Class<?> classInfo,
                                         JDKInvocationHandlerService jdkInvocationHandlerService) {
        // 1.拼接代理类的源代码
        Method[] methods = classInfo.getMethods();
        String proxyClass = "package com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v2.proxy;\n" +
                "import java.lang.reflect.Method;\n" +
                "import com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v2.JDKInvocationHandlerService;\n" +
                "import com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v2.OrderService;\n" +
                "/**\n" +
                " * @Author: wtshen\n" +
                " * @Description:\n" +
                " * @Date: Created in 4:13 PM 2020/4/4.\n" +
                " * @Modified By:\n" +
                " */\n" +
                "public class $Proxy0 implements OrderService {\n" +
                "    JDKInvocationHandlerService h;\n" +
                "    public $Proxy0(JDKInvocationHandlerService h) {\n" +
                "        this.h = h;\n" +
                "    }" + getMethodString(methods, classInfo) + "}";

        try {
            // 2.写入到本地文件中
            String fileName = "/Users/wtshen/MyProject/springbootExam/web/src/main/java/com/swt/web/designpattern/proxypattern/dynamicproxy/myjdkproxy/v2/proxy/$Proxy0.java";
            File f = new File(fileName);
            FileWriter fw = new FileWriter(f);
            fw.write(proxyClass);
            fw.flush();
            fw.close();

            // 3.使用javaCompile编译$Proxy0源代码 获取class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileManager.getJavaFileObjects(fileName);
            JavaCompiler.CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
            t.call();
            fileManager.close();

            // 4. 使用ClassLoader将$Proxy0.class 读取到内存中
            Class<?> $Proxy0 = classLoader.loadClass("com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v2.proxy.$Proxy0");

            // 5. 指明初始化有参构造函数
            Constructor<?> constructor = $Proxy0.getConstructor(JDKInvocationHandlerService.class);
            Object o = constructor.newInstance(jdkInvocationHandlerService);
            return o;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getMethodString(Method[] methods, Class<?> classInfo) {
        String proxyMe = "";
        for (Method method : methods) {
            proxyMe += "\n@Override\n";
            proxyMe += "public void " + method.getName() + "() throws Throwable {\n" +
                    "        Method method = " + classInfo.getName() + ".class.getMethod(\"" + method.getName() + "\", new Class[]{});\n" +
                    "        this.h.invoke(this, method, null);\n" +
                    "    }";
        }
        return proxyMe;
    }
}
