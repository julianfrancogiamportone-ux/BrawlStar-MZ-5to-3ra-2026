package Starapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Starapi.entidades.armas;
import Starapi.entidades.peleador;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		long num= 121233;
		float num2=2;
		armas a1 = new armas(num,"Escopeta",num,num2);
	}

}
