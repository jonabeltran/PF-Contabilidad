package Administracion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BRANKO
 */
public class perfiles {
   
  private String nombre;
  private int id ;
  
  public perfiles(String nombre , int id ) {
    this.nombre=nombre;
    this.id=id;
  }
 
  public int getId(){
    return id ;
  }
 
 public String toString()
{
return nombre ;
}

}
