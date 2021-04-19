package com.xzm.video.aop;

import com.xzm.video.annotation.MyIncreBy;
import com.xzm.video.utils.RedisUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-19 15:33
 */

@Aspect
@Component
public class MyIncreByAspect {

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisUtils redisUtils;

    @Around(value = "@annotation(com.xzm.video.annotation.MyIncreBy)")
    public Object handler(ProceedingJoinPoint joinPoint) throws Throwable {
        //通过反射得到注解对象
        Signature signature = joinPoint.getSignature();
        Method method = ((MethodSignature) signature).getMethod();
        Method declaredMethod = joinPoint.getTarget().getClass().getDeclaredMethod(signature.getName(), method.getParameterTypes());
        MyIncreBy annotation = declaredMethod.getAnnotation(MyIncreBy.class);
        String key = annotation.key();
        String format = formatter.format(new Date());

        logger.info("进入设置缓存注解，键是:{}",key+format);

        if(redisUtils.isEmpty(key+format)){
            redisUtils.incrby(key+format,1L);
            redisUtils.expire(key+format,7, TimeUnit.DAYS);
        }else{
            redisUtils.incrby(key+format,1L);
        }
        Object proceed = joinPoint.proceed();
        return proceed;
    }
}
