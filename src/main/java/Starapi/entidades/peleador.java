package Starapi.entidades;
import java.util.ArrayList;

import jakarta.persistence.*;
@Entity

public class peleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int puntosVida;
    private int energia;
    private Float defensaBase;
    private Arma armaEqupiada;
    private ArrayList[] inventario;
    private ArrayList[] habilidades;


    public peleador(int id, String nombre, int puntosVida, int energia, Float defensaBase, Arma armaEqupiada,
            ArrayList[] inventario, ArrayList[] habilidades) {
        this.id = id;
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.energia = energia;
        this.defensaBase = defensaBase;
        this.armaEqupiada = armaEqupiada;
        this.inventario = inventario;
        this.habilidades = habilidades;
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


    public Arma getArmaEqupiada() {
        return armaEqupiada;
    }


    public ArrayList[] getInventario() {
        return inventario;
    }


    public ArrayList[] getHabilidades() {
        return habilidades;
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


    public void setArmaEqupiada(Arma armaEqupiada) {
        this.armaEqupiada = armaEqupiada;
    }


    public void setInventario(ArrayList[] inventario) {
        this.inventario = inventario;
    }


    public void setHabilidades(ArrayList[] habilidades) {
        this.habilidades = habilidades;
    }

    
}





