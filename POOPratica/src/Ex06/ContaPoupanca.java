/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex06;

import java.io.Serializable;

/**
 *
 * @author josine-torero
 */
public class ContaPoupanca implements Conta, Serializable {
    private String titular;
    private double saldo;
    private double taxaPercentual;

    public ContaPoupanca(String titular, double saldo, double taxaPercentual) {
        this.titular = titular;
        this.saldo = saldo;
        this.taxaPercentual = taxaPercentual;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTaxaPercentual() {
        return taxaPercentual;
    }

    public void setTaxaPercentual(double taxaPercentual) {
        this.taxaPercentual = taxaPercentual;
    }

    @Override
    public double calcularTaxa() {
        return saldo*taxaPercentual;
    }

    @Override
    public String getDescricao() {
        return "Conta Poupanca: "+ titular;
    }
    
    
    
}
