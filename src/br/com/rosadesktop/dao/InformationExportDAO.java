/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.dao;

import br.com.rosadesktop.model.InformationFilterExport;
import br.com.rosadesktop.model.ItemPedido;
import br.com.rosadesktop.model.Pedido;
import br.com.rosadesktop.model.Usuario;
import br.com.rosadesktop.thread.Progress;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

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
    private ObservableList<Usuario> listOfUsers;
    
    public InformationExportDAO(InformationFilterExport information) throws IOException
    {
        this.information = information;
        this.listOfPedidos = null;
        this.listOfUsers = null;
        this.con = ConexaoDAO.getInstance();
    }
    
    public void loadListOfPedidos() throws SQLException
    {
        
        String query = "SELECT *" +
                        "FROM PEDIDO a" +
                        " where a.codven = ?" +
                        " and ( substring(a.DATPED from 7 for 10) >= substring(? from 7 for 10)" +
                        "        and (substring(a.DATPED from 4 for 5) = substring(? from 4 for 5)" +
                        "        and substring(a.DATPED from 1 for 2) >= substring(? from 1 for 2))" +
                        "        OR ( substring(a.DATPED from 7 for 10) >= substring(? from 7 for 10)" +
                        "	     AND substring(a.DATPED from 4 for 5) > substring(? from 4 for 5) ) )" +
                        " " +
                        "	AND (substring(a.DATPED from 7 for 10) <= substring(? from 7 for 10)" +
                        "        	and (substring(a.DATPED from 4 for 5) = substring(? from 4 for 5)" +
                        "        	and substring(a.DATPED from 1 for 2) <= substring(? from 1 for 2) )" +
                        "        	OR ( substring(a.DATPED from 7 for 10) <= substring(? from 7 for 10)" +
                        "	     		AND substring(a.DATPED from 4 for 5) < substring(? from 4 for 5) ))";
        
        
        
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
            statement.setString(3, information.getDateFrom());
            statement.setString(4, information.getDateFrom());
            statement.setString(5, information.getDateFrom());
            statement.setString(6, information.getDateFrom());
            statement.setString(7, information.getDateTo());
            statement.setString(8, information.getDateTo());
            statement.setString(9, information.getDateTo());
            statement.setString(10, information.getDateTo());
            statement.setString(11, information.getDateTo());
            
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
    
    
    public void loadListOfUsers() throws SQLException
    {
        
        String query = "SELECT *" +
                        " FROM ARQSENHAS;" ;
        
        
        
        PreparedStatement statement = null;
        try {
             statement = con.prepareStatement(query);
           System.out.println("chegou aqui");
        } catch (SQLException ex) {
           System.out.println("deu erro aqui");
            Logger.getLogger(InformationExportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(statement != null)
        {
            
            results = statement.executeQuery();
            System.out.println("rodou a query");
            if(results != null)
            {
                this.listOfUsers = FXCollections.observableArrayList();
                while(results.next())
                {
                    System.out.println("chegou aqui");
                    String senha = "";
                    String nome = results.getString("NOME");
                    if(!(results.getString("SENHA") == null)){
                        senha = results.getString("SENHA");
                    }
                    System.out.println("senha é: " + senha);
                    String valida = results.getString("VALIDA");
                    String limite = results.getString("LIMITE");
              
                    
                    Usuario user = new Usuario(nome,senha,valida,limite);
                    
                    listOfUsers.add(user);
                }
            }
        }
    }
    
    public ObservableList<Pedido> getListOfPedidos()
    {
        return listOfPedidos;
    }

    public void exportPedidosToSQLlite(String pathDB) 
    {
        Connection conSQLlite = ConexaoSQLDAO.getInstance(pathDB);
        if(listOfPedidos != null)
        {
            Progress progresso = new Progress();
            Thread threadProgresso = new Thread(progresso);
            threadProgresso.start();
            int i = 0;
            for(Pedido pedido : listOfPedidos)
            {
                System.out.println("inserindo linha " + i);
                insertPedido(conSQLlite,pedido);
                i++;
            }
            progresso.stopRun();
            
            try {
                conSQLlite.close();
            } catch (SQLException ex) {
                Logger.getLogger(InformationExportDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
     public void exportUsuariosToSQLlite(String pathDB) 
    {
        Connection conSQLlite = ConexaoSQLDAO.getInstance(pathDB);
        if(listOfUsers != null)
        {
            Progress progresso = new Progress();
            Thread threadProgresso = new Thread(progresso);
            threadProgresso.start();
            int i = 0;
            for(Usuario usuario : listOfUsers)
            {
                System.out.println("inserindo linha " + i);
                insertUsuario(conSQLlite,usuario);
                i++;
            }
            progresso.stopRun();
            
            try {
                conSQLlite.close();
            } catch (SQLException ex) {
                Logger.getLogger(InformationExportDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
    public ArrayList<ItemPedido> loadListOfItems(Pedido pedido) throws SQLException
    {
        ArrayList<ItemPedido> listOfItemsPedidos = null;
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
               listOfItemsPedidos = new ArrayList<>();
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
                    
                    listOfItemsPedidos.add(itemPedido);
               }
            }
             
        }
        return listOfItemsPedidos;
    }

    private void insertItemPedido(Connection conSQLlite, Pedido pedido) 
    {
        ArrayList<ItemPedido> itemPedidos = null;
        try {
            itemPedidos = loadListOfItems(pedido);
        } catch (SQLException ex) {
            Logger.getLogger(InformationExportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(itemPedidos != null)
        {
            for(ItemPedido itemPedido : itemPedidos)
            {
                insertItemsPedido(conSQLlite,itemPedido);
            }
            
        }
    }
    
    private void insertItemsPedido(Connection conSQLlite, ItemPedido itemPedido) 
    {
        String insertItemPedido = " INSERT INTO ITEMPEDIDO"
                            + " ('PEDIDO','CODART','DESCRICAO','QTDSAI','QTDRET','PRECUS','PREVEN')"
                            + " VALUES ('"
                                + itemPedido.getPedido()
                                +"','"+itemPedido.getCodArt()
                                +"','"+itemPedido.getDescricao()
                                +"','"+itemPedido.getQtdSai()
                                +"','"+itemPedido.getQtdRet()
                                +"','"+itemPedido.getPreCus()
                                +"','"+itemPedido.getPreVen()
                                +"')";
      
        PreparedStatement statement = null;
        
        try {
            statement = conSQLlite.prepareStatement(insertItemPedido);
        } catch (SQLException ex) {
            Logger.getLogger(InformationExportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(statement != null)
        {
            try {
                boolean result = statement.execute();
                if(!result)
                {
//                    System.out.println("Item inserido na tabela de Item Pedido");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lista de pedidos já foi exportada.", "Alerta", JOptionPane.WARNING_MESSAGE);
//                Logger.getLogger(ConexaoSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }                       
    }
    
    private void insertPedido(Connection conSQLlite, Pedido pedido) 
    {
        String insertPedido = " INSERT INTO PEDIDO"
                            + " ('CODVEN','PEDIDO','CODCLI','NOMCLI','TOTPED','SITU','VIA','DATPED')"
                            + " VALUES"
                            + " ('"+pedido.getCodVend()
                                +"','"+pedido.getPedido()
                                +"','"+pedido.getCodCli()
                                +"','"+pedido.getNomCli()
                                +"','"+pedido.getTotPed()
                                +"','"+pedido.getSitu()
                                +"','"+pedido.getVia()
                                +"','"+pedido.getDatPed()+"')";
        
        PreparedStatement statement = null;
        
        try {
            statement = conSQLlite.prepareStatement(insertPedido);
        } catch (SQLException ex) {
            Logger.getLogger(InformationExportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(statement != null)
        {
            try {
                boolean result = statement.execute();
                if(!result)
                {
                    System.out.println("Item inserido na tabela de Pedido");
                }
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "Lista de pedidos já foi exportada.", "Alerta", JOptionPane.WARNING_MESSAGE);
//                Logger.getLogger(ConexaoSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
                insertItemPedido(conSQLlite, pedido);
    }
    
    private void insertUsuario(Connection conSQLlite, Usuario usuario) 
    {
        String insertUsuario = " INSERT INTO USUARIO"
                            + " ('NOME','SENHA','VALIDA','LIMITE')"
                            + " VALUES"
                            + " ('"+usuario.getNome()
                                +"','"+usuario.getSenha()
                                +"','"+usuario.getValida()
                                +"','"+usuario.getLimite()+"')";
        
        PreparedStatement statement = null;
        
        try {
            statement = conSQLlite.prepareStatement(insertUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(InformationExportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(statement != null)
        {
            try {
                boolean result = statement.execute();
                if(!result)
                {
                    System.out.println("Item inserido na tabela de Pedido");
                }
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "Lista de pedidos já foi exportada.", "Alerta", JOptionPane.WARNING_MESSAGE);
//                Logger.getLogger(ConexaoSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
               
    }
    
}
