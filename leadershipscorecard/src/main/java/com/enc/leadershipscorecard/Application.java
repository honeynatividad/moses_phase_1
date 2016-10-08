package com.enc.leadershipscorecard;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

/**
 * Spring Boot Servlet Initializer
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer{

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setPort(9000);
//		factory.setSessionTimeout(10, TimeUnit.MINUTES);
		factory.setSessionTimeout(24, TimeUnit.HOURS);
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html"));
		return factory;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main( String[] args ) {
		SpringApplication.run(Application.class, args);
	}

}