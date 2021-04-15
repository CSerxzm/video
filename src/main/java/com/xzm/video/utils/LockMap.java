package com.xzm.video.utils;

import com.xzm.video.constant.LockName;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-15 10:05
 */
public class LockMap {

    private static Map<LockName, ReentrantReadWriteLock> lockMap= new HashMap<>(16);

    static{
        for (LockName value : LockName.values()) {
            lockMap.put(value,new ReentrantReadWriteLock());
        }
    }

    private LockMap(){

    }

    public static Map<LockName, ReentrantReadWriteLock> getLockMap(){
        return lockMap;
    }

}
