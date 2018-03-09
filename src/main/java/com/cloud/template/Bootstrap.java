package com.cloud.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;

/**
 * @author slankka
 */
@SpringBootApplication
@ImportResource("classpath*:spring/applicationContext.xml")
@EnableFeignClients
public class Bootstrap {
	public static void main(String[] args) {
		SpringApplication.run(Bootstrap.class, args);
	}
}
