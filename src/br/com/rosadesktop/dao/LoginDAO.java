/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.dao;

import br.com.rosadesktop.model.Login;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Claudio
 */
public class LoginDAO {
    
    private Login login;
    private Connection conexao;
    
    public LoginDAO(Login login)
    {
        this.login = login;
        try {
            this.conexao =  ConexaoDAO.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean verifyLogin() 
    {
        String query = "Select senha from arqsenhas where nome = ?";
        
        PreparedStatement statement = null;
        if(conexao != null){
            try {
                statement = conexao.prepareStatement(query);
                statement.setString(1, this.login.getUsuario());
//                statement.setString(2, this.login.getPassword().equals("")?"null":this.login.getPassword());
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            ResultSet result = null;   
            try {
                if(statement != null)
                {
                    result = statement.executeQuery();
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(result != null)
            {
                try {
                    if(result.next())
                    {
                        String senha = result.getString(1);
                        if(senha == null && login.getPassword() == null)
                        {
                            return true;
                        }
                        else if(senha.equals(login.getPassword()))
                        {
                            return true;
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            System.out.println("Nulo");
        }
        
        
        return false;
    }
}
