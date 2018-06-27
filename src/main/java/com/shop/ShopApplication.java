package com.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shop.mapper")
public class ShopApplication {
	private static final Logger logger = LoggerFactory.getLogger(ShopApplication.class);

	public static void main(String[] args) {
		logger.info("OK","ok");
		SpringApplication.run(ShopApplication.class, args);
	}
}
