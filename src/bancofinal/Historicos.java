package bancofinal;

public class Historicos {
    private String ID_Hist;
    private String Historico;

    public Historicos(String ID_Hist, String Historico) {
        this.ID_Hist = ID_Hist;
        this.Historico = Historico;    
    }
    
    public Historicos() {}

    public String getID_Hist() { return ID_Hist; }
    public void setID_Hist(String ID_Hist) { this.ID_Hist = ID_Hist; }

    public String getHistorico() { return Historico; }
    public void setHistorico(String Historico) { this.Historico = Historico; }
    
    public String dadosSQLValues() {
        String dadosHistorico;
        dadosHistorico = "'"
                + this.getHistorico()+ "'";
        return dadosHistorico;
    }
    
    public String alteraDadosSQLValues() {
        String dadosHistorico;
        dadosHistorico = "DES_HIS='"
                + this.getHistorico()+ "'";
        return dadosHistorico;
    }
    
}
