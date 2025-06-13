package View;

import DAO.ConnectDAO;
import bancofinal.Historicos;

public class Cad_Hist extends javax.swing.JFrame {

    String operacaoAtivaGlobal = "Nenhum";

    public Cad_Hist() {
        initComponents();
    }

    public Cad_Hist(String operacaoAtiva) {
        initComponents();
        operacaoAtivaGlobal = operacaoAtiva;
        String operacao = "Incluir";

        if (operacaoAtiva.equals(operacao)) {
            jLabel1.setVisible(false);
            jLabel2.setVisible(true);
            jTextField1.setVisible(false);
            jTextField2.setVisible(true);
            jButton1.setText("Incluir BD");
        }

        if ("Alterar".equals(operacaoAtiva) || "Consultar".equals(operacaoAtiva) || "Excluir".equals(operacaoAtiva)) {
            jLabel1.setVisible(true);
            jLabel2.setVisible(false);
            jTextField1.setVisible(true);
            jTextField2.setVisible(false);
            jButton1.setText("Pesquisar");
            jButton2.setVisible(false);
            jButton3.setVisible(false);
        }

    }

    Historicos tela_his = new Historicos();

    void limpar() {
        jTextField1.setText("");
        jTextField2.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Histórico:");

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

        jLabel1.setText("ID Histórico");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jTextField1)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Cadastrar
        String operacao = "Incluir";
        if (operacaoAtivaGlobal.equals(operacao)) {
            tela_his.setHistorico(jTextField2.getText());

            ConnectDAO objcon = new ConnectDAO();
            objcon.insereRegistroJFBD("HISTORICOS", tela_his.dadosSQLValues());

            limpar();
        }

        operacao = "Alteração";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            tela_his.setID_Hist(jTextField1.getText());
            tela_his.setHistorico(jTextField2.getText());

            objcon.alteraRegistroJFBD("HISTORICOS", tela_his.alteraDadosSQLValues(),
                    "ID_HIS='" + jTextField1.getText() + "'");

            limpar();
        }

        operacao = "Alterar";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            tela_his = objcon.pesquisaHistoricosJFBD("HISTORICOS", "ID_HIS='" + jTextField1.getText() + "'");
            jTextField2.setText(tela_his.getHistorico());

            jLabel2.setVisible(true);
            jTextField2.setVisible(true);
            jButton1.setText("Alterar");
            operacaoAtivaGlobal = "Alteração";

        }

        operacao = "Consultar";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            tela_his = objcon.pesquisaHistoricosJFBD("HISTORICOS", "ID_HIS='" + jTextField1.getText() + "'");
            jTextField2.setText(tela_his.getHistorico());

            jLabel2.setVisible(true);
            jTextField2.setVisible(true);

            jTextField2.setEditable(false);

        }

        operacao = "Exclusão";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            objcon.excluiRegistroJFBD("HISTORICOS", "ID_HIS=" + jTextField1.getText());

            limpar();
        }
        operacao = "Excluir";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            tela_his = objcon.pesquisaHistoricosJFBD("HISTORICOS", "ID_HIS='" + jTextField1.getText() + "'");
            jTextField2.setText(tela_his.getHistorico());

            jLabel2.setVisible(true);
            jTextField2.setVisible(true);
            jButton1.setText("Excluir");
            operacaoAtivaGlobal = "Exclusão";

            jTextField2.setEditable(false);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Limpar
        limpar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Ler
        jTextField2.setText(tela_his.getHistorico());
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cad_Hist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
