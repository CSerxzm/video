package com.xzm.video.annotation;

import com.xzm.video.constant.LockName;
import com.xzm.video.constant.LockType;

import java.lang.annotation.*;

/**
 * @author xiangzhimin
 * @Description 点击量的自增，只是更新redis
 * @create 2021-04-19 15:30
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyIncreBy {

    String key() default "video:views:";

}
