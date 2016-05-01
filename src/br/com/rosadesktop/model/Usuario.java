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
public class Usuario {
    
    private SimpleStringProperty  nome;
    private SimpleStringProperty  senha;
    private SimpleStringProperty  valida;
    private SimpleStringProperty  limite;

    
    public Usuario()
    {

    }
    
    public Usuario(String nome, String senha, String valida, String limite){
        this.nome = new SimpleStringProperty(nome);
        this.senha = new SimpleStringProperty(senha);
        this.valida = new SimpleStringProperty(valida);
        this.limite = new SimpleStringProperty(limite);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome.get();
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(SimpleStringProperty nome) {
        this.nome = nome;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha.get();
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(SimpleStringProperty senha) {
        this.senha = senha;
    }

    /**
     * @return the valida
     */
    public String getValida() {
        return valida.get();
    }

    /**
     * @param valida the valida to set
     */
    public void setValida(SimpleStringProperty valida) {
        this.valida = valida;
    }

    /**
     * @return the limite
     */
    public String getLimite() {
        return limite.get();
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(SimpleStringProperty limite) {
        this.limite = limite;
    }
    
    
}
