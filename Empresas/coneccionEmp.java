/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empresas;

/**
 *
 * @author jonathan
 */

import java.sql.*;
import javax.swing.JOptionPane;

public class coneccionEmp {
     private String driver="com.mysql.jdbc.Driver";
     public String con="jdbc:mysql://localhost/empresas";
     public String user="root";
     public String pass="";
     public ResultSet rs1;
     public ResultSet rs2;
     public Statement miSentencia;
     public Connection conn;
     
    public Statement dameSentencia(){
    	
		try {
			Connection miConexion=DriverManager.getConnection(con,user,pass);
			miSentencia=miConexion.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	    	
    	return miSentencia;
    }
    
      public ResultSet listar(String tabla){
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(con,user,pass);
            Statement miStatement=conn.createStatement();
			
	    rs1=miStatement.executeQuery("select * from "+tabla);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+e.getMessage());
        }
        return rs1;
    }
    
}
