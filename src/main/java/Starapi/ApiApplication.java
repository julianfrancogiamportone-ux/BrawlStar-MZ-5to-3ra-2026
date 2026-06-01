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
<<<<<<< HEAD

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

		// =========================================================================
        // Ejercicio 5   
        // =========================================================================
		int contador1=0;
		int scont = 0;
		int n=0;
		for (Ataque ataque : Shelly.getAtaques() ){
			contador1 = ataque.getCostoEnergia();
			scont= scont + contador1;
			n=n+1;
		}
		int resultado = scont/n;
		if (resultado > 50){
			System.out.println("el promedio de energía de los ataques de Shelly es: " + resultado + " es mayor a 50");	
		}
		else{
			System.out.println("el promedio de energía de los ataques de Shelly es: " + resultado + " es menor a 50");
		}
		System.out.println("------Siguiente punto------");

		CalcularDanio(Shelly, Colt, golpe);

		System.out.println("------Siguiente punto------");
		Descanso(Colt);

		System.out.println("------Siguiente punto------");

		FiltrarHabilidades(Shelly);

		System.out.println("------Siguiente punto------");

		// =========================================================================
        // Ejercicio 10
        // =========================================================================

		while (Shelly.getPuntosVida() > 0 && Colt.getPuntosVida() > 0){
			CalcularDanio(Shelly, Colt, Shelly.getAtaques().get(0));
			if (Colt.getPuntosVida() <= 0 || Shelly.getPuntosVida() <= 0){
				break;
			}
			else{
				Descanso(Shelly);
			}
			CalcularDanio(Colt, Shelly, Colt.getAtaques().get(0));
			if (Colt.getPuntosVida() <= 0 || Shelly.getPuntosVida() <= 0){
				break;
			}
			else{
				Descanso(Colt);
			}
			
		}

	}
		// =========================================================================
        // Ejercicio 6 
        // =========================================================================
	public static void CalcularDanio(Peleador atacante, Peleador defensor, Ataque ataque) {


		// =========================================================================
        // Ejercicio 7
        // =========================================================================
		
		if(atacante.getEnergia() >= ataque.getCostoEnergia()){
			int danioTotal = ataque.getDanioBase() + atacante.getArmas().get(0).getBonificadorDanio().intValue();
    	
			int danioRecibido = danioTotal - defensor.getDefensaBase().intValue();
    
    		if (danioRecibido < 0) {
        	danioRecibido = 0;
    		}
		
    		defensor.setPuntosVida(defensor.getPuntosVida() - danioRecibido);

			System.out.println( atacante.getNombre() + " hizo " + danioRecibido + " de daño.");
		
			if (defensor.getPuntosVida() < 0) {
				System.out.println(defensor.getNombre() + " murió.");
    		}
			else{
				System.out.println("A " + defensor.getNombre() + " le quedo " + defensor.getPuntosVida() + " de vida.");
			}
			atacante.setEnergia(atacante.getEnergia() - ataque.getCostoEnergia());
			System.out.println(atacante.getNombre() + " tiene " + atacante.getEnergia() + " de energía restante.");
		}
		else{
			System.out.println(atacante.getNombre() + " está demasiado cansado para atacar");
		}
		
	}

	// =========================================================================
    // Ejercicio 8
    // =========================================================================
	
	public static void Descanso(Peleador peleador){
		if (peleador.getPuntosVida() < 200){
			peleador.setPuntosVida(peleador.getPuntosVida() + 500);
			peleador.setEnergia(0);
			System.out.println(peleador.getNombre() + " ha descansado y ahora tiene "+ peleador.getPuntosVida() + " puntos de vida y " + peleador.getEnergia() + " de energía.");
		}

		else{
			peleador.setEnergia(peleador.getEnergia() + 100);
			System.out.println(peleador.getNombre() + " ha descansado y ahora tiene " + peleador.getEnergia() + " de energía.");
		}
	}
	// =========================================================================
    // Ejercicio 9
    // =========================================================================
	//Usamos una funcion ya que en el ejercicio no aclara bien si puede sers cualquier peleador o uno en especifico, entonces se hace una funcion que reciba un peleador y filtre sus habilidades dependiendo de su energia actual.
    public static void FiltrarHabilidades(Peleador peleador) {
        System.out.println("Ataques disponibles para " + peleador.getNombre() + " (Energía actual: " + peleador.getEnergia() + "):");
        
        for (Ataque ataque : peleador.getAtaques()) {
            if (ataque.getCostoEnergia() <= peleador.getEnergia()) {
                System.out.println("- " + ataque.getNombre() + " (Costo energía: " + ataque.getCostoEnergia() + ")");
            }
        }
=======
        
>>>>>>> origin/pipi3
	
    }
	
}

