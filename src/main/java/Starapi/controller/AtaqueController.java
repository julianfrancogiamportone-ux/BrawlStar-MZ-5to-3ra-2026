package Starapi.controller;

import java.util.List; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 
import Starapi.IService.AtaqueIservice; 
import Starapi.entidades.Ataque;
import org.springframework.web.bind.annotation.CrossOrigin;
 
@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/api/attacks") 
public class AtaqueController { 
 
    @Autowired 
    private AtaqueIservice aService; 
 
    @GetMapping 
    public List<Ataque> getAllAttacks() { 
        return aService.findAllAttacks(); 
    } 
 
    @PostMapping 
    public Ataque createAttack(@RequestBody Ataque ataque) { 
        return aService.saveAttack(ataque); 
    } 
} 
