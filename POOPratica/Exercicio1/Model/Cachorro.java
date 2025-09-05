/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio1.Model;

import Exercicio1.Model.Animal;
import java.io.Serializable;

/**
 *
 * @author josine-torero
 */
public class Cachorro extends Animal implements Serializable{

    public Cachorro(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void fazerSom() {
        System.out.println("au au");
    }
    
}
