/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex05;

import java.io.Serializable;

/**
 *
 * @author josine-torero
 */
public class Freelancer implements Pagavel, Serializable {
    private String nome;
    private int horas;
    private double valorHora;

    public Freelancer(String nome, int horas, double valorHora) {
        this.nome = nome;
        this.horas = horas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularPagamento() {
        return horas * valorHora;
    }

    @Override
    public String getDescricao() {
        return "Freelancer: " + nome;
    }

    public String getNome() {
        return nome;
    }

    public int getHoras() {
        return horas;
    }

    public double getValorHora() {
        return valorHora;
    }
}

