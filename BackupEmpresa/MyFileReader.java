
package BackupEmpresa;

import java.io.*;
import java.util.*;

public class MyFileReader {
    
     public String leer(String archivo) throws java.io.IOException
    {
 
        String s1;
        String s2="";
        String s3;
        String s4;
 
        // Cargamos el buffer con el contenido del archivo
        BufferedReader br = new BufferedReader (new FileReader (archivo));
 
        // Leemos la primera linea
        s1 = br.readLine();
        s3 = br.readLine();
        s4 = br.readLine();
 
     //   System.out.println ("La tercera linea del archivo es: " + s4);
       // System.out.println ("La linea tiene " + s4.length() + " caracteres");
 
     //   System.out.println ();
    //    System.out.println ("Separando la linea en trozos tenemos las siguientes palabras:");
 
        int numTokens = 0;
        StringTokenizer st = new StringTokenizer (s4);
 
        // bucle por todas las palabras
        while (st.hasMoreTokens())
        {
            s2 = st.nextToken();
            numTokens++;
        //    System.out.println ("    Palabra " + numTokens + " es: " + s2);
        }
        return s2;
    }
     
     
    
}
