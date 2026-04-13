package Starapi.entidades;
import jakarta.persistence.*;
@Entity
public class armas {
 
private Long id;
private String nombre;
private Long bonificadorDanio;
private float peso;





public armas(Long id, String nombre, Long bonificadorDanio, float peso) {
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
