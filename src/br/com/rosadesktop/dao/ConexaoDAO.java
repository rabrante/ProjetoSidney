/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michel
 */
public class ConexaoDAO {

    static Connection con = null;

    public static Connection getInstance()  {
        if(con == null)
        {
            try {
                Class.forName("org.firebirdsql.jdbc.FBDriver");
                con = DriverManager.getConnection("jdbc:firebirdsql:localhost/3050:C://DBROSA.GDB", "sysdba", "masterkey");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return con;
    }

}
