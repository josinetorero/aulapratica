/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex04;

/**
 *
 * @author josine-torero
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaFuncionarios extends JFrame {
    private JTextField txtNome, txtSalario, txtPercentual;
    private JComboBox<String> cbTipo;
    private JTextArea txtArea;
    private Ficheiro fich = new Ficheiro();

    public TelaFuncionarios() {
        setTitle("Cadastro de Funcionários");
        setSize(650, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel superior
        JPanel panelTop = new JPanel(new FlowLayout());
        txtNome = new JTextField(10);
        txtSalario = new JTextField(7);
        txtPercentual = new JTextField(5);
        cbTipo = new JComboBox<>(new String[]{"Funcionario", "Gerente"});
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCalcular = new JButton("Calcular Folha Total");

        panelTop.add(new JLabel("Nome:"));
        panelTop.add(txtNome);
        panelTop.add(new JLabel("Salário:"));
        panelTop.add(txtSalario);
        panelTop.add(new JLabel("Tipo:"));
        panelTop.add(cbTipo);
        panelTop.add(new JLabel("% Aumento (apenas gerente):"));
        panelTop.add(txtPercentual);
        panelTop.add(btnSalvar);
        panelTop.add(btnCalcular);

        add(panelTop, BorderLayout.NORTH);

        // Área de texto
        txtArea = new JTextArea();
        txtArea.setEditable(false);
        add(new JScrollPane(txtArea), BorderLayout.CENTER);

        // Eventos
        btnSalvar.addActionListener(e -> salvarFuncionario());
        btnCalcular.addActionListener(e -> calcularFolha());
    }

    private void salvarFuncionario() {
        try {
            String nome = txtNome.getText().trim();
            double salario = Double.parseDouble(txtSalario.getText());
            String tipo = cbTipo.getSelectedItem().toString();

            Funcionario f;
            if (tipo.equals("Gerente")) {
                Gerente g = new Gerente(nome, salario);

                if (!txtPercentual.getText().trim().isEmpty()) {
                    double perc = Double.parseDouble(txtPercentual.getText());
                    g.aumentarSalario(perc);
                }

                f = g;
            } else {
                f = new Funcionario(nome, salario);
            }

            fich.salvar(f);
            JOptionPane.showMessageDialog(this, "Funcionário salvo!");
            txtNome.setText("");
            txtSalario.setText("");
            txtPercentual.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Salário inválido!");
        }
    }

    private void calcularFolha() {
        ArrayList<Funcionario> lista = fich.carregar();
        double total = somaRecursiva(lista, 0);
        txtArea.setText("Folha total de pagamento: " + total);
    }

    //  Recursividade
    private double somaRecursiva(ArrayList<Funcionario> lista, int i) {
        if (i >= lista.size()) return 0;
        return lista.get(i).getSalario() + somaRecursiva(lista, i + 1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaFuncionarios().setVisible(true));
    }
}
