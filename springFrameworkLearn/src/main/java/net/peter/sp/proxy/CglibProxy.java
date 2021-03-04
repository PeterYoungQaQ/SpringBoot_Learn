package net.peter.sp.proxy;
/*
 * @Author: Haoran
 * @Date: 2021/3/4 8:48
 * @Description: cglib动态代理
 */

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    //目标类
    private Object targetObject;

    //绑定关系

    public Object newProxyInstance(Object targetObject){

        this.targetObject = targetObject;
        //设置代理类的父类（目标类）
        Enhancer enhancer = new Enhancer();
        //设置回调函数
        enhancer.setSuperclass(this.targetObject.getClass());
        enhancer.setCallback(this);
        //创建子类（代理对象）
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        Object result = null;
        try {
            System.out.println("使用cglib进行动态代理" + method.getName());
            result = methodProxy.invokeSuper(o, args);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
