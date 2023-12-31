
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexionBD {
    
    private Connection conexion;
    private Statement statement;   

    public ConexionBD() {
    }        
    
        
//    public void conectar(){
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conexion = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/SoLgdoA3ya", "SoLgdoA3ya", "4hA6P1xTOL");
//            statement = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
//        } catch (SQLException e) {           
//            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
//    public void conectar(){
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conexion = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/OX4VXZZMQ5", "OX4VXZZMQ5", "e0ThWbq0ZR");
//            statement = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
//        } catch (SQLException e) {           
//            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    
     
//     public void conectar(){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conexion = DriverManager.getConnection("jdbc:mysql://localhost/example","root","");
//            statement = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
//        } catch (SQLException e) {           
//            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    
    
    Connection connect = null;
//    
//    public Connection conectar() {
//        try { 
//            Class.forName("com.mysql.jdbc.Driver");
//               connect = DriverManager.getConnection("jdbc:mysql://localhost/example","root","");
//          //  connect = DriverManager.getConnection("jdbc:mysql://localhost/example", "root", "");
//            //JOptionPane.showMessageDialog(null, "Felicitaciones estas conectado");
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Error..."+ex);
//        }
//        return connect;
//    }
//    

    public Connection conectar() {
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connect = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10505947","sql10505947","hDmRRLagiF");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/example", "root", "");
            //JOptionPane.showMessageDialog(null, "Felicitaciones estas conectado");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error..."+ex);
        }
        return connect;
    }
    public ResultSet CONSULTAR(String sql) throws SQLException{
        System.out.println(sql);
        return statement.executeQuery(sql);
    }
    
    public int GUARDAR(String sql) throws SQLException{
        int n = statement.executeUpdate(sql);;
        return n;
    }
    
    
    public void CERRAR(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}