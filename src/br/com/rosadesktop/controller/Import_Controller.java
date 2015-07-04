/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.controller;

import br.com.rosadesktop.interfaces.Window_Interface;
import br.com.rosadesktop.viewController.Import_WindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Claudio
 */
public class Import_Controller extends Application implements Window_Interface{
    private Stage primaryStage;
    
    private Import_WindowController importWindowController;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/rosadesktop/fxml/Import_Window.fxml"));
        Parent root = fxmlLoader.load();
        
        importWindowController = fxmlLoader.getController();
        
        importWindowController.setController(this);
        
        
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
