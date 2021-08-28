/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Dell
 */
public class Vendedor extends Persona implements Serializable{
    
    public Vendedor(String nombres, String apellidos, String correo, String organizacion, String clave) {
        super(nombres, apellidos, correo, organizacion, clave);
    }
    
    public static void GuardarVendedor(Vendedor v, String nomFile){
        try(ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(nomFile))){
            out.writeObject(v);
        }catch(IOException ex){
            System.out.println("IOException");
        }
    }
    
}
