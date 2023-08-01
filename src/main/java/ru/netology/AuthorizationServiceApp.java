package ru.netology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
//import java.util.List;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class AuthorizationServiceApp  {
  //  @Override
    //public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    //    argumentResolvers.add(new FooBarHandlerMethodArgumentResolver());
    //}
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServiceApp.class, args);
	}
}
