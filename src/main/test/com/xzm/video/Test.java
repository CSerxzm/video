package com.xzm.video;

import com.xzm.video.service.VideoService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import javax.sql.DataSource;

@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class Test extends AbstractJUnit4SpringContextTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    VideoService videoService;

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
}
