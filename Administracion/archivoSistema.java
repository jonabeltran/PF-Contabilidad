/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import Comunes.coneccionComun;
import Comunes.metodosComunes;
import Login.*;
import java.awt.event.*;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.util.*;
import Reporte.*;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.io.File;
import net.sf.jasperreports.engine.JRException;
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
public class archivoSistema extends javax.swing.JPanel {

    /**
     * Creates new form nuevoUsuario
     */
    public archivoSistema() {
        initComponents();
         metodos=new metodosTabla();
         
         metodos1=new metodos_login();
         
         mod=metodos.dameModelo("pago");
        
        jTable1.setModel(mod);
        
         mod2=metodos.dameModelo("articulos");
        
        jTable2.setModel(mod2);
        
        jTextField7.setEnabled(false);
        
        jTextField8.setEnabled(false);
        
        misComunes=new metodosComunes();
        
        //ejecuto permisos
        
        try{
               
                 
                
                    ResultSet permisos=metodos1.registroTabla2("permisos","id_perfil",login.idperfil);
                           
                             while (permisos.next()) {
                                int id_mod= permisos.getInt("id_modulo");
                                int alta= permisos.getByte("alta");
                                int baja= permisos.getByte("baja");
                                int mod=permisos.getByte("modif");
                                int consulta=permisos.getByte("consulta");
                                int listado=permisos.getByte("listado");
                                ResultSet modulo=metodos1.registroTabla2("modulos","id_modulo",id_mod);
                                 
                                 while (modulo.next()) {
                                    String nombremod= modulo.getString("nombre");
                                    switch(nombremod)
                                        {

                                            case "formaspago":
                                                if(alta ==0){
                                                    jButton1.setEnabled(false);
                                                }
                                                
                                                if(baja== 0){
                                                    jButton2.setEnabled(false);
                                                }
                                                if(mod== 0){
                                                    jButton3.setEnabled(false);
                                                }
                                                if(consulta== 0){
                                                    jButton4.setEnabled(false);
                                                }
                                                  if(listado== 0){
                                                    //faltan botones
                                                    jButton11.setEnabled(false);
                                                    }
                                            
                                            break; 

                                            case "stock": 
                                                    if(alta ==0){
                                                    jButton5.setEnabled(false);
                                                    }
                                                    if(baja== 0){
                                                    jButton6.setEnabled(false);
                                                    }
                                                    if(mod== 0){
                                                    jButton7.setEnabled(false);
                                                    }
                                                    if(consulta== 0){
                                                    jButton8.setEnabled(false);
                                                    }
                                                    if(listado== 0){
                                                    jButton10.setEnabled(false);
                                                    }
                                                  
                                             
                                            break;

                                            default: 

                                            break;

                                        }

                                  }
                            
                         }  
                             
                             
                      }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(810, 386));

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 437));

        jLabel4.setText("Id Articulo");

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jLabel5.setText("Descripcion");

        jLabel6.setText("Tipo Tasa IVA");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "21%", "27%", "10.5%" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Clave de Pago");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        jButton5.setText("Alta");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Baja");
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Modificar");
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Consultar");
        jButton8.setFocusable(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField7.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField8.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jTable2 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int ColIndex){
                return false;
            }
        };
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setFocusable(false);
        jTable2.getTableHeader().setResizingAllowed(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        jButton10.setText("Guardar");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.setDisabledIcon(null);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setIconTextGap(2);
        jButton10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 776, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField8)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton7)
                                    .addComponent(jButton8))
                                .addGap(0, 334, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jButton10)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton8))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Articulos de Stock", jPanel2);

        jPanel3.setPreferredSize(new java.awt.Dimension(1000, 437));

        jLabel1.setText("Clave");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel2.setText("Descripcion");

        jLabel3.setText("Siglas");

        jButton1.setText("Alta");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Baja");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Modificar");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Consultar");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        jButton11.setText("Guardar");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.setDisabledIcon(null);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setIconTextGap(2);
        jButton11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2)
                                .addGap(178, 178, 178)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(64, 64, 64))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton11)
                .addGap(0, 214, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton1))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton2))))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButton11)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Formas de Pago", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:

        char caracter=evt.getKeyChar();

        if (caracter<'0' || caracter>'9' || jTextField4.getText().length()>=2) {
            evt.consume();

        }

    }//GEN-LAST:event_jTextField4KeyTyped

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

        String seleccion=jComboBox1.getSelectedItem().toString();

        switch(seleccion){
            case "21%":jTextField7.setText("Tasa General");
            break;
            case "27%":jTextField7.setText("Tasa Diferencial");
            break;
            case "10.5%":jTextField7.setText("Tasa Especial");
            break;
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        // TODO add your handling code here:

        if(evt.getKeyCode()==KeyEvent.VK_F1 || evt.getKeyCode()==KeyEvent.VK_A){      //KeyEvent.VK_F1){

            Ventana_F1 miVentana=new Ventana_F1();

            miVentana.setVisible(true);

        }
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:

        if (jTextField6.getText().length()==2){

            metodos=new metodosTabla();

            boolean encontre=metodos.Buscar(jTextField6.getText(), "pago");

            if (encontre==false){

                JOptionPane.showMessageDialog(null, "Esta clave es INCORRECTA");

                jTextField6.setText("");
                jTextField8.setText("");

                Ventana_F1 miVentana=new Ventana_F1();

                miVentana.setVisible(true);

            }else{

                String dato=metodos.dameDescripcion(jTextField6.getText());

                jTextField8.setText(dato);

            }

        }

    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        // TODO add your handling code here:

        char caracter=evt.getKeyChar();

        if (caracter<'0' || caracter>'9' || jTextField6.getText().length()>=2) {
            evt.consume();

        }

    }//GEN-LAST:event_jTextField6KeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        metodos=new metodosTabla();

        boolean existe=metodos.repetido(jTextField4.getText(), "articulos");

        if(existe==true){

            JOptionPane.showMessageDialog(null, "el codigo ya existe");

        }else if(jTextField5.getText().equals("") || jTextField6.getText().equals("") ){

            JOptionPane.showMessageDialog(null, "Existen campos vacios");

        }
        else{

            instruccionSQL="insert into articulos_de_stock values('"+jTextField4.getText()+"','"+jTextField5.getText()+"','"+jTextField7.getText()+"','"+jTextField6.getText()+"')";

            miConexion=new coneccionBD();

            miSentencia=miConexion.dameSentencia();

            try{

                miSentencia.executeUpdate(instruccionSQL);

            }catch(Exception e){

                e.printStackTrace();

            }

            String fila[]={jTextField4.getText(),jTextField5.getText(),jTextField7.getText(),jTextField6.getText()};

            int valorFila=metodos.dameNumFila(jTextField4.getText(), "articulos");

            mod2.insertRow(valorFila, fila);

            jTable2.changeSelection(valorFila, 0, false, false);
            
            metodosAuditoria audicion=new metodosAuditoria();
        
            audicion.ingresarAuditoria("Alta", jTextField4.getText(), jTextField5.getText(),jTextField7.getText(),jTextField6.getText());
            
            misComunes.insertar_en_uso(jTextField6.getText(), jTextField8.getText());
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

        if(jTextField4.getText().equals("") ){

            JOptionPane.showMessageDialog(null, "Existen campos vacios. Debes Seleccionarlo en la Tabla");

        }else{

            boolean encontre=metodos.Buscar(jTextField4.getText(), "articulos");

            if(encontre==true){

                int rta=JOptionPane.showConfirmDialog(null, "Estas seguro ?", "eliminar", JOptionPane.YES_NO_OPTION);

                if(rta==0){

                    String[]tabla=metodos.dameDatos(jTextField4.getText(), "articulos");
        
                    metodosAuditoria audicion=new metodosAuditoria();
                    
                   audicion.ingresarAuditoria("Baja",  tabla[0], tabla[1],tabla[2],tabla[3]);
                    
                    
                    int indice=metodos.dameNumFila(jTextField4.getText(), "articulos");

                    miConexion=new coneccionBD();

                    instruccionSQL="delete from articulos_de_stock where id="+jTextField4.getText();

                    miSentencia=miConexion.dameSentencia();

                    try{

                        miSentencia.executeUpdate(instruccionSQL);

                    }catch(Exception e){

                    }

                    mod2.removeRow(indice);

                    jTextField4.setText("");
                    jTextField5.setText("");
                    jTextField6.setText("");
                    jTextField8.setText("");
                }

            }else{
                JOptionPane.showMessageDialog(null, "la clave no existe");
                jTextField4.setText("");

            }

        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:

        if(jTextField4.getText().equals("") ||jTextField5.getText().equals("") || jTextField6.getText().equals("") ) {

            JOptionPane.showMessageDialog(null, "existen campo vacios");

        }else {

            boolean encontre=metodos.Buscar(jTextField4.getText(), "articulos");

            if(encontre==true){

                String[]tabla=metodos.dameDatos(jTextField4.getText(), "articulos");
                
                if(tabla[0].equals(jTextField4.getText()) && tabla[1].equals(jTextField5.getText()) && tabla[2].equals(jTextField7.getText()) && tabla[3].equals(jTextField6.getText())){
                    JOptionPane.showMessageDialog(null, "No se realizo ningun cambio");
                }else{
                    metodosAuditoria audicion=new metodosAuditoria();
                     
                    audicion.ingresarAuditoria("Modificar viejo", tabla[0], tabla[1],tabla[2],tabla[3]);
                    audicion.ingresarAuditoria("Modificar nuevo", jTextField4.getText(), jTextField5.getText(),jTextField7.getText(),jTextField6.getText());
               
                
                
                miConexion=new coneccionBD();

                instruccionSQL="UPDATE articulos_de_stock SET descripcion='"+jTextField5.getText()+"', tipo_tasa_iva='"+jTextField7.getText()+"',clave='"+jTextField6.getText()+"' WHERE id="+jTextField4.getText();

                miSentencia=miConexion.dameSentencia();

                try{

                    miSentencia.executeUpdate(instruccionSQL);

                }catch(Exception e){

                }

                int indice=metodos.dameNumFila(jTextField4.getText(), "articulos");

                jTable2.setValueAt(jTextField5.getText(), indice, 1);

                jTable2.setValueAt(jTextField7.getText(), indice, 2);

                jTable2.setValueAt(jTextField6.getText(), indice, 3);

                jTable2.changeSelection(indice, 0, false, false);
                }
            }else{
                JOptionPane.showMessageDialog(null, "existen campo vacios");
                jTextField4.setText("");

            }

        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

        boolean esta=metodos.Buscar(jTextField4.getText(), "articulos");

        if(esta==true){

            String [] miVector=metodos.dameDatos(jTextField4.getText(), "articulos");

            for(int i=0;i<4;i++){

                switch(i){

                    case 0: jTextField4.setText(miVector[i]);
                    break;
                    case 1: jTextField5.setText(miVector[i]);
                    break;
                    case 2: switch(miVector[i]){
                        case "Tasa General": jComboBox1.setSelectedItem("21%");
                        break;
                        case "Tasa Diferencial": jComboBox1.setSelectedItem("27%");
                        break;
                        case "Tasa Especial": jComboBox1.setSelectedItem("10.5%");
                        break;
                    }
                    break;
                    case 3: jTextField6.setText(miVector[i]);
                    String dato=metodos.dameDescripcion(jTextField6.getText());
                    jTextField8.setText(dato);
                    break;
                }

            }

            int fila=metodos.dameNumFila(jTextField4.getText(), "articulos");

            jTable2.changeSelection(fila, 0, false, false);

        }else{

            JOptionPane.showMessageDialog(null, "Valor incorrecto");

        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:

        int indice=jTable2.getSelectedRow();

        jTextField4.setText(jTable2.getValueAt(indice, 0).toString());

        jTextField5.setText(jTable2.getValueAt(indice, 1).toString());

        // jTextField3.setText(jTable1.getValueAt(indice, 2).toString());
        switch(jTable2.getValueAt(indice, 2).toString()){
            case "Tasa General": jComboBox1.setSelectedItem("21%");
            break;
            case "Tasa Diferencial": jComboBox1.setSelectedItem("27%");
            break;
            case "Tasa Especial": jComboBox1.setSelectedItem("10.5%");
            break;

        }

        jTextField6.setText(jTable2.getValueAt(indice, 3).toString());

        String descripcion=metodos.dameDescripcion(jTable2.getValueAt(indice, 3).toString());
        jTextField8.setText(descripcion);

    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        // TODO add your handling code here:

    /*    if(evt.getKeyCode()==38){

            int indice=jTable2.getSelectedRow();

            if(indice>=1){

                jTextField4.setText(jTable2.getValueAt(indice-1, 0).toString());

                jTextField5.setText(jTable2.getValueAt(indice-1, 1).toString());

                // jTextField3.setText(jTable1.getValueAt(indice-1, 2).toString());
                switch(jTable2.getValueAt(indice-1, 2).toString()){
                    case "Tasa General": jComboBox1.setSelectedItem("21%");
                    break;
                    case "Tasa Diferencial": jComboBox1.setSelectedItem("27%");
                    break;
                    case "Tasa Especial": jComboBox1.setSelectedItem("10.5%");
                    break;

                }

                jTextField6.setText(jTable2.getValueAt(indice-1, 3).toString());

                String descripcion=metodos.dameDescripcion(jTable2.getValueAt(indice-1, 3).toString());
                jTextField8.setText(descripcion);

            }

        }else if(evt.getKeyCode()==40){

            int indice=jTable2.getSelectedRow();

            if(indice<mod2.getRowCount()-1){

                jTextField4.setText(jTable2.getValueAt(indice+1, 0).toString());

                jTextField5.setText(jTable2.getValueAt(indice+1, 1).toString());

                // jTextField3.setText(jTable1.getValueAt(indice-1, 2).toString());
                switch(jTable2.getValueAt(indice+1, 2).toString()){
                    case "Tasa General": jComboBox1.setSelectedItem("21%");
                    break;
                    case "Tasa Diferencial": jComboBox1.setSelectedItem("27%");
                    break;
                    case "Tasa Especial": jComboBox1.setSelectedItem("10.5%");
                    break;

                }

                jTextField6.setText(jTable2.getValueAt(indice+1, 3).toString());

                String descripcion=metodos.dameDescripcion(jTable2.getValueAt(indice+1, 3).toString());
                jTextField8.setText(descripcion);

            }

        }*/

    }//GEN-LAST:event_jTable2KeyPressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:

        char caracter=evt.getKeyChar();

        if (caracter<'0' || caracter>'9' || jTextField1.getText().length()>=2) {
            evt.consume();

            //  JOptionPane.showMessageDialog(null, "solo puedes ingresar numeros de dos caracteres");
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        metodos=new metodosTabla();

        boolean existe=metodos.repetido(jTextField1.getText(), "pago");

        if(existe==true){

            JOptionPane.showMessageDialog(null, "el codigo ya existe");

        }else if(jTextField1.getText().equals("") || jTextField2.getText().equals("") || jTextField3.getText().equals("")){

            JOptionPane.showMessageDialog(null, "Existen campos vacios");

        }

        else if(jTextField1.getText().length()==2){

            instruccionSQL="insert into formas_de_pago values('"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField3.getText()+"')";

            coneccionComun miConexion=new coneccionComun();

            miSentencia=miConexion.dameSentencia();

            try{

                miSentencia.executeUpdate(instruccionSQL);

            }catch(Exception e){

                e.printStackTrace();

            }

            String fila[]={jTextField1.getText(),jTextField2.getText(),jTextField3.getText()};

            int valorFila=metodos.dameNumFila(jTextField1.getText(), "pago");

            mod.insertRow(valorFila, fila);
            
            
            metodosAuditoria audicion=new metodosAuditoria();
            
           audicion.ingresarAuditoriaPAgo("Alta", jTextField1.getText(),jTextField2.getText(),jTextField3.getText());
           

        }else{
            JOptionPane.showMessageDialog(null, "la clave debe tener dos caracteres");

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        if(jTextField1.getText().equals("") ){

            JOptionPane.showMessageDialog(null, "Existen campos vacios. Debes Seleccionarlo en la Tabla");

        }else{

            boolean encontre=metodos.Buscar(jTextField1.getText(), "pago");

            if(encontre==true){

                //  metodos=new metodosTabla();

               // boolean dependeArticulo=metodos.BuscarDepende(jTextField1.getText(), "articulos");

                boolean dependeArticulo=misComunes.depende(jTextField1.getText());
                if(dependeArticulo==true){

                    JOptionPane.showMessageDialog(null, "Lo lamento. No puede eliminar esta de Pago. Proque depende de un Articulo");

                }else{

                    int rta=JOptionPane.showConfirmDialog(null, "Estas seguro que deseas eliminarlo ?", "Eliminar", JOptionPane.YES_NO_OPTION);

                    if(rta==0){

                        String[]tabla=metodos.dameDatos(jTextField1.getText(), "pago");
        
                        metodosAuditoria audicion=new metodosAuditoria();
                    
                        audicion.ingresarAuditoriaPAgo("Baja", tabla[0],tabla[1],tabla[2] );
                        
                        
                        
                        int indice=metodos.dameNumFila(jTextField1.getText(), "pago");

                        miConexion=new coneccionBD();

                        instruccionSQL="delete from formas_de_pago where clave='"+jTextField1.getText()+"'";

                        miSentencia=miConexion.dameSentencia();

                        try{

                            miSentencia.executeUpdate(instruccionSQL);

                        }catch(Exception e){

                        }

                        mod.removeRow(indice);

                        jTextField1.setText("");
                        jTextField2.setText("");
                        jTextField3.setText("");
                    }
                }

            }else{
                JOptionPane.showMessageDialog(null, "La clave no existe");

            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        if(jTextField1.getText().equals("") ||jTextField2.getText().equals("") || jTextField3.getText().equals("") ) {

            JOptionPane.showMessageDialog(null, "existen campo vacios");

        }else {

            boolean encontre=metodos.Buscar(jTextField1.getText(), "pago");

            if (encontre==true){

                String[]tabla=metodos.dameDatos(jTextField1.getText(), "pago");
                
                if(tabla[0].equals(jTextField1.getText()) && tabla[1].equals(jTextField2.getText()) && tabla[2].equals(jTextField3.getText())){
                  JOptionPane.showMessageDialog(null, "no se realizo ningun cambio");  
                }else{
        
                metodosAuditoria audicion=new metodosAuditoria();
                    
               audicion.ingresarAuditoriaPAgo("Modificar viejo",  tabla[0], tabla[1],tabla[2]);
                audicion.ingresarAuditoriaPAgo("Modificar nuevo", jTextField1.getText(),jTextField2.getText(),jTextField3.getText());
                
                
                miConexion=new coneccionBD();

                instruccionSQL="UPDATE formas_de_pago SET descripcion='"+jTextField2.getText()+"', sigla='"+jTextField3.getText()+"' WHERE clave='"+jTextField1.getText()+"'";

                miSentencia=miConexion.dameSentencia();

                try{

                    miSentencia.executeUpdate(instruccionSQL);

                }catch(Exception e){

                }

                int indice=metodos.dameNumFila(jTextField1.getText(), "pago");

                jTable1.setValueAt(jTextField2.getText(), indice, 1);

                jTable1.setValueAt(jTextField3.getText(), indice, 2);

                jTable1.changeSelection(indice, 0, false, false);
                }
            }else{
                JOptionPane.showMessageDialog(null, "no existe la clave");

                jTextField1.setText("");

            }

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        boolean esta=metodos.Buscar(jTextField1.getText(), "pago");

        if(esta==true){

            String [] miVector=metodos.dameDatos(jTextField1.getText(), "pago");

            for(int i=0;i<3;i++){

                switch(i){

                    case 0: jTextField1.setText(miVector[i]);
                    break;
                    case 1: jTextField2.setText(miVector[i]);
                    break;
                    case 2: jTextField3.setText(miVector[i]);
                    break;

                }

            }

            int fila=metodos.dameNumFila(jTextField1.getText(), "pago");

            jTable1.changeSelection(fila, 0, false, false);

        }else{

            JOptionPane.showMessageDialog(null, "Valor incorrecto");

        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int indice=jTable1.getSelectedRow();

        jTextField1.setText(jTable1.getValueAt(indice, 0).toString());

        jTextField2.setText(jTable1.getValueAt(indice, 1).toString());

        jTextField3.setText(jTable1.getValueAt(indice, 2).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:

        if(evt.getKeyCode()==38){

            int indice=jTable1.getSelectedRow();

            if(indice>=1){

                jTextField1.setText(jTable1.getValueAt(indice-1, 0).toString());

                jTextField2.setText(jTable1.getValueAt(indice-1, 1).toString());

                jTextField3.setText(jTable1.getValueAt(indice-1, 2).toString());

            }

        }else if(evt.getKeyCode()==40){

            int indice=jTable1.getSelectedRow();

            if(indice<mod.getRowCount()-1){

                jTextField1.setText(jTable1.getValueAt(indice+1, 0).toString());

                jTextField2.setText(jTable1.getValueAt(indice+1, 1).toString());

                jTextField3.setText(jTable1.getValueAt(indice+1, 2).toString());

            }

        }

    }//GEN-LAST:event_jTable1KeyPressed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        
        ArrayList lista=new ArrayList();
        
        for(int i=0;i<jTable2.getRowCount();i++){
            
            ListaArticulos misArticulos=new ListaArticulos(jTable2.getValueAt(i, 0).toString(),jTable2.getValueAt(i, 1).toString(),jTable2.getValueAt(i, 2).toString(),jTable2.getValueAt(i, 3).toString());
            
            lista.add(misArticulos);
            
        }
        
        try {
            File fichero = new File("src/Reporte/ReporteArticulos.jasper");
            String ruta=fichero.getAbsolutePath();
            String barra=File.separator;
            String dobleBarra=File.separator+File.separator;
            String rutaNueva=ruta.replace(barra,dobleBarra);
                                                                          
            JasperReport reporte=(JasperReport) JRLoader.loadObjectFromFile(rutaNueva);
            
            Map parametro = new HashMap();
            
            JasperPrint jprint=JasperFillManager.fillReport(reporte,parametro,new JRBeanCollectionDataSource(lista));
            
            //JasperViewer.viewReport(jprint);
            
            JasperViewer visor=new JasperViewer(jprint,false);
            
            visor.setVisible(true);
            
          //  visor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            
        } catch (JRException ex) {
            Logger.getLogger(archivoSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        ArrayList lista=new ArrayList();
        
        for(int i=0;i<jTable1.getRowCount();i++){
            
            ListaPagos misArticulos=new ListaPagos(jTable1.getValueAt(i, 0).toString(),jTable1.getValueAt(i, 1).toString(),jTable1.getValueAt(i, 2).toString());
            
            lista.add(misArticulos);
            
        }
        
        try {
            File fichero = new File("src/Reporte/ReportePagos.jasper");
            String ruta=fichero.getAbsolutePath();
            String barra=File.separator;
            String dobleBarra=File.separator+File.separator;
            String rutaNueva=ruta.replace(barra,dobleBarra);
                                                                          
            JasperReport reporte=(JasperReport) JRLoader.loadObjectFromFile(rutaNueva);
            
            Map parametro = new HashMap();
            
            JasperPrint jprint=JasperFillManager.fillReport(reporte,parametro,new JRBeanCollectionDataSource(lista));
            
            //JasperViewer.viewReport(jprint);
            
            JasperViewer visor=new JasperViewer(jprint,false);
            
            visor.setVisible(true);
            
          //  visor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            
        } catch (JRException ex) {
            Logger.getLogger(archivoSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton11ActionPerformed

public metodosComunes misComunes;
      public metodosTabla metodos;
    private String instruccionSQL;
    private Statement miSentencia;
    public DefaultTableModel mod,mod2;
    private coneccionBD miConexion; 
    public String clavGlob;
    public metodos_login metodos1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    public static javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public static javax.swing.JButton jButton5;
    public static javax.swing.JButton jButton6;
    public static javax.swing.JButton jButton7;
    public static javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    public static javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    public static javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
