/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex02;

/**
 *
 * @author josine-torero
 */
import java.io.*;
import java.util.ArrayList;

public class Ficheiro {
    private File arquivo = new File("veiculos.dat");

    // Salva um veículo na lista
    public void salvar(Veiculo v) {
        ArrayList<Veiculo> lista = carregar();
        lista.add(v);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carrega todos os veículos salvos
    public ArrayList<Veiculo> carregar() {
        if (!arquivo.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (ArrayList<Veiculo>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
