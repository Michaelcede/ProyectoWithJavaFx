/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Vendedor extends Persona implements Serializable{
    private static final long serialVersionUID=123412412431234l;
    
    public Vendedor(String nombres, String apellidos, String correo, String organizacion, String clave) {
        super(nombres, apellidos, correo, organizacion, clave);
    }
    public static void RegistrarVendedorFile(ArrayList<Vendedor>vendedores){
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("Vendedores.dat",true));) {
            out.writeObject(vendedores);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static boolean ComprobarVendedorInFile(Vendedor ve){
        try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Vendedores.dat"));){
            ArrayList<Vendedor>vendedores=(ArrayList<Vendedor>)ois.readObject();
            for(Vendedor v:vendedores){
                if(ve.equals(v))
                    return true;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public static ArrayList<Vendedor> LeerVendedorInFile(){
        try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Vendedores.dat"));){
            ArrayList<Vendedor>vendedores=(ArrayList<Vendedor>)ois.readObject();
            return vendedores;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public boolean Equals(Object o){
        if(o==null)
            return false;
        if(o==this)
            return true;
        if(this.getClass()!=o.getClass())
            return false;
        Vendedor v=(Vendedor)o;
        return this.correo.equals(v.correo);
    }
}
