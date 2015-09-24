/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.properties;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;
import javax.swing.JOptionPane;


/**
 *
 * @author Rafael
 */
public class Properties_Manipulator {
    
	public Properties getProp() throws IOException {
		Properties props = new Properties();
                String path = Properties_Manipulator.class.getProtectionDomain().getCodeSource().getLocation().getPath();
                String decodedPath = URLDecoder.decode(path, "UTF-8");
                File file1 = new File(decodedPath);
                String mainPath = file1.getParent();
//                JOptionPane.showMessageDialog(null, mainPath);
		FileInputStream file = new FileInputStream("lib/data.properties");
		props.load(file);
		return props;

	}


}