package com.xzm.video.utils;

import java.util.Comparator;
import java.util.Map;

/**
 * @author xiangzhimin
 * @Description 根据map中的时间进行排序,这只是针对管理端主页进行排序
 * 需要的map结构为
 * {
 *      day:2021-12-23;
 *      count:23
 * }
 * @create 2021-04-20 16:18
 */
public class HashMapComparator implements Comparator< Map<String,String> > {

    @Override
    public int compare(Map<String, String> o1, Map<String, String> o2) {
        String day1 = o1.get("day");
        String day2 = o2.get("day");
        if(day1==null||day2==null){
            throw new RuntimeException("类型不对");
        }
        return day1.compareTo(day2);
    }
}
