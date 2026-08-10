package Starapi.IService;
import java.util.List;
import Starapi.entidades.Arma;
public interface ArmaIservice {
public List<Arma> findAllArmas();
public Arma saveArmas(Arma arma);
}
