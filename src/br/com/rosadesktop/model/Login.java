/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.model;

import br.com.rosadesktop.dao.LoginDAO;

/**
 *
 * @author Claudio
 */
public class Login {
    private String usuario;
    private String password;
    private LoginDAO loginDao;
    
    public Login()
    {
    }
    
    public Login(String usuario, String password)
    {
        this.usuario = usuario;
        this.password = password.equals("")?null:password;
        this.loginDao = new LoginDAO(this);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean validLogin()
    {
        return loginDao.verifyLogin();
    }
    
}
