package controller;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.bean.*;
import model.Equipamento;
import java.util.*;
import javax.faces.model.*; //IMPORTAÇÃO NECESSÁRIA PARA MANIPULAR DataTable

@ManagedBean(name = "ct")
@SessionScoped
public class Bean implements Serializable {

    public Bean() {
        setCpVal("0.87");
    }//builder
    
    private String cpNom;//campo nome do equipamento
    private String cpPot;//campo potência do equipamento
    private String cpTmp;//campo tempo informado de uso mensal do equipamento
    private String cpMed;//campo unidade medida de tempo de uso mensal do equipamento
    private String cpVal;//campo valor kW/h cobrado pela compania de energia
    private String cptot;//total em reais a ser pago pela soma de consumo de cada equipamento
    
    private ArrayList<Equipamento> lista = new ArrayList<>(); //vetor java do tipo equipamento (dados lógicos)
    private DataModel dadosTabela; //reponsável por prover os dados para o componente datatable
    Equipamento equip = new Equipamento();
    int pos = 0;
    int poslinha = -1; //determina qual posição da linha selecionada
    double total; //variavel para acumular totaç a ser pago
    
    public void somaTabela(){
        total = 0;
        for (Equipamento e : lista){
            total += e.getReais();
    }
        setCptot(String.valueOf(total));
    }//somaTabela
    
    public void btAlterar(ActionEvent ae){
        poslinha = dadosTabela.getRowIndex(); //pegue a posição da linha em que eu vou alterar
        equip = (Equipamento)dadosTabela.getRowData();
        setCpNom(equip.getNomeEq());
        setCpPot(String.valueOf(equip.getPot()));
        setCpTmp(String.valueOf(equip.getTempo()));
        setCpMed(equip.getMed());
        somaTabela();
    }//btAlterar
    
    public void btRemover(ActionEvent ae){
        equip = (Equipamento)dadosTabela.getRowData();
        //armazerna o objeto do tipo Equipamento para remover na tabela
        lista.remove(equip);
        //remove do vetor o elemento de acordo com o objeto selecionado (linha)
        dadosTabela = new ListDataModel(lista);
        //converte o vetor (lista) para dataModel
        somaTabela();
    }//btRemover
    
    public void btSalvar(ActionEvent ae){
        equip = new Equipamento();
        equip.setNomeEq(getCpNom());
        double pot, kwh, tempo, valorKwh, reais;
        pot = Double.parseDouble(getCpPot());
        tempo = Double.parseDouble(getCpTmp());
        equip.setPos(pos);
        pos++;
        //verificar se escolheu minuo
        if(getCpMed().equals("Minuto"))
            tempo /= 60; //tempo = tempo /60
        //calculo para achar o valor em reais em consumo mensal do equipamento (Kwh)
        kwh = (pot*tempo*30)/1000;
        valorKwh = Double.parseDouble(getCpVal());
        reais = kwh * valorKwh;
        equip.setReais(reais);
        equip.setKwh(kwh);
        equip.setTempo(tempo);
        equip.setPot(pot);
        equip.setMed(getCpMed());
        
        if(poslinha == -1)// não selecionei nenhuma linha para edição da tabela
            lista.add(equip);//adicionando o objeto com os dados do equipamento no vetor
        else//selecionei alguma linha na tabela para edição
            lista.set(poslinha, equip);
        //atualizar no vetor na posição de edição do objeto
        dadosTabela = new ListDataModel(lista);//converte o vetor para um modelo de dados
        setCpNom("");
        setCpPot("");
        setCpTmp("");
        setCpMed("");//retorna o primeiro item da lista
        somaTabela();
    }//btSalvar
    
    ////////////////////////////GET e SET
    public ArrayList<Equipamento> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Equipamento> lista) {
        this.lista = lista;
    }

    public DataModel getDadosTabela() {
        return dadosTabela;
    }

    public void setDadosTabela(DataModel dadosTabela) {
        this.dadosTabela = dadosTabela;
    }
    

    public String getCpNom() {
        return cpNom;
    }

    public void setCpNom(String cpNom) {
        this.cpNom = cpNom;
    }

    public String getCpPot() {
        return cpPot;
    }

    public void setCpPot(String cpPot) {
        this.cpPot = cpPot;
    }

    public String getCpTmp() {
        return cpTmp;
    }

    public void setCpTmp(String cpTmp) {
        this.cpTmp = cpTmp;
    }

    public String getCpMed() {
        return cpMed;
    }

    public void setCpMed(String cpMed) {
        this.cpMed = cpMed;
    }

    public String getCpVal() {
        return cpVal;
    }

    public void setCpVal(String cpVal) {
        this.cpVal = cpVal;
    }

    public String getCptot() {
        return cptot;
    }

    public void setCptot(String cptot) {
        this.cptot = cptot;
    }
    
}//class
