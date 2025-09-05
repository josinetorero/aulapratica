/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex02;

/**
 *
 * @author josine-torero
 */
import java.io.Serializable;

public abstract class Veiculo implements Serializable {
    private String nome;

    public Veiculo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract String mover();
}
