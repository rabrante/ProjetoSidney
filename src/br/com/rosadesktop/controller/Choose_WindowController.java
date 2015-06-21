/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.controller;

import br.com.rosadesktop.Window_Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Claudio
 */
public class Choose_WindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private void buttonExportFile(ActionEvent event)
    {
        Window_Controller.getInstance().openExportWindow();
    }
    
    @FXML private void buttonImportFile(ActionEvent event)
    {
        Window_Controller.getInstance().openImportWindow();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
