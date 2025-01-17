package com.blogginService.Blogging_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories
@EnableEurekaClient
public class BloggingServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BloggingServiceApplication.class, args);
	}

}
