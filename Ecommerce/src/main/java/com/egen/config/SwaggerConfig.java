package com.egen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	/*
	 * @Component is used to create objects for class in our spring application
	 * @beans can create objects for class outside our application. Eg: like below the docket class which is 
	 * not a part of our application
	 * */
	
	 @Bean  //bean creates an object and registers it whereas autowire uses this registered object
	    public Docket api() { //Docket is a builder which is intended to be the primary interface into the swagger-springmvc framework
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .paths(PathSelectors.ant("/order-service/*"))
	                .apis(RequestHandlerSelectors.any())
	                .build().apiInfo(metadata());
	    }

	    private ApiInfo metadata(){
	    return new ApiInfoBuilder().title("Ecommerce order microservice").description("orders").version("1.0")
	    		.build();
	    }
}
