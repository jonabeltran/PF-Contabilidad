/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan
 */
public class metodos_login {
    
    public boolean verificar_usuario(String nombre,String pass){
        
        coneccion=new coneccionBD();
        
        rs1=coneccion.listar("usuarios");
        
        boolean encontrado=false;
        
        try{
            
            while(rs1.next() && encontrado==false){
               
               if(rs1.getString(2).equals(nombre) && rs1.getString(3).equals(pass)){
                   
                   encontrado=true;
                   
               }
               
           } 
            
        }catch(Exception e){
            
        }
        
        
        return encontrado;
    }
    
   
    
    
    
      public ResultSet registroTabla2(String tabla,String campoid,int id){
        coneccion=new coneccionBD();
        rs1=coneccion.registroTabla(tabla, campoid, id);
        return rs1;
    }
      
    public int dameClaveEmpresa(String nombre,String pass){
        
         coneccion=new coneccionBD();
        
        rs1=coneccion.listar("usuarios");
        
        boolean encontrado=false;
        int idEmpresa=0;
        
        try{
            
            while(rs1.next() && encontrado==false){
               
               if(rs1.getString("usu_nombre").equals(nombre) && rs1.getString("usu_contra").equals(pass)){
                   
                   encontrado=true;
                   idEmpresa=Integer.parseInt(rs1.getString("id_empresa"));
                   
               }
               
           } 
            
        }catch(Exception e){
            
        }
        
        
        return idEmpresa;
        
    } 
    
     public String dameNombreEmpresa(int id){
        
         coneccion=new coneccionBD();
        
        rs1=coneccion.listar("empresas");
        
        boolean encontrado=false;
      //  String nombre="";
        int i=0;
        String ne="";
        try{
            
            while(rs1.next() && encontrado==false){
                
               i=Integer.parseInt(rs1.getString("id_empresa"));
               
               if(i==id){
                   
                   encontrado=true;
                    ne=rs1.getString("nombre");
                   
               }
               
           } 
            
        }catch(Exception e){
            
        }
        
        
        return ne;
        
    } 
     public int dameClavePerfil(String nombre,String pass){
        
         coneccion=new coneccionBD();
        
        rs1=coneccion.Dame_Conector_usuarios();
        
        boolean encontrado=false;
        int idperfil=0;
        
        try{
            
            while(rs1.next() && encontrado==false){
               
               if(rs1.getString(2).equals(nombre) && rs1.getString(3).equals(pass)){
                   
                   encontrado=true;
                   idperfil=rs1.getInt(4);
                   
               }
               
           } 
            
        }catch(Exception e){
            
        }
        
        
        return idperfil;
        
    }
    
     public String dameTipoPerfil(int clave){
        
         coneccion=new coneccionBD();
        
        rs1=coneccion.Dame_Conector_perfiles();
        
        boolean encontrado=false;
        String tipo="";
        
        try{
            
            while(rs1.next() && encontrado==false){
               
               if(rs1.getInt(1)==clave){
                   
                   encontrado=true;
                   tipo=rs1.getString(2);
                   
               }
               
           } 
            
        }catch(Exception e){
            
        }
        
        
        return tipo;
        
    }
     
    
   
     
    public coneccionBD coneccion;
    public ResultSet rs1;
}
