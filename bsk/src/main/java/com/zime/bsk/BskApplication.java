package com.zime.bsk;

import com.zime.bsk.controller.CakeInfoController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@MapperScan(basePackages = "com.zime.bsk.dao")
@ServletComponentScan(basePackages = "com.zime.bsk.context")
@SpringBootApplication
public class BskApplication {

    public static void main(String[] args) {
        SpringApplication.run(BskApplication.class, args);
    }

}
