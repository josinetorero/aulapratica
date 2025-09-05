/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex03;

/**
 *
 * @author josine-torero
 */
import java.io.*;
import java.util.ArrayList;

public class Ficheiro {
    private static final String FILE_NAME = "pessoas.dat";

    public static void salvar(ArrayList<Pessoa> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(lista);
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Pessoa> carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Pessoa>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>(); // retorna lista vazia se não conseguir carregar
        }
    }
}
