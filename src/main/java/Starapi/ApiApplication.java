package Starapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		peleador shelly= new peleador(1,"shelly",100,10,50);
		armas escopeta= new armas(7,"escopeta",320,1,2);
	}

}
