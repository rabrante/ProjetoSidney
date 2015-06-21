/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop;

import br.com.rosadesktop.interfaces.Window_Interface;
import br.com.rosadesktop.view.Choose_Window;
import br.com.rosadesktop.view.Export_Window;
import br.com.rosadesktop.view.Import_Window;
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
        Login login = new Login();
        currentWindow = (Window_Interface)login;
        try {
            login.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Window_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void openSelectedImportOrExport()
    {
        Choose_Window choose = new Choose_Window();
        
        try {
            choose.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Window_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage s = currentWindow.getStage();
        currentWindow = choose;
        
        s.close();
    }   
    
    public void openExportWindow()
    {
        Export_Window export = new Export_Window();
        
        try {
            export.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Window_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage s = currentWindow.getStage();
        currentWindow = export;
        
        s.close();
    }
    
    public void openImportWindow()
    {
        Import_Window importWindow = new Import_Window();
        
        try {
            importWindow.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(Window_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage s = currentWindow.getStage();
        currentWindow = importWindow;
        
        s.close();
    }
    
}
