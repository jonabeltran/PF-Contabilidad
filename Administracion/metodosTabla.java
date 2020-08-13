/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Administracion;

import Login.coneccionBD;

/**
 *
 * @author jonathan
 */

import javax.sql.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import Comunes.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class metodosTabla {
    
  public String[][] dameMatriz(ResultSet rs){
		
	       String datos[][] = null;
			
	        try{
	        	
	             rs.last();
	        	 
	             ResultSetMetaData rsmd = rs.getMetaData();
	      
	             int numCols = rsmd.getColumnCount();
	      
	             int numFils =rs.getRow();
	      
	            datos =new String[numFils][numCols];
	            
	            int i=0;
	            
	            rs.beforeFirst();
	        	
	        	while(rs.next()){	
	        		for(int j=0;j<numCols;j++){
	        			
	        			datos[i][j]=rs.getString(j+1);	
	        			
	        		}
	        		i++;
	        	}
	        
				
			}catch(Exception e){
				
				System.out.println("no conecta");
				e.printStackTrace();
				
			}
	        		
			return datos;
			
			
     }
    
    public DefaultTableModel dameModelo(String nomTabla){
        
        miConexion=new coneccionBD();
        coneccionComun aux=new coneccionComun();
      
      if(nomTabla=="pago"){
          
          cabecera=new String[3];
            
            cabecera[0]="Clave";
            cabecera[1]="Descripcion";
            cabecera[2]="Sigla";
            
            
            ResultSet dat2=aux.listar("formas_de_pago");
            
            datos=dameMatriz(dat2);
          
      }else
      if (nomTabla=="articulos"){
            
            cabecera=new String[4];
            
            cabecera[0]="Nro de articulo";
            cabecera[1]="Descripcion";
            cabecera[2]="Tipo de Tasa de IVA";
            cabecera[3]="Clave de Forma de Pago";
            
            ResultSet dat2=miConexion.listar("articulos_de_stock");
            
            datos=dameMatriz(dat2);
            
        }else if (nomTabla=="usuarios"){
            
            cabecera=new String[4];
            
            cabecera[0]="ID";
            cabecera[1]="Nombre Usuario";
            cabecera[2]="Contraseña";
            cabecera[3]="Perfil";
            
            ResultSet dat2=miConexion.listar("usuarios");
            
            datos=dameMatriz(dat2);
            
        }else if (nomTabla=="auditorArticulo"){
            
            cabecera=new String[11];
            
            cabecera[0]="ID";
            cabecera[1]="usuario";
            cabecera[2]="terminal";
            cabecera[3]="fecha";
            cabecera[4]="hora";
            cabecera[5]="tabla";
            cabecera[6]="accion";
            cabecera[7]="campo ID";
            cabecera[8]="campo Descripcion";
            cabecera[9]="campo Tasa";
            cabecera[10]="campo pago";
            
            ResultSet dat2=miConexion.listar("auditoriaarticulos");
            
            datos=dameMatriz(dat2);
            
        }
      
       else if (nomTabla=="auditorPago"){
            
            cabecera=new String[10];
            
            cabecera[0]="ID";
            cabecera[1]="usuario";
            cabecera[2]="terminal";
            cabecera[3]="fecha";
            cabecera[4]="hora";
            cabecera[5]="tabla";
            cabecera[6]="accion";
            cabecera[7]="ID";
            cabecera[8]="Descripcion";
            cabecera[9]="sigla";
            
            
            ResultSet dat2=aux.listar("auditoriapago");
            
            datos=dameMatriz(dat2);
            
        }
      
        DefaultTableModel modelo=new DefaultTableModel(datos,cabecera);
        
        return modelo;
        
    }
    
    public boolean repetido(String valor,String nomTabla){
        
        repetido=false;
        
        miConexion=new coneccionBD();
        
         if (nomTabla=="articulos"){
            
           miTabla=miConexion.listar("articulos_de_stock");
            
        }else if(nomTabla=="pago"){
            
            coneccionComun comun=new coneccionComun();
            
            miTabla=comun.listar("formas_de_pago");
            
        }else if(nomTabla=="plan_cuentas"){
           miTabla=miConexion.listar("plan_cuentas"); 
        }
        
        try{
            
           while((miTabla.next()) && (repetido==false)){
               
               if(miTabla.getString(1).equals(valor)){
                   
                   repetido=true;
                   
               }
               
           } 
            
        }catch (Exception e){
            
        }
        
        return repetido;
    }
    
    public int dameNumFila(String num,String nomTabla){
        
        miConexion=new coneccionBD();
        
        if (nomTabla=="articulos"){
            
            miTabla2=miConexion.listar("articulos_de_stock");
            
        }else if(nomTabla=="pago"){
            
            coneccionComun comun=new coneccionComun();
            
            miTabla=comun.listar("formas_de_pago");
        }
        
        try{
            
            boolean corte=false;
            numero=0;
            
            while(miTabla2.next() && corte==false){
                
                if(miTabla2.getString(1).equals(num)){
                    
                    corte=true;
                         
                }else{
                    
                    numero++;
                    
                }
                
            }
            
        }catch (Exception e){
            
        }
        
        return numero;
        
    }
    
    public boolean BuscarDepende(String clave,String nomTabla){
        
        miConexion=new coneccionBD();
       if (nomTabla=="articulos"){
            
            miTabla2=miConexion.listar("articulos_de_stock");
            
        }
        
        try{  
            
            encontre=false;
            
            while(miTabla2.next() && encontre==false){
                
                if(miTabla2.getString(4).equals(clave)){
                    
                    encontre=true;
                    
                }
                
            }
            
        }catch(Exception e){
            
        }
        
        return encontre;
    }
    
    
    public boolean Buscar(String clave,String nomTabla){
        
        miConexion=new coneccionBD();
        
       if (nomTabla=="articulos"){
            
            miTabla2=miConexion.listar("articulos_de_stock");
            
        }else if(nomTabla=="pago"){
            
            coneccionComun aux=new coneccionComun();
            
            miTabla2=aux.listar("formas_de_pago");
        }
        
        try{  
            
            encontre=false;
            
            while(miTabla2.next() && encontre==false){
                
                if(miTabla2.getString(1).equals(clave)){
                    
                    encontre=true;
                    
                }
                
            }
            
        }catch(Exception e){
            
        }
        
        return encontre;
    }
    
    public String[] dameDatos(String clave,String nomTabla){
        
        miConexion=new coneccionBD();
        
    if (nomTabla=="articulos"){
            
            miTabla2=miConexion.listar("articulos_de_stock");
            
    }else if(nomTabla=="pago"){
            
            coneccionComun aux=new coneccionComun();
            
            miTabla2=aux.listar("formas_de_pago");
        }
        
        try{  
            
            boolean corte=false;
            
            while(miTabla2.next() && corte==false){
                
                if(miTabla2.getString(1).equals(clave)){
                    
                    corte=true;
                    
                    if(nomTabla=="pago"){
                        
                        consulta=new String[3];
                        consulta[0]=miTabla2.getString(1);
                        consulta[1]=miTabla2.getString(2);
                        consulta[2]=miTabla2.getString(3);
                      
                    }else {
                        
                        consulta=new String[4];
                        consulta[0]=miTabla2.getString(1);
                        consulta[1]=miTabla2.getString(2);
                        consulta[2]=miTabla2.getString(3);
                        consulta[3]=miTabla2.getString(4);
                    }
                         
                }
                
            }
            
        }catch (Exception e){
            
        }
        
        return consulta;
        
    }
    
    public String dameDescripcion(String clave){
        
        coneccionComun aux=new coneccionComun();
        
        miTabla3=aux.listar("formas_de_pago");
        
        try{  
            
            boolean corte=false;
            
            while(miTabla3.next() && corte==false){
                
                if(miTabla3.getString(1).equals(clave)){
                    
                    corte=true;
                    
                    descrip=miTabla3.getString(2);
                    
                }
                
            }
            
        }catch(Exception e){
        
        }
        
        return descrip;
        
    }
    
    private int NumColumna;
    private String descrip;
    private boolean encontre;
    public String[] consulta; 
    private boolean repetido;
    private ResultSet miTabla;
    private ResultSet miTabla2,miTabla3;
     private String [][] datos;
     private String [] cabecera;
    private coneccionBD miConexion;
    private int numero;
    
}

