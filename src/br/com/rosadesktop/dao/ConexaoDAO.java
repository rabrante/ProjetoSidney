/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.dao;

import Properties.Properties_Manipulator;
import static Properties.Properties_Manipulator.getProp;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michel
 */
public class ConexaoDAO {

    static Connection con = null;
    
    
    public static Connection getInstance() throws IOException  {
        if(con == null)
        {
            try {
                Properties_Manipulator a = new Properties_Manipulator();
                Properties prop = a.getProp();
                
                String dataBase;
                String path;
                String user;
                String pass;
                dataBase = prop.getProperty("prop.server.dataBase");
                path = prop.getProperty("prop.server.path");
                user = prop.getProperty("prop.server.user");
                pass = prop.getProperty("prop.server.psw");
                
                System.out.println("dataBase = "+ dataBase+"   ------path= "+
                                    path+" user= "+ user + " pass = "+pass);
                Class.forName(dataBase);
                con = DriverManager.getConnection(path, user, pass);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return con;
    }

}
