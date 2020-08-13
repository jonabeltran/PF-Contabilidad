/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan
 */
public class coneccionBD {
    
    public static String BD;
     private String driver="com.mysql.jdbc.Driver";
     public String con="jdbc:mysql://localhost/"+BD;
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
      public ResultSet listar_cuentas(String tabla){
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(con,user,pass);
            Statement miStatement=conn.createStatement();
			
	    rs1=miStatement.executeQuery("select * from "+tabla+" ORDER BY codigo_cta");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+e.getMessage());
        }
        return rs1;
    }
      
    public Connection dameConexion(){
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(con,user,pass);
           
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+e.getMessage());
        }
        return conn;
    }
      
      public boolean insertar(String tabla, String campos,String valores){
         boolean res=false;
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(con,user,pass);
            Statement miStatement=conn.createStatement();
            String st="INSERT INTO "+tabla+" ("+campos+") VALUES("+valores+");";
             miStatement.executeUpdate(st);
             
                
            miStatement.close();
             res=true;
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+e.getMessage());
        }
        return res;
       
    }
      
     public boolean actualizaRegistro( String valor, String id , String tabla, String campoid){
         boolean res = false;
        String q = " UPDATE "+tabla+" SET " + valor + " WHERE "+campoid+"= '" + id+"'";
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(con,user,pass);
            Statement st = conn.createStatement();
            st.executeUpdate(q);
            st.close();
            res=true;
         }catch(Exception e){
            System.out.println(e);
        }
        return res;
    }
     
    public int insertar2(String tabla, String campos,String valores){
         int res=0;
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(con,user,pass);
            Statement miStatement=conn.createStatement();
            String st="INSERT INTO "+tabla+" ("+campos+") VALUES("+valores+");";
             miStatement.executeUpdate(st, Statement.RETURN_GENERATED_KEYS);
             ResultSet rs = miStatement.getGeneratedKeys();
             
                if (rs.next()){
                    res=rs.getInt(1);
                }
                
            miStatement.close();
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+e.getMessage());
        }
        return res;
       
    }
    
    public boolean eliminaRegistro(String tabla,String id, String campoid){
        boolean res = false;
        String q = "Delete from "+ tabla+" WHERE "+campoid+" = " +Integer.valueOf(id)+"";
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(con,user,pass);
            Statement st = conn.createStatement();
            st.executeUpdate(q);
            st.close();
            res=true;
         }catch(Exception e){
            System.out.println(e);
        }
        return res;
   }
     public boolean eliminaRegistro2(String tabla,String id, String campoid){
        boolean res = false;
        String q = "Delete from "+ tabla+" WHERE "+campoid+" = '" + id+"'";
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(con,user,pass);
            Statement st = conn.createStatement();
            st.executeUpdate(q);
            st.close();
            res=true;
         }catch(Exception e){
            System.out.println(e);
        }
        return res;
   }
    
     public ResultSet registroTabla(String tabla,String campoid,int id){
        try{
           
           Connection miConexion=DriverManager.getConnection(con,user,pass);
            Statement miStatement=miConexion.createStatement();
			
		rs1=miStatement.executeQuery("select * from "+tabla+" where "+campoid+"="+id);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+e.getMessage());
        }
        return rs1;
    }
     public ResultSet registroTabla2(String tabla,String campoid,String id){
        try{
           
           Connection miConexion=DriverManager.getConnection(con,user,pass);
            Statement miStatement=miConexion.createStatement();
			
		rs1=miStatement.executeQuery("select * from "+tabla+" where "+campoid+"= '"+id+"'");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+e.getMessage());
        }
        return rs1;
    }
     
      public ResultSet registroTablaconFiltro(String tabla,String filtro){
        try{
           
           Connection miConexion=DriverManager.getConnection(con,user,pass);
            Statement miStatement=miConexion.createStatement();
			
		rs1=miStatement.executeQuery("select * from "+tabla+" "+filtro);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+e.getMessage());
        }
        return rs1;
    }
      
       public boolean elimina_perfil(String idd){
        boolean res = false;
        int cant=0;
        
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(con,user,pass);
            Statement st = conn.createStatement();
            rs1=st.executeQuery( "Select * from usuarios WHERE usu_perfil= " + idd);
            if (rs1.last()){
            cant = rs1.getRow();
            } else {
            cant = 0;
            }
            if (cant > 0){
              res=true;  
            }
            
         }catch(Exception e){
            System.out.println(e);
        }
       if (res != true){
            String q = "Delete from perfiles WHERE id_perfil= " + idd;
                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate(q);
                    st.close();
                   // res=true;
                 }catch(SQLException e){
                    System.out.println(e);
                }
            
       }
       return !res;
   }
        public void crearBD(String base){
            try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();
                    String query="CREATE DATABASE IF NOT EXISTS "+base;
                    miStatement.executeUpdate(query);

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
      
        }
         public void borrarBD(String base){
            try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    rs1=miStatement.executeQuery("DROP DATABASE "+base);

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
      
        }
         public ResultSet Dame_Conector_usuarios(){
		
		try{
			
			Connection miConexion=DriverManager.getConnection(con,user,pass);
			
			Statement miStatement=miConexion.createStatement();
			
			rs1=miStatement.executeQuery("select * from usuarios");
			
		}catch(Exception e){
			
			System.out.println("no conecta");
			e.printStackTrace();
			
		}
		return rs1;
		
	}
         
         public ResultSet Dame_Conector_perfiles(){
		
		try{
			
			Connection miConexion=DriverManager.getConnection(con,user,pass);
			
			Statement miStatement=miConexion.createStatement();
			
			rs2=miStatement.executeQuery("select * from perfiles");
			
		}catch(Exception e){
			
			System.out.println("no conecta");
			e.printStackTrace();
			
		}
		return rs2;
		
	  }
         
          public void crearTabla_users(){
            try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    miStatement.executeUpdate("CREATE TABLE `usuarios` (\n" +
                                                "  `ID` int(11) NOT NULL,\n" +
                                                "  `usu_nombre` varchar(20) NOT NULL,\n" +
                                                "  `usu_pass` varchar(20) NOT NULL,\n" +
                                                "  `usu_perfil` int(11) NOT NULL\n" +
                                                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
                    miStatement.executeUpdate("INSERT INTO `usuarios` (`ID`, `usu_nombre`, `usu_pass`, `usu_perfil`) VALUES\n" +
                                                "(1, 'admin', '123', 1);");
                     miStatement.executeUpdate("ALTER TABLE `usuarios`\n" +
                                                "  ADD PRIMARY KEY (`ID`);");
                     
                     miStatement.executeUpdate("ALTER TABLE `usuarios`\n" +
                                                "  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;");
                    

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
      
        }
          
        public void crearTabla_perfiles(){
            try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    miStatement.executeUpdate("CREATE TABLE `perfiles` (\n" +
                                                "  `id_perfil` int(4) NOT NULL,\n" +
                                                "  `descripcion` varchar(20) NOT NULL\n" +
                                                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
                    
                    miStatement.executeUpdate("INSERT INTO `perfiles` (`id_perfil`, `descripcion`) VALUES\n" +
                                                "(1, 'Administrador');");
                    
                    miStatement.executeUpdate("ALTER TABLE `perfiles`\n" +
                                                "  ADD PRIMARY KEY (`id_perfil`);");
                    
                    miStatement.executeUpdate("ALTER TABLE `perfiles`\n" +
                                                "  MODIFY `id_perfil` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;");
              

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
      
        }
        public void crearTabla_permisos(){
            try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    miStatement.executeUpdate("CREATE TABLE `permisos` (\n" +
                                                "  `id_permiso` int(4) NOT NULL,\n" +
                                                "  `id_modulo` int(4) NOT NULL,\n" +
                                                "  `alta` bit(1) NOT NULL,\n" +
                                                "  `baja` bit(1) NOT NULL,\n" +
                                                "  `id_perfil` int(4) NOT NULL,\n" +
                                                "  `modif` bit(1) NOT NULL,\n" +
                                                "  `consulta` bit(1) NOT NULL,\n" +
                                                "  `listado` bit(1) NOT NULL\n" +
                                                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
                    miStatement.executeUpdate("INSERT INTO `permisos` (`id_permiso`, `id_modulo`, `alta`, `baja`, `id_perfil`, `modif`, `consulta`, `listado`) VALUES\n" +
                                                "(1, 1, b'1', b'1', 1, b'1', b'1', b'1'),\n" +
                                                "(2, 2, b'1', b'1', 1, b'1', b'1', b'1');");
                    miStatement.executeUpdate("ALTER TABLE `permisos`\n" +
                                                "  ADD PRIMARY KEY (`id_permiso`);");
                    miStatement.executeUpdate("ALTER TABLE `permisos`\n" +
                                            "  MODIFY `id_permiso` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;");

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
      
        }
        public void crearTabla_modulos(){
            try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    miStatement.executeUpdate("CREATE TABLE `modulos` (\n" +
                                                "  `id_modulo` int(4) NOT NULL,\n" +
                                                "  `nombre` varchar(15) NOT NULL,\n" +
                                                "  `descripcion` varchar(25) NOT NULL\n" +
                                                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
                    
                    miStatement.executeUpdate("INSERT INTO `modulos` (`id_modulo`, `nombre`, `descripcion`) VALUES\n" +
                                                        "(1, 'formaspago', 'mod clientes'),\n" +
                                                        "(2, 'stock', 'mod stock');");
                    miStatement.executeUpdate("ALTER TABLE `modulos`\n" +
                                                "  ADD PRIMARY KEY (`id_modulo`);");
                    miStatement.executeUpdate("ALTER TABLE `modulos`\n" +
                                                "  MODIFY `id_modulo` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;");

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
      
        }
        public void crearTabla_ultdiario(String ultfecha){
             try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    miStatement.executeUpdate("CREATE TABLE `ultima_impresion` (\n" +
                                            "  `id` int(2) NOT NULL,\n" +
                                            "  `ult_impresion` date NOT NULL,\n" +
                                            "  `ult_tomo` int(11) NOT NULL,\n" +
                                            "  `ult_folio` int(11) NOT NULL,\n" +
                                            "  `ult_transporte_debe` decimal(10,2) NOT NULL,\n" +
                                            "  `ult_transporte_haber` decimal(10,2) NOT NULL,\n" +
                                            "  `ult_asiento` int(11) NOT NULL,\n" +
                                            "  `ult_registro` int(11) NOT NULL\n" +
                                            ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
                    
                   
                    miStatement.executeUpdate("INSERT INTO `ultima_impresion` (`id`, `ult_impresion`, `ult_tomo`, `ult_folio`, `ult_transporte_debe`, `ult_transporte_haber`, `ult_asiento`, `ult_registro`) VALUES\n" +
                                                "(1, STR_TO_DATE(REPLACE('"+ultfecha+"','-','.') ,GET_FORMAT(date,'EUR')), 0, 0, '0.00', '0.00', 0, 0);");
                     miStatement.executeUpdate("ALTER TABLE `ultima_impresion`\n" +
                                                "  ADD PRIMARY KEY (`id`);");

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
        }
        public void crearTabla_plancuentas(){
             try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    miStatement.executeUpdate("CREATE TABLE `plan_cuentas` (\n" +
                                            "  `codigo_cta` varchar(20) NOT NULL,\n" +
                                            "  `descripcion` varchar(20) NOT NULL,\n" +
                                            "  `nro_cuenta` int(11) NOT NULL,\n" +
                                            "  `nivel` int(11) NOT NULL,\n" +
                                            "  `imputa` tinyint(1) NOT NULL\n" +
                                            ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
                    
                    miStatement.executeUpdate("INSERT INTO `plan_cuentas` (`codigo_cta`, `descripcion`, `nro_cuenta`, `nivel`, `imputa`) VALUES\n" +
                                        "('1', 'Activo', 1, 1, 0),\n" +
                                        "('1.1', 'Activo Corriente', 2, 2, 0),\n" +
                                        "('1.1.01', 'Disponibilidades', 3, 3, 0),\n" +
                                        "('1.1.01.01', 'Caja', 4, 4, 1),\n" +
                                        "('1.1.01.02', 'Bancos', 5, 4, 0),\n" +
                                        "('1.1.01.02.01', 'Banco Prov Cta Cte', 6, 5, 1),\n" +
                                        "('1.1.01.02.02', 'Banco Cta de Ahorro', 7, 5, 1),\n" +
                                        "('1.1.01.03', 'Valores a Depositar', 8, 4, 1),\n" +
                                        "('1.1.02', 'Ctas Cobrar', 9, 3, 0),\n" +
                                        "('1.1.02.01', 'Deudores en c.C', 10, 4, 1),\n" +
                                        "('1.1.02.02', 'Documentos a Cobrar', 11, 4, 1),\n" +
                                        "('1.1.02.03', 'Iva credito fiscal', 12, 4, 1),\n" +
                                        "('1.1.03', 'Bienes de Cambio', 13, 3, 0),\n" +
                                        "('1.1.03.01', 'Mercaderias', 14, 4, 1),\n" +
                                        "('1.1.05', 'Otros Creditos', 15, 3, 0),\n" +
                                        "('1.1.05.01', 'Socio 1 Cta Particul', 16, 4, 1),\n" +
                                        "('1.1.05.02', 'Socio 2 Cta Particul', 17, 4, 1),\n" +
                                        "('2', 'Pasivo', 18, 1, 0),\n" +
                                        "('2.1', 'Pasivo Corriente', 19, 2, 0),\n" +
                                        "('2.1.01', 'Deudas', 20, 3, 0),\n" +
                                        "('2.1.01.01', 'Deudas Comerciales', 21, 4, 0),\n" +
                                        "('2.1.01.01.01', 'Proveedores', 22, 5, 1),\n" +
                                        "('2.1.01.01.02', 'Obligaciones a pagar', 23, 5, 1),\n" +
                                        "('3', 'Patrimonio Neto', 24, 1, 0),\n" +
                                        "('3.1', 'Capital', 25, 2, 0),\n" +
                                        "('3.1.01', 'Capital Social', 26, 3, 1),\n" +
                                        "('5', 'Resultado Negativo', 27, 1, 0),\n" +
                                        "('5.2', 'Gastos', 28, 2, 0),\n" +
                                        "('5.2.04', 'Alquileres Creditos', 29, 3, 1);");
                    
                    miStatement.executeUpdate("ALTER TABLE `plan_cuentas`\n" +
                                                "  ADD PRIMARY KEY (`nro_cuenta`);");
                   miStatement.executeUpdate("ALTER TABLE `plan_cuentas`\n" +
                                            "  MODIFY `nro_cuenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;");

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
        }
         public void crearTabla_diario_mayor(){
             try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    miStatement.executeUpdate("CREATE TABLE `diario_mayor` (\n" +
                                                "  `nro_asiento` int(11) NOT NULL,\n" +
                                                "  `fecha_contable` date NOT NULL,\n" +
                                                "  `tipo_as` int(11) NOT NULL,\n" +
                                                "  `ok_carga` int(11) NOT NULL,\n" +
                                                "  `registrado` int(11) NOT NULL,\n" +
                                                "  `nro_renglon` int(11) NOT NULL,\n" +
                                                "  `nro_cuenta` int(11) NOT NULL,\n" +
                                                "  `descripcion` varchar(20) NOT NULL,\n" +
                                                "  `fecha_cierre` date NOT NULL,\n" +
                                                "  `fecha_apertura` date NOT NULL,\n" +
                                                "  `comprobante` varchar(20) NOT NULL,\n" +
                                                "  `sucursal` varchar(20) NOT NULL,\n" +
                                                "  `seccion` varchar(20) NOT NULL,\n" +
                                                "  `debe_haber` int(11) NOT NULL,\n" +
                                                "  `importe_debe` decimal(10,2) NOT NULL,\n" +
                                                "  `importe_haber` decimal(10,2) NOT NULL,\n" +
                                                "  `leyenda` varchar(30) NOT NULL\n" +
                                                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
                    
                   

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
        }
         public void crearTabla_asientos(){
             try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    miStatement.executeUpdate("CREATE TABLE `asientos` (\n" +
                                            "  `nro_asiento` int(11) NOT NULL,\n" +
                                            "  `fecha_contable` date NOT NULL,\n" +
                                            "  `tipo_asiento` int(11) NOT NULL,\n" +
                                            "  `ok_carga` int(11) NOT NULL,\n" +
                                            "  `registrado` int(11) NOT NULL,\n" +
                                            "  `nro_renglon` int(11) NOT NULL,\n" +
                                            "  `nro_cuenta` varchar(20) NOT NULL,\n" +
                                            "  `descripcion` varchar(30) NOT NULL,\n" +
                                            "  `fecha_vencimiento` date NOT NULL,\n" +
                                            "  `fecha_operacion` date NOT NULL,\n" +
                                            "  `comprobante` varchar(20) NOT NULL,\n" +
                                            "  `sucursal` varchar(20) NOT NULL,\n" +
                                            "  `seccion` varchar(20) NOT NULL,\n" +
                                            "  `debe_haber` int(11) NOT NULL,\n" +
                                            "  `importe` decimal(10,2) NOT NULL,\n" +
                                            "  `leyenda` varchar(30) NOT NULL\n" +
                                            ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
                    
                    

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
        }
         public void crearTabla_secciones(){
            try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    miStatement.executeUpdate("CREATE TABLE `seccion` (\n" +
                                                "  `id` varchar(2) NOT NULL,\n" +
                                                "  `descripcion` varchar(20) NOT NULL\n" +
                                                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
                    
                    miStatement.executeUpdate("INSERT INTO `seccion` (`id`, `descripcion`) VALUES\n" +
                                            "('01', 'RRHH'),\n" +
                                            "('02', 'Administracion');");
                    
                    miStatement.executeUpdate("ALTER TABLE `seccion`\n" +
                                                "  ADD PRIMARY KEY (`id`);");
              

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
      
        }
         public void crearTabla_sucursales(){
            try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    miStatement.executeUpdate("CREATE TABLE `sucursales` (\n" +
                                                    "  `id` varchar(2) NOT NULL,\n" +
                                                    "  `descripcion` varchar(20) NOT NULL,\n" +
                                                    "  `direccion` varchar(20) NOT NULL,\n" +
                                                    "  `seccion` varchar(2) NOT NULL\n" +
                                                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
                    
                    miStatement.executeUpdate("INSERT INTO `sucursales` (`id`, `descripcion`, `direccion`, `seccion`) VALUES\n" +
                                            "('01', 'Don juan', 'vieytes 1200', 'A1'),\n" +
                                            "('02', 'Bartolo', 'brown 200', 'A2');");
                    
                    miStatement.executeUpdate("ALTER TABLE `sucursales`\n" +
                                                "  ADD PRIMARY KEY (`id`);");
              

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
      
        }
         
         public void crearTabla_articulos(){
            try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    miStatement.executeUpdate("CREATE TABLE `articulos_de_stock` (\n" +
                                            "  `id` int(5) NOT NULL,\n" +
                                            "  `descripcion` varchar(30) DEFAULT NULL,\n" +
                                            "  `tipo_tasa_iva` varchar(20) DEFAULT NULL,\n" +
                                            "  `clave` varchar(2) DEFAULT NULL\n" +
                                            ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
                    
                    miStatement.executeUpdate("INSERT INTO `articulos_de_stock` (`id`, `descripcion`, `tipo_tasa_iva`, `clave`) VALUES\n" +
                                            "(1, 'fanta', 'Tasa Diferencial', '04'),\n" +
                                            "(2, 'mirinda', 'Tasa General', '04');");
                    
                    miStatement.executeUpdate("ALTER TABLE `articulos_de_stock`\n" +
                                            "  ADD PRIMARY KEY (`id`),\n" +
                                            "  ADD KEY `articulosfk1` (`clave`);");
                    miStatement.executeUpdate("ALTER TABLE `articulos_de_stock`\n" +
                        "  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;");

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
      
        }
         
          public void crearTabla_audit_articulos(){
            try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    miStatement.executeUpdate("CREATE TABLE `auditoriaarticulos` (\n" +
                                            "  `ID` int(11) NOT NULL,\n" +
                                            "  `usuario` varchar(20) NOT NULL,\n" +
                                            "  `terminal` varchar(20) NOT NULL,\n" +
                                            "  `fecha` date NOT NULL,\n" +
                                            "  `hora` time NOT NULL,\n" +
                                            "  `tabla` varchar(20) NOT NULL,\n" +
                                            "  `accion` varchar(20) NOT NULL,\n" +
                                            "  `id_articulo` int(11) NOT NULL,\n" +
                                            "  `descripcion` varchar(20) NOT NULL,\n" +
                                            "  `tasa_iva` varchar(20) NOT NULL,\n" +
                                            "  `id_pago` varchar(5) NOT NULL\n" +
                                            ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
                    
                    miStatement.executeUpdate("ALTER TABLE `auditoriaarticulos`\n" +
                                            "  ADD PRIMARY KEY (`ID`);");
                    
                    miStatement.executeUpdate("ALTER TABLE `auditoriaarticulos`\n" +
                                        "  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;");
                    

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
      
        }
          
          public void crearTabla_balanza_aux(){
            try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    miStatement.executeUpdate("CREATE TABLE `balanza_auxuliar` (\n" +
                                                "  `nro_cuenta` int(11) NOT NULL,\n" +
                                                "  `codigo_cta` varchar(20) NOT NULL,\n" +
                                                "  `nom_cuenta` varchar(30) NOT NULL,\n" +
                                                "  `nivel` int(11) NOT NULL,\n" +
                                                "  `saldo_inicial` decimal(10,2) NOT NULL,\n" +
                                                "  `debito` decimal(10,2) NOT NULL,\n" +
                                                "  `credito` decimal(10,2) NOT NULL,\n" +
                                                "  `acumulado` decimal(10,2) NOT NULL,\n" +
                                                "  `cierre` decimal(10,2) NOT NULL\n" +
                                                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
                    
                    miStatement.executeUpdate("ALTER TABLE `balanza_auxuliar`\n" +
                                                "  ADD PRIMARY KEY (`nro_cuenta`);");
                    

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
      
        }
        public boolean es_titulo(String padre){
            boolean resultado=false;
            try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    rs1=miStatement.executeQuery("select * from plan_cuentas where codigo_cta= '"+padre+"' and imputa= 0");
                    int cant=0;
                    if (rs1.last()){
                   cant = rs1.getRow();
                   } else {
                   cant = 0;
                   }
                   if (cant > 0){
                     resultado=true;  
                   }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
            return resultado;
        } 
        public String damefecha_apertura(){
            return "d";
        } 
        public boolean tiene_hijos(String codigo_cuenta){
            boolean resultado=false;
            try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    rs1=miStatement.executeQuery("SELECT * FROM plan_cuentas WHERE codigo_cta like '"+codigo_cuenta+".%'");
                    int cant=0;
                    if (rs1.last()){
                   cant = rs1.getRow();
                   } else {
                   cant = 0;
                   }
                   if (cant > 0){
                     resultado=true;  
                   }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
            return resultado;
        }
         public boolean tiene_asientos(String nro_cuenta){
            boolean resultado=false;
            try{

               Connection miConexion=DriverManager.getConnection(con,user,pass);
                Statement miStatement=miConexion.createStatement();

                    rs1=miStatement.executeQuery("SELECT * FROM diario_mayor WHERE nro_cuenta = '"+nro_cuenta+"' and ok_carga=1");
                    int cant=0;
                    if (rs1.last()){
                   cant = rs1.getRow();
                   } else {
                   cant = 0;
                   }
                   if (cant > 0){
                     resultado=true;  
                   }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error"+e.getMessage());
            }
            return resultado;
        }
    
}
