package Ex03;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TelaCadastro extends JFrame {
    private JTextField txtNome, txtIdade, txtMatricula;
    private JTable tabela;
    private DefaultTableModel modelo;
    private ArrayList<Pessoa> lista = new ArrayList<>();

    public TelaCadastro() {
        setTitle("Cadastro de Pessoas e Alunos");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de entrada
        JPanel painelEntrada = new JPanel(new GridLayout(4, 2));
        painelEntrada.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelEntrada.add(txtNome);

        painelEntrada.add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        painelEntrada.add(txtIdade);

        painelEntrada.add(new JLabel("Matrícula (só p/ alunos):"));
        txtMatricula = new JTextField();
        painelEntrada.add(txtMatricula);

        JButton btnPessoa = new JButton("Cadastrar Pessoa");
        JButton btnAluno = new JButton("Cadastrar Aluno");
        painelEntrada.add(btnPessoa);
        painelEntrada.add(btnAluno);

        add(painelEntrada, BorderLayout.NORTH);

        // Tabela
        modelo = new DefaultTableModel(new Object[]{"Tipo", "Nome", "Idade", "Matrícula"}, 0);
        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Botões de salvar/carregar
        JPanel painelBotoes = new JPanel();
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCarregar = new JButton("Carregar");
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCarregar);
        add(painelBotoes, BorderLayout.SOUTH);

        // Eventos
        btnPessoa.addActionListener(e -> cadastrarPessoa());
        btnAluno.addActionListener(e -> cadastrarAluno());
        btnSalvar.addActionListener(e -> salvarLista());
        btnCarregar.addActionListener(e -> carregarLista());
    }

    private void cadastrarPessoa() {
        try {
            String nome = txtNome.getText().trim();
            if (nome.isEmpty()) throw new IllegalArgumentException("O nome não pode estar vazio.");
            int idade = Integer.parseInt(txtIdade.getText().trim());

            Pessoa p = new Pessoa(nome, idade);
            lista.add(p);
            atualizarTabela();
            limparCampos();
            JOptionPane.showMessageDialog(this, "Pessoa cadastrada com sucesso!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Idade deve ser um número inteiro.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void cadastrarAluno() {
        try {
            String nome = txtNome.getText().trim();
            if (nome.isEmpty()) throw new IllegalArgumentException("O nome não pode estar vazio.");
            int idade = Integer.parseInt(txtIdade.getText().trim());
            String matricula = txtMatricula.getText().trim();
            if (matricula.isEmpty()) throw new IllegalArgumentException("A matrícula não pode estar vazia.");

            Aluno a = new Aluno(nome, idade, matricula);
            lista.add(a);
            atualizarTabela();
            limparCampos();
            JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Idade deve ser um número inteiro.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void salvarLista() {
        Ficheiro.salvar(lista);
        JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!");
    }

    private void carregarLista() {
        lista = Ficheiro.carregar();
        atualizarTabela();
        JOptionPane.showMessageDialog(this, "Dados carregados com sucesso!");
    }

    private void atualizarTabela() {
        modelo.setRowCount(0);
        for (Pessoa p : lista) {
            if (p instanceof Aluno a) {
                modelo.addRow(new Object[]{"Aluno", a.getNome(), a.getIdade(), a.getMatricula()});
            } else {
                modelo.addRow(new Object[]{"Pessoa", p.getNome(), p.getIdade(), ""});
            }
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtIdade.setText("");
        txtMatricula.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastro().setVisible(true));
    }
}
