package com.xzm.video.aop;

import com.xzm.video.annotation.MyLock;
import com.xzm.video.constant.LockName;
import com.xzm.video.constant.LockType;
import com.xzm.video.utils.LockMap;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MemberSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-15 9:49
 */

@Aspect
@Component
public class MyLockAspect {

    @Around(value = "@annotation(com.xzm.video.annotation.MyLock)")
    public Object handler(ProceedingJoinPoint joinPoint) throws Throwable {
        //通过反射得到注解对象
        Signature signature = joinPoint.getSignature();
        Method method = ((MethodSignature) signature).getMethod();
        Method declaredMethod = joinPoint.getTarget().getClass().getDeclaredMethod(signature.getName(), method.getParameterTypes());
        MyLock annotation = declaredMethod.getAnnotation(MyLock.class);
        //获得锁的种类
        LockType type = annotation.type();
        LockName name = annotation.name();

        Map<LockName, ReentrantReadWriteLock> lockMap = LockMap.getLockMap();

        ReentrantReadWriteLock readWriteLock = lockMap.get(name);
        Object proceed=null;
        if(type==LockType.READ){
            ReentrantReadWriteLock.ReadLock lock = readWriteLock.readLock();
            System.out.println("加读锁");
            lock.lock();
            proceed = joinPoint.proceed();
            lock.unlock();
            System.out.println("释放读锁");
        }else{
            ReentrantReadWriteLock.WriteLock lock = readWriteLock.writeLock();
            System.out.println("加写锁");
            lock.lock();
            proceed = joinPoint.proceed();
            lock.unlock();
            System.out.println("释放写锁");
        }
        return proceed;
    }
}
