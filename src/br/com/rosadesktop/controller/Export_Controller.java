/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.controller;

import br.com.rosadesktop.interfaces.Window_Interface;
import br.com.rosadesktop.model.InformationFilterExport;
import br.com.rosadesktop.viewController.Export_WindowController;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

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
        this.exportWindowController = new Export_WindowController();
        fxmlLoader.setController(this.exportWindowController);
        Parent root = fxmlLoader.load();
        
        
        
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

    public void exportFile() 
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(".rosa", "Banco de dados do Rosa Tablet"));
        fileChooser.setTitle("Save Database");
        
        File file = fileChooser.showSaveDialog(this.getStage());
        
        String description = fileChooser.getSelectedExtensionFilter().getDescription();
//        System.out.println(description);
        
        if (file != null) 
        {
            String pathDB = file.getPath().replace("\\", "\\\\")+description;
//            System.out.println(pathDB);
            this.informationModel.exportPedidosSelected(pathDB);
            JOptionPane.showMessageDialog(null, "Exportado com sucesso!");
        }
    }
}
