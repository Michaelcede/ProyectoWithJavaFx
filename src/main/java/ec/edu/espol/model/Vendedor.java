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
 * @author Dell
 */
public class Vendedor extends Persona implements Serializable{
    ArrayList<Vendedor>vendedores=new ArrayList<>();
    public Vendedor(String nombres, String apellidos, String correo, String organizacion, String clave) {
        super(nombres, apellidos, correo, organizacion, clave);
    }
    public static void cargarArchivo(){
        try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Vendedores.txt"));){
            Vendedor v=new Vendedor("default","default","default","default","default");
            ArrayList<Vendedor>vendedores=new ArrayList<>();
            vendedores.add(v);
            oos.writeObject(vendedores);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void RegistrarVendedorFile(ArrayList<Vendedor>vendedores){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Vendedores.txt"));) {
            oos.writeObject(vendedores);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
        public static ArrayList<Vendedor> LeerVendedorFile(){
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Vendedores.txt"));) {
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
        public static boolean comprobarEstadoenLista(Vendedor v,ArrayList<Vendedor>vendedores){
            for(Vendedor ve:vendedores){
                if(v.equals(ve)){
                    return true;
                } 
            }
            
            return false;
        }
    @Override
    public boolean equals(Object o){
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
