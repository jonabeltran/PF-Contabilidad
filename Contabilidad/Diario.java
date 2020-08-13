/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contabilidad;

import static Contabilidad.datMayor.jFormattedTextField1;
import static Contabilidad.datMayor.jFormattedTextField2;
import static Contabilidad.menues.jDesktopPane1;
import Login.coneccionBD;
import Login.login;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import Login.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
/**
 *
 * @author BRANKO
 */
public class Diario extends javax.swing.JInternalFrame {

    /**
     * Creates new form Diario
     */
    public Diario() {
        initComponents();
        
        bd=new coneccionBD();
         try{
            String sql="select id,DATE_FORMAT(ult_impresion, '%d-%m-%Y')as ult_impresion,ult_tomo,ult_folio,ult_transporte_debe,ult_transporte_haber,ult_asiento,ult_registro from ultima_impresion";
            Statement miSt=bd.dameSentencia();
            ResultSet ult_imp=miSt.executeQuery(sql);
            ult_imp.next();
            jTextField1.setText(parsefecha(ult_imp.getString("ult_impresion")));
           // fecha_ult_diario=ult_imp.getString("ult_impresion");
            ult_debe=ult_imp.getString("ult_transporte_debe");
            ult_haber=ult_imp.getString("ult_transporte_haber");
            ult_tomo=ult_imp.getString("ult_tomo");
            ult_folio=ult_imp.getString("ult_folio");
                   
            }catch( Exception e ){
               JOptionPane.showMessageDialog(null, e);
            }
        
        jTextField1.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setClosable(true);

        jButton1.setText("VISTA PREVIA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha Hasta");

        jLabel3.setText("Fecha Ultimo Diario");

        jButton2.setText("IMPRIMIR LIBRO DIARIO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jTextField1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
        SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
        try{
         /* String inicio=diarioMayor.jTable3.getValueAt(1, 6).toString();
           String fin=diarioMayor.jTable3.getValueAt(1, 5).toString();
            System.out.println(inicio+" "+fin);
           Date dato1=sd.parse(inicio);
           Date dato2=sd.parse(fin);/*/
      
            Connection conect=bd.dameConexion();
            File fichero2 = new File("src/Reporte/ReporteLibroDiario.jasper");
            String ruta=fichero2.getAbsolutePath();
            String barra=File.separator;
            String dobleBarra=File.separator+File.separator;
            String rutaNueva=ruta.replace(barra,dobleBarra);
                                                                          
            JasperReport reporte=(JasperReport) JRLoader.loadObjectFromFile(rutaNueva);
            
            Map parametro = new HashMap();
           
            parametro.put("fecha_desde", jTextField1.getText());
            parametro.put("fecha_hasta", jFormattedTextField1.getText());
            parametro.put("ult_debe", Double.parseDouble(ult_debe));
            parametro.put("ult_haber", Double.parseDouble(ult_haber));
            parametro.put("ult_tomo", Integer.parseInt(ult_tomo));
            parametro.put("ult_folio", Integer.parseInt(ult_folio));
            parametro.put("empresa", login.nombreEmpresa);
            parametro.put("cuil", login.cuit);
            parametro.put("actividad", login.actividad);
            
            JasperPrint jprint=JasperFillManager.fillReport(reporte,parametro,conect);
            
            JasperViewer visor=new JasperViewer(jprint,false);
            
            visor.setVisible(true);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Imprimir2();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void Imprimir2(){                    
        /* Array para almacenar las impresoras del sistema */
         PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
         if( printService.length>0 )//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService)printService[0]; //JOptionPane.showInputDialog(null, "Eliga impresora:",
                  //   "Imprimir Reporte", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
             if( impresora != null ) //Si se selecciono una impresora
             {
                 try {
                    //esto para el JasperReport
                    JasperReport jasperReport;
                    JasperPrint jasperPrint;
                    //se carga el reporte
                    
                    Connection conect=bd.dameConexion();
            
                    File fichero2 = new File("src/Reporte/ReporteLibroDiario.jasper");
                    String ruta=fichero2.getAbsolutePath();
                    String barra=File.separator;
                    String dobleBarra=File.separator+File.separator;
                    String rutaNueva=ruta.replace(barra,dobleBarra);
                    
                     jasperReport=(JasperReport) JRLoader.loadObjectFromFile(rutaNueva);
                   /* URL in = this.getClass().getResource("src/Reporte/LibroDiario.jasper");
                    jasperReport = (JasperReport) JRLoader.loadObject(in);*/                    //se procesa el archivo jasper
                    
                     Map parametro = new HashMap();
                    parametro.put("fecha_desde", jTextField1.getText());
                    parametro.put("fecha_hasta", jFormattedTextField1.getText());
                    parametro.put("ult_debe", Double.parseDouble(ult_debe));
                    parametro.put("ult_haber", Double.parseDouble(ult_haber));
                    parametro.put("ult_tomo", Integer.parseInt(ult_tomo));
                    parametro.put("ult_folio", Integer.parseInt(ult_folio));
                    parametro.put("empresa", login.nombreEmpresa);
                    parametro.put("cuil", login.cuit);
                    parametro.put("actividad", login.actividad);
                    jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, conect);
                    //se manda a la impresora
                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint );
                   jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora );
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.exportReport();
                    int resp = JOptionPane.showConfirmDialog(null, "¿El Libro Diario se imprimio correctamente?", "Confirmar Impresion", JOptionPane.YES_NO_OPTION);
                    if(resp==JOptionPane.YES_OPTION){
                     //   ult_impresion.jTextField2.setText(jFormattedTextField1.getText());
                        ult_impresion na=new ult_impresion();
                        
                        menues.jDesktopPane1.add(na);
        
                        na.toFront();
                        na.setVisible(true);
                        centrar(na);
                        
                    }
                    
                 } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                 }
             }
        }
   }
    
    public void centrar (JInternalFrame interno){
        
        int x=(jDesktopPane1.getWidth()/2 - interno.getWidth()/2);
        int y=(jDesktopPane1.getHeight()/2 - interno.getHeight()/2);
        
        if(interno.isShowing()){
            interno.setLocation(x, y);
        }else{
            jDesktopPane1.add(interno);
            interno.setLocation(x, y);
            interno.show();
        }
    }
    
    public String parsefecha(String fecha_ap){
        
        String fecha_ult_imp="";
                           
        try {    
            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat parseador = new SimpleDateFormat("dd-MM-yyyy");
            Date fechanueva = new Date();
                                
            fechanueva = formatoDeFecha.parse(fecha_ap);
            Calendar cal = Calendar.getInstance(); 
            cal.setTime(fechanueva); 
            cal.add(Calendar.DATE, +1);
            fechanueva= cal.getTime();

                     //  Date fechanueva2 = parseador.parse(fechanueva);
            fecha_ult_imp=formatoDeFecha.format(fechanueva);

        } catch (Exception ex) {

            ex.printStackTrace();

        }
      return fecha_ult_imp;
                            
    }
    
     public Date sumarRestarDiasFecha(Date fecha, int dias){
	
      Calendar calendar = Calendar.getInstance();
	
      calendar.setTime(fecha); // Configuramos la fecha que se recibe
	
      calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
	
      return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
	
     }
    
    private String ordFecha;
    private coneccionBD bd, conn;
    private String fecha_ult_diario,ult_debe,ult_haber,ult_tomo,ult_folio;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}