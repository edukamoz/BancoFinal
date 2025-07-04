package View;

import bancofinal.Movimentacao;
import DAO.ConnectDAO;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Cad_Mov extends javax.swing.JFrame {

    String operacaoAtivaGlobal = "Nenhum";

    public Cad_Mov() {
        initComponents();
    }

    public Cad_Mov(String operacaoAtiva) {
        initComponents();
        operacaoAtivaGlobal = operacaoAtiva;
        String operacao = "Incluir";

        if (operacaoAtiva.equals(operacao)) {
            jButton1.setText("Incluir BD");
        }

        if ("Alterar".equals(operacaoAtiva) || "Excluir".equals(operacaoAtiva)) {
            numContaLabel.setVisible(false);
            docLabel.setVisible(false);
            dataMovLabel.setVisible(false);
            tipoLabel.setVisible(false);
            idHistLabel.setVisible(false);
            complementLabel.setVisible(false);
            valueLabel.setVisible(false);
            saldoLabel.setVisible(false);
            numContaField.setVisible(false);
            docField.setVisible(false);
            dataMovField.setVisible(false);
            idHistField.setVisible(false);
            ComplementField.setVisible(false);
            saldoField.setVisible(false);
            tipoBox.setVisible(false);
            jButton1.setText("Pesquisar");
            jButton2.setVisible(false);
            jButton3.setVisible(false);
        }

        if ("Consultar".equals(operacaoAtiva)) {
            // 1. Obter a lista de Movimentações
            ConnectDAO objcon = new ConnectDAO();
            // Supondo que o método receba a conta e agência para filtrar o extrato
            List<Movimentacao> movimentacoes = objcon.consultaRegistroMovBD();

            // 2. Configurar a janela
            JFrame frame = new JFrame("Extrato de Movimentação da Conta");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(800, 500);

            // 3. Definir as colunas da tabela para um extrato claro
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID_Age");
            model.addColumn("Num_CC");
            model.addColumn("Documento");
            model.addColumn("C/D"); // Crédito ou Débito
            model.addColumn("Histórico");
            model.addColumn("Compl_Histórico");
            model.addColumn("Valor (R$)");
            model.addColumn("Saldo (R$)");

            // 4. Preencher a tabela com os dados das movimentações
            for (Movimentacao movimentacao : movimentacoes) {
                Object[] linha = {
                    movimentacao.getNum_Agencia(),
                    movimentacao.getNum_Conta(),
                    movimentacao.getDocumento(),
                    movimentacao.getCredOuDeb(),
                    movimentacao.getID_Hist(),
                    movimentacao.getCompl_Hist(),
                    movimentacao.getValor(),
                    movimentacao.getSaldo()
                };
                model.addRow(linha);
            }

            // 5. Configurar e exibir a tabela
            JTable tabela = new JTable(model);

            JScrollPane scrollPane = new JScrollPane(tabela);

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

    }

    Movimentacao tela_mv = new Movimentacao();

    void limpar() {
        numContaField.setText("");
        numAgField.setText("");
        docField.setText("");
        dataMovField.setText("");
        idHistField.setText("");
        ComplementField.setText("");
        saldoField.setText("");
        valueField.setText("");
        tipoBox.setSelectedItem("Crédito");
    }

    void tudoVisivel() {
        numContaLabel.setVisible(true);
        docLabel.setVisible(true);
        dataMovLabel.setVisible(true);
        numAgLabel.setVisible(true);
        tipoLabel.setVisible(true);
        idHistLabel.setVisible(true);
        complementLabel.setVisible(true);
        valueLabel.setVisible(true);
        saldoLabel.setVisible(true);
        numContaField.setVisible(true);
        numAgField.setVisible(true);
        docField.setVisible(true);
        dataMovField.setVisible(true);
        idHistField.setVisible(true);
        ComplementField.setVisible(true);
        saldoField.setVisible(true);
        tipoBox.setVisible(true);
    }

    void naoEditavel() {
        numContaField.setEditable(false);
        numAgField.setEditable(false);
        docField.setEditable(false);
        dataMovField.setEditable(false);
        idHistField.setEditable(false);
        ComplementField.setEditable(false);
        saldoField.setEditable(false);
        tipoBox.setEditable(false);
    }

    void lerDados() {
        numContaField.setText(tela_mv.getNum_Conta());
        numAgField.setText(String.valueOf(tela_mv.getNum_Agencia()));
        docField.setText(tela_mv.getDocumento());
        dataMovField.setText(tela_mv.getData_Mov());
        idHistField.setText(String.valueOf(tela_mv.getID_Hist()));
        ComplementField.setText(tela_mv.getCompl_Hist());
        valueField.setText(String.valueOf(tela_mv.getValor()));
        saldoField.setText(String.valueOf(tela_mv.getSaldo()));
        tipoBox.setSelectedItem(tela_mv.getCredOuDeb());
    }

    void inserirAlterar() {
        tela_mv.setNum_Conta(numContaField.getText());
        tela_mv.setNum_Agencia(Integer.parseInt(numAgField.getText()));
        tela_mv.setDocumento(docField.getText());
        tela_mv.setData_Mov(dataMovField.getText());
        tela_mv.setCredOuDeb(tipoBox.getSelectedItem().toString().charAt(0));
        tela_mv.setID_Hist(Integer.parseInt(idHistField.getText()));
        tela_mv.setCompl_Hist(ComplementField.getText());
        tela_mv.setValor(Float.parseFloat(saldoField.getText()));
        tela_mv.setSaldo(Float.parseFloat(valueField.getText()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        numContaLabel = new javax.swing.JLabel();
        numAgLabel = new javax.swing.JLabel();
        docLabel = new javax.swing.JLabel();
        dataMovLabel = new javax.swing.JLabel();
        tipoBox = new javax.swing.JComboBox<>();
        tipoLabel = new javax.swing.JLabel();
        idHistLabel = new javax.swing.JLabel();
        complementLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        saldoLabel = new javax.swing.JLabel();
        numContaField = new javax.swing.JTextField();
        numAgField = new javax.swing.JTextField();
        docField = new javax.swing.JTextField();
        dataMovField = new javax.swing.JTextField();
        idHistField = new javax.swing.JTextField();
        ComplementField = new javax.swing.JTextField();
        saldoField = new javax.swing.JTextField();
        valueField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpar tela");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ler");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        numContaLabel.setText("Número da conta:");

        numAgLabel.setText("Número da agência:");

        docLabel.setText("Documento:");

        dataMovLabel.setText("Data de movimentação:");

        tipoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crédito", "Débito" }));

        tipoLabel.setText("Tipo de movimentação:");

        idHistLabel.setText("ID Histórico:");

        complementLabel.setText("Complemento:");

        valueLabel.setText("Valor:");

        saldoLabel.setText("Saldo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numContaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numContaField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numAgLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numAgField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(docLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(docField))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tipoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dataMovLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(dataMovField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idHistLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idHistField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(complementLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComplementField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(valueLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valueField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saldoLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(saldoField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numContaLabel)
                    .addComponent(numContaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numAgLabel)
                    .addComponent(numAgField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(docLabel)
                    .addComponent(docField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataMovLabel)
                    .addComponent(dataMovField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoLabel)
                    .addComponent(tipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idHistLabel)
                    .addComponent(idHistField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(complementLabel)
                    .addComponent(ComplementField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueLabel)
                    .addComponent(saldoLabel)
                    .addComponent(saldoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Cadastrar
        String operacao = "Incluir";
        if (operacaoAtivaGlobal.equals(operacao)) {
            inserirAlterar();

            ConnectDAO objcon = new ConnectDAO();
            objcon.insereRegistroJFBD("MOVIMENTACAO", tela_mv.dadosSQLValues());

            limpar();
        }

        operacao = "Alteração";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            inserirAlterar();

            objcon.alteraRegistroJFBD("MOVIMENTACAO", tela_mv.alteraDadosSQLValues(),
                    "ID_AGE=" + numAgField.getText());

            limpar();
        }

        operacao = "Alterar";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            tela_mv = objcon.pesquisaMovJFBD("MOVIMENTACAO", "ID_AGE=" + numAgField.getText());
            lerDados();

            tudoVisivel();
            jButton1.setText("Alterar");
            operacaoAtivaGlobal = "Alteração";

        }

        operacao = "Exclusão";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            objcon.excluiRegistroJFBD("MOVIMENTACAO", "ID_AGE=" + numAgField.getText());

            limpar();
        }

        operacao = "Excluir";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            tela_mv = objcon.pesquisaMovJFBD("MOVIMENTACAO", "ID_AGE=" + numAgField.getText());
            lerDados();

            tudoVisivel();
            jButton1.setText("Excluir");
            operacaoAtivaGlobal = "Exclusão";

            naoEditavel();

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Limpar
        limpar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Ler
        lerDados();
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cad_Mov().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ComplementField;
    private javax.swing.JLabel complementLabel;
    private javax.swing.JTextField dataMovField;
    private javax.swing.JLabel dataMovLabel;
    private javax.swing.JTextField docField;
    private javax.swing.JLabel docLabel;
    private javax.swing.JTextField idHistField;
    private javax.swing.JLabel idHistLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField numAgField;
    private javax.swing.JLabel numAgLabel;
    private javax.swing.JTextField numContaField;
    private javax.swing.JLabel numContaLabel;
    private javax.swing.JTextField saldoField;
    private javax.swing.JLabel saldoLabel;
    private javax.swing.JComboBox<String> tipoBox;
    private javax.swing.JLabel tipoLabel;
    private javax.swing.JTextField valueField;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
