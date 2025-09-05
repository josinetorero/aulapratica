/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex07;

/**
 *
 * @author josine-torero
 */

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TelaRelatorio extends JFrame {
    private JComboBox<String> cbTipo;
    private JTextArea txtArea;
    private JButton btnGerar, btnExportar;
    private Ficheiro fich = new Ficheiro();

    public TelaRelatorio() {
        setTitle("Relatório Recursivo");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ComboBox
        cbTipo = new JComboBox<>(new String[]{"Animais", "Pessoas", "Funcionarios"});
        add(cbTipo, BorderLayout.NORTH);

        // JTextArea
        txtArea = new JTextArea();
        txtArea.setEditable(false);
        add(new JScrollPane(txtArea), BorderLayout.CENTER);

        // Botões
        JPanel botoes = new JPanel();
        btnGerar = new JButton("Gerar Relatório");
        btnExportar = new JButton("Exportar para TXT");
        botoes.add(btnGerar);
        botoes.add(btnExportar);
        add(botoes, BorderLayout.SOUTH);

        // Eventos
        btnGerar.addActionListener(e -> gerarRelatorio());
        btnExportar.addActionListener(e -> exportarTXT());
    }

    private void gerarRelatorio() {
        String tipo = cbTipo.getSelectedItem().toString();
        StringBuilder sb = new StringBuilder();

        switch (tipo) {
            case "Animais":
                listarAnimaisRecursivo(fich.carregarAnimais(), 0, sb);
                break;
            case "Pessoas":
                listarPessoasRecursivo(fich.carregarPessoas(), 0, sb);
                break;
            case "Funcionarios":
                listarFuncionariosRecursivo(fich.carregarFuncionarios(), 0, sb);
                break;
        }

        txtArea.setText(sb.toString());
    }

    // ---------- Funções recursivas ----------
    private void listarAnimaisRecursivo(ArrayList<Animal> list, int i, StringBuilder sb) {
        if (i >= list.size()) return;
        sb.append(list.get(i).getDescricao()).append("\n");
        listarAnimaisRecursivo(list, i + 1, sb);
    }

    private void listarPessoasRecursivo(ArrayList<Pessoa> list, int i, StringBuilder sb) {
        if (i >= list.size()) return;
        sb.append(list.get(i).getDescricao()).append("\n");
        listarPessoasRecursivo(list, i + 1, sb);
    }

    private void listarFuncionariosRecursivo(ArrayList<Funcionario> list, int i, StringBuilder sb) {
        if (i >= list.size()) return;
        sb.append(list.get(i).getDescricao()).append("\n");
        listarFuncionariosRecursivo(list, i + 1, sb);
    }

    // ---------- Exportar para TXT ----------
    private void exportarTXT() {
        try (FileWriter fw = new FileWriter("relatorio.txt")) {
            fw.write(txtArea.getText());
            JOptionPane.showMessageDialog(this, "Relatório exportado com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao exportar arquivo.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaRelatorio().setVisible(true));
    }
}
