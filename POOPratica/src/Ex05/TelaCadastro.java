/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex05;

/**
 *
 * @author josine-torero
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TelaCadastro extends JFrame {
    private JTextField txtNome, txtSalario, txtHoras, txtValorHora;
    private JComboBox<String> cbTipo;
    private JTable tabela;
    private DefaultTableModel modelo;
    private Ficheiro fich = new Ficheiro();
    private ArrayList<Pagavel> lista = new ArrayList<>();

    public TelaCadastro() {
        setTitle("Cadastro de Pagáveis");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel superior - formulário
        JPanel form = new JPanel(new GridLayout(5, 5, 5, 5));
        txtNome = new JTextField();
        txtSalario = new JTextField();
        txtHoras = new JTextField();
        txtValorHora = new JTextField();
        cbTipo = new JComboBox<>(new String[]{"Funcionario", "Freelancer"});

        form.add(new JLabel("Nome:"));
        form.add(txtNome);
        form.add(new JLabel("Tipo:"));
        form.add(cbTipo);
        form.add(new JLabel("Salário (Funcionario):"));
        form.add(txtSalario);
        form.add(new JLabel("Horas (Freelancer):"));
        form.add(txtHoras);
        form.add(new JLabel("Valor por Hora (Freelancer):"));
        form.add(txtValorHora);

        add(form, BorderLayout.NORTH);

        // Tabela
        modelo = new DefaultTableModel(new String[]{"Descrição", "Pagamento"}, 0);
        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Botões
        JPanel botoes = new JPanel(new FlowLayout());
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnCalcular = new JButton("Calcular Total");
        botoes.add(btnCadastrar);
        botoes.add(btnCalcular);
        add(botoes, BorderLayout.SOUTH);

        // Eventos
        btnCadastrar.addActionListener(e -> cadastrar());
        btnCalcular.addActionListener(e -> calcularTotal());

        // Carregar dados do arquivo ao iniciar
        carregarTabela();
    }

    private void cadastrar() {
        String nome = txtNome.getText().trim();
        String tipo = cbTipo.getSelectedItem().toString();

        try {
            Pagavel p;
            if (tipo.equals("Funcionario")) {
                double salario = Double.parseDouble(txtSalario.getText());
                p = new Funcionario(nome, salario);
            } else {
                int horas = Integer.parseInt(txtHoras.getText());
                double valorHora = Double.parseDouble(txtValorHora.getText());
                p = new Freelancer(nome, horas, valorHora);
            }

            lista.add(p);
            fich.salvar(p);
            modelo.addRow(new Object[]{p.getDescricao(), p.calcularPagamento()});

            txtNome.setText("");
            txtSalario.setText("");
            txtHoras.setText("");
            txtValorHora.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Dados inválidos!");
        }
    }

    private void carregarTabela() {
        lista = fich.carregar();
        modelo.setRowCount(0); // Limpa tabela
        for (Pagavel p : lista) {
            modelo.addRow(new Object[]{p.getDescricao(), p.calcularPagamento()});
        }
    }

    private void calcularTotal() {
        double total = 0;
        for (Pagavel p : lista) {
            total += p.calcularPagamento(); // Polimorfismo
        }
        JOptionPane.showMessageDialog(this, "Pagamento Total: " + total);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastro().setVisible(true));
    }
}
