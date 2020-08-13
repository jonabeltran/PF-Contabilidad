
package BackupEmpresa;

import java.awt.HeadlessException;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class funcionesBackup {
    
    public String login ="branko";
    public String password ="3355";
    public String urlcero = "jdbc:mysql://192.168.0.3/";
    public Connection conn = null;
    public String nombrebackup=null;
    public String rutaMysqlDumnp=dameRutaMysqlDump("mysqldump.exe");
    public String rutaMysql=dameRutaMysqlDump("mysql.exe");
    
     public void RestaurarBackup(Connection con,String[] nom, String nomBd){
      Statement sentencia = null;
      Connection coneccionini = null;
   //   conectar();
         if (con!=null){
          try {
               coneccionini = DriverManager.getConnection(urlcero, login, password);
               sentencia = coneccionini.createStatement();
               String comsSQLborra = "DROP DATABASE IF EXISTS " + nomBd;
               sentencia.executeUpdate(comsSQLborra);
               coneccionini = DriverManager.getConnection(urlcero, login, password);
               sentencia = coneccionini.createStatement();
               String comsSQL = "CREATE DATABASE "+nomBd;
               sentencia.executeUpdate(comsSQL);
              
               Process child = Runtime.getRuntime().exec(nom);
               int proceCom = child.waitFor();
               if (proceCom==0) {
                   JOptionPane.showMessageDialog(null, "BD Restaurada");
                }else{
                   JOptionPane.showMessageDialog(null, "BD Fallida");
                }
              
         } catch (Exception ex) {}
       }else if (con==null){ 
           try {
             coneccionini = DriverManager.getConnection(urlcero, login, password);
             sentencia = coneccionini.createStatement();
             String comsSQL = "CREATE DATABASE "+nomBd; 
             sentencia.executeUpdate(comsSQL);
           //  Process child = Runtime.getRuntime().exec("cmd /c mysql --password="+password+" --user="+login+" "+bd+" < " +nom.getPath());
             Process child = Runtime.getRuntime().exec(nom);
             int proceCom = child.waitFor();
             if (proceCom==0) {
                JOptionPane.showMessageDialog(null, "BD Restaurada");
             }else{
                JOptionPane.showMessageDialog(null, "BD Fallida");
             }
          }catch (Exception ex) { }
           
          }
        
    }
     
    public void HacerBackup(JFileChooser miChooser, String bd){
      try {
            String archivo = null;

            miChooser.setVisible(true);

            int result = miChooser.showSaveDialog(null);

            if(result == JFileChooser.APPROVE_OPTION){
                archivo = miChooser.getSelectedFile().toString().concat(".sql");

                File file = new File(archivo);

                if(file.exists()){
                    Object[] options = { "Si", "No" };
                    int opcao = JOptionPane.showOptionDialog(null,"Este archivo ya existe.¿Quiere sobre escribir este Archivo?","¡¡¡Atención!!!",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,options, options[0]);
                    if (opcao == JOptionPane.YES_OPTION) {
                        Runtime bck = Runtime.getRuntime();
                   //     bck.exec("C:/xampp/mysql/bin/mysqldump.exe --host=localhost --user=root --password= --result-file="+archivo+" --databases "+bd);
                        bck.exec(rutaMysqlDumnp+" --host=192.168.0.3 --user=branko --password=3355 --result-file="+archivo+" --databases "+bd);
                       
                        JOptionPane.showMessageDialog(null, "¡Respaldo de Base de datos Reemplazado!", "Java", 1);
                        //        dispose();
                    }
                }else{
                    Runtime bck = Runtime.getRuntime();
                 //   bck.exec("C:/xampp/mysql/bin/mysqldump.exe --host=localhost --user=root --password= --result-file="+archivo+" --databases "+bd);
                    bck.exec(rutaMysqlDumnp+" --host=192.168.0.3 --user=branko --password=3355 --result-file="+archivo+" --databases "+bd);
                  
                    JOptionPane.showMessageDialog(null, "¡Respaldo de Base de datos éxitoso!", "Java", 1);
                    //         dispose();
                }

            }

        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", 2);
        }
    }
    
   public void Restaurar(String archivo){
       
        Process runtimProcess;
                try {
                    //  String[]restoreCmd=new String[]{"C:/xampp/mysql/bin/mysql.exe ", "--user=" + login, "--password=" + password, "-e", "source " + archivo};
                   //   String[]restoreCmd=new String[]{rutaMysql, " --user=" + login, "--password=" + password, "-e", "source " + archivo};
                    String restoreCmd=rutaMysql+" --user="+login+" --password="+password+" emp002 < " +archivo;
                      runtimProcess = Runtime.getRuntime().exec(restoreCmd);
                    /*  int proceCom = runtimProcess.waitFor();
            
                      if (proceCom==0) {
                         JOptionPane.showMessageDialog(null, "BD Restaurada");
                      }else{
                         JOptionPane.showMessageDialog(null, "BD Fallida");
                      }*/
                } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e);
                }
               
           
        }
   
   
   public String[]dameComando(String rutaArchivo){
       
        String[]restoreCmd=null;   
                    
     //   restoreCmd=new String[]{"C:/xampp/mysql/bin/mysql.exe ", "--user=" + login, "--password=" + password, "-e", "source " + rutaArchivo};
        restoreCmd=new String[]{rutaMysql, "--user=" + login, "--password=" + password, "-e", "source " + rutaArchivo};
                   
        return restoreCmd;
   }
   
    public String dameArchivo(){
       
        JFileChooser ch=new JFileChooser();
        
        FileNameExtensionFilter fil=new FileNameExtensionFilter("SQL","sql");
        
        ch.setFileFilter(fil);
        
        int se=ch.showOpenDialog(null);
        
        if(se==JFileChooser.APPROVE_OPTION){
            
            int rta=JOptionPane.showConfirmDialog(null, "Estas seguro que desea Importar la BD ?", "importar", JOptionPane.YES_NO_OPTION);

            if(rta==0){ 
                String rutaImportar=ch.getSelectedFile().getAbsolutePath();
                nombrebackup=rutaImportar.replace("\\","/");   
                    
                    
             }else{
                JOptionPane.showMessageDialog(null, "cancelaste");
            }   
       
        }
        return nombrebackup;
   }
    
   public String dameRutaMysqlDump(String archivo){
       
       File fichero = new File(archivo);
       String ruta=fichero.getAbsolutePath();
       String rutaNueva=ruta.replace("\\","/");
       
       return rutaNueva;
       
   }
    
   
}
