package View;

import DAO.ConnectDAO;
import bancofinal.Clientes;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Cad_Cliente extends javax.swing.JFrame {

    String operacaoAtivaGlobal = "Nenhum";

    public Cad_Cliente() {
        initComponents();
        ConnectDAO objcon = new ConnectDAO();
        ResultSet clienteRS;
        clienteRS = objcon.consultaRegistroClienteRSBD();
        jTable1.setModel(DbUtils.resultSetToTableModel(clienteRS));
        jTable1.setVisible(true);
    }

    public Cad_Cliente(String operacaoAtiva) {
        initComponents();
        operacaoAtivaGlobal = operacaoAtiva;
        String operacao = "Incluir";

        if (operacaoAtiva.equals(operacao)) {
            idLabel.setVisible(false);
            idField.setVisible(false);
            jButton1.setText("Incluir BD");
        }

        if ("Alterar".equals(operacaoAtiva) || "Excluir".equals(operacaoAtiva)) {
            nameLabel.setVisible(false);
            adressLabel.setVisible(false);
            neighborLabel.setVisible(false);
            cpfLabel.setVisible(false);
            cityLabel.setVisible(false);
            ufLabel.setVisible(false);
            cepLabel.setVisible(false);
            emailLabel.setVisible(false);
            numberLabel.setVisible(false);
            complementLabel.setVisible(false);
            nameField.setVisible(false);
            adressField.setVisible(false);
            cpfField.setVisible(false);
            cityField.setVisible(false);
            numberField.setVisible(false);
            cepField.setVisible(false);
            neighborField.setVisible(false);
            ufField.setVisible(false);
            jButton1.setText("Pesquisar");
            jButton2.setVisible(false);
            jButton3.setVisible(false);
        }
        
        if ("Consultar".equals(operacaoAtiva)) {
            
            ConnectDAO objcon = new ConnectDAO();
            List<Clientes> clientes = objcon.consultaRegistroClienteBD();
            System.out.println(clientes);
            
            JFrame frame = new JFrame("Tabela de Clientes");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nome");
            model.addColumn("End");
            model.addColumn("Num");
            model.addColumn("Bair");
            model.addColumn("Cid");
            model.addColumn("UF");
            model.addColumn("Comp");
            model.addColumn("Email");
            model.addColumn("CPF");
            
            for (Clientes cliente : clientes) {
                Object[] linha = {
                    cliente.getNome(),
                    cliente.getEndereco(),
                    cliente.getNumero(),
                    cliente.getBairro(),
                    cliente.getCidade(),
                    cliente.getUF(),
                    cliente.getComplemento(),
                    cliente.getEmail(),
                    cliente.getCPF(),
                };
                
                // Adicione a linha ao modelo da tabela
                model.addRow(linha);
            }
            
            JTable tabela = new JTable();
            
            tabela.setModel(model);

            JScrollPane scrollPane = new JScrollPane(tabela);

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setLocationRelativeTo(null); // Centralizar na tela
            frame.setVisible(true);
            
        }

    }

    Clientes clientes_tela = new Clientes();

    void limpar() {
        nameField.setText("");
        adressField.setText("");
        neighborField.setText("");
        cpfField.setText("");
        cityField.setText("");
        numberField.setText("");
        emailField.setText("");
        cepField.setText("");
        complementField.setText("");
        ufField.setSelectedItem("AC");
    }

    void tudoVisivel() {
        nameLabel.setVisible(true);
        neighborLabel.setVisible(true);
        cpfLabel.setVisible(true);
        adressLabel.setVisible(true);
        cityLabel.setVisible(true);
        ufLabel.setVisible(true);
        cepLabel.setVisible(true);
        emailLabel.setVisible(true);
        numberLabel.setVisible(true);
        complementLabel.setVisible(true);
        nameField.setVisible(true);
        cpfField.setVisible(true);
        adressField.setVisible(true);
        numberField.setVisible(true);
        complementField.setVisible(true);
        neighborField.setVisible(true);
        cityField.setVisible(true);
        cepField.setVisible(true);
        emailField.setVisible(true);
        ufField.setVisible(true);
    }

    void naoEditavel() {
        nameField.setEditable(false);
        cpfField.setEditable(false);
        adressField.setEditable(false);
        numberField.setEditable(false);
        complementField.setEditable(false);
        neighborField.setEditable(false);
        cityField.setEditable(false);
        cepField.setEditable(false);
        emailField.setEditable(false);
        ufField.setEditable(false);
    }

    void lerDados() {
        nameField.setText(clientes_tela.getNome());
        adressField.setText(clientes_tela.getEndereco());
        neighborField.setText(clientes_tela.getBairro());
        cpfField.setText(clientes_tela.getCPF());
        cityField.setText(clientes_tela.getCidade());
        numberField.setText(clientes_tela.getNumero());
        emailField.setText(clientes_tela.getEmail());
        cepField.setText(clientes_tela.getCep());
        complementField.setText(clientes_tela.getComplemento());
        ufField.setSelectedItem(clientes_tela.getUF());
    }

    void inserirAlterar() {
        clientes_tela.setNome(nameField.getText());
        clientes_tela.setCPF(cpfField.getText());
        clientes_tela.setEndereco(adressField.getText());
        clientes_tela.setNumero(numberField.getText());
        clientes_tela.setComplemento(complementField.getText());
        clientes_tela.setBairro(neighborField.getText());
        clientes_tela.setCidade(cityField.getText());
        clientes_tela.setCep(cepField.getText());
        clientes_tela.setEmail(emailField.getText());
        clientes_tela.setUF(ufField.getSelectedItem().toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        nameLabel = new javax.swing.JLabel();
        adressLabel = new javax.swing.JLabel();
        neighborLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        adressField = new javax.swing.JTextField();
        neighborField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cpfLabel = new javax.swing.JLabel();
        cpfField = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        cityLabel = new javax.swing.JLabel();
        ufLabel = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        cepLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        numberLabel = new javax.swing.JLabel();
        numberField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        cepField = new javax.swing.JTextField();
        complementLabel = new javax.swing.JLabel();
        complementField = new javax.swing.JTextField();
        ufField = new javax.swing.JComboBox<>();
        idLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nameLabel.setText("Nome do Cliente");

        adressLabel.setText("Endereço do Cliente");

        neighborLabel.setText("Bairro");

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ler");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cpfLabel.setText("CPF");

        jButton3.setText("Limpar tela");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cityLabel.setText("Cidade");

        ufLabel.setText("UF");

        cepLabel.setText("CEP");

        emailLabel.setText("Email");

        numberLabel.setText("Número");

        complementLabel.setText("Complemento");

        ufField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RR", "RO", "RJ", "RN", "RS", "SC", "SP", "SE", "TO" }));

        idLabel.setText("ID do Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(adressLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(adressField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(ufLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ufField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cepLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cepField))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(neighborLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(neighborField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cityLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cityField))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(complementLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(complementField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(emailLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cpfLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adressLabel)
                    .addComponent(adressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberLabel)
                    .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(neighborLabel)
                    .addComponent(neighborField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityLabel)
                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ufLabel)
                    .addComponent(cepLabel)
                    .addComponent(cepField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(complementLabel)
                    .addComponent(complementField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ufField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfLabel)
                    .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // INSERT NO DB:
        String operacao = "Incluir";
        if (operacaoAtivaGlobal.equals(operacao)) {

            inserirAlterar();

            ConnectDAO objcon = new ConnectDAO();
            objcon.insereRegistroJFBD("CLIENTES", clientes_tela.dadosSQLValues());

            limpar();
            this.dispose();

        }

        operacao = "Alteração";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            inserirAlterar();

            objcon.alteraRegistroJFBD("CLIENTES", clientes_tela.alteraDadosSQLValues(),
                    "ID_CLI='" + idField.getText() + "'");

            limpar();
            this.dispose();

        }

        operacao = "Alterar";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            clientes_tela = objcon.pesquisaClienteJFBD("CLIENTES", "ID_CLI='" + idField.getText() + "'");
            lerDados();

            tudoVisivel();
            jButton1.setText("Alterar");
            operacaoAtivaGlobal = "Alteração";

        }

        operacao = "Exclusão";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            objcon.excluiRegistroJFBD("CLIENTES", "ID_CLI=" + idField.getText());

            limpar();
            this.dispose();
        }

        operacao = "Excluir";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            clientes_tela = objcon.pesquisaClienteJFBD("CLIENTES", "ID_CLI='" + idField.getText() + "'");
            lerDados();

            tudoVisivel();
            jButton1.setText("Excluir");
            operacaoAtivaGlobal = "Exclusão";

            naoEditavel();

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Botão LIMPAR TELA:
        limpar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Botão LER:
        lerDados();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cad_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adressField;
    private javax.swing.JLabel adressLabel;
    private javax.swing.JTextField cepField;
    private javax.swing.JLabel cepLabel;
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField complementField;
    private javax.swing.JLabel complementLabel;
    private javax.swing.JTextField cpfField;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField neighborField;
    private javax.swing.JLabel neighborLabel;
    private javax.swing.JTextField numberField;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JComboBox<String> ufField;
    private javax.swing.JLabel ufLabel;
    // End of variables declaration//GEN-END:variables
}
