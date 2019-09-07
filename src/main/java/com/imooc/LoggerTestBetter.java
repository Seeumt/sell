package com.imooc;

import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j

public class LoggerTestBetter {
    //private final Logger logger= LoggerFactory.getLogger(LoggerTestBetter.class);//写所在类的类名
    //private final Logger logger = LoggerFactory.getLogger("Andy");

    @Test
    public void test2() {
        log.debug("debug");
        log.info("info");
        log.error("error");
    }
}
