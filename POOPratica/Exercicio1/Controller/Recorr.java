/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio1.Controller;

import Exercicio1.Model.Cachorro;
import Exercicio1.Model.Gato;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recorr implements Serializable {
    private List<Cachorro> cachorros= new ArrayList<>();
    private List<Gato> gatos = new ArrayList<>();
    
    // Getters e Setters
    public List<Gato> getGatos() {
        return gatos;
    }

    public void setGatos (List<Gato> gatos) {
        this.gatos = gatos;
    }

    public List<Cachorro> getCachorros() {
        return cachorros;
    }

    public void setCachorros(List<Cachorro> cachorros) {
        this.cachorros = cachorros;
    }

    
    
}