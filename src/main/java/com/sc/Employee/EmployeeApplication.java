package com.sc.Employee;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	
	@Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
	
	@SuppressWarnings("unused")
	private ApiInfo getApiInfo() {
	    return new ApiInfo(
	            "EMPLOYEE PORTAL",
	            "DETAILS TO ADD,DELETE,FETCH,UPDATE",
	            "1",
	            "TERMS OF SERVICE URL",
	            new Contact("ABINASH","URL","abinashm226@gmail.com"),
	            "LICENSE",
	            "LICENSE URL",
	            Collections.emptyList()
	    );
	}
}
