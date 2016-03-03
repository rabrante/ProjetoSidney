/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.controller;

import br.com.rosadesktop.Window_Controller;
import br.com.rosadesktop.viewController.Login_WindowController;
import br.com.rosadesktop.interfaces.Window_Interface;
import br.com.rosadesktop.model.Login;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author Claudio
 */
public class Login_Controller extends Application implements Window_Interface{
    
    Stage primaryStage;
    private Login_WindowController loginController;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/rosadesktop/fxml/Login_Window.fxml"));
        loginController = new Login_WindowController();
        fxmlLoader.setController(loginController);
        Parent root = fxmlLoader.load();
        
        
        
        loginController.setMainClass(this);
         
        Scene scene = new Scene(root);
        
        this.primaryStage = stage;
        
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        this.primaryStage.show();
    }
    
    public void doLogin(String userName, String password)
    {
        Login login = new Login(userName,password);
        
        if(login.validLogin())//tfPass.getText().equals("1234") && tfUser.getText().equals("test"))
        {
            Window_Controller.getInstance().openSelectedImportOrExport();
        }
        else
        {
            loginController.setLabelStatus("Usuário ou senha inválidos.");
//            lbStatus.setText("Usuário e senha inválido");
//            lbStatus.setStyle("-fx-text-fill:red;");
        }
    }
    
    @Override
    public Stage getStage() {
       return this.primaryStage;
    }

    
}
