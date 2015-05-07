/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package freelancer_sidney;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michel
 */
public class Conexao {

    static Connection con=null;

 public static Connection conectar(){
    try {
        //Class.forName("com.mysql.jdbc.Driver");
       // con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/ocorrenciasanimais3","root","");
         Class.forName("org.firebirdsql.jdbc.FBDriver");
         con =  DriverManager.getConnection("jdbc:firebirdsql:localhost/3050:C://DBROSA.GDB","SYSDBA","masterkey");
         System.out.println("its alive");
    }
    catch (SQLException e) {
        System.out.println(e.getMessage());
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return con;
    }

}
