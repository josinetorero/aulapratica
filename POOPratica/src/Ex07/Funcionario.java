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

public class Funcionario implements Serializable {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getDescricao() {
        return nome + " - Salário: " + salario;
    }
}
