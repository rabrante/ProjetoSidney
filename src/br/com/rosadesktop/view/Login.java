/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop;

import br.com.rosadesktop.interfaces.Window_Interface;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Claudio
 */
public class Login extends Application implements Window_Interface{
    
    Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/rosadesktop/fxml/Login_Window.fxml"));
        
        Scene scene = new Scene(root);
        
        this.primaryStage = stage;
        
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        this.primaryStage.show();
    }

    @Override
    public Stage getStage() {
       return this.primaryStage;
    }

    
}
