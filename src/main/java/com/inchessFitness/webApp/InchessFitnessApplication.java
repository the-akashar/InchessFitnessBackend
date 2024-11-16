package com.inchessFitness.webApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.inchessFitness.webApp.repository")
@EntityScan("com.inchessFitness.webApp.model")
public class InchessFitnessApplication {

	public static void main(String[] args) {

		SpringApplication.run(InchessFitnessApplication.class, args);

	}

}




