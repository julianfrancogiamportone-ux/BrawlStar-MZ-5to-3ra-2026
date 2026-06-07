package Starapi.IService;
import java.util.List; 
import Starapi.entidades.Peleador;
 
public interface PeleadorIservice { 
public List<Peleador> findAllCharacters(); 
public Peleador saveCharacter(Peleador peleador); 
}