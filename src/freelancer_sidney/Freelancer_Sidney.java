/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package freelancer_sidney;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Rafael
 */
public class Freelancer_Sidney extends Application {

  

   /* public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }*/
    
    
    @Override
    public void start(Stage stage) {
       
        
       
        
        TableColumn firstNameCol = new TableColumn();
        
        AnchorPane pane = new AnchorPane();
        
        pane.setPrefSize(600, 500);
        
        final TextField txVendedor = new TextField();
        txVendedor.setPromptText("Vendedor");
        final TextField txPedido = new TextField();
        txPedido.setPromptText("Pedido");
        
        Button btEntrar = new Button("Entrar");
        final TableView tableView = new TableView();
        pane.getChildren().addAll(txVendedor, txPedido, btEntrar, tableView);
        
        Scene scene = new Scene(pane);
        
        
        
        stage.setScene(scene);
        stage.show();

txVendedor.setLayoutX(50);//(pane.getWidth() - txVendedor.getWidth()) / 2
txVendedor.setLayoutY(30);
txVendedor.setPrefWidth(70);

txPedido.setLayoutX(130);
txPedido.setLayoutY(30);
txPedido.setPrefWidth(98);

tableView.setLayoutX(50);
tableView.setLayoutY(80);
tableView.setMaxHeight(300);
tableView.setMaxWidth(500);

btEntrar.setLayoutX(100);
btEntrar.setLayoutY(55);

btEntrar.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
               Conexao.conectar();
               
               
               TableColumn primeiraNameCol = new TableColumn();  
               primeiraNameCol.setText("Pedido");  
               primeiraNameCol.setCellValueFactory(new PropertyValueFactory("Pedido"));
               
               
               TableColumn segundaNameCol = new TableColumn();  
               segundaNameCol.setText("CodArt");  
               segundaNameCol.setCellValueFactory(new PropertyValueFactory("CodArt"));
               
               
               TableColumn terceiraNameCol = new TableColumn();  
               terceiraNameCol.setText("Descricao");  
               terceiraNameCol.setCellValueFactory(new PropertyValueFactory("Descricao")); 
               
               
               TableColumn quartaNameCol = new TableColumn();  
               quartaNameCol.setText("QtdSai");  
               quartaNameCol.setCellValueFactory(new PropertyValueFactory("QtdSai"));
               
               
               TableColumn quintaNameCol = new TableColumn();  
               quintaNameCol.setText("QtdRet");  
               quintaNameCol.setCellValueFactory(new PropertyValueFactory("QtdRet"));
               
               
               TableColumn sextaNameCol = new TableColumn();  
               sextaNameCol.setText("Precus");  
               sextaNameCol.setCellValueFactory(new PropertyValueFactory("Precus")); 
               
               
               TableColumn setimaNameCol = new TableColumn();  
               setimaNameCol.setText("Preven");  
               setimaNameCol.setCellValueFactory(new PropertyValueFactory("Preven"));
               
               
               tableView.getColumns().addAll(primeiraNameCol, segundaNameCol, terceiraNameCol, quartaNameCol, quintaNameCol, sextaNameCol, setimaNameCol);
               
               
               LoadTable table = new LoadTable();
               table.setPedido(txPedido.getText());
               table.setVendedor(txVendedor.getText());
               try {
                   table.LoadTable(tableView);
               } catch (SQLException ex) {
                   Logger.getLogger(Freelancer_Sidney.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
});


        
    }

    

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
