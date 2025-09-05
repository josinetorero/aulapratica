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
public class ContaCorrente implements Conta, Serializable {
    private String titular;
    private double taxaFixa;

    public ContaCorrente(String titular, double taxaFixa) {
        this.titular = titular;
        this.taxaFixa = taxaFixa;
    }
    
    
    @Override
    public double calcularTaxa() {
        return taxaFixa;
    }

    @Override
    public String getDescricao() {
        return "Conta corrente:"+ titular;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getTaxaFixa() {
        return taxaFixa;
    }

    public void setTaxaFixa(double taxaFixa) {
        this.taxaFixa = taxaFixa;
    }
    
    
}
