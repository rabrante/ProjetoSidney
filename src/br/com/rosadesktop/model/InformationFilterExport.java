/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.model;

import br.com.rosadesktop.dao.InformationExportDAO;
import br.com.rosadesktop.interfaces.iObservable;
import br.com.rosadesktop.interfaces.iObserver;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Claudio
 */
public class InformationFilterExport implements iObservable{
    private String codVend;
    private String dateFrom;
    private String dateTo;
    private InformationExportDAO informationExportDAO;
    private ArrayList<iObserver> listOfObserver;

    public InformationFilterExport()
    {
        this.codVend = null;
        this.dateFrom = null;
        this.dateTo = null;
        listOfObserver = new ArrayList<>();
        try {
            this.informationExportDAO = new InformationExportDAO(this);
        } catch (IOException ex) {
            Logger.getLogger(InformationFilterExport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public InformationFilterExport(String codVend, String dateFrom, String dateTo) {
        this.codVend = codVend;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        listOfObserver = new ArrayList<>();
        try {
            this.informationExportDAO = new InformationExportDAO(this);
        } catch (IOException ex) {
            Logger.getLogger(InformationFilterExport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void exportPedidosSelected(String pathDB)
    {
        this.informationExportDAO.exportPedidosToSQLlite(pathDB);
    }
    
    public String getCodVend() {
        return codVend;
    }

    public void setCodVend(String codVend) {
        this.codVend = codVend;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public void loadInformation() 
    {
        try {
            this.informationExportDAO.loadListOfPedidos();
            measureChanges();
        } catch (SQLException ex) {
            Logger.getLogger(InformationFilterExport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Pedido> getPedidos() 
    {
        return this.informationExportDAO.getListOfPedidos();
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
        for(iObserver ob : listOfObserver)
        {
            ob.update(this);
        }
    }
       
}
