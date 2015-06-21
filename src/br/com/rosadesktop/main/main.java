/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.main;

import br.com.rosadesktop.Login;
import br.com.rosadesktop.Window_Controller;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Claudio
 */
public class main extends Application{
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Window_Controller wc = Window_Controller.getInstance();
        wc.openLoginWindow();
        primaryStage.close();
    }
}
