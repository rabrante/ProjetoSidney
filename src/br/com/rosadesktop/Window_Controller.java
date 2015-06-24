/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop;

import br.com.rosadesktop.interfaces.Window_Interface;
import br.com.rosadesktop.controller.Choose_Controller;
import br.com.rosadesktop.controller.Export_Controller;
import br.com.rosadesktop.controller.Import_Controller;
import br.com.rosadesktop.controller.Login_Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;

/**
 *
 * @author Claudio
 */
public class Window_Controller {
    
    private Window_Interface currentWindow;
    
    public static Window_Controller wdf;
    
    public static Window_Controller getInstance() {
            if (wdf == null) {
                    wdf =  new Window_Controller();
            }
            return wdf;
    }
    
    public void openLoginWindow() {
        Login_Controller login = new Login_Controller();
        currentWindow = (Window_Interface)login;
        try {
            login.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Window_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void openSelectedImportOrExport()
    {
        Choose_Controller choose = new Choose_Controller();
        
        try {
            choose.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Window_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage s = currentWindow.getStage();
        currentWindow = choose;
        
        s.getScene().getWindow().hide();
    }   
    
    public void openExportWindow()
    {
        Export_Controller export = new Export_Controller();
        
        try {
            export.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Window_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage s = currentWindow.getStage();
        currentWindow = export;
        
       s.getScene().getWindow().hide();
    }
    
    public void openImportWindow()
    {
        Import_Controller importWindow = new Import_Controller();
        
        try {
            importWindow.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Window_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage s = currentWindow.getStage();
        currentWindow = importWindow;
        
        s.getScene().getWindow().hide();
    }
    
}
