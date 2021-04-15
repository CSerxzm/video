package com.xzm.video.annotation;

import com.xzm.video.constant.LockName;
import com.xzm.video.constant.LockType;

import java.lang.annotation.*;

/**
 * @author xiangzhimin
 * @Description  自定义注解实现读写锁
 * @create 2021-04-15 9:37
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyLock {

    LockName name();//锁的类型

    LockType type();//锁的名字

}
