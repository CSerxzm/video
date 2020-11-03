package com.xzm.video;

import com.xzm.video.service.VideoService;
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
}
