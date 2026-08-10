package Starapi.Service;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import Starapi.IService.AtaqueIservice; 
import Starapi.entidades.Ataque; 
import Starapi.Repository.AtaqueRepository; 
 
@Service 
public class AtaqueService implements AtaqueIservice { 
 @Autowired 
    private AtaqueRepository aRepository; 
    public List<Ataque> findAllAttacks() { 
        return aRepository.findAll(); 
    } 
    public Ataque saveAttack(Ataque ataque) { 
        return aRepository.save(ataque); 
    } 
} 
