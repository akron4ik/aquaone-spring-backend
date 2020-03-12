package com.example.aquaone;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ImportResource(value = {
		"classpath:spring/spring-app.xml",
		"classpath:spring/spring-db.xml",
		"classpath:spring/spring-mvc.xml",
		"classpath:spring/spring-security.xml",
		"classpath:spring/spring-tools.xml"
})
public class AquaoneApplication {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(AquaoneApplication.class);
		/*application.setWebApplicationType(WebApplicationType.NONE);*/
		application.run(args);
	}

}
