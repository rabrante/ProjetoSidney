/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.dao;

import br.com.rosadesktop.model.InformationFilterExport;
import br.com.rosadesktop.model.Pedido;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Claudio
 */
public class InformationExportDAO 
{
    private InformationFilterExport information;
    private Connection con;
    private ResultSet results;
    private ObservableList<Pedido> listOfPedidos;
    
    public InformationExportDAO(InformationFilterExport information) throws IOException
    {
        this.information = information;
        this.listOfPedidos = null;
        this.con = ConexaoDAO.getInstance();
    }
    
    public void loadListOfPedidos() throws SQLException
    {
        String query = " SELECT PEDIDO.* "
                     + " FROM PEDIDO"
                     + " WHERE PEDIDO.CODVEN = ?"
                     + " AND PEDIDO.DATPED BETWEEN ? AND ?";
        
        PreparedStatement statement = null;
        try {
             statement = con.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(InformationExportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(statement != null)
        {
            statement.setString(1, information.getCodVend());
            statement.setString(2, information.getDateFrom());
            statement.setString(3, information.getDateTo());
            
            results = statement.executeQuery();
            
            if(results != null)
            {
                this.listOfPedidos = FXCollections.observableArrayList();
                while(results.next())
                {
                    String codVend = results.getString("CODVEN");
                    String codPedido = results.getString("PEDIDO");
                    String codCli = results.getString("CODCLI");
                    String nomCli = results.getString("NOMCLI");
                    String totPed = results.getString("TOTPED");
                    String situ = results.getString("SITU");
                    String via = results.getString("VIA");
                    String datPed = results.getString("DATPED");
                    
                    Pedido pedido = new Pedido(codVend,codPedido,codCli,nomCli,totPed,situ,via,datPed);
                    
                    listOfPedidos.add(pedido);
                }
            }
        }
    }
    
    public ObservableList<Pedido> getListOfPedidos()
    {
        return listOfPedidos;
    }
    
}
