/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Properties;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 *
 * @author Rafael
 */
public class Properties_Manipulator {
    
	public Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("src/Properties/data.properties");
		props.load(file);
		return props;

	}


}