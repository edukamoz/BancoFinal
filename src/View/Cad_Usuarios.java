package View;

import DAO.ConnectDAO;
import bancofinal.Usuarios;
import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Cad_Usuarios extends javax.swing.JFrame {

    String operacaoAtivaGlobal = "Nenhum";

    public Cad_Usuarios() {
        initComponents();
    }

    public Cad_Usuarios(String operacaoAtiva) {
        initComponents();
        operacaoAtivaGlobal = operacaoAtiva;
        String operacao = "Incluir";

        if (operacaoAtiva.equals(operacao)) {
            jButton3.setText("Incluir BD");
        }

        if ("Alterar".equals(operacaoAtiva) || "Excluir".equals(operacaoAtiva)) {
            passwordLabel.setVisible(false);
            agLabel.setVisible(false);
            ccLabel.setVisible(false);
            passwordField.setVisible(false);
            agField.setVisible(false);
            ccField.setVisible(false);
            jButton3.setText("Pesquisar");
            jButton4.setVisible(false);
            jButton2.setVisible(false);
            jButton1.setVisible(false);
        }

        if ("Consultar".equals(operacaoAtiva)) {
            // Obter a lista de usuários do banco
            ConnectDAO objcon = new ConnectDAO();
            List<Usuarios> usuarios = objcon.consultaRegistroUsuBD();

            // Configurar a janela
            JFrame frame = new JFrame("Tabela de Usuários");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 300);

            // Definir as colunas da tabela
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nº da Agência");
            model.addColumn("Nº da Conta");
            model.addColumn("Senha"); // Atenção à segurança!

            // Preencher a tabela com os dados dos usuários
            // Assumindo que a classe Usuario tem os getters: getNumAge(), getNumCc(), getSenha()
            for (Usuarios usuario : usuarios) {
                Object[] linha = {
                    usuario.getNum_AGE(),
                    usuario.getNum_CC(),
                    usuario.getSenha()
                };
                model.addRow(linha);
            }

            // Configurar e exibir a tabela
            JTable tabela = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(tabela);

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

    }

    Usuarios tela_usu = new Usuarios();
    boolean senhaVisivel = false;

    void limpar() {
        agField.setText("");
        ccField.setText("");
        passwordField.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        passwordLabel = new javax.swing.JLabel();
        agLabel = new javax.swing.JLabel();
        ccLabel = new javax.swing.JLabel();
        agField = new javax.swing.JTextField();
        ccField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        IdLabel = new javax.swing.JLabel();
        IdField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        passwordLabel.setText("Senha:");

        agLabel.setText("Número da Agência:");

        ccLabel.setText("Número da Conta Corrente:");

        jButton2.setText("Limpar tela");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cadastrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Ler");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("Mostrar Senha");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        IdLabel.setText("Id do Usuário:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(agLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(passwordLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ccLabel)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(115, 115, 115)
                                .addComponent(jButton3))
                            .addComponent(ccField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IdField)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdLabel)
                    .addComponent(IdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agLabel)
                    .addComponent(agField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ccLabel)
                    .addComponent(ccField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Limpar:
        limpar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Cadastrar:
        String operacao = "Incluir";
        if (operacaoAtivaGlobal.equals(operacao)) {
            tela_usu.setSenha(Arrays.toString(passwordField.getPassword()));
            tela_usu.setNum_AGE(Integer.parseInt(agField.getText()));
            tela_usu.setNum_CC(Integer.parseInt(ccField.getText()));

            ConnectDAO objcon = new ConnectDAO();
            objcon.insereRegistroJFBD("USUARIOS", tela_usu.dadosSQLValues());

            agField.setText(String.valueOf(tela_usu.getNum_AGE()));
            ccField.setText(String.valueOf(tela_usu.getNum_CC()));
            passwordField.setText(tela_usu.getSenha());
        }

        operacao = "Alteração";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            tela_usu.setNum_AGE(Integer.parseInt(agField.getText()));
            tela_usu.setNum_CC(Integer.parseInt(ccField.getText()));
            tela_usu.setSenha(passwordField.getText());

            objcon.alteraRegistroJFBD("USUARIOS", tela_usu.alteraDadosSQLValues(),
                    "ID_USU='" + IdField.getText() + "'");

            limpar();
        }
        operacao = "Alterar";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            tela_usu = objcon.pesquisaUsuarioJFBD("USUARIOS", "ID_USU='" + IdField.getText() + "'");
            agField.setText(Integer.toString(tela_usu.getNum_AGE()));
            ccField.setText(Integer.toString(tela_usu.getNum_CC()));

            agLabel.setVisible(true);
            ccLabel.setVisible(true);
            passwordLabel.setVisible(true);
            agField.setVisible(true);
            ccField.setVisible(true);
            jButton1.setText("Alterar");
            operacaoAtivaGlobal = "Alteração";

        }

        operacao = "Exclusão";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            objcon.excluiRegistroJFBD("USUARIOS", "ID_USU=" + IdField.getText());

            limpar();
        }
        operacao = "Excluir";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            tela_usu = objcon.pesquisaUsuarioJFBD("USUARIOS", "ID_USU='" + IdField.getText() + "'");
            agField.setText(Integer.toString(tela_usu.getNum_AGE()));
            ccField.setText(Integer.toString(tela_usu.getNum_CC()));

            agLabel.setVisible(true);
            ccLabel.setVisible(true);
            passwordLabel.setVisible(true);
            agField.setVisible(true);
            ccField.setVisible(true);
            jButton1.setText("Excluir");
            operacaoAtivaGlobal = "Exclusão";

            agField.setEditable(false);
            ccField.setEditable(false);

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Ler:
        agField.setText(String.valueOf(tela_usu.getNum_AGE()));
        ccField.setText(String.valueOf(tela_usu.getNum_CC()));
        passwordField.setText(tela_usu.getSenha());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (senhaVisivel) {
            passwordField.setEchoChar('*'); // Oculta a senha
            jButton1.setText("Mostrar senha");
        } else {
            passwordField.setEchoChar((char) 0); // Mostra a senha
            jButton1.setText("Ocultar senha");
        }
        senhaVisivel = !senhaVisivel;
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cad_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IdField;
    private javax.swing.JLabel IdLabel;
    private javax.swing.JTextField agField;
    private javax.swing.JLabel agLabel;
    private javax.swing.JTextField ccField;
    private javax.swing.JLabel ccLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    // End of variables declaration//GEN-END:variables
}
