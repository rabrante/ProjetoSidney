/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Claudio
 */
public class ConexaoSQLDAO 
{
    public static Connection getInstance(String pathDB)
    {
        Connection con = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+pathDB);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexaoSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        createTable(con);
        
        return con;
    }

    private static void createTable(Connection con) 
    {                    
        String createTablePedido = "CREATE TABLE PEDIDO "
                                + " (PEDIDO VARCHAR(6) PRIMARY KEY NOT NULL,"
                                + " CODVEN VARCHAR(3),"
                                + " CODCLI VARCHAR(4),"
                                + " NOMCLI VARCHAR(4),"
                                + " TOTPED VARCHAR(10),"
                                + " SITU CHAR(1),"
                                + " VIA CHAR(1),"
                                + " DATPED VARCHAR(10)"
                                + ");" ;
        
        PreparedStatement statement = null;
        try {
             statement = con.prepareStatement(createTablePedido);
        } catch (SQLException ex) {
            Logger.getLogger(InformationExportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(statement != null)
        {
            try {
                boolean result = statement.execute();
                if(!result)
                {
                    System.out.println("Tabela Pedido Criada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
