package minibank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@ImportResource("classpath:spring-config.xml")
public class WebAppInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebAppInitializer.class, args);
	}

}