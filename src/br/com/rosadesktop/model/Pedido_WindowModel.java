/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.model;

import br.com.rosadesktop.dao.Pedido_WindowDAO;
import br.com.rosadesktop.interfaces.iObservable;
import br.com.rosadesktop.interfaces.iObserver;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Claudio
 */
public class Pedido_WindowModel implements iObservable
{
    private final Pedido pedido;
    private final ArrayList<iObserver> listOfObserver;
    private final Pedido_WindowDAO pedidoWindowDAO;
    
    public Pedido_WindowModel(Pedido pedido)
    {
        this.pedido = pedido;
        listOfObserver = new ArrayList<>();
        pedidoWindowDAO = new Pedido_WindowDAO(this);
    }
    
    public void loadingInformation()
    {
        try {
            this.pedidoWindowDAO.loadListOfItems();
            measureChanges();
        } catch (SQLException ex) {
            Logger.getLogger(Pedido_WindowModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addObserver(iObserver observer) 
    {
        listOfObserver.add(observer);
    }

    @Override
    public void removeObserver(iObserver observer) 
    {
        listOfObserver.remove(observer);
    }

    @Override
    public void measureChanges() 
    {
        for(iObserver observe : listOfObserver)
        {
            observe.update(this);
        }
    }

    public ObservableList<ItemPedido> getListOfItems() 
    {
        return this.pedidoWindowDAO.getListOfItems();
    }

    public Pedido getPedido() 
    {
        return this.pedido;
    }
}
