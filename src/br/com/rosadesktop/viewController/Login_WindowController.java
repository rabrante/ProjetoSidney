/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.viewController;


import br.com.rosadesktop.controller.Login_Controller;
import br.com.rosadesktop.Window_Controller;
import br.com.rosadesktop.interfaces.Window_Interface;
import br.com.rosadesktop.model.Login;
import br.com.rosadesktop.controller.Choose_Controller;
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
public class Login_WindowController implements Initializable {
    
    @FXML
    private Label lbStatus;
    
    @FXML
    private TextField tfUser;
    
    @FXML
    private PasswordField tfPass;
    
    private Login_Controller controller;
    
    @FXML private void loginButtonPressed(ActionEvent event)
    {
        String usuario = tfUser.getText();
        String password = tfPass.getText();
        
        controller.doLogin(usuario, password);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setMainClass(Login_Controller aThis)
    {
        this.controller = aThis;
    }

    public void setLabelStatus(String msg) 
    {
        lbStatus.setText(msg);
        lbStatus.setStyle("-fx-text-fill:red;");
    }
    
    @FXML
    public void handleEnterPressed(KeyEvent event){
        
        if (event.getCode().equals(KeyCode.ENTER)) 
        {
        
            loginButtonPressed(new ActionEvent());
            
        }
    }
    
}
