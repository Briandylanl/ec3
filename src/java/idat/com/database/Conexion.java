package idat.com.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author JHAIRO MENDOZA
 */
import java.sql.*;
public class Conexion {

   public static Connection MySQL() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://single-2040.banahosting.com:3306/zfuxgsvw_idat_grupo7", "zfuxgsvw_root_grupo7", "Lim@2023");
        return c;
    } 
    
}

