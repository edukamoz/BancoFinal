package DAO;

import java.util.List;
import java.util.ArrayList;
import bancofinal.Clientes;
import bancofinal.Agencia;
import bancofinal.Conta_Corrente;
import bancofinal.Historicos;
import bancofinal.Movimentacao;
import bancofinal.Usuarios;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
// import javax.swing.table.AbstractTableModel;

public class ConnectDAO {

    Connection con;

    public Connection ConnectDB() {
        JOptionPane.showMessageDialog(null, "Inicia a classe para conexão com SQL SERVER!");

        String caminho = "jdbc:sqlserver://localhost:1433;databaseName=MOV_CONTA_CORRENTE;"
                + "encrypt=true;trustServerCertificate=true;";
        String usuario = "sa";
        String senha = ".";
        try {
            con = DriverManager.getConnection(caminho, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
            JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
            JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
        }
        return con;
        // con.close();
    }

    public void insereRegistroJFBD(String tabela, String strDados) {

        con = ConnectDB();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "INSERT INTO dbo." + tabela + " "
                    + "VALUES (" + strDados + ")";
            JOptionPane.showMessageDialog(null, "String de Insert: " + sql);

            try {
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Inclusão executada com sucesso!");
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
            }

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void alteraRegistroJFBD(String tabela, String strDados, String pesquisaId) {
        con = ConnectDB();

        {
            Statement stmt;
            try {
                stmt = con.createStatement();

                String sql = "UPDATE dbo." + tabela
                        + " SET " + strDados
                        + " WHERE (" + pesquisaId + ");";
                try {
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Inclusão executada com sucesso!");
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
                }

                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void excluiRegistroJFBD(String tabela, String pesquisaId) {
        con = ConnectDB();
        {
            Statement stmt;
            try {
                stmt = con.createStatement();

                String sql = "DELETE dbo." + tabela + " WHERE (" + pesquisaId + ");";

                try {
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Inclusão executada com sucesso!");
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
                }

                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Clientes pesquisaClienteJFBD(String tabela, String pesquisaId) {
        Clientes clientesReturn = new Clientes();
        String tabelaSGBD = "CLIENTES";
        if (tabela.equals(tabelaSGBD)) {
            con = ConnectDB();

            Statement stmt;
            try {
                stmt = con.createStatement();

                String sql = "SELECT * FROM " + tabela + " WHERE " + pesquisaId;

                try {
                    ResultSet dados;
                    dados = stmt.executeQuery(sql);
                    if (dados.next() == false) {

                        JOptionPane.showMessageDialog(null, "Nenhum registro foi encontrado para essa pesquisa.");

                    } else {
                        clientesReturn.setNome(dados.getString(2));
                        clientesReturn.setCPF(dados.getString(3));
                        clientesReturn.setEndereco(dados.getString(4));
                        clientesReturn.setNumero(dados.getString(5));
                        clientesReturn.setComplemento(dados.getString(6));
                        clientesReturn.setBairro(dados.getString(7));
                        clientesReturn.setCidade(dados.getString(8));
                        clientesReturn.setUF(dados.getString(9));
                        clientesReturn.setCep(dados.getString(10));
                        clientesReturn.setEmail(dados.getString(11));
                    }

                    con.close();

                    return clientesReturn;

                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
                }

                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return clientesReturn;

    }

    public List<Clientes> consultaRegistroClienteBD() {
        con = ConnectDB();
        List<Clientes> clientes = new ArrayList<>();

        Statement stmt;

        try {
            stmt = con.createStatement();
            // Cria a string com a sentença SQL para excluir registro.
            String sql = "SELECT * FROM CLIENTES";

            try {
                //Execute a sentença de delete7
                ResultSet dados = stmt.executeQuery(sql);
                JOptionPane.showMessageDialog(null, "Select executado com sucesso");
                int i = 0;
                while (dados.next()) {
                    if (i == 0) {
                        i++;
                    }
                    Clientes cliente = new Clientes(
                            dados.getString("NOME_CLI"),
                            dados.getString("CPF_CLI"),
                            dados.getString("ENDE_CLI"),
                            dados.getString("NUME_CLI"),
                            dados.getString("COMPL_CLI"),
                            dados.getString("BAIR_CLI"),
                            dados.getString("CIDA_CLI"),
                            dados.getString("UF_CLI"),
                            dados.getString("CEP_CLI"),
                            dados.getString("EMAIL_CLI")
                    );
                    clientes.add(cliente);
                }
                con.close();
                return clientes; //lista;

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Agencia pesquisaAgenciaJFBD(String tabela, String pesquisaId) {
        Agencia agenciaReturn = new Agencia();
        String tabelaSGBD = "AGENCIAS";
        if (tabela.equals(tabelaSGBD)) {
            con = ConnectDB();

            Statement stmt;
            try {
                stmt = con.createStatement();

                String sql = "SELECT * FROM " + tabela + " WHERE " + pesquisaId;

                try {
                    ResultSet dados;
                    dados = stmt.executeQuery(sql);
                    if (dados.next() == false) {

                        JOptionPane.showMessageDialog(null, "Nenhum registro foi encontrado para essa pesquisa.");

                    } else {
                        agenciaReturn.setNome(dados.getString(2));
                        agenciaReturn.setEndereco(dados.getString(3));
                        agenciaReturn.setNumero(dados.getString(4));
                        agenciaReturn.setComplemento(dados.getString(5));
                        agenciaReturn.setBairro(dados.getString(6));
                        agenciaReturn.setCidade(dados.getString(7));
                        agenciaReturn.setUF(dados.getString(8));
                        agenciaReturn.setCEP(dados.getString(9));
                        agenciaReturn.setCNPJ(dados.getString(10));
                        agenciaReturn.setGerente(dados.getString(11));
                    }

                    con.close();

                    return agenciaReturn;

                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
                }

                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return agenciaReturn;

    }

    public List<Agencia> consultaRegistroAgenciaBD() {
        con = ConnectDB();
        List<Agencia> agencias = new ArrayList<>();

        Statement stmt;

        try {
            stmt = con.createStatement();
            // Cria a string com a sentença SQL para excluir registro.
            String sql = "SELECT * FROM AGENCIAS";

            try {
                //Execute a sentença de delete7
                ResultSet dados = stmt.executeQuery(sql);
                JOptionPane.showMessageDialog(null, "Select executado com sucesso");
                int i = 0;
                while (dados.next()) {
                    if (i == 0) {
                        i++;
                    }
                    Agencia agencia = new Agencia(
                            dados.getString("NOME_AGE"),
                            dados.getString("ENDE_AGE"),
                            dados.getString("NUME_AGE"),
                            dados.getString("COMPL_AGE"),
                            dados.getString("BAIR_AGE"),
                            dados.getString("CIDA_AGE"),
                            dados.getString("UF_AGE"),
                            dados.getString("CEP_AGE"),
                            dados.getString("CNPJ_AGE"),
                            dados.getString("GER_AGE")
                    );
                    agencias.add(agencia);
                }
                con.close();
                return agencias; //lista;

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Conta_Corrente pesquisaCCJFBD(String tabela, String pesquisaId) {
        Conta_Corrente ccReturn = new Conta_Corrente();
        String tabelaSGBD = "CONTACORRENTE";
        if (tabela.equals(tabelaSGBD)) {
            con = ConnectDB();

            Statement stmt;
            try {
                stmt = con.createStatement();

                String sql = "SELECT * FROM " + tabela + " WHERE " + pesquisaId;

                try {
                    ResultSet dados;
                    dados = stmt.executeQuery(sql);
                    if (dados.next() == false) {

                        JOptionPane.showMessageDialog(null, "Nenhum registro foi encontrado para essa pesquisa.");

                    } else {
                        ccReturn.setNum_agencia(dados.getString(1));
                        ccReturn.setNum_conta(dados.getInt(2));
                        ccReturn.setID_Cli(dados.getString(3));
                        ccReturn.setSaldo(dados.getInt(4));
                    }

                    con.close();

                    return ccReturn;

                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
                }

                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ccReturn;

    }

    public List<Conta_Corrente> consultaRegistroCCBD() {
        con = ConnectDB();
        List<Conta_Corrente> ccs = new ArrayList<>();

        Statement stmt;

        try {
            stmt = con.createStatement();
            // Cria a string com a sentença SQL para excluir registro.
            String sql = "SELECT * FROM CONTACORRENTE";

            try {
                //Execute a sentença de delete7
                ResultSet dados = stmt.executeQuery(sql);
                JOptionPane.showMessageDialog(null, "Select executado com sucesso");
                int i = 0;
                while (dados.next()) {
                    if (i == 0) {
                        i++;
                    }
                    Conta_Corrente cc = new Conta_Corrente(
                            dados.getInt("NUM_CC"),
                            dados.getString("ID_AGE"),
                            dados.getString("ID_CLI"),
                            dados.getFloat("SALDO")
                    );
                    ccs.add(cc);
                }
                con.close();
                return ccs; //lista;

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Historicos pesquisaHistoricosJFBD(String tabela, String pesquisaId) {
        Historicos historicoReturn = new Historicos();
        String tabelaSGBD = "HISTORICOS";
        if (tabela.equals(tabelaSGBD)) {
            con = ConnectDB();

            Statement stmt;
            try {
                stmt = con.createStatement();

                String sql = "SELECT * FROM " + tabela + " WHERE " + pesquisaId;

                try {
                    ResultSet dados;
                    dados = stmt.executeQuery(sql);
                    if (dados.next() == false) {

                        JOptionPane.showMessageDialog(null, "Nenhum registro foi encontrado para essa pesquisa.");

                    } else {
                        historicoReturn.setHistorico(dados.getString(2));
                    }

                    con.close();

                    return historicoReturn;

                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
                }

                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return historicoReturn;

    }

    public List<Historicos> consultaRegistroHistBD() {
        con = ConnectDB();
        List<Historicos> hists = new ArrayList<>();

        Statement stmt;

        try {
            stmt = con.createStatement();
            // Cria a string com a sentença SQL para excluir registro.
            String sql = "SELECT * FROM HISTORICOS";

            try {
                //Execute a sentença de delete7
                ResultSet dados = stmt.executeQuery(sql);
                JOptionPane.showMessageDialog(null, "Select executado com sucesso");
                int i = 0;
                while (dados.next()) {
                    if (i == 0) {
                        i++;
                    }
                    Historicos hist = new Historicos(
                            dados.getString("ID_HIS"),
                            dados.getString("DES_HIS")
                    );
                    hists.add(hist);
                }
                con.close();
                return hists; //lista;

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Movimentacao pesquisaMovJFBD(String tabela, String pesquisaId) {
        Movimentacao movimentacaoReturn = new Movimentacao();
        String tabelaSGBD = "MOVIMENTACAO";
        if (tabela.equals(tabelaSGBD)) {
            con = ConnectDB();

            Statement stmt;
            try {
                stmt = con.createStatement();

                String sql = "SELECT * FROM " + tabela + " WHERE " + pesquisaId;

                try {
                    ResultSet dados;
                    dados = stmt.executeQuery(sql);
                    if (dados.next() == false) {

                        JOptionPane.showMessageDialog(null, "Nenhum registro foi encontrado para essa pesquisa.");

                    } else {
                        movimentacaoReturn.setNum_Agencia(dados.getInt(1));
                        movimentacaoReturn.setNum_Conta(dados.getString(2));
                        movimentacaoReturn.setData_Mov(dados.getString(3));
                        movimentacaoReturn.setDocumento(dados.getString(4));
                        movimentacaoReturn.setCredOuDeb(dados.getString(5).charAt(0));
                        movimentacaoReturn.setID_Hist(dados.getInt(6));
                        movimentacaoReturn.setCompl_Hist(dados.getString(7));
                        movimentacaoReturn.setValor(dados.getInt(8));
                        movimentacaoReturn.setSaldo(dados.getInt(9));
                    }

                    con.close();

                    return movimentacaoReturn;

                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
                }

                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return movimentacaoReturn;

    }

    public List<Movimentacao> consultaRegistroMovBD() {
        con = ConnectDB();
        List<Movimentacao> movs = new ArrayList<>();

        Statement stmt;

        try {
            stmt = con.createStatement();
            // Cria a string com a sentença SQL para excluir registro.
            String sql = "SELECT * FROM MOVIMENTACAO";

            try {
                //Execute a sentença de delete7
                ResultSet dados = stmt.executeQuery(sql);
                JOptionPane.showMessageDialog(null, "Select executado com sucesso");
                int i = 0;
                while (dados.next()) {
                    if (i == 0) {
                        i++;
                    }
                    Movimentacao mov = new Movimentacao(
                            dados.getString("ID_AGE"),
                            dados.getInt("NUM_CC"),
                            dados.getString("DATA_MOV"),
                            dados.getString("NUM_DOCTO"),
                            dados.getString("DEBITO_CREDITO").charAt(0),
                            dados.getInt("ID_HIS"),
                            dados.getString("COMPL_HIS"),
                            dados.getFloat("VALOR"),
                            dados.getFloat("SALDO")
                    );
                    movs.add(mov);
                }
                con.close();
                return movs; //lista;

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Usuarios pesquisaUsuarioJFBD(String tabela, String pesquisaId) {
        Usuarios usuariosReturn = new Usuarios();
        String tabelaSGBD = "USUARIOS";
        if (tabela.equals(tabelaSGBD)) {
            con = ConnectDB();

            Statement stmt;
            try {
                stmt = con.createStatement();

                String sql = "SELECT * FROM " + tabela + " WHERE " + pesquisaId;

                try {
                    ResultSet dados;
                    dados = stmt.executeQuery(sql);
                    if (dados.next() == false) {

                        JOptionPane.showMessageDialog(null, "Nenhum registro foi encontrado para essa pesquisa.");

                    } else {
                        usuariosReturn.setSenha(dados.getString(2));
                        usuariosReturn.setNum_AGE(dados.getInt(3));
                        usuariosReturn.setNum_CC(dados.getInt(4));
                    }

                    con.close();

                    return usuariosReturn;

                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
                }

                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return usuariosReturn;

    }

    public List<Usuarios> consultaRegistroUsuBD() {
        con = ConnectDB();
        List<Usuarios> usuarios = new ArrayList<>();

        Statement stmt;

        try {
            stmt = con.createStatement();
            // Cria a string com a sentença SQL para excluir registro.
            String sql = "SELECT * FROM USUARIOS";

            try {
                //Execute a sentença de delete7
                ResultSet dados = stmt.executeQuery(sql);
                JOptionPane.showMessageDialog(null, "Select executado com sucesso");
                int i = 0;
                while (dados.next()) {
                    if (i == 0) {
                        i++;
                    }
                    Usuarios usu = new Usuarios(
                            dados.getString("SENHA"),
                            dados.getInt("NUM_AGE"),
                            dados.getInt("NUM_CC")
                    );
                    usuarios.add(usu);
                }
                con.close();
                return usuarios; //lista;

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet consultaRegistroClienteRSBD() {
        con = ConnectDB();

        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "SELECT * FROM CLIENTES";

            try {
                ResultSet dados = stmt.executeQuery(sql);
                JOptionPane.showMessageDialog(null, "Select executado com sucesso!");

                return dados;
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => " + erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => " + erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => " + erro.getErrorCode());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
