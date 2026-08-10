package Starapi.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Starapi.IService.ArmaIservice;
import Starapi.entidades.Arma;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/Arma")
public class ArmaController {
@Autowired
private ArmaIservice aService;
@GetMapping
public List<Arma> getAllArmas() {
return aService.findAllArmas();
}
@PostMapping
public Arma createArmasArmas(@RequestBody Arma arma) {
return aService.saveArmas(arma);
}
}