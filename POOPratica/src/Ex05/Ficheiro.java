/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex05;

/**
 *
 * @author josine-torero
 */
import java.io.*;
import java.util.ArrayList;

public class Ficheiro {
    private File arquivo = new File("pagaveis.dat");

    // Salva um objeto Pagavel
    public void salvar(Pagavel p) {
        ArrayList<Pagavel> lista = carregar();
        lista.add(p);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carrega todos os objetos Pagavel
    public ArrayList<Pagavel> carregar() {
        if (!arquivo.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (ArrayList<Pagavel>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // Limpar o arquivo (opcional)
    public void limpar() {
        if (arquivo.exists()) arquivo.delete();
    }
}
