/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex07;

/**
 *
 * @author josine-torero
 */
import java.io.Serializable;

public class Animal implements Serializable {
    private String nome;
    private String especie;

    public Animal(String nome, String especie) {
        this.nome = nome;
        this.especie = especie;
    }

    public String getDescricao() {
        return nome + " (" + especie + ")";
    }
}
