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
public class Oferta {
    private Vehiculo vehiculo;
    private String correoVendedor;
    private Double precio;
    private String correoComprador;

    public Oferta(Vehiculo vehiculo, String correoVendedor, Double precio, String correoComprador) {
        this.vehiculo = vehiculo;
        this.correoVendedor = correoVendedor;
        this.precio = precio;
        this.correoComprador = correoComprador;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getCorreoVendedor() {
        return correoVendedor;
    }

    public void setCorreoVendedor(String correoVendedor) {
        this.correoVendedor = correoVendedor;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCorreoComprador() {
        return correoComprador;
    }

    public void setCorreoComprador(String correoComprador) {
        this.correoComprador = correoComprador;
    }
    
    public static void cargarArchivo(){
        try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Ofertas.txt"));){
            Oferta o=new Oferta(null,"default",0.0,"default");
            ArrayList<Oferta>ofertas=new ArrayList<>();
            ofertas.add(o);
            oos.writeObject(ofertas);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void RegistrarOfertaFile(ArrayList<Oferta>ofertas){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Ofertas.txt"));){
            oos.writeObject(ofertas);
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
