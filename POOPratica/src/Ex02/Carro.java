/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Ex02;

/**
 *
 * @author josine-torero
 */
public class Carro extends Veiculo {
    public Carro(String nome) {
        super(nome);
    }

    @Override
    public String mover() {
        return "Carro " + getNome() + " está a dirigir na estrada!";
    }
}
