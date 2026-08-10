package Starapi.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Starapi.IService.ArmaIservice;
import Starapi.entidades.Arma;
import Starapi.Repository.ArmaRepository;


@Service
public class ArmaService implements ArmaIservice {
@Autowired
private ArmaRepository aRepository;
public List<Arma> findAllArmas() {
return aRepository.findAll();
}
public Arma saveArmas(Arma arma) {
return aRepository.save(arma);
}
}