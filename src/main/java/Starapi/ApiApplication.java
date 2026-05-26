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

		// =========================================================================
        // Ejercicio 1
        // =========================================================================
		
		Ataque golpe = new Ataque(1L, "Golpe", 10, 10);
		Ataque patada = new Ataque(2L, "Patada", 15, 25);
		Ataque superGolpe = new Ataque(3L, "Super Golpe", 30, 50);
		
		Peleador Shelly = new Peleador(1L, "Shelly", 520, 10, 10.0f);
		Peleador Colt = new Peleador(2L, "Colt", 600, 60, 8.0f);
		
		Arma escopeta = new Arma(1L,"escopeta",580L, 20.0f);
		Arma pistola = new Arma(2L,"pistola",500L, 10.0f);
		Arma rayosLaser = new Arma(3L,"Rayo laser",120L, 5.0f);
		Arma lengua = new Arma(4L,"lengua",70L, 1.0f);
		Arma pata = new Arma(5L,"pata",25L, 2.5f);

		System.out.println("Peleador: " + Shelly.getNombre() + " | Vida Inicial: " + Shelly.getPuntosVida());
        System.out.println("Peleador: " + Colt.getNombre() + " | Vida Inicial: " + Colt.getPuntosVida());
		
		System.out.println("------Siguiente punto------");

		// =========================================================================
        // Ejercicio 3  
        // =========================================================================

		List<Arma> Armasnuevas = new ArrayList<>();
		Armasnuevas.add(escopeta);
		Armasnuevas.add(pistola);
		Armasnuevas.add(rayosLaser);
		Armasnuevas.add(lengua);
		Armasnuevas.add(pata);

		List<Ataque> habilidades = new ArrayList<>();
		habilidades.add(golpe);
		habilidades.add(patada);
		habilidades.add(superGolpe);

		// =========================================================================
        // Ejercicio 2  
        // =========================================================================
		Shelly.setArmas(new ArrayList<>(List.of(escopeta)));
		Colt.setArmas(new ArrayList<>(List.of(pistola)));
		Shelly.setAtaques(habilidades);
		Colt.setAtaques(habilidades);
		

		if( Shelly.getArmas().get(0).getBonificadorDanio() > Colt.getArmas().get(0).getBonificadorDanio()){
			System.out.println( Shelly.getNombre() + " tiene el arma más poderosa.");
		}
		else{
			System.out.println( Colt.getNombre() + " tiene el arma más poderosa.");
		}

		System.out.println("------Siguiente punto------");

		// =========================================================================
        // Ejercicio 3  
        // =========================================================================

		Shelly.setArmas(new ArrayList<>());
		
		for (Arma a : Armasnuevas ){
			Shelly.getArmas().add(a);
		}

		// =========================================================================
        // Ejercicio 4
        // =========================================================================

		int contador=0;
		String Ncontador="";
		for (Ataque ataque : Shelly.getAtaques() ){
			if (ataque.getDanioBase() > contador){
				contador= ataque.getDanioBase();
				Ncontador= ataque.getNombre();
			}
		}
		System.out.println("El ataque más poderoso es: " + Ncontador + " con un daño de: " + contador);
		System.out.println("------Siguiente punto------");

    }
	
}

