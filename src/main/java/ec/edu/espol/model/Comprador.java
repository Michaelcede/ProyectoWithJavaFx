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
import java.util.ArrayList;

/**
 *
 * @author alecs
 */
public class Comprador extends Persona implements Serializable{
    
    public Comprador(String nombres, String apellidos, String correo, String organizacion, String clave) {
        super(nombres, apellidos, correo, organizacion, clave);
    }
    public static void cargarArchivo(){
        try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Compradores.txt"));){
            Comprador c = new Comprador("default","default","default","default","default");
            ArrayList<Comprador> compradores = new ArrayList<>();
            compradores.add(c);
            oos.writeObject(compradores);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void RegistrarCompradorFile(ArrayList<Comprador>compradores){
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("Compradores.txt",true));) {
            out.writeObject(compradores);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
    public static boolean comprobarEstadoenLista(Comprador c,ArrayList<Comprador>compradores){
        for(Comprador co: compradores){
            if(c.equals(co)){
                return true;
            } 
        } 
        return false;
    }
    public boolean equals(Object o){
        if(o==null)
            return false;
        if(o==this)
            return true;
        if(this.getClass()!=o.getClass())
            return false;
        Comprador c=(Comprador)o;
        return this.correo.equals(c.correo);
    }
    @Override
    public String toString(){
        return "Nombre: "+this.nombres+" Apellido: "+this.apellidos+" Correo: "+this.correo+" Organizacion: "+this.organizacion+" Contraseña: "+this.clave;
    }
}
