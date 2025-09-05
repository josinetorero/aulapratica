/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex07;

/**
 *
 * @author josine-torero
 */
import java.io.*;
import java.util.ArrayList;

public class Ficheiro {
    private File arquivoAnimais = new File("animais.dat");
    private File arquivoPessoas = new File("pessoas.dat");
    private File arquivoFuncionarios = new File("funcionarios.dat");

    // ---------- Animais ----------
    public void salvarAnimal(Animal a) {
        ArrayList<Animal> lista = carregarAnimais();
        lista.add(a);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivoAnimais))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Animal> carregarAnimais() {
        if (!arquivoAnimais.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivoAnimais))) {
            return (ArrayList<Animal>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // ---------- Pessoas ----------
    public void salvarPessoa(Pessoa p) {
        ArrayList<Pessoa> lista = carregarPessoas();
        lista.add(p);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivoPessoas))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Pessoa> carregarPessoas() {
        if (!arquivoPessoas.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivoPessoas))) {
            return (ArrayList<Pessoa>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // ---------- Funcionários ----------
    public void salvarFuncionario(Funcionario f) {
        ArrayList<Funcionario> lista = carregarFuncionarios();
        lista.add(f);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivoFuncionarios))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Funcionario> carregarFuncionarios() {
        if (!arquivoFuncionarios.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivoFuncionarios))) {
            return (ArrayList<Funcionario>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
