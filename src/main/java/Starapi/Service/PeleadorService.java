package Starapi.Service;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import Starapi.Repository.PeleadorRepository;
import Starapi.entidades.Peleador;
import Starapi.IService.PeleadorIservice;

@Service 
public class PeleadorService implements PeleadorIservice { 
 @Autowired 
    private PeleadorRepository pRepository; 
    public List<Peleador> findAllCharacters() { 
        return pRepository.findAll(); 
    } 
    public Peleador saveCharacter(Peleador peleador) { 
        return pRepository.save(peleador); 
    } 
}