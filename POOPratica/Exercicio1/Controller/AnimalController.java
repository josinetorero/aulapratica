/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio1.Controller;

import Exercicio1.Model.Cachorro;
import Exercicio1.Model.Gato;
import java.util.ArrayList;

/**
 *
 * @author josine-torero
 */
public class AnimalController {

    private Recorr dados;

    public AnimalController() {
        dados = Database.getData();
    }

    public boolean adicionar (Cachorro cachorro) {
        for (Cachorro c : dados.getCachorros()) {
            if (c.getNome().equals(cachorro.getNome())) {
                return false; // já existe
            }
        }
        dados.getCachorros().add(cachorro);
        Database.save();
        return true;
    }
    
    public boolean adicionar (Gato gato) {
        for (Gato g : dados.getGatos()) {
            if (g.getNome().equals(gato.getNome())) {
                return false; // já existe
            }
        }
        dados.getGatos().add(gato);
        Database.save();
        return true;
    }

    
}
