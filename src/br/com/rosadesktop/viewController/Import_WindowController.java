/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.viewController;

import br.com.rosadesktop.controller.Import_Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Claudio
 */
public class Import_WindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Import_Controller controller;
    
    @FXML private void searchOnDatabase()
    {
        
    }
    
    public void setController(Import_Controller controller)
    {
        this.controller = controller;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
