package model;
public class Equipamento {
    private int pos;//posição do registro na tabela
    private String nomeEq;//descrição do equipamento
    private double pot;//potência de consumo em watts do equipamento
    private double tempo;//o tempo médio (h) de uso em 30 dias 
    private String med;//a unidade de medida sobre o tempo uso (horas ou minuto)
    private double kwh;//valor total de consumo kw/h do equipamento por 30 dias
    private double reais;//valor em reais gasto pelo equipamento por 30 dias

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getNomeEq() {
        return nomeEq;
    }

    public void setNomeEq(String nomeEq) {
        this.nomeEq = nomeEq;
    }

    public double getPot() {
        return pot;
    }

    public void setPot(double pot) {
        this.pot = pot;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public String getMed() {
        return med;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public double getKwh() {
        return kwh;
    }

    public void setKwh(double kwh) {
        this.kwh = kwh;
    }

    public double getReais() {
        return reais;
    }

    public void setReais(double reais) {
        this.reais = reais;
    }
   
}//class
