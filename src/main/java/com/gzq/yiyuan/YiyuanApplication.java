package com.gzq.yiyuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.gzq.yiyuan.dao"})
public class YiyuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(YiyuanApplication.class, args);
    }

}
