/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.viewController;

import br.com.rosadesktop.controller.Pedido_Controller;
import br.com.rosadesktop.interfaces.iObservable;
import br.com.rosadesktop.interfaces.iObserver;
import br.com.rosadesktop.model.ItemPedido;
import br.com.rosadesktop.model.Pedido_WindowModel;
import br.com.rosadesktop.util.Util;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Rafael
 */
public class Pedido_WindowController implements Initializable , iObserver {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView tbView;
    
    @FXML
    private Pedido_Controller controller;
    
    @FXML public void btnVoltar(ActionEvent event)
    {
        this.controller.buttonBackPressed();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Map<String,String> mapColumnName = Util.getMapColumnNamePedido();
        
        for(int i = 0; i < tbView.getColumns().size();i++)
        {
            TableColumn tableColumn = (TableColumn) tbView.getColumns().get(i);
            tableColumn.setCellValueFactory(new PropertyValueFactory(mapColumnName.get(tableColumn.getText())));
            tbView.getColumns().set(i, tableColumn);
        }
        
    }    

    public void setController(Pedido_Controller aThis)
    {
        this.controller = aThis;
    }

    @Override
    public void update(iObservable observable) 
    {
        Pedido_WindowModel pedidoWindowModel = (Pedido_WindowModel) observable;
        ObservableList<ItemPedido> listOfItems = pedidoWindowModel.getListOfItems();
        tbView.setItems(listOfItems);        
    }
    
      
    
}
