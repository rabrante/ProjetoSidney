/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Rafael
 */
public class Pedido 
{    
    private SimpleStringProperty  codVend;
    private SimpleStringProperty  pedido;
    private SimpleStringProperty  codCli;
    private SimpleStringProperty  nomCli;
    private SimpleStringProperty  totPed;
    private SimpleStringProperty  situ;
    private SimpleStringProperty  via;
    private SimpleStringProperty  datPed;
    
    public Pedido()
    {

    }

    public Pedido(String codVend, String pedido, String codCli, String nomCli, String totPed, String situ, String via, String datPed) 
    {
        this.codVend = new SimpleStringProperty(codVend);
        this.pedido = new SimpleStringProperty(pedido);
        this.codCli = new SimpleStringProperty(codCli);
        this.nomCli = new SimpleStringProperty(nomCli);
        this.totPed = new SimpleStringProperty(totPed);
        this.situ = new SimpleStringProperty(situ);
        this.via = new SimpleStringProperty(via);
        this.datPed = new SimpleStringProperty(datPed);
    }
    
    public String getCodVend() {
        return codVend.get();
    }

    public void setCodVend(String codVend) {
        this.codVend = new SimpleStringProperty(codVend);
    }

    public String getPedido() {
        return pedido.get();
    }

    public void setPedido(String pedido) {
        this.pedido = new SimpleStringProperty(pedido);
    }

    public String getCodCli() {
        return codCli.get();
    }

    public void setCodCli(String codCli) {
        this.codCli = new SimpleStringProperty(codCli);
    }

    public String getNomCli() {
        return nomCli.get();
    }

    public void setNomCli(String nomCli) {
        this.nomCli = new SimpleStringProperty(nomCli);
    }

    public String getTotPed() {
        return totPed.get();
    }

    public void setTotPed(String totPed) {
        this.totPed = new SimpleStringProperty(totPed);
    }

    public String getSitu() {
        return situ.get();
    }

    public void setSitu(String situ) {
        this.situ = new SimpleStringProperty(situ);
    }

    public String getVia() {
        return via.get();
    }

    public void setVia(String via) {
        this.via = new SimpleStringProperty(via);
    }

    public String getDatPed() {
        return datPed.get();
    }

    public void setDatPed(String datPed) {
        this.datPed = new SimpleStringProperty(datPed);
    }
}
