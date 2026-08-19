package Starapi.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import Starapi.entidades.Arma;

public interface ArmaRepository extends JpaRepository<Arma, Long> {
}