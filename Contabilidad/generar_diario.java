/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contabilidad;
import Login.coneccionBD;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
 
import com.lowagie.text.Anchor;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Chapter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Section;
import com.lowagie.text.Table;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
 
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPTable;
 
import com.lowagie.text.Image;
 
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author BRANKO
 */

public class generar_diario {
     private String strNombreDelPDF;
 
    private  Font fuenteNegra10 = new Font(Font.TIMES_ROMAN, 10, Font.BOLD, Color.BLACK);
    private  Font fuente8 = new Font(Font.TIMES_ROMAN, 8, Font.NORMAL, Color.BLACK);
    private  Font fuenteAzul25 = new Font(Font.TIMES_ROMAN, 25, Font.BOLD, Color.BLUE);
 
    Color grisClaro = new Color( 230,230,230);  
    Color azulClaro = new Color( 124,195,255 );
    Document document;
    PdfWriter writer;
    String strRotuloPDF,d_h;
    coneccionBD bd; 
    //String desde=datMayor.jFormattedTextField1.getText();
    String desde="2017-01-01";
    String hasta=Diario.jFormattedTextField1.getText();
    double saldo=0;
    
    public generar_diario(String titulo, String nomPDF)
    {
        strRotuloPDF = titulo;
        strNombreDelPDF = nomPDF;
        try
        {       //Hoja tamanio carta, rotarla (cambiar a horizontal)
            document = new Document( PageSize.A4 );
             
            writer = PdfWriter.getInstance(document,new FileOutputStream(strNombreDelPDF));
            document.open();
 
            agregarMetaDatos(document);
            agregarContenido(document);
             
            document.close();
             
            JOptionPane.showMessageDialog(null,"Se ha generado el PDF ");
                 
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
     
    //agrega el contenido del documento; para este ejemplo agrega una tabla con datos y una imagen
    //Espera como entrada el documento donde agregara el contenido
    private void agregarContenido(Document document) throws DocumentException
    {
        
        Paragraph ParrafoHoja = new Paragraph();
                 
        // Agregamos una linea en blanco al principio del documento
        agregarLineasEnBlanco(ParrafoHoja, 1);
        // Colocar un encabezado (en mayusculas)
        ParrafoHoja.add(new Paragraph(strRotuloPDF.toUpperCase (), fuenteAzul25) );
    //    ParrafoHoja.add(new Paragraph("Fecha Desde: "+desde+" Fecha Hasta: "+hasta, fuenteNegra10) );
      //  ParrafoHoja.add(new Paragraph("Fecha Desde: "+desde+"  Fecha Hasta: "+hasta, fuenteNegra10) );
        agregarLineasEnBlanco(ParrafoHoja, 1);
        // 1.- AGREGAMOS LA TABLA
        agregarTabla(ParrafoHoja);
        //Agregar 2 lineas en blanco
      //  agregarLineasEnBlanco(ParrafoHoja, 2);
        // 2.- AGREGAMOS LA IMAGEN
     /*   try
        {
            Image im = Image.getInstance("logo_mysql.gif");
            im.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP );
            im.setWidthPercentage (50);
          ParrafoHoja.add(im);
        }
        catch(Exception e)
        {
            e.printStackTrace ();
        }*/
         
        document.add(ParrafoHoja);
        
    }
 
    //Se conecta al DBMS MySQL , obtiene los datos de la tabla (SELECT) y los acomoda en una tabla JTable de iText.
    // Espera como entrada el parrafo donde agregara la tabla
    private void agregarTabla(Paragraph parrafo) throws BadElementException 
    {
         bd=new coneccionBD();
        
          
        //Anchos de las columnas
      //  float anchosFilas[] = { 0.2f,1f,1f,0.5f,0.5f,0.3f,1f,1.5f,0.7f };
      float anchosFilas[] = { 0.5f,0.5f,0.5f,0.5f,0.5f,0.5f };
        PdfPTable tabla = new PdfPTable(anchosFilas);
        String rotulosColumnas[] = {"Nro Renglon","Cuenta","Descripcion","Leyenda","Debe","Haber"};
        // Porcentaje que ocupa a lo ancho de la pagina del PDF
        tabla.setWidthPercentage(100);
        //Alineacion horizontal centrada
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        //agregar celda que ocupa las 9 columnas de los rotulos
        PdfPCell cell = new PdfPCell(new Paragraph("Transporte "+"   Debe 0"+"  Haber: 0"));
        cell.setColspan(9);
        //Centrar contenido de celda
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        //Color de fondo de la celda
        cell.setBackgroundColor (azulClaro);        
        tabla.addCell(cell);
 
        try{
                // Mostrar los rotulos de las columnas
                for(int i=0; i<rotulosColumnas.length; i++)
                {
                    cell = new PdfPCell(new Paragraph(rotulosColumnas[i],fuenteNegra10));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor (grisClaro);
                    tabla.addCell(cell);
                }
                 
                //Consultar la tabla empleados
               String strConsultaSQL = "SELECT * FROM diario_mayor where (fecha_contable BETWEEN '"+desde+"' and '"+hasta+"') ORDER BY fecha_contable DESC";
               
               Statement  estSQL1=bd.dameSentencia();
                //ejecutar consulta
               ResultSet rs = estSQL1.executeQuery(strConsultaSQL);
 
                //Iterar Mientras haya una fila siguiente
            while (rs.next())
            {           //Agregar 9 celdas
                    cell = new PdfPCell(new Paragraph(rs.getString("nro_renglon"),fuente8 ));
                    tabla.addCell(cell);
                    cell = new PdfPCell(new Paragraph(rs.getString("fecha_contable"),fuente8));
                    tabla.addCell(cell);
                    cell = new PdfPCell(new Paragraph(rs.getString("descripcion"),fuente8));
                    tabla.addCell(cell);
                    cell = new PdfPCell(new Paragraph(rs.getString("leyenda"),fuente8));
                    tabla.addCell(cell);
                     //calculos
                    if(rs.getString("debe_haber").equals("0")){
                        cell = new PdfPCell(new Paragraph(rs.getString("importe")));
                        tabla.addCell(cell);
                        cell = new PdfPCell(new Paragraph(""));
                        tabla.addCell(cell);
                        
                    }else{
                       
                        cell = new PdfPCell(new Paragraph(""));
                        tabla.addCell(cell);
                        cell = new PdfPCell(new Paragraph(rs.getString("importe")));
                        tabla.addCell(cell);
                    }
                    //--------------------------------------
                    
                  
            }
             
            rs.close();
            estSQL1.close();
        }catch(Exception e) {
            System.out.println("Excepcion al ejecutar CONSULTA!!!");
            //Mostrar la traza de la pila
            e.printStackTrace();
        }
        cell = new PdfPCell(new Paragraph("Total: "+String.valueOf("00")));
        cell.setColspan(9);
        //Centrar contenido de celda
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        //Color de fondo de la celda
        cell.setBackgroundColor (grisClaro);        
        tabla.addCell(cell);
        saldo=0;
        
        parrafo.add(tabla);
        agregarLineasEnBlanco(parrafo, 1);
            
        
        
        
            
       
        
        //Agregar la tabla con los datos al parrafo que nos llego como entrada
      //  parrafo.add(tabla);
    }  //Fin del metodo que crea la tabla
 
    //Agrega las lineas en blanco  especificadas a un parrafo especificado
    private static void agregarLineasEnBlanco(Paragraph parrafo, int nLineas) 
    {
        for (int i = 0; i < nLineas; i++) 
            parrafo.add(new Paragraph(" "));
    }
     
    //Agrega los metadatos del documento, los metadatos a asignar son
    //Titulo, Asunto, Palabras clave, Autor y el sw o org con el cual fue generado
    private static void agregarMetaDatos(Document document)
    {
        document.addTitle("Documento con datos de tabla MySQL");
        document.addSubject("Usando iText y MySQL");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Beltran Jonathan");
        document.addCreator("Beltran Jonathan");
    }
 
 
    public void abrirPDF()
    {
        /* Abrir el archivo PDF */
        try
        {
         //   Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +strNombreDelPDF);
             Runtime.getRuntime().exec("cmd /c start " +strNombreDelPDF);
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }   
    }   
    
}
