/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.dao;

import br.com.rosadesktop.model.InformationImport;
import br.com.rosadesktop.model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Claudio
 */
public class InformationImportDAO 
{
    private final InformationImport informationModel;
    private ObservableList<Pedido> listOfPedidos;
    private Connection con;
    private ResultSet results;
    private boolean firstTime;
    
    public InformationImportDAO(InformationImport informationModel,String pathDB)
    {
        this.informationModel = informationModel;
        this.firstTime = true;
        this.con = ConexaoSQLDAO.getInstance(pathDB);
    }
    
    public void loadListOfPedidos() throws SQLException
    {
        String query;
       
        query = " SELECT PEDIDO.* "
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
            statement.setString(1, informationModel.getCodVend());
            statement.setString(2, informationModel.getDateFrom());
            statement.setString(3, informationModel.getDateTo());
            
            results = statement.executeQuery();
            
            if(results != null)
            {
                this.listOfPedidos = FXCollections.observableArrayList();
                while(results.next())
                {
                    System.out.println("1");
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
    
    public void loadListOfPedidosAll() throws SQLException
    {
        String query;
        
        query = " SELECT * "
             + " FROM PEDIDO";
        
        
        PreparedStatement statement = null;
        try {
             statement = con.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(InformationExportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(statement != null)
        {
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

    public ObservableList<Pedido>  getListOfPedidos() 
    {
        return this.listOfPedidos;
    }
}
