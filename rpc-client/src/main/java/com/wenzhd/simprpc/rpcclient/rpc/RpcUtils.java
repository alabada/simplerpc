package com.wenzhd.simprpc.rpcclient.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @Author wenzhd
 * @Date 2019/10/12
 * @Description Rpc调用类
 */
public class RpcUtils {

    public static Object rpcInvoke(final Class clazz) {

        // 使用动态代理 在客户端调用远程方法时，默认调用以下invoke方法
        return Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz}, new InvocationHandler() {

                    // 以下invoke本质 - socket通信
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        String apiClassName = clazz.getName();
                        String methodName = method.getName();
                        Class[] parameterTypes = method.getParameterTypes();

                        Socket socket = new Socket("127.0.0.1", 8888);

                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        objectOutputStream.writeUTF(apiClassName);
                        objectOutputStream.writeUTF(methodName);
                        objectOutputStream.writeObject(parameterTypes);
                        objectOutputStream.writeObject(args);
                        objectOutputStream.flush();

                        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                        Object o = objectInputStream.readObject();
                        objectInputStream.close();
                        objectOutputStream.close();

                        socket.close();
                        return o;
                    }
                }
        );
    }
}
