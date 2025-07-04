package View;

import DAO.ConnectDAO;
import bancofinal.Conta_Corrente;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Cad_Conta_Corrente extends javax.swing.JFrame {

    String operacaoAtivaGlobal = "Nenhum";

    public Cad_Conta_Corrente() {
        initComponents();
    }

    public Cad_Conta_Corrente(String operacaoAtiva) {
        initComponents();
        operacaoAtivaGlobal = operacaoAtiva;
        String operacao = "Incluir";

        if (operacaoAtiva.equals(operacao)) {
            jButton1.setText("Incluir BD");
        }

        if ("Alterar".equals(operacaoAtiva) || "Excluir".equals(operacaoAtiva)) {
            agLabel.setVisible(false);
            cliLabel.setVisible(false);
            saldoLabel.setVisible(false);
            agField.setVisible(false);
            cliField.setVisible(false);
            saldoField.setVisible(false);
            jButton1.setText("Pesquisar");
            jButton2.setVisible(false);
            jButton3.setVisible(false);
        }

        if ("Consultar".equals(operacaoAtiva)) {
            // 1. Obter a lista de Contas Correntes
            ConnectDAO objcon = new ConnectDAO();
            List<Conta_Corrente> contas = objcon.consultaRegistroCCBD(); // Crie este método no seu DAO

            // 2. Configurar a janela
            JFrame frame = new JFrame("Tabela de Contas Correntes"); // Título atualizado
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(600, 400);

            // 3. Definir as colunas da tabela para ContaCorrente
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Número da Conta");
            model.addColumn("Número da Agência");
            model.addColumn("ID do Cliente");
            model.addColumn("Saldo (R$)");

            // 4. Preencher a tabela com os dados das contas
            for (Conta_Corrente conta : contas) {
                Object[] linha = {
                    conta.getNum_conta(),
                    conta.getNum_agencia(),
                    conta.getID_Cli(),
                    conta.getSaldo()
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

    Conta_Corrente conta_cc = new Conta_Corrente();

    void limpar() {
        ccField.setText("");
        agField.setText("");
        cliField.setText("");
        saldoField.setText("");
    }

    void tudoVisivel() {
        ccLabel.setVisible(true);
        cliLabel.setVisible(true);
        saldoLabel.setVisible(true);
        agLabel.setVisible(true);
        ccField.setVisible(true);
        agField.setVisible(true);
        cliField.setVisible(true);
        saldoField.setVisible(true);
    }

    void naoEditavel() {
        ccField.setEditable(false);
        agField.setEditable(false);
        cliField.setEditable(false);
        saldoField.setEditable(false);
    }

    void lerDados() {
        ccField.setText(conta_cc.getNum_agencia());
        agField.setText(conta_cc.getID_Cli());
        cliField.setText(String.valueOf(conta_cc.getNum_conta()));
        saldoField.setText(Float.toString(conta_cc.getSaldo()));
    }

    void inserirAtualizar() {
        conta_cc.setID_Cli(cliField.getText());
        conta_cc.setNum_agencia(agField.getText());
        conta_cc.setNum_conta(Integer.parseInt(ccField.getText()));
        conta_cc.setSaldo(Float.parseFloat(saldoField.getText()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ccLabel = new javax.swing.JLabel();
        ccField = new javax.swing.JTextField();
        agField = new javax.swing.JTextField();
        agLabel = new javax.swing.JLabel();
        cliField = new javax.swing.JTextField();
        cliLabel = new javax.swing.JLabel();
        saldoField = new javax.swing.JTextField();
        saldoLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ccLabel.setText("Número da Conta:");

        agLabel.setText("Número da Agência:");

        cliLabel.setText("ID do Cliente:");

        saldoLabel.setText("Saldo da Conta:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ccLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ccField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(agLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agField, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cliLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cliField, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saldoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saldoField, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(68, 68, 68)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ccLabel)
                    .addComponent(ccField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agLabel)
                    .addComponent(agField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cliLabel)
                    .addComponent(cliField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saldoLabel)
                    .addComponent(saldoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Cadastrar
        String operacao = "Incluir";
        if (operacaoAtivaGlobal.equals(operacao)) {
            inserirAtualizar();

            ConnectDAO objcon = new ConnectDAO();
            objcon.insereRegistroJFBD("CONTACORRENTE", conta_cc.dadosSQLValues());

            limpar();
        }

        operacao = "Alteração";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            inserirAtualizar();

            objcon.alteraRegistroJFBD("CONTACORRENTE", conta_cc.alteraDadosSQLValues(),
                    "NUM_CC=" + ccField.getText() + "");

            limpar();
        }
        operacao = "Alterar";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            conta_cc = objcon.pesquisaCCJFBD("CONTACORRENTE", "NUM_CC=" + ccField.getText() + "");
            lerDados();

            tudoVisivel();
            jButton1.setText("Alterar");
            operacaoAtivaGlobal = "Alteração";

        }
        
        operacao = "Exclusão";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            objcon.excluiRegistroJFBD("CONTACORRENTE", "NUM_CC=" + ccField.getText());

            limpar();
            this.dispose();
        }

        operacao = "Excluir";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            conta_cc = objcon.pesquisaCCJFBD("CONTACORRENTE", "NUM_CC=" + ccField.getText() + "");
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
                new Cad_Conta_Corrente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agField;
    private javax.swing.JLabel agLabel;
    private javax.swing.JTextField ccField;
    private javax.swing.JLabel ccLabel;
    private javax.swing.JTextField cliField;
    private javax.swing.JLabel cliLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField saldoField;
    private javax.swing.JLabel saldoLabel;
    // End of variables declaration//GEN-END:variables
}
