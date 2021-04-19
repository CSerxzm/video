package com.xzm.video;

import com.xzm.video.service.VideoService;
import com.xzm.video.utils.RedisUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Date;

@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class Test extends AbstractJUnit4SpringContextTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private VideoService videoService;

    @Autowired
    private RedisUtils redisUtils;

    @org.junit.Test
    public void test(){
        System.out.println(dataSource);
    }

    @org.junit.Test
    public void test01(){
        String hashAlgorithmName = "MD5";
        Object password = "password";
        ByteSource salt = ByteSource.Util.bytes("admin");
        int hashIterations = 2;
        Object result = new SimpleHash(hashAlgorithmName,password,salt,hashIterations);
        System.out.println(result);
    }

    @org.junit.Test
    public void test02(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        redisUtils.hIncrement("test:views",dateString);
        //redisUtils.expire()
        Object o = redisUtils.hGet("test:views", dateString);
        System.out.println(o);
    }
}
