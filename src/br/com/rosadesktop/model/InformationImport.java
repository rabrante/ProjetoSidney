/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.model;

import br.com.rosadesktop.dao.InformationImportDAO;
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
public class InformationImport implements iObservable
{
    private final ArrayList<iObserver> listOfObserver;
    private final InformationImportDAO importDAO;
    private String codVend;
    private String dateFrom;
    private String dateTo;
    
    public InformationImport(String pathDB)
    {
        this.codVend = null;
        this.dateFrom = null;
        this.dateTo = null;
        this.listOfObserver = new ArrayList<>();
        this.importDAO = new InformationImportDAO(this,pathDB);
    }
    
    public InformationImport(String pathDB,String codVend,String dateFrom,String dateTo)
    {
        this.codVend = codVend;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.listOfObserver = new ArrayList<>();
        this.importDAO = new InformationImportDAO(this,pathDB);
    }
    
    @Override
    public void addObserver(iObserver observer) 
    {
        this.listOfObserver.add(observer);
    }

    @Override
    public void removeObserver(iObserver observer)
    {
        this.listOfObserver.remove(observer);
    }

    @Override
    public void measureChanges() 
    {
        for(iObserver observer : listOfObserver)
        {
            observer.update(this);
        }
    }

    public ObservableList<Pedido> getListOfPedidos() 
    {
        return this.importDAO.getListOfPedidos();
    }

    public String getCodVend() 
    {
        return this.codVend;
    }

    public String getDateFrom() 
    {
        return this.dateFrom;
    }

    public String getDateTo() {
        return this.dateTo;
    }

    public void setCodVend(String strCodVend) 
    {
        this.codVend = strCodVend;
    }

    public void setDateFrom(String strDateFrom) {
        this.dateFrom = strDateFrom;
    }

    public void setDateTo(String strDateTo) {
        this.dateTo = strDateTo;
    }

    public void loadInformation() {
        try {
            this.importDAO.loadListOfPedidos();
            measureChanges();
        } catch (SQLException ex) {
            Logger.getLogger(InformationImport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadViewInformation()
    {
        try {
            this.importDAO.loadListOfPedidosAll();
            measureChanges();
        } catch (SQLException ex) {
            Logger.getLogger(InformationImport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
