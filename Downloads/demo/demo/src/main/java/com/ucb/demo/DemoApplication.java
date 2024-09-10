package com.ucb.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		var applicationContext = SpringApplication.run(DemoApplication.class, args);//Application context
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for ( String beanDefinitionName: beanDefinitionNames){
			//System.out.println(String.format("Name: %s", beanDefinitionNames));
		}
		System.out.printf("Total beans: %d", beanDefinitionNames.length);
	}
	@Bean
	String ucb(){
		return "Universidad Catolica Boliviana";
	}

	@Bean
	String umss(){
		return "Universidad Mayor de San Simón";
	}

	@Bean
	CommandLineRunner commandLineRunner(String ucb){
		return args -> {
			System.out.printf("Hello world, %s", ucb);
		};
	}
}
