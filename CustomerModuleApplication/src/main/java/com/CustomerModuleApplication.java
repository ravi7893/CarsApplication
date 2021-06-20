package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class CustomerModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerModuleApplication.class, args);
		
		System.out.println("Connected to DB");
	    }
	 @Bean
	    public Docket productApi() {
	        return (new Docket(DocumentationType.SWAGGER_2)).select().apis(RequestHandlerSelectors.basePackage("com")).build();
	    }
	 //http://localhost:9090/swagger-ui/index.html this is swagger ui

}
