/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio1.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Database {
    private static final String FILE_NAME = "Recorr.dat";
    private static Recorr recorr = load();

    // Retorna os dados do sistema
    public static Recorr getData() {
        return recorr;
    }

    // Guarda os dados no ficheiro
    public static void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(recorr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carrega os dados do ficheiro
    private static Recorr load() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                return (Recorr) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new Recorr(); // Se não existir, devolve um novo conjunto de dados
    }
}