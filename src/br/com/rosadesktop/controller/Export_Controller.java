/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.controller;

import br.com.rosadesktop.interfaces.Window_Interface;
import br.com.rosadesktop.model.InformationFilterExport;
import br.com.rosadesktop.viewController.Export_WindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 *
 * @author Claudio
 */
public class Export_Controller extends Application implements Window_Interface{
    private Stage primaryStage;
    
    private Export_WindowController exportWindowController;
    
    private InformationFilterExport informationModel;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/com/rosadesktop/fxml/Export_Window.fxml"));
        Parent root = fxmlLoader.load();
        
        this.exportWindowController = fxmlLoader.getController();
        
        this.exportWindowController.setController(this);
        
        this.informationModel = new InformationFilterExport();
        
        this.informationModel.addObserver(exportWindowController);
        
        
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

    public void searchButtonPressed(String codVend, String dateFrom, String dateTo) 
    {
        this.informationModel.setCodVend(codVend);
        this.informationModel.setDateFrom(dateFrom);
        this.informationModel.setDateTo(dateTo);
        
        this.informationModel.loadInformation();
    }
}
