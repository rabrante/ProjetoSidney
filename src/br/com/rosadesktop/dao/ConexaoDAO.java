/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.dao;

import br.com.rosadesktop.properties.Properties_Manipulator;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                
                String dataBase = prop.getProperty("prop.server.dataBase");
                String path = prop.getProperty("prop.server.path");
                String pathDB = prop.getProperty("prop.server.pathDB");
                String user = prop.getProperty("prop.server.user");
                String pass = prop.getProperty("prop.server.psw");
                
                Class.forName(dataBase);
                con = DriverManager.getConnection(path+pathDB, user, pass);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return con;
    }

    public static void closeConnection(ResultSet results, Statement statement, Connection con) throws SQLException {
        if(results != null)
            results.close();
        if(statement != null)
            statement.close();
        if(con != null)
            con.close();
    }
}
