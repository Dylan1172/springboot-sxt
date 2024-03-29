package org.jit.sose;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("org.jit.sose.mapper")  // 扫描mapper
@EnableCaching  // 开启缓存
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
