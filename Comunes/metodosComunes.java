
package Comunes;

import java.sql.*;


public class metodosComunes {
    
    public coneccionComun miComun;
    public ResultSet rs;
    public Statement senten;
    
    public void insertar_en_uso(String id_pago,String descripcion){
        
        miComun=new coneccionComun();
        rs=miComun.listar("pagos_en_uso");
        
        boolean esta=false;
        
        try{
        
        while(rs.next() && esta==false){
            
            if(rs.getString("id_pago").equals(id_pago)){
                
                esta=true;
                
            }  
        }
        
         if(esta==false){
            
            String sql="insert into pagos_en_uso values('"+id_pago+"','"+descripcion+"');";
            senten=miComun.dameSentencia();
            senten.executeUpdate(sql);
            
        }
        
        }catch(Exception e){}
        
       
        
    }
    
    public boolean depende(String clave){
        
        miComun=new coneccionComun();
        rs=miComun.listar("pagos_en_uso");
        
        boolean esta=false;
        
        try{
        
        while(rs.next() && esta==false){
            
            if(rs.getString("id_pago").equals(clave)){
                
                esta=true;
                
            }  
        }
        }catch(Exception e){}
        
        return esta;
        
    }
    
}
