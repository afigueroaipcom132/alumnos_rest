package mx.unam.dgtic.alumnos_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AlumnosRestApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AlumnosRestApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AlumnosRestApplication.class, args);
	}
}
