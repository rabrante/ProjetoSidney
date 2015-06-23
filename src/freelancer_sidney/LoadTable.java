/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package freelancer_sidney;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class LoadTable {
    private String vendedor;
    private String pedido;
    ResultSet result;
    
    ObservableList<ItemPedido> data = FXCollections.observableArrayList( ); 
    
    Connection con = null;
    
    public void LoadTable(TableView tableView) throws SQLException
    {
        Group root = new Group();
        
        con = Conexao.conectar();
        if(con != null)
        {
            PreparedStatement statement = con.prepareStatement("SELECT * "
                                                         + " FROM ITEMPEDIDO"
                                                         + " INNER JOIN PEDIDO ON ITEMPEDIDO.PEDIDO = PEDIDO.PEDIDO"
                                                         + " WHERE "
                                                         + " PEDIDO.CODVEN = ?");
                                                        // + " AND PEDIDO.CODVEN = '"+vendedor+"'");
            statement.setString(1, pedido);
            result = statement.executeQuery();
            result.next();

            
            if(result.next())
            {
                System.out.println(result.getString(1));
                while(result.next())
                {  

                             System.out.println(result.getString(1));
                             //data.addAll(new ItemPedido(result.getInt("PEDIDO"), result.getInt("CODART"), result.getString("DESCRICAO"), result.getInt("QTDSAI"), result.getInt("QTDRET"), result.getFloat("PRECUS"), result.getFloat("PREVEN")));
                             data.add(new ItemPedido(result.getString("PEDIDO"), result.getString("CODART"), result.getString("DESCRICAO"), result.getFloat("QTDSAI"), result.getFloat("QTDRET"), result.getFloat("PRECUS"), result.getFloat("PREVEN")));
                }

                tableView.setItems(data);  
            }
            else
            {
                data.removeAll();
                JOptionPane.showMessageDialog(null, "valor errado");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar");
        }
        /*TableColumn firstNameCol = new TableColumn();  
  
        firstNameCol.setText("First");  
  
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));  
  
  * 
  * 
  * 
  * 
  * SELECT ITEMPEDIDO.PEDIDO
FROM ITEMPEDIDO
     INNER JOIN PEDIDO
           ON PEDIDO.PEDIDO = ITEMPEDIDO.PEDIDO
WHERE ITEMPEDIDO.PEDIDO = '001184'
AND PEDIDO.CODVEN = '005'
  * 
  * 
  * 
        TableColumn lastNameCol = new TableColumn();  
  
        lastNameCol.setText("Last");  
  
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));  
  
        TableColumn emailCol = new TableColumn();  
  
        emailCol.setText("Email");  
  
        emailCol.setMinWidth(200);  
  
        emailCol.setCellValueFactory(new PropertyValueFactory("email"));*/  
  
        //TableView tableView = new TableView();  
          
    
  
       // tableView.getColumns().addAll(firstNameCol, lastNameCol, emailCol);  
  
        //root.getChildren().add(tableView); 
    }

    
    
    
    
    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
}
