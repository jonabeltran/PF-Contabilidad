/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contabilidad;

/**
 *
 * @author BRANKO
 */
public class cuenta_class {
  
   
  private String nombre;
  private String codigo_cuenta ;
  
  public cuenta_class(String nombre , String codigo_cuenta ) {
    this.nombre=nombre;
    this.codigo_cuenta=codigo_cuenta;
  }
 
  public String getcodigo_cuenta(){
    return codigo_cuenta;
  }
 
 public String toString()
{
return nombre ;
}


}
