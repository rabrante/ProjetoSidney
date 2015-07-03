/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.model;

/**
 *
 * @author Rafael
 */
public class Pedido {
    
    private String Pedido;
    private String codArt;
    private String Descricao;
    private float qtdSai;
    private float qtdRet;
    private float Precus;
    private float Preven;
    
    Pedido(String aInt, String aInt0) {
        this.Pedido = aInt;
        this.codArt = aInt0;
    }

   

    public String getPedido() {
        return Pedido;
    }

    public void setPedido(String Pedido) {
        this.Pedido = Pedido;
    }

    public String getCodArt() {
        return codArt;
    }

    public void setCodArt(String codArt) {
        this.codArt = codArt;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public float getQtdSai() {
        return qtdSai;
    }

    public void setQtdSai(int qtdSai) {
        this.qtdSai = qtdSai;
    }

    public float getQtdRet() {
        return qtdRet;
    }

    public void setQtdRet(int qtdRet) {
        this.qtdRet = qtdRet;
    }

    public float getPrecus() {
        return Precus;
    }

    public void setPrecus(float Precus) {
        this.Precus = Precus;
    }

    public float getPreven() {
        return Preven;
    }

    public void setPreven(float Preven) {
        this.Preven = Preven;
    }
    
    
    
    
   public Pedido(String _Pedido, String _codArt, String _Descricao, float _qtdSai, float _qtdRet, float _Precus, float _Preven){
        this.Pedido = _Pedido;
        this.codArt = _codArt;
        this.Descricao = _Descricao;
        this.qtdSai = _qtdSai;
        this.qtdRet = _qtdRet;
        this.Precus = _Precus;
        this.Preven = _Preven;
    }
}
