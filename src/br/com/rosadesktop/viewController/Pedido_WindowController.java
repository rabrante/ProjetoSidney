/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.viewController;

import br.com.rosadesktop.controller.Login_Controller;
import br.com.rosadesktop.controller.Pedido_Controller;
import br.com.rosadesktop.model.Pedido;
import freelancer_sidney.Conexao;
import freelancer_sidney.ItemPedido;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Rafael
 */
public class Pedido_WindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView TbPedido;
    
    @FXML
    private Pedido_Controller controller;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    public void setController(Pedido_Controller aThis)
    {
        this.controller = aThis;
    }
    
      
    
}
