package Starapi.entidades;
import java.util.List;
import jakarta.persistence.*;
@Entity

public class Peleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int puntosVida;
    private int energia;
    private Float defensaBase;

    @ManyToMany
    @JoinTable(
         name = "peleador-ataques", 
        joinColumns = @JoinColumn(name = "peleador_id"),  
        inverseJoinColumns = @JoinColumn(name = "ataque_id")
    )
    private List<Ataque> Ataques; 

    @ManyToMany
    @JoinTable(
         name = "peleador-armas", 
        joinColumns = @JoinColumn(name = "peleador_id"),  
        inverseJoinColumns = @JoinColumn(name = "arma_id")
    )
    private List<Arma> Armas; 




    public Peleador(int id, String nombre, int puntosVida, int energia, Float defensaBase, Arma armaEqupiada,
            List<Arma> inventario, List<Ataque> habilidades, List<Ataque> ataques, List<Arma> armas) {
        this.id = id;
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.energia = energia;
        this.defensaBase = defensaBase;
        Ataques = ataques;
        Armas = armas;
    }


    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    public int getPuntosVida() {
        return puntosVida;
    }


    public int getEnergia() {
        return energia;
    }


    public Float getDefensaBase() {
        return defensaBase;
    }


    


    public void setId(int id) {
        this.id = id;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }


    public void setEnergia(int energia) {
        this.energia = energia;
    }


    public void setDefensaBase(Float defensaBase) {
        this.defensaBase = defensaBase;
    }


    
}