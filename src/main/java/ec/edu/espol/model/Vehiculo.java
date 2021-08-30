/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;



/**
 *
 * @author micha
 */
public class Vehiculo {
    private int id;
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
    
    //METODO CONSTRUCTOR PARA AUTOS
    public Vehiculo(int id, String placa, String tipo, String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, String vidrios, String transmision, double precio) {
        this.id = id;
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
    public Vehiculo(int id, String placa, String tipo , String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, String vidrios, String transmision, String traccion, double precio) {
        this.id = id;
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
    public Vehiculo(int id, String placa, String tipo , String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, double precio) {
        this.id = id;
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
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
   
   
  
}
