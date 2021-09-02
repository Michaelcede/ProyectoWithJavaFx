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
 * @author micha
 */
public class Vehiculo implements Serializable {
    private String tipo; //(auto,camioneta,motocicleta)
    private String placa;
    private String marca;
    private String modelo;
    private String tipo_de_motor;
    private int año;
    private double recorrido;
    private String color;
    private String tipo_combustible;
    private String vidrios;  //no aplica para motos
    private String transmision; //no aplica para motos
    private String traccion; //aplica para camionetas
    private double precio;
    
    private static final long serialVersionUID = 8799656478674716638L;
    ArrayList<Vehiculo> vehiculos =new ArrayList<>();
    
    //METODO CONSTRUCTOR PARA AUTOS
    public Vehiculo( String placa, String tipo, String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, String vidrios, String transmision, double precio) {
        this.placa = placa;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo_de_motor = tipo_de_motor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.tipo_combustible = tipo_combustible;
        this.vidrios = vidrios;
        this.transmision = transmision;
        this.precio = precio;
    }
    
    //METODO CONSTRUCTOR PARA CAMIONETAS
    public Vehiculo(String placa, String tipo , String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, String vidrios, String transmision, String traccion, double precio) {
        this.placa = placa;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo_de_motor = tipo_de_motor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.tipo_combustible = tipo_combustible;
        this.vidrios = vidrios;
        this.transmision = transmision;
        this.traccion = traccion;
        this.precio = precio;
    }
    
    //METODO CONSTRUCTOR PARA MOTOS
    public Vehiculo( String placa, String tipo , String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, double precio) {
        this.placa = placa;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo_de_motor = tipo_de_motor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.tipo_combustible = tipo_combustible;
        this.precio = precio;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo_de_motor() {
        return tipo_de_motor;
    }

    public void setTipo_de_motor(String tipo_de_motor) {
        this.tipo_de_motor = tipo_de_motor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getRecorrido() {
        return recorrido;
    }
    

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }

    public String getVidrios() {
        return vidrios;
    }

    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
   @Override
   public String toString(){
       // Para Auto: (String placa, String tipo, String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, String vidrios, String transmision, double precio) 
       if (this.tipo.toLowerCase().equals("auto"))
           return placa + "|" + tipo + "|" + marca + "|" + modelo + "|" + tipo_de_motor + "|" + año + "|" + recorrido + "|" + color + "|" + tipo_combustible + "|" + vidrios + "|" + transmision + "|" + precio;
       
       // Para Camioneta: (String placa, String tipo , String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, String vidrios, String transmision, String traccion, double precio) 
       if (this.tipo.toLowerCase().equals("camioneta"))
           return placa + "|" + tipo + "|" + marca + "|" + modelo + "|" + tipo_de_motor + "|" + año + "|" + recorrido + "|" + color + "|" + tipo_combustible + "|" + vidrios + "|" + transmision + "|" + traccion + "|" + precio;
       
       // Para Moto: (String placa, String tipo , String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, double precio)
       if (this.tipo.toLowerCase().equals("moto"))
           return placa + "|" + tipo + "|" + marca + "|" + modelo + "|" + tipo_de_motor + "|" + año + "|" + recorrido + "|" + color + "|" + tipo_combustible + "|" + precio;
       
       return null;
   }
   
   //Metodo para validar una cadena Numerica
    public static boolean validarNumeros(String cadena) {
        if (cadena.matches("[0-9]*")) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void cargarArchivo(){
        try (ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("Vehiculos.ser"));){
            Vehiculo v=new Vehiculo("default","default","default","default","default",0,0,"default","default",0);
            ArrayList<Vehiculo> vehiculos=new ArrayList<>();
            vehiculos.add(v);
            out.writeObject(vehiculos);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void RegistrarVehiculosFile(ArrayList<Vehiculo> vehiculos){
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("Vehiculos.ser"));) {
            out.writeObject(vehiculos);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static ArrayList<Vehiculo> LeerVehiculosFile(){
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Vehiculos.ser"));) {
            ArrayList<Vehiculo> vehiculos=(ArrayList<Vehiculo>)ois.readObject();
            return vehiculos;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    //Verifica si la placa ingresada se encuentra en el sistema
    //Si se encuentra True, sino False
    public static boolean VerificarPlaca(Vehiculo v1, ArrayList<Vehiculo> vehiculos){
        for (Vehiculo v2 : vehiculos){
            if(v2.placa.equals(v1.placa))
                return true;
        }
        return false;
    }
    
    
}
