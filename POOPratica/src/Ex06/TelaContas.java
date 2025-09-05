/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex06;

/**
 *
 * @author josine-torero
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TelaContas extends JFrame {
    private JTextField txtTitular, txtTaxaFixa, txtSaldo, txtPercentual;
    private JComboBox<String> cbTipo;
    private JTable tabela;
    private DefaultTableModel modelo;
    private Ficheiro fich = new Ficheiro();
    private ArrayList<Conta> lista = new ArrayList<>();

    public TelaContas() {
        setTitle("Cadastro de Contas");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel formulário
        JPanel form = new JPanel(new GridLayout(5, 5, 5, 5));
        txtTitular = new JTextField();
        txtTaxaFixa = new JTextField();
        txtSaldo = new JTextField();
        txtPercentual = new JTextField();
        cbTipo = new JComboBox<>(new String[]{"ContaCorrente", "ContaPoupanca"});

        form.add(new JLabel("Titular:"));
        form.add(txtTitular);
        form.add(new JLabel("Tipo:"));
        form.add(cbTipo);
        form.add(new JLabel("Taxa Fixa (CC):"));
        form.add(txtTaxaFixa);
        form.add(new JLabel("Saldo (CP):"));
        form.add(txtSaldo);
        form.add(new JLabel("% Taxa (CP):"));
        form.add(txtPercentual);

        add(form, BorderLayout.NORTH);

        // Tabela
        modelo = new DefaultTableModel(new String[]{"Descrição", "Taxa Calculada"}, 0);
        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Botões
        JPanel botoes = new JPanel(new FlowLayout());
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnCalcular = new JButton("Calcular Taxas Totais");
        botoes.add(btnCadastrar);
        botoes.add(btnCalcular);
        add(botoes, BorderLayout.SOUTH);

        // Eventos
        btnCadastrar.addActionListener(e -> cadastrar());
        btnCalcular.addActionListener(e -> calcularTotal());

        // Carregar dados do arquivo
        carregarTabela();
    }

    private void cadastrar() {
        String titular = txtTitular.getText().trim();
        String tipo = cbTipo.getSelectedItem().toString();

        try {
            Conta c;
            if (tipo.equals("ContaCorrente")) {
                double taxa = Double.parseDouble(txtTaxaFixa.getText());
                c = new ContaCorrente(titular, taxa);
            } else {
                double saldo = Double.parseDouble(txtSaldo.getText());
                double percentual = Double.parseDouble(txtPercentual.getText());
                c = new ContaPoupanca(titular, saldo, percentual);
            }

            lista.add(c);
            fich.salvar(c);
            modelo.addRow(new Object[]{c.getDescricao(), c.calcularTaxa()});

            txtTitular.setText("");
            txtTaxaFixa.setText("");
            txtSaldo.setText("");
            txtPercentual.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Dados inválidos!");
        }
    }

    private void carregarTabela() {
        lista = fich.carregar();
        modelo.setRowCount(0);
        for (Conta c : lista) {
            modelo.addRow(new Object[]{c.getDescricao(), c.calcularTaxa()});
        }
    }

    private void calcularTotal() {
        double total = calcularRecursivo(lista, 0);
        JOptionPane.showMessageDialog(this, "Total das Taxas: " + total);
    }

    // Recursividade 
    private double calcularRecursivo(ArrayList<Conta> l, int i) {
        if (i >= l.size()) return 0;
        return l.get(i).calcularTaxa() + calcularRecursivo(l, i + 1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaContas().setVisible(true));
    }
}
