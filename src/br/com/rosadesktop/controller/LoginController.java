/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.controller;


import br.com.rosadesktop.view.Login_Window;
import br.com.rosadesktop.Window_Controller;
import br.com.rosadesktop.interfaces.Window_Interface;
import br.com.rosadesktop.model.Login;
import br.com.rosadesktop.view.Choose_Window;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author Claudio
 */
public class LoginController implements Initializable {
    
    @FXML
    private Label lbStatus;
    
    @FXML
    private TextField tfUser;
    
    @FXML
    private PasswordField tfPass;
    
    @FXML private void loginButtonPressed(ActionEvent event)
    {
        String usuario = tfUser.getText();
        String password = tfPass.getText();
        
        Login login = new Login(usuario,password);
        
        if(login.validLogin())//tfPass.getText().equals("1234") && tfUser.getText().equals("test"))
        {
            lbStatus.setText("Logado");
            lbStatus.setStyle("-fx-text-fill:blue;");
            
            Window_Controller.getInstance().openSelectedImportOrExport();
            
        }
        else
        {
            lbStatus.setText("Usuário e senha inválido");
            lbStatus.setStyle("-fx-text-fill:red;");
        }
    }
    
    
    @FXML
    public void handleEnterTyped(KeyEvent event){
        
        if (event.getCode().equals(KeyCode.ENTER)) {
        
            loginButtonPressed(new ActionEvent());
            
        }
    }
        
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if(rb != null)
            System.out.println(rb.toString());
    }    
    
}
