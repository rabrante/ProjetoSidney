/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.model;

import javafx.beans.property.SimpleStringProperty;

public class ItemPedido {

    private SimpleStringProperty pedido;
    private SimpleStringProperty codArt;
    private SimpleStringProperty descricao;
    private SimpleStringProperty qtdSai;
    private SimpleStringProperty qtdRet;
    private SimpleStringProperty preCus;
    private SimpleStringProperty preVen;
    
    public ItemPedido(String Pedido, 
                        String codArt, 
                        String descricao, 
                        String qtdSai,
                        String qtdRet,
                        String preVen, 
                        String preCus){
        this.pedido = new SimpleStringProperty(Pedido);
        this.codArt = new SimpleStringProperty(codArt);
        this.descricao = new SimpleStringProperty(descricao);
        this.qtdSai = new SimpleStringProperty(qtdSai);
        this.qtdRet = new SimpleStringProperty(qtdRet);
        this.preVen = new SimpleStringProperty(preVen);
        this.preCus = new SimpleStringProperty(preCus);
    }
    
    public String getPedido() {
        return pedido.get();
    }

    public void setPedido(String Pedido) {
        this.pedido = new SimpleStringProperty(Pedido);
    }

    public String getCodArt() {
        return codArt.get();
    }

    public void setCodArt(String codArt) {
        this.codArt = new SimpleStringProperty(codArt);
    }

    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricao(String Descricao) {
        this.descricao = new SimpleStringProperty(Descricao);
    }

    public String getQtdSai() {
        return qtdSai.get();
    }

    public void setQtdSai(String qtdSai) {
        this.qtdSai = new SimpleStringProperty(qtdSai);
    }

    public String getQtdRet() {
        return qtdRet.get();
    }

    public void setQtdRet(String qtdRet) {
        this.qtdRet = new SimpleStringProperty(qtdRet);
    }

    public String getPrecus() {
        return preCus.get();
    }

    public void setPrecus(String Precus) {
        this.preCus = new SimpleStringProperty(Precus);
    }

    public String getPreven() {
        return preVen.get();
    }

    public void setPreven(String Preven) {
        this.preVen = new  SimpleStringProperty(Preven);
    }
    
}
