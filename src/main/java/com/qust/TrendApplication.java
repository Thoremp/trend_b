package com.qust;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qust.mapper") //在主类名上添加mapperscan包扫描
public class TrendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrendApplication.class, args);
	}
}
