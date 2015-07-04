/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.controller;

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
public class Choose_Controller extends Application implements Window_Interface
{
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/rosadesktop/fxml/Choose_Window.fxml"));
        Parent root = fxmlLoader.load();
        
        Scene scene = new Scene(root);
        
        this.primaryStage = primaryStage;
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        this.primaryStage.show();
    }

    @Override
    public Stage getStage() {
        return this.primaryStage;
    }
   
}
