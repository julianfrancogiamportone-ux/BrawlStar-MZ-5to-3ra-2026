package Starapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Starapi.entidades.ataques;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		ataque at1= new ataques(10,disparo,1,300);
		ataque at2= new ataques(11,disparo,1,300);
		ataque at3= new ataques(12,disparo,1,300);

	}

}
