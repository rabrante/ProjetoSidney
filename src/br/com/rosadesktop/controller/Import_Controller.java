/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.controller;

import br.com.rosadesktop.interfaces.Window_Interface;
import br.com.rosadesktop.model.InformationImport;
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
    private InformationImport importModel;
    private final String pathDB;
    
    public Import_Controller(String pathDB)
    {
        this.pathDB = pathDB;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/rosadesktop/fxml/Import_Window.fxml"));
        Parent root = fxmlLoader.load();
        
        importWindowController = fxmlLoader.getController();
        
        importWindowController.setController(this);
        
        this.importModel = new InformationImport(this.pathDB);
        this.importModel.addObserver(this.importWindowController);
        this.importModel.loadViewInformation();
        
        
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

    public void searchButtonPressed(String strCodVend, String strDateFrom, String strDateTo) 
    {
        this.importModel.setCodVend(strCodVend);
        this.importModel.setDateFrom(strDateFrom);
        this.importModel.setDateTo(strDateTo);
        
        this.importModel.loadInformation();
    }

    public String getPathDB() 
    {
        return this.pathDB;
    }
}
