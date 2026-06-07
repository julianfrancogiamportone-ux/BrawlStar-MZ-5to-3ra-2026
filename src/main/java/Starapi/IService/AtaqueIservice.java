package Starapi.IService;
import java.util.List; 
import Satarapi.entidades.Ataque; 
 
public interface AtaqueIservice { 
public List<Ataque> findAllAttacks(); 
public Ataque saveAttack(Ataque ataque); 
}
