/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex04;

/**
 *
 * @author josine-torero
 */
import java.io.*;
import java.util.ArrayList;

public class Ficheiro {
    private File arquivo = new File("funcionarios.dat");

    public void salvar(Funcionario f) {
        ArrayList<Funcionario> lista = carregar();
        lista.add(f);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Funcionario> carregar() {
        if (!arquivo.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (ArrayList<Funcionario>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
