package Starapi.controller;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 
import Starapi.IService.PeleadorIservice; 
import Starapi.entidades.Peleador;
import java.util.List;

@RestController 
@RequestMapping("/api/characters") 
public class PeleadorController { 

    @Autowired 
    private PeleadorIservice pService; 

    @GetMapping 
    public List<Peleador> getAllCharacters() { 
        return pService.findAllCharacters(); 
    } 

    @PostMapping 
    public Peleador createCharacter(@RequestBody Peleador peleador) { 
        return pService.saveCharacter(peleador); 
    } 
}