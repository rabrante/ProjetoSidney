/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.controller;

import br.com.rosadesktop.interfaces.Window_Interface;
import br.com.rosadesktop.viewController.Login_WindowController;
import br.com.rosadesktop.viewController.Pedido_WindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Rafael
 */
public class Pedido_Controller  extends Application implements Window_Interface{
    
    
    Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/rosadesktop/fxml/Pedido_Window.fxml"));
        
        Pedido_WindowController PedidoController = fxmlLoader.getController();
        
        PedidoController.setMainClass(this);
         
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
