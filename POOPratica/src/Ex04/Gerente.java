/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex04;

/**
 *
 * @author josine-torero
 */
public class Gerente extends Funcionario {

    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    public void aumentarSalario(double percentual) {
        this.salario += this.salario * (percentual / 100);
    }
}
