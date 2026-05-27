package Starapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Starapi.entidades.Arma;
import Starapi.entidades.Ataque;
import Starapi.entidades.Peleador;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

    }
	
}

