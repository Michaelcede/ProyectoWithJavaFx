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
import java.util.ArrayList;

/**
 *
 * @author alecs
 */
public class Comprador extends Persona{
    
    public Comprador(String nombres, String apellidos, String correo, String organizacion, String clave) {
        super(nombres, apellidos, correo, organizacion, clave);
    }
    
    public static void RegistrarCompradorFile(ArrayList<Comprador>compradores){
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("Compradores.dat",true));) {
            out.writeObject(compradores);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static boolean ComprobarCompradorInFile(Comprador co){
        try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Compradores.dat"));){
            ArrayList<Comprador>compradores=(ArrayList<Comprador>)ois.readObject();
            for(Comprador c:compradores){
                if(co.equals(c))
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
    public static ArrayList<Comprador> LeerCompradorInFile(){
        try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Compradores.dat"));){
            ArrayList<Comprador>compradores=(ArrayList<Comprador>)ois.readObject();
            return compradores;
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
        Comprador c=(Comprador)o;
        return this.correo.equals(c.correo);
    }
}
