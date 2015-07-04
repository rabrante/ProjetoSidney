/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.viewController;

import br.com.rosadesktop.controller.Export_Controller;
import br.com.rosadesktop.interfaces.iObservable;
import br.com.rosadesktop.interfaces.iObserver;
import br.com.rosadesktop.model.InformationFilterExport;
import br.com.rosadesktop.model.Pedido;
import br.com.rosadesktop.util.Util;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Claudio
 */
public class Export_WindowController implements Initializable, iObserver{

    /**
     * Initializes the controller class.
     */
    @FXML private TextField codVend;
    
    @FXML private DatePicker dateFrom;
    
    @FXML private DatePicker dateTo;
    
    @FXML private TableView tableExportContent;
    
    private Export_Controller controller;
    
    @FXML private void searchOnDatabase()
    {
        String strCodVend = this.codVend.getText();
        
        LocalDate ldDateFrom = this.dateFrom.getValue();
        String strDateFrom = Util.getRightDate(ldDateFrom.toString());//ldDateFrom.getDayOfMonth()+"/"+ldDateFrom.getMonth()+"/"+ldDateFrom.getYear();
        
        LocalDate ldDateTo = this.dateTo.getValue();
        String strDateTo = Util.getRightDate(ldDateTo.toString());//ldDateTo.getDayOfMonth()+"/"+ldDateTo.getMonth()+"/"+ldDateTo.getYear();
        
        if(strCodVend != null && ldDateFrom != null && ldDateTo != null)
        {
            controller.searchButtonPressed(strCodVend,strDateFrom,strDateTo);
        }
    }
    
    public void setController(Export_Controller controller)
    {
        this.controller = controller;
    }   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        
        ArrayList<String> listColumnName = Util.getListColumnName();
        
        for(int i = 0; i < listColumnName.size();i++)
        {
            TableColumn tableColumn = (TableColumn) tableExportContent.getColumns().get(i);
            tableColumn.setCellValueFactory(new PropertyValueFactory(listColumnName.get(i)));
            tableExportContent.getColumns().set(i, tableColumn);
        }
    
    }    

    @Override
    public void update(iObservable observable) 
    {
        InformationFilterExport model = (InformationFilterExport) observable;
        ObservableList<Pedido> listOfPedidos = model.getPedidos();
        tableExportContent.setItems(listOfPedidos);
    }
    
}
