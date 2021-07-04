package com.adtech.ecommerce;

import com.adtech.ecommerce.service.InitOperations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(EcommerceApplication.class, args);
		InitOperations initOperations = (InitOperations) configurableApplicationContext.getBean(InitOperations.class);
		initOperations.createRoles();
	}

}
