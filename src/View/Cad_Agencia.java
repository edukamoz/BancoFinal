package View;

import DAO.ConnectDAO;
import bancofinal.Agencia;

public class Cad_Agencia extends javax.swing.JFrame {

    String operacaoAtivaGlobal = "Nenhum";

    public Cad_Agencia() {
        initComponents();
    }

    public Cad_Agencia(String operacaoAtiva) {
        initComponents();
        operacaoAtivaGlobal = operacaoAtiva;
        String operacao = "Incluir";

        if (operacaoAtiva.equals(operacao)) {
            jButton1.setText("Incluir BD");
        }

        if ("Alterar".equals(operacaoAtiva) || "Consultar".equals(operacaoAtiva) || "Excluir".equals(operacaoAtiva)) {
            nameLabel.setVisible(false);
            adressLabel.setVisible(false);
            agenLabel.setVisible(false);
            complementLabel.setVisible(false);
            neighborLabel.setVisible(false);
            cityLabel.setVisible(false);
            ufLabel.setVisible(false);
            cepLabel.setVisible(false);
            cnpjLabel.setVisible(false);
            gerLabel.setVisible(false);
            nameField.setVisible(false);
            adressField.setVisible(false);
            agenField.setVisible(false);
            complementField.setVisible(false);
            neighborField.setVisible(false);
            cityField.setVisible(false);
            cepField.setVisible(false);
            cnpjField.setVisible(false);
            gerField.setVisible(false);
            ufBox.setVisible(false);
            jButton1.setText("Pesquisar");
            jButton2.setVisible(false);
            jButton3.setVisible(false);
        }

    }

    Agencia agencia_tela = new Agencia();

    void limpar() {
        agenField.setText("");
        nameField.setText("");
        adressField.setText("");
        complementField.setText("");
        neighborField.setText("");
        cityField.setText("");
        cepField.setText("");
        cnpjField.setText("");
        gerField.setText("");
        ufBox.setSelectedItem("AC");
    }

    void tudoVisivel() {
        agenLabel.setVisible(true);
        adressLabel.setVisible(true);
        nameLabel.setVisible(true);
        complementLabel.setVisible(true);
        neighborLabel.setVisible(true);
        cityLabel.setVisible(true);
        ufLabel.setVisible(true);
        cepLabel.setVisible(true);
        cnpjLabel.setVisible(true);
        cnpjLabel.setVisible(true);
        agenField.setVisible(true);
        nameField.setVisible(true);
        adressField.setVisible(true);
        complementField.setVisible(true);
        neighborField.setVisible(true);
        cityField.setVisible(true);
        cepField.setVisible(true);
        cnpjField.setVisible(true);
        gerField.setVisible(true);
        ufBox.setVisible(true);
    }

    void naoEditavel() {
        agenField.setEditable(false);
        nameField.setEditable(false);
        adressField.setEditable(false);
        complementField.setEditable(false);
        neighborField.setEditable(false);
        cityField.setEditable(false);
        cepField.setEditable(false);
        cnpjField.setEditable(false);
        gerField.setEditable(false);
        ufBox.setEditable(false);
    }

    void lerDados() {
        agenField.setText(agencia_tela.getNumero());
        nameField.setText(agencia_tela.getNome());
        adressField.setText(agencia_tela.getEndereco());
        complementField.setText(agencia_tela.getComplemento());
        neighborField.setText(agencia_tela.getBairro());
        cityField.setText(agencia_tela.getCidade());
        cepField.setText(agencia_tela.getCEP());
        cnpjField.setText(agencia_tela.getCNPJ());
        gerField.setText(agencia_tela.getGerente());
        ufBox.setSelectedItem(agencia_tela.getUF());
    }

    void inserirAtualizar() {
        agencia_tela.setNome(nameField.getText());
        agencia_tela.setEndereco(adressField.getText());
        agencia_tela.setNumero(agenField.getText());
        agencia_tela.setComplemento(complementField.getText());
        agencia_tela.setBairro(neighborField.getText());
        agencia_tela.setCidade(cityField.getText());
        agencia_tela.setCEP(cepField.getText());
        agencia_tela.setCNPJ(cnpjField.getText());
        agencia_tela.setGerente(gerField.getText());
        agencia_tela.setUF(ufBox.getSelectedItem().toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agenLabel = new javax.swing.JLabel();
        agenField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        adressLabel = new javax.swing.JLabel();
        adressField = new javax.swing.JTextField();
        complementLabel = new javax.swing.JLabel();
        complementField = new javax.swing.JTextField();
        neighborLabel = new javax.swing.JLabel();
        neighborField = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        ufLabel = new javax.swing.JLabel();
        cepLabel = new javax.swing.JLabel();
        cepField = new javax.swing.JTextField();
        cnpjLabel = new javax.swing.JLabel();
        cnpjField = new javax.swing.JTextField();
        gerLabel = new javax.swing.JLabel();
        gerField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        ufBox = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        idAgeLabel = new javax.swing.JLabel();
        IdAgeField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        agenLabel.setText("Número da Agência:");

        nameLabel.setText("Nome:");

        adressLabel.setText("Endereço:");

        complementLabel.setText("Complemento:");

        neighborLabel.setText("Bairro:");

        cityLabel.setText("Cidade:");

        ufLabel.setText("UF:");

        cepLabel.setText("CEP:");

        cnpjLabel.setText("CNPJ:");

        gerLabel.setText("Gerente:");

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ufBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RR", "RO", "RJ", "RN", "RS", "SC", "SP", "SE", "TO" }));

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

        idAgeLabel.setText("Id da Agência:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agenLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agenField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(adressLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adressField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(complementLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(complementField, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(neighborLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(neighborField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cityLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cityField, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ufLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ufBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cepLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cepField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cnpjLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cnpjField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gerField))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idAgeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IdAgeField)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idAgeLabel)
                    .addComponent(IdAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agenLabel)
                    .addComponent(agenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adressLabel)
                    .addComponent(adressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(complementLabel)
                    .addComponent(complementField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(neighborLabel)
                    .addComponent(neighborField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityLabel)
                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ufLabel)
                    .addComponent(cepLabel)
                    .addComponent(cepField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cnpjLabel)
                    .addComponent(cnpjField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gerLabel)
                    .addComponent(gerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ufBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Cadastrar:
        String operacao = "Incluir";
        if (operacaoAtivaGlobal.equals(operacao)) {

            inserirAtualizar();
            
            ConnectDAO objcon = new ConnectDAO();
            objcon.insereRegistroJFBD("AGENCIAS", agencia_tela.dadosSQLValues());

            limpar();
            this.dispose();

        }

        operacao = "Alteração";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            inserirAtualizar();

            objcon.alteraRegistroJFBD("AGENCIAS", agencia_tela.alteraDadosSQLValues(),
                    "ID_AGE='" + IdAgeField.getText() + "'");

            limpar();
            this.dispose();
        }

        operacao = "Alterar";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            agencia_tela = objcon.pesquisaAgenciaJFBD("AGENCIAS", "ID_AGE='" + IdAgeField.getText() + "'");
            lerDados();

            tudoVisivel();
            jButton1.setText("Alterar");
            operacaoAtivaGlobal = "Alteração";

        }

        operacao = "Consultar";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            agencia_tela = objcon.pesquisaAgenciaJFBD("AGENCIAS", "ID_AGE='" + IdAgeField.getText() + "'");
            lerDados();
            tudoVisivel();
            naoEditavel();

        }

        operacao = "Exclusão";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            objcon.excluiRegistroJFBD("AGENCIAS", "ID_AGE=" + IdAgeField.getText());

            limpar();
            this.dispose();
        }

        operacao = "Excluir";
        if (operacaoAtivaGlobal.equals(operacao)) {

            ConnectDAO objcon = new ConnectDAO();
            agencia_tela = objcon.pesquisaAgenciaJFBD("AGENCIAS", "ID_AGE='" + IdAgeField.getText() + "'");
            lerDados();

            tudoVisivel();
            jButton1.setText("Excluir");
            operacaoAtivaGlobal = "Exclusão";

            naoEditavel();

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Limpar:
        limpar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Ler:
        lerDados();
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cad_Agencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IdAgeField;
    private javax.swing.JTextField adressField;
    private javax.swing.JLabel adressLabel;
    private javax.swing.JTextField agenField;
    private javax.swing.JLabel agenLabel;
    private javax.swing.JTextField cepField;
    private javax.swing.JLabel cepLabel;
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cnpjField;
    private javax.swing.JLabel cnpjLabel;
    private javax.swing.JTextField complementField;
    private javax.swing.JLabel complementLabel;
    private javax.swing.JTextField gerField;
    private javax.swing.JLabel gerLabel;
    private javax.swing.JLabel idAgeLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField neighborField;
    private javax.swing.JLabel neighborLabel;
    private javax.swing.JComboBox<String> ufBox;
    private javax.swing.JLabel ufLabel;
    // End of variables declaration//GEN-END:variables
}
