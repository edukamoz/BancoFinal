package View;

import DAO.ConnectDAO;
import bancofinal.Conta_Corrente;

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

        if ("Alterar".equals(operacaoAtiva) || "Consultar".equals(operacaoAtiva) || "Excluir".equals(operacaoAtiva)) {
            jLabel2.setVisible(false);
            jLabel3.setVisible(false);
            jLabel4.setVisible(false);
            jTextField2.setVisible(false);
            jTextField3.setVisible(false);
            jTextField4.setVisible(false);
            jButton1.setText("Pesquisar");
            jButton2.setVisible(false);
            jButton3.setVisible(false);
        }

    }

    Conta_Corrente conta_cc = new Conta_Corrente();

    void limpar() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }

    void tudoVisivel() {
        jLabel1.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jLabel2.setVisible(true);
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        jTextField3.setVisible(true);
        jTextField4.setVisible(true);
    }

    void naoEditavel() {
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
    }

    void lerDados() {
        jTextField1.setText(conta_cc.getNum_agencia());
        jTextField2.setText(conta_cc.getID_Cli());
        jTextField3.setText(conta_cc.getNum_conta());
        jTextField4.setText(Float.toString(conta_cc.getSaldo()));
    }

    void inserirAtualizar() {
        conta_cc.setID_Cli(jTextField3.getText());
        conta_cc.setNum_agencia(jTextField2.getText());
        conta_cc.setNum_conta(jTextField1.getText());
        conta_cc.setSaldo(Float.parseFloat(jTextField4.getText()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Número da Conta:");

        jLabel2.setText("Número da Agência:");

        jLabel3.setText("ID do Cliente:");

        jLabel4.setText("Saldo da Conta:");

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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
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
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    "NUM_CC='" + jTextField3.getText() + "'");

            limpar();
        }
        operacao = "Alterar";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            conta_cc = objcon.pesquisaCCJFBD("CONTACORRENTE", "NUM_CC='" + jTextField3.getText() + "'");
            lerDados();

            tudoVisivel();
            jButton1.setText("Alterar");
            operacaoAtivaGlobal = "Alteração";

        }

        operacao = "Alterar";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            conta_cc = objcon.pesquisaCCJFBD("CONTACORRENTE", "NUM_CC='" + jTextField3.getText() + "'");
            lerDados();

            tudoVisivel();
            jButton1.setText("Alterar");
            operacaoAtivaGlobal = "Alteração";

        }

        operacao = "Consultar";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            objcon.excluiRegistroJFBD("CONTACORRENTE", "NUM_CC=" + jTextField3.getText());

            limpar();

            naoEditavel();
        }

        operacao = "Excluir";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            conta_cc = objcon.pesquisaCCJFBD("CONTACORRENTE", "NUM_CC='" + jTextField3.getText() + "'");
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
