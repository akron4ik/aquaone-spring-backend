package com.example.aquaone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ImportResource(value = {
		"classpath:spring/spring-app.xml",
		"classpath:spring/spring-db.xml"
})
public class AquaoneApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(AquaoneApplication.class);
		application.run(args);
	}

}
