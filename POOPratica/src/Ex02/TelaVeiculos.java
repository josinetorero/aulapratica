/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex02;

/**
 *
 * @author josine-torero
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaVeiculos extends JFrame {
    private JTextField txtNome;
    private JComboBox<String> cbTipo;
    private JTextArea txtArea;
    private Ficheiro fich = new Ficheiro();

    public TelaVeiculos() {
        setTitle("Cadastro de Veículos");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel superior
        JPanel panelTop = new JPanel(new FlowLayout());
        txtNome = new JTextField(15);
        cbTipo = new JComboBox<>(new String[]{"Carro", "Bicicleta"});
        JButton btnSalvar = new JButton("Salvar");
        JButton btnMostrar = new JButton("Mostrar Todos");

        panelTop.add(new JLabel("Nome:"));
        panelTop.add(txtNome);
        panelTop.add(new JLabel("Tipo:"));
        panelTop.add(cbTipo);
        panelTop.add(btnSalvar);
        panelTop.add(btnMostrar);

        add(panelTop, BorderLayout.NORTH);

        // Área de texto
        txtArea = new JTextArea();
        txtArea.setEditable(false);
        add(new JScrollPane(txtArea), BorderLayout.CENTER);

        // Eventos
        btnSalvar.addActionListener(e -> salvarVeiculo());
        btnMostrar.addActionListener(e -> mostrarVeiculos());
    }

    private void salvarVeiculo() {
        String nome = txtNome.getText().trim();
        String tipo = cbTipo.getSelectedItem().toString();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite um nome!");
            return;
        }

        Veiculo v;
        if (tipo.equals("Carro")) {
            v = new Carro(nome);
        } else {
            v = new Bicicleta(nome);
        }

        fich.salvar(v);
        JOptionPane.showMessageDialog(this, "Veículo salvo!");
        txtNome.setText("");
    }

    private void mostrarVeiculos() {
        ArrayList<Veiculo> lista = fich.carregar();
        txtArea.setText("");
        mostrarRecursivo(lista, 0);
    }

    //  Recursividade
    private void mostrarRecursivo(ArrayList<Veiculo> lista, int i) {
        if (i < lista.size()) {
            txtArea.append(lista.get(i).mover() + "\n");
            mostrarRecursivo(lista, i + 1);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaVeiculos().setVisible(true));
    }
}

