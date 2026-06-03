package Starapi.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Starapi.IService.ArmaIService;
import Starapi.entidades.Arma;

@RestController
@RequestMapping("/api/Arma")
public class ArmaController {
@Autowired
private ArmaIService aService;
@GetMapping
public List<Arma> getAllArmas() {
return aService.findAllArmas();
}
@PostMapping
public Arma createArmasArmas(@RequestBody Arma arma) {
return aService.saveArmas(arma);
}
