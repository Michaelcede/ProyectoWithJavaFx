/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    
    public Vendedor(String nombres, String apellidos, String correo, String organizacion, String clave) {
        super(nombres, apellidos, correo, organizacion, clave);
    }
    
    public static void RegistrarVendedorFile(Vendedor v){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("Vendedores.txt",true));) {
            bw.write(v.nombres+"|"+v.apellidos+"|"+v.correo+"|"+v.organizacion+"|"+v.clave);
            bw.newLine();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
        public static ArrayList<Vendedor> LeerVendedorFile(){
        try(BufferedReader br=new BufferedReader(new FileReader("Vendedores.txt"));) {
            ArrayList<Vendedor>vendedores=new ArrayList<>();
            String line;
            while((line=br.readLine())!=null){
                String[]lista=line.split("|");
                String nombre=lista[0];
                String apellido=lista[1];
                String correo=lista[2];
                String organizacion=lista[3];
                String clave=lista[4];
                Vendedor v=new Vendedor(nombre,apellido,correo,organizacion,clave);
                vendedores.add(v);
            }
            return vendedores;
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
        public static boolean comprobarEstadoenLista(Vendedor v){
            if(Vendedor.LeerVendedorFile()!=null){
                ArrayList<Vendedor>vendedores=Vendedor.LeerVendedorFile();
                for(Vendedor ve:vendedores){
                if(ve.equals(v))
                    return true;
                } 
            }
            return false;
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
