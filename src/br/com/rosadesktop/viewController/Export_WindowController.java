/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.viewController;

import br.com.rosadesktop.Window_Controller;
import br.com.rosadesktop.controller.Export_Controller;
import br.com.rosadesktop.controller.Pedido_Controller;
import br.com.rosadesktop.interfaces.iObservable;
import br.com.rosadesktop.interfaces.iObserver;
import br.com.rosadesktop.model.InformationFilterExport;
import br.com.rosadesktop.model.Pedido;
import br.com.rosadesktop.util.Util;
import java.net.URL;
import java.time.LocalDate;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

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
    
    @FXML private void searchOnDatabase(ActionEvent event)
    {
        String strCodVend = this.codVend.getText();
        
        LocalDate ldDateFrom = this.dateFrom.getValue();
        String strDateFrom = Util.getRightDate(ldDateFrom.toString());//ldDateFrom.getDayOfMonth()+"/"+ldDateFrom.getMonth()+"/"+ldDateFrom.getYear();
        
        LocalDate ldDateTo = this.dateTo.getValue();
        String strDateTo = Util.getRightDate(ldDateTo.toString());//ldDateTo.getDayOfMonth()+"/"+ldDateTo.getMonth()+"/"+ldDateTo.getYear();
         
        if(strCodVend != null)
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
        
        Map<String,String> mapColumnName = Util.getMapColumnName();
        
        for(int i = 0; i < tableExportContent.getColumns().size();i++)
        {
            TableColumn tableColumn = (TableColumn) tableExportContent.getColumns().get(i);
            tableColumn.setCellValueFactory(new PropertyValueFactory(mapColumnName.get(tableColumn.getText())));
            tableExportContent.getColumns().set(i, tableColumn);
        }
        
        initListeners();
    }   
    
    private void initListeners() 
    {
        tableExportContent.setRowFactory(new Callback() {

            @Override
            public Object call(Object param) 
            {
                TableRow row = new TableRow();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2 && (! row.isEmpty()) ) 
                    {
                        int i = tableExportContent.getSelectionModel().getSelectedIndex();
                        Pedido pedido = (Pedido) tableExportContent.getItems().get(i);
                        Window_Controller.getInstance().openWindowPedido(pedido);
                    }
                });
                return row ;
            }
        });
    }

    @Override
    public void update(iObservable observable) 
    {
        InformationFilterExport model = (InformationFilterExport) observable;
        ObservableList<Pedido> listOfPedidos = model.getPedidos();
        tableExportContent.setItems(listOfPedidos);
    }
    
    @FXML private void exportButtonPressed(ActionEvent event)
    {
        this.controller.exportFile();
    }

}
