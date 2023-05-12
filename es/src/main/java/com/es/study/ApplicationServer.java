package com.es.study;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 新增任务评论功能
 */
@EnableScheduling
@SpringBootApplication
@Slf4j
@MapperScan("com.infoearth.develop.db.mapper")
public class ApplicationServer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationServer.class);
    }
}
