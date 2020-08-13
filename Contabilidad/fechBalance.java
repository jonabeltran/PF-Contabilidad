/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contabilidad;

import static Contabilidad.menues.jDesktopPane1;
import Login.coneccionBD;
import Login.login;
import Reporte.*;
import java.io.*;
import java.io.FileReader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jonathan
 */
public class fechBalance extends javax.swing.JInternalFrame {

    /**
     * Creates new form fechBalance
     */
    public fechBalance() {
        initComponents(); 
        
        bd=new coneccionBD();
        acum1=0;
        acum2=0;
        acum3=0;
        acum4=0;
        acum5=0;
        padreNivel="";
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
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);

        jButton1.setText("OK");
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

        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("Fecha Desde");

        jLabel2.setText("Fecha Hasta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField2))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
        try{
           String inicio=diarioMayor.jTable3.getValueAt(1, 6).toString();
           String fin=diarioMayor.jTable3.getValueAt(1, 5).toString(); 
           Date dato1=sd.parse(inicio);
           Date dato2=sd.parse(fin);
           Date dato3=sd.parse(jFormattedTextField1.getText());
           Date dato4=sd.parse(jFormattedTextField2.getText());
           if(((dato1.before(dato3) || dato1.equals(dato3)) && (dato2.after(dato3) || dato2.equals(dato3)))&&
                 ((dato1.before(dato4) || dato1.equals(dato4)) && (dato2.after(dato4) || dato2.equals(dato4)))  ){
               //-----------------Cargo la columna Saldo Inicial-------------
               String cargaInicial="SELECT nro_cuenta FROM plan_cuentas where imputa='1'";
               Statement stInicial=bd.dameSentencia();
               ResultSet rtInicial=stInicial.executeQuery(cargaInicial);
               try{
                   while(rtInicial.next()){
                       sinicial=dameSaldoAnterior(rtInicial.getString("nro_cuenta")); 
                       modificaInicial="update balanza_auxuliar set saldo_inicial='"+String.valueOf(sinicial)+"' where nro_cuenta='"+rtInicial.getString("nro_cuenta")+"'";
                       rsModIni=bd.dameSentencia();
                       rsModIni.executeUpdate(modificaInicial);
                       rsModIni.close();
                   }
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null, e);
               }
               
               //---------Cargo las Columnas Debito, Credito y Acumulado-----------
               String filtro="SELECT nro_cuenta,SUM(importe_debe)as debito, SUM(importe_haber) as credito,SUM(importe_debe-importe_haber)as acumulado"
                       + " FROM diario_mayor "+
                       "where fecha_contable BETWEEN STR_TO_DATE('"+jFormattedTextField1.getText()+"','%d-%m-%Y') and STR_TO_DATE('"+jFormattedTextField2.getText()+"','%d-%m-%Y') GROUP BY nro_cuenta";
               Statement st=bd.dameSentencia();
               ResultSet rt=st.executeQuery(filtro);
               try{
                   while(rt.next()){
                     modificabalance="update balanza_auxuliar set debito='"+rt.getString("debito")+"',"
                             + "credito='"+rt.getString("credito")+"', acumulado='"+rt.getString("acumulado")+"'"
                             + "where nro_cuenta='"+rt.getString("nro_cuenta")+"'";
                     statebalance=bd.dameSentencia();
                     statebalance.executeUpdate(modificabalance);
                     statebalance.close();
                   }
                   
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null, e);
               }
               
               //---------Cargo la columna de Cierre-------------
               String cierre="UPDATE balanza_auxuliar SET cierre=saldo_inicial+acumulado";
               Statement stCierre=bd.dameSentencia();
               try{
                   stCierre.executeUpdate(cierre);
                   stCierre.close();
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null, e);
               }
            int n=dameMaximo();
            acumulando(n);
            jasper();
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jasper(){
        try{
         Connection conect=bd.dameConexion();
            File fichero2 = new File("src/Reporte/ReporteBalance.jasper");
            String ruta=fichero2.getAbsolutePath();
            String barra=File.separator;
            String dobleBarra=File.separator+File.separator;
            String rutaNueva=ruta.replace(barra,dobleBarra);
                                                                          
            JasperReport reporte=(JasperReport) JRLoader.loadObjectFromFile(rutaNueva);
            
            Map parametro = new HashMap();
            //
            parametro.put("fecha_desde", jFormattedTextField1.getText());
            parametro.put("fecha_hasta", jFormattedTextField2.getText());
            parametro.put("empresa", login.nombreEmpresa);
            parametro.put("cuil", login.cuit);
            parametro.put("actividad", login.actividad);
            
            JasperPrint jprint=JasperFillManager.fillReport(reporte,parametro,conect);
            
            JasperViewer visor=new JasperViewer(jprint,false);
            
            visor.setVisible(true);
        }catch(Exception e){
            
        }
    }
    
    private int dameMaximo(){
        String maximoNivel="SELECT MAX(nivel)as maximo FROM balanza_auxuliar";
        Statement stMax=bd.dameSentencia();
        maxNivel=0;
        try{
            ResultSet rtMax=stMax.executeQuery(maximoNivel);
            rtMax.beforeFirst();
            rtMax.next();
            maxNivel=Integer.parseInt(rtMax.getString("maximo"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return maxNivel;
    }
    
    private void acumulando(int nivel){
      while(nivel>1){
        String dameReves="select * from balanza_auxuliar order by codigo_cta desc";
        Statement stReves=bd.dameSentencia();
        try{
            ResultSet rtReves=stReves.executeQuery(dameReves);
            while(rtReves.next()){
                if(Integer.parseInt(rtReves.getString("nivel"))==nivel){
                    acum1=acum1+Double.parseDouble(rtReves.getString("saldo_inicial"));
                    acum2=acum2+Double.parseDouble(rtReves.getString("debito"));
                    acum3=acum3+Double.parseDouble(rtReves.getString("credito"));
                    acum4=acum4+Double.parseDouble(rtReves.getString("acumulado"));
                    acum5=acum5+Double.parseDouble(rtReves.getString("cierre"));
                    padreNivel=busco_padre(rtReves.getString("codigo_cta"));
                }else if(rtReves.getString("codigo_cta").equals(padreNivel)){
                    modificaAux="update balanza_auxuliar set saldo_inicial='"+acum1+"', debito='"+acum2+"', credito='"+acum3+"', acumulado='"+acum4+"', cierre='"+acum5+"'"
                            + " where nro_cuenta='"+rtReves.getString("nro_cuenta")+"'";
                    stateAux=bd.dameSentencia();
                    stateAux.executeUpdate(modificaAux);
                    stateAux.close();
                    acum1=0;
                    acum2=0;
                    acum3=0;
                    acum4=0;
                    acum5=0;
                }
            }
            stReves.close();
            rtReves.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        nivel=nivel-1;
      }
    }
    
    private double dameSaldoAnterior(String cuenta){
        
     consultaAnt="select SUM(importe_debe-importe_haber)as inicial from diario_mayor where nro_cuenta='"+cuenta+"' and fecha_contable< STR_TO_DATE('"+jFormattedTextField1.getText()+"','%d-%m-%Y')";
        sini=0;
        try{
           state1=bd.dameSentencia();
           r1=state1.executeQuery(consultaAnt);
          // r1.beforeFirst();
           r1.next();
           sini=Double.parseDouble(r1.getString("inicial"));
           state1.close();
           r1.close();
           
        }catch(Exception e){
        //   JOptionPane.showMessageDialog(null,"error : "+ e.getMessage());
        }
        return sini;
    }
      
    private String busco_padre(String cuenta){
            String delimiter = "\\.";
            String[] temp;
            temp = cuenta.split(delimiter);
            String padre=null;


            for(int i =0; i < temp.length-1 ; i++){
                if(i==0){
                    padre=temp[i];
                }else{
                    padre=padre+"."+temp[i];
                }

            }
            return padre;
    }
    

    public static String nom_empresa;
    private int maxNivel;
    private int indice;
    private double[]d_h;
    private coneccionBD bd;
    private ResultSet r1,r2,resultbalance;
    private Statement state1,state2,statebalance,stateAux,rsModIni;
    private String cta,consultaAnt,consultaDB,modificabalance,modificaAux,modificaInicial;
    private String v1,v2,v3,v4,v5,v6,v7,v8,padreNivel;
    private double sinicial,debe,haber,sacum,scierre,sini,dini,hini,acum1,acum2,acum3,acum4,acum5;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}