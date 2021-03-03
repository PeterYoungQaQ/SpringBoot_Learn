package net.peter.sp.proxy;
/*
 * @Author: Haoran
 * @Date: 2021/3/3 9:30
 * @Description: 动态代理
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

    private Object targetObject;

    /**
     * 代理类和实际类绑定关系
     * @return
     */
    public Object newProxyInstance(Object targetObject){

        this.targetObject = targetObject;

        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;
        try{
            System.out.println("通过jdkproxy进行调用" + method.getName());
            result = method.invoke(targetObject, args);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
