package Starapi.entidades;
import jakarta.persistence.*;
@Entity
public class ataques {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
}
