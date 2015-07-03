/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.viewController;

import br.com.rosadesktop.controller.Login_Controller;
import br.com.rosadesktop.controller.Pedido_Controller;
import br.com.rosadesktop.model.Pedido;
import freelancer_sidney.Conexao;
import freelancer_sidney.ItemPedido;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Rafael
 */
public class Pedido_WindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView TbPedido;
    private Pedido_Controller PedidoWindow;
    ObservableList<Pedido> data = FXCollections.observableArrayList( ); 
    
    
    public void LoadPedido() throws SQLException{
        ResultSet result;
         Connection con = null;
        con = Conexao.conectar();
        if(con != null)
        {
            PreparedStatement statement = con.prepareStatement("SELECT * "
                                                         + " FROM ITEMPEDIDO"
                                                         + " INNER JOIN PEDIDO ON ITEMPEDIDO.PEDIDO = PEDIDO.PEDIDO"
                                                         + " WHERE "
                                                         + " PEDIDO.CODVEN = ?");
                                                        // + " AND PEDIDO.CODVEN = '"+vendedor+"'");
            statement.setString(1, "002499");
            result = statement.executeQuery();
            result.next();

            
            if(result.next())
            {
                System.out.println(result.getString(1));
                while(result.next())
                {  

                             System.out.println(result.getString(1));
                             //data.addAll(new ItemPedido(result.getInt("PEDIDO"), result.getInt("CODART"), result.getString("DESCRICAO"), result.getInt("QTDSAI"), result.getInt("QTDRET"), result.getFloat("PRECUS"), result.getFloat("PREVEN")));
                             data.add(new Pedido(result.getString("PEDIDO"), result.getString("CODART"), result.getString("DESCRICAO"), result.getFloat("QTDSAI"), result.getFloat("QTDRET"), result.getFloat("PRECUS"), result.getFloat("PREVEN")));
                }

                TbPedido.setItems(data);  
            }
            else
            {
                data.removeAll();
               // JOptionPane.showMessageDialog(null, "valor errado");
            }
        }
        else
        {
            //JOptionPane.showMessageDialog(null, "Não foi possivel conectar");
        
    }
    }
       
        
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if(rb != null)
            System.out.println(rb.toString());
    }    

    public void setMainClass(Pedido_Controller aThis)
    {
        this.PedidoWindow = aThis;
    }
    
      
    
}
