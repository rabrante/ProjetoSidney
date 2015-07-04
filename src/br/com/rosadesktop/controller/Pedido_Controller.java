/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.controller;

import br.com.rosadesktop.Window_Controller;
import br.com.rosadesktop.interfaces.Window_Interface;
import br.com.rosadesktop.model.Pedido;
import br.com.rosadesktop.model.Pedido_WindowModel;
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
public class Pedido_Controller  extends Application implements Window_Interface
{
    private Stage primaryStage;
    private final Pedido pedido;
    private Pedido_WindowModel pedidoWindowModel;
    private Pedido_WindowController pedidoController;
    
    public Pedido_Controller(Pedido pedido)
    {
        this.pedido = pedido;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/rosadesktop/fxml/Pedido_Window.fxml"));
        
        Parent root = fxmlLoader.load();
        
        this.pedidoController = fxmlLoader.getController();
        
        this.pedidoController.setController(this);
        
        this.pedidoWindowModel = new Pedido_WindowModel(pedido);
        
        this.pedidoWindowModel.addObserver(this.pedidoController);
        
        this.pedidoWindowModel.loadingInformation();
         
        Scene scene = new Scene(root);
        
        this.primaryStage = stage;
        
        this.primaryStage.setTitle(pedido.getNomCli());
        
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        this.primaryStage.show();
    }

    @Override
    public Stage getStage() {
       return this.primaryStage;
    }

    public void buttonBackPressed() 
    {
        Window_Controller.getInstance().closeWindowPedido();
    }
    
}
