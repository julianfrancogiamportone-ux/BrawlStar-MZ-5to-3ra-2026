package Starapi.entidades;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Arma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Long bonificadorDanio;
    private float peso;


    @ManyToMany(mappedBy = "Armas")
    private List<Peleador> peleadores;


    public Arma(Long id, String nombre, Long bonificadorDanio, float peso) {
    this.id = id;
    this.nombre = nombre;
    this.bonificadorDanio = bonificadorDanio;
    this.peso = peso;
    }





    public void setId(Long id) {
    this.id = id;
    }





    public void setNombre(String nombre) {
    this.nombre = nombre;
    }





    public void setBonificadorDanio(Long bonificadorDanio) {
    this.bonificadorDanio = bonificadorDanio;
    }





    public void setPeso(float peso) {
    this.peso = peso;
    }   





    public Long getId() {
    return id;
    }





    public String getNombre() {
    return nombre;
    }





    public Long getBonificadorDanio() {
    return bonificadorDanio;
    }





    public float getPeso() {
    return peso;
    }







}
