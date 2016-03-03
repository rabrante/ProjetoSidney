/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.thread;

import br.com.rosadesktop.dao.InformationExportDAO;
import br.com.rosadesktop.model.Pedido;
import java.awt.FlowLayout;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rafael
 */
public class Progress implements Runnable{
    private volatile boolean fim = false;
    private JFrame janela = new JFrame();
    
   
    public void run(){
        
        if(!fim){
            janela.setLocationRelativeTo(null);
            //janela.setLayout(null);
            janela.setSize(400,100);
            

            janela.setVisible(true);
            JPanel painel = new JPanel();
            janela.add(painel);
            JLabel myLabel = new JLabel("O sistema está copiando o banco, Aguarde alguns instantes.", JLabel.LEFT); 
            painel.setLayout(new FlowLayout());
            painel.add(myLabel);  
        }
    }
    
    public void stopRun(){
        fim = true;
        janela.dispose();
    }
}
