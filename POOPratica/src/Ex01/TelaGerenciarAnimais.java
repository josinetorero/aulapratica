package Ex01;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class TelaGerenciarAnimais extends JFrame {
    private JTextField txtNome, txtIdade;
    private JComboBox<String> cbTipo;
    private JTable tabela;
    private DefaultTableModel modelo;
    private List<Animal> animais;

    public TelaGerenciarAnimais() {
        super("Gerenciador de Animais");

        animais = Ficheiro.carregar();

        // Painel de formulário
        JPanel painelForm = new JPanel(new GridLayout(3, 2));
        painelForm.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelForm.add(txtNome);

        painelForm.add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        painelForm.add(txtIdade);

        painelForm.add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{"Cachorro", "Gato"});
        painelForm.add(cbTipo);

        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnListar = new JButton("Listar");
        JButton btnSons = new JButton("Ouvir Sons");

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnListar);
        painelBotoes.add(btnSons);

        // Tabela
        modelo = new DefaultTableModel(new String[]{"Nome", "Idade", "Tipo"}, 0);
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        // Layout principal
        setLayout(new BorderLayout());
        add(painelForm, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        // Ações dos botões
        btnAdicionar.addActionListener(e -> adicionarAnimal());
        btnListar.addActionListener(e -> listarAnimais());
        btnSons.addActionListener(e -> imprimirSonsRecursivo(animais, 0));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
    }

    private void adicionarAnimal() {
        try {
            String nome = txtNome.getText();
            int idade = Integer.parseInt(txtIdade.getText());
            String tipo = (String) cbTipo.getSelectedItem();

            Animal animal = tipo.equals("Cachorro") ?
                    new Cachorro(nome, idade) : new Gato(nome, idade);

            animais.add(animal);
            Ficheiro.salvar(animais);

            JOptionPane.showMessageDialog(this, "Animal adicionado com sucesso!");
            txtNome.setText("");
            txtIdade.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Idade deve ser um número inteiro.");
        }
    }

    private void listarAnimais() {
        modelo.setRowCount(0);
        for (Animal a : animais) {
            modelo.addRow(new Object[]{
                    a.getNome(), a.getIdade(), a.getClass().getSimpleName()
            });
        }
    }

    private void imprimirSonsRecursivo(List<Animal> lista, int index) {
        if (index >= lista.size()) return;
        Animal a = lista.get(index);
        JOptionPane.showMessageDialog(this, a.getNome() + " diz: " + a.fazerSom());
        imprimirSonsRecursivo(lista, index + 1);
    }

    public static void main(String[] args) {
        new TelaGerenciarAnimais();
    }
}
