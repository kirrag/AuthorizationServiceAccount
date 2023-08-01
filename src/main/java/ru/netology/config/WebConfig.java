package ru.netology.config;

import org.springframework.context.annotation.Configuration;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.netology.handler.AccountHandlerMethodArgumentResolver;
import java.util.List;


@EnableWebMvc
@Configuration
public class WebConfig  implements WebMvcConfigurer {
	
	//@Autowired
	//AccountHandlerMethodArgumentResolver accountHandlerMethodArgumentResolver;
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		//argumentResolvers.add(accountHandlerMethodArgumentResolver);
		argumentResolvers.add(new AccountHandlerMethodArgumentResolver());
	}
}

