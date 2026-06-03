package Starapi.IService;
import java.util.List;
import Starapi.entidades.Arma;
public interface ArmaIService {
public List<Arma> findAllArmas();
public Arma saveArmas(Arma arma);
}
