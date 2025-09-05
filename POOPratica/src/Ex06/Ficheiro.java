/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex06;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author josine-torero
 */
public class Ficheiro {

    private File arquivo = new File("contas.dat");

    void salvar(Conta c) {
        ArrayList<Conta> lista = carregar();
        lista.add(c);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    ArrayList<Conta> carregar() {
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (ArrayList<Conta>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
