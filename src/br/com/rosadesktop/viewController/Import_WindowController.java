/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.viewController;

import br.com.rosadesktop.Window_Controller;
import br.com.rosadesktop.controller.Import_Controller;
import br.com.rosadesktop.interfaces.iObservable;
import br.com.rosadesktop.interfaces.iObserver;
import br.com.rosadesktop.model.InformationImport;
import br.com.rosadesktop.model.Pedido;
import br.com.rosadesktop.util.Util;
import java.net.URL;
import java.time.LocalDate;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Claudio
 */
public class Import_WindowController implements Initializable, iObserver {

    /**
     * Initializes the controller class.
     */
    
    @FXML private TableView tableImportContent;
    @FXML private TextField codVend;
    @FXML private DatePicker dateFrom;
    @FXML private DatePicker dateTo;
    private Import_Controller controller;
    
    @FXML private void searchOnDatabase()
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
    
    public void setController(Import_Controller controller)
    {
        this.controller = controller;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         Map<String,String> mapColumnName = Util.getMapColumnName();
        
        for(int i = 0; i < tableImportContent.getColumns().size();i++)
        {
            TableColumn tableColumn = (TableColumn) tableImportContent.getColumns().get(i);
            tableColumn.setCellValueFactory(new PropertyValueFactory(mapColumnName.get(tableColumn.getText())));
            tableImportContent.getColumns().set(i, tableColumn);
        }
        
        initListeners();
        
    }    

    @Override
    public void update(iObservable observable) 
    {
        InformationImport importModel = (InformationImport) observable;
        ObservableList<Pedido> listOfPedidos = importModel.getListOfPedidos();
        tableImportContent.setItems(listOfPedidos);
        System.out.println(listOfPedidos.size());       
    }

    public String getCodVend() 
    {
        String strCodVend = this.codVend.getText();
        return strCodVend;
    }

    public String getDateFrom() 
    {
        LocalDate ldDateFrom = this.dateFrom.getValue();
        String strDateFrom = Util.getRightDate(ldDateFrom.toString());
        return strDateFrom;
    }

    public String getDateTo() 
    {
        LocalDate ldDateTo = this.dateTo.getValue();
        String strDateTo = Util.getRightDate(ldDateTo.toString());
        return strDateTo;
    }

    private void initListeners() 
    {
        tableImportContent.setRowFactory(new Callback() {

            @Override
            public Object call(Object param) 
            {
                TableRow row = new TableRow();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2 && (! row.isEmpty()) ) 
                    {
                        int i = tableImportContent.getSelectionModel().getSelectedIndex();
                        Pedido pedido = (Pedido) tableImportContent.getItems().get(i);
                        String pathDB = controller.getPathDB();
                        Window_Controller.getInstance().openWindowPedido(pedido,pathDB);
                    }
                });
                return row ;
            }
        });
    }
    
}
