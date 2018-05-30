/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.utils;

import java.util.Objects;

/**
 *
 * @author Java-LM
 */
public final class Precondiciones {
    
    private Precondiciones(){
        
    }
    
    public static void revisarArgumento(boolean  condicion, String mensaje){
        if(!condicion)
            throw new IllegalArgumentException(mensaje);
    }
    
    public static void revisarArgumento(String cadena, String mensaje){
        /*
        Codniciones:
        1. La cadena no debe ser nula
        2. la cadena no debe ser vacia
        3. La cadena debe poseer por lo menos un caracter diferente a espacio vacio
        */
        revisarArgumento(
                cadena != null && !"".equals(cadena) && !"".equals(cadena.trim())
                , mensaje);        
    }
}
