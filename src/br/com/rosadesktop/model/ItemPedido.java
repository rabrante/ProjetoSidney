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

    public ItemPedido(String pedido, 
                        String codArt,
                        String descricao, 
                        String qtdSai,
                        String qtdRet,
                        String preCus,
                        String preVen) {
        this.pedido = new SimpleStringProperty(pedido);
        this.codArt = new SimpleStringProperty(codArt);
        this.descricao = new SimpleStringProperty(descricao);
        this.qtdSai = new SimpleStringProperty(qtdSai);
        this.qtdRet = new SimpleStringProperty(qtdRet);
        this.preCus = new SimpleStringProperty(preCus);
        this.preVen = new SimpleStringProperty(preVen);
    }

    public String getPedido() {
        return pedido.get();
    }

    public void setPedido(String pedido) {
        this.pedido.set(pedido);
    }

    public String getCodArt() {
        return codArt.get();
    }

    public void setCodArt(String codArt) {
        this.codArt.set(codArt);
    }

    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }

    public String getQtdSai() {
        return qtdSai.get();
    }

    public void setQtdSai(String qtdSai) {
        this.qtdSai.set(qtdSai);
    }

    public String getQtdRet() {
        return qtdRet.get();
    }

    public void setQtdRet(String qtdRet) {
        this.qtdRet.set(qtdRet);
    }

    public String getPreCus() {
        return preCus.get();
    }

    public void setPreCus(String preCus) {
        this.preCus.set(preCus);
    }

    public String getPreVen() {
        return preVen.get();
    }

    public void setPreVen(String preVen) {
        this.preVen.set(preVen);
    }

}
