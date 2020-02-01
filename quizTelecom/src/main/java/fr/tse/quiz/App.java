package fr.tse.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableAutoConfiguration
@ComponentScan(basePackages = "fr.tse.quiz")
@EnableJpaRepositories(basePackages = "fr.tse.quiz.dao", entityManagerFactoryRef = "entityManagerFactory")
public class App implements WebMvcConfigurer{
	
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/style/**").addResourceLocations("/style/");
	}
	 
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}