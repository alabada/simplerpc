package com.wenzhd.simprpc.rpcserver;

import com.wenzhd.simprpc.api.service.ProductService;
import com.wenzhd.simprpc.rpcserver.service.impl.ProductServiceImpl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author wenzhd
 * @Date 2019/10/12
 * @Description rpc服务提供
 */
public class ServerMain {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                    // 读取网络协议
                    String apiClassName = objectInputStream.readUTF();
                    String methodName = objectInputStream.readUTF();
                    Class[] parameterTypes = (Class[]) objectInputStream.readObject();
                    Object[] args4Method = (Object[]) objectInputStream.readObject();

                    Class clazz = null;

                    if (apiClassName.equals(ProductService.class.getName())) {
                        clazz = ProductServiceImpl.class;
                    }

                    Method method = clazz.getMethod(methodName, parameterTypes);
                    clazz.newInstance();
                    Object invoke = method.invoke(clazz.newInstance(), args4Method);

                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject(invoke);
                    objectOutputStream.flush();

                    objectInputStream.close();
                    objectOutputStream.close();
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
