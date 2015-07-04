/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.dao;

import br.com.rosadesktop.model.ItemPedido;
import br.com.rosadesktop.model.Pedido;
import br.com.rosadesktop.model.Pedido_WindowModel;
import java.io.IOException;
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
public class Pedido_WindowDAO 
{
    private Pedido_WindowModel pedidoModel;
    private Connection con;
    private ObservableList<ItemPedido> listOfPedidos;
    private Pedido pedido;
    private ResultSet results;
    
    public Pedido_WindowDAO(Pedido_WindowModel pedido)
    {
        this.pedidoModel = pedido;
        this.pedido = this.pedidoModel.getPedido();
        try {
            this.con = ConexaoDAO.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(Pedido_WindowDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadListOfItems() throws SQLException
    {
        String query = " SELECT IT.* "
                     + " FROM ITEMPEDIDO IT "
                     + " WHERE IT.PEDIDO = ? ";
        
        PreparedStatement statement = null;
        
        statement = con.prepareStatement(query);
        
        results = null;
        if(statement != null)
        {
            statement.setString(1,pedido.getPedido());
            
            results = statement.executeQuery();
            
            if( results != null )
            {
               this.listOfPedidos = FXCollections.observableArrayList();
               while(results.next())
               {
                    String codPedido = results.getString("PEDIDO");
                    String codArt = results.getString("CODART");
                    String descricao = results.getString("DESCRICAO");
                    String qtdSai = results.getString("QTDSAI");
                    String qtdRet = results.getString("QTDRET");
                    String preVen = results.getString("PREVEN");
                    String preCus = results.getString("PRECUS");
                    
                    ItemPedido itemPedido = new ItemPedido(codPedido, codArt, descricao, qtdSai, qtdRet, preVen , preCus);
                    
                    listOfPedidos.add(itemPedido);
               }
            }
             
        }
    }

    public ObservableList<ItemPedido> getListOfItems() 
    {
        return this.listOfPedidos;
    }
}
