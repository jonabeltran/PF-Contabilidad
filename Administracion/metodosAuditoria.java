/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import Comunes.coneccionComun;
import Login.*;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jonathan
 */
public class metodosAuditoria {
    
    public void ingresarAuditoria(String accion,String id_art,String descripcion,String tasa,String pago){
        
       // miLogin=new login();
        
        String usuario=login.nombreUsuario;
        String terminal=ventana_supervisor.jTextField2.getText();
        String fecha=dameFecha();
        String hora=dameHora();
        String tabla="Articulos";
        
        instruccionSQL="INSERT INTO auditoriaarticulos( usuario, terminal, fecha, hora, tabla, accion, id_articulo, descripcion, tasa_iva, id_pago)VALUES('"
                + usuario + "','" + terminal + "','" + fecha + "','" + hora + "','" + tabla + "','" + accion + "'," + id_art + ",'" + descripcion + "','" + tasa +"','"+ pago +"')";

        miConexion=new coneccionBD();

        miSentencia=miConexion.dameSentencia();

        try{

            miSentencia.executeUpdate(instruccionSQL);

        }catch(Exception e){

            e.printStackTrace();

        }
        
    }
    
    public void ingresarAuditoriaPAgo(String accion, String id_pago,String descripcion, String sigla){
        
       // miLogin=new login();
        
        String usuario=login.nombreUsuario;
        String terminal=ventana_supervisor.jTextField2.getText();;
        String fecha=dameFecha();
        String hora=dameHora();
        String tabla="Formas Pago";
        
        instruccionSQL="INSERT INTO auditoriapago( usuario, terminal, fecha, hora, tabla, accion, id_pago,descripcion,siglas)VALUES('"
                + usuario + "','" + terminal + "','" + fecha + "','" + hora + "','" + tabla + "','" + accion + "','" + id_pago + "','" + descripcion + "','" + sigla +"');";

        coneccionComun miConexion=new coneccionComun();

        miSentencia=miConexion.dameSentencia();

        try{

            miSentencia.executeUpdate(instruccionSQL);

        }catch(Exception e){

            e.printStackTrace();

        }
        
    }
    
    public String dameHora(){
        
        Calendar calendario = Calendar.getInstance();
        
        int hora, minutos, segundos;
        
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        
        String laHora=hora + ":" + minutos + ":" + segundos;
        
        return laHora;
        
    }
    
    public String dameFecha(){
        
       /* Calendar c = new GregorianCalendar();
        
       // String dia,mes,annio;
        
        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH));
        String annio = Integer.toString(c.get(Calendar.YEAR));
        
        String fecha=annio + "-" + mes + "-" + dia;*/
       DateFormat formato=new SimpleDateFormat("YYYY-MM-dd");
       
       String fecha=formato.format(new Date());
       
        return fecha;
    }
    
    public String instruccionSQL;
    public coneccionBD miConexion;
    public Statement miSentencia;
    public login miLogin;
    
}
