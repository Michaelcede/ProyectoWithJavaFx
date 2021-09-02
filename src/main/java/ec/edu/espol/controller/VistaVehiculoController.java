/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.proyectofinal.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import java.lang.NumberFormatException;
import java.util.ArrayList;

/**
 * FXML Controller class
 *
 * @author micha
 */
public class VistaVehiculoController implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField pwContraseña;
    @FXML
    private GridPane PanelVehiculos;
    @FXML
    private HBox HBoxIngreso;

    /**
     * Initializes the controller class.
     */
    
    //Creacion de Botones Cambiar e Ingresar
    private Button cambiar;
    private Button ingresarVehiculo;
    //Creacion de los Textfield
    private TextField tf0;
    private TextField tf1;
    private TextField tf2;
    private TextField tf3;
    private TextField tf4;
    private TextField tf5;
    private TextField tf6;
    private TextField tf7;
    private TextField tf8;
    private TextField tf9;
    private TextField tf10;
    private TextField tf11;
    private TextField tf12;
    
    ArrayList<Vehiculo> ListaVehiculos=new ArrayList<>();
    @FXML
    private GridPane PanelBotones;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Vehiculo.cargarArchivo();
        this.ListaVehiculos = Vehiculo.LeerVehiculosFile();
    }   
    
    @FXML
    private void RegresaraVendedor(MouseEvent event) {
        try {
            FXMLLoader fxmloader=App.LoadFXMLLoader("VistaVendedor");
            App.setRoot(fxmloader);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void IngresarUsuario(MouseEvent event) {
        HBoxIngreso.getChildren().clear();
        cambiar = new Button("CAMBIAR VEHICULO");
        cambiar.setMinSize(90.00, 45.00);
        cambiar.setTranslateX(30);
        cambiar.setTranslateY(-20);
        cambiar.addEventFilter(MouseEvent.MOUSE_CLICKED, eventoCambiar);
        PanelBotones.add(cambiar, 2, 0);
        ingresarVehiculo = new Button("INGRESAR VEHICULO");
        ingresarVehiculo.setMinSize(90.00, 45.00);
        ingresarVehiculo.setTranslateX(30);
        ingresarVehiculo.setTranslateY(-20);
        ingresarVehiculo.addEventFilter(MouseEvent.MOUSE_CLICKED, eventoIngresar);
        PanelBotones.add(ingresarVehiculo, 1, 0);
        Text t0= new Text ("Ingrese el tipo de Vehiculo:");
        PanelVehiculos.add(t0,0,0);
        tf0=new TextField();
        PanelVehiculos.add(tf0, 1, 0);
        tf0.setOnKeyPressed((KeyEvent e)->{
                if((e.getCode() == KeyCode.ENTER)){
                    if(tf0.getText().toLowerCase().equals("auto")){
                        PanelVehiculos.getChildren().clear();
                        Text t1=new Text("Placa:");
                        PanelVehiculos.add(t1, 0, 1);
                        tf1=new TextField();
                        PanelVehiculos.add(tf1, 1, 1);
                        Text t2=new Text("Marca:");
                        PanelVehiculos.add(t2, 0, 2);
                        tf2=new TextField();
                        PanelVehiculos.add(tf2, 1, 2);
                        Text t3=new Text("Modelo:");
                        PanelVehiculos.add(t3, 0, 3);
                        tf3=new TextField();
                        PanelVehiculos.add(tf3, 1, 3);
                        Text t4=new Text("Tipo de Motor:");
                        PanelVehiculos.add(t4, 0, 4);
                        tf4=new TextField();
                        PanelVehiculos.add(tf4, 1, 4);
                        Text t5=new Text("Año:");
                        PanelVehiculos.add(t5, 0, 5);
                        tf5=new TextField();
                        PanelVehiculos.add(tf5, 1, 5);
                        Text t6=new Text("Recorrido:");
                        PanelVehiculos.add(t6, 0, 6);
                        tf6=new TextField();
                        PanelVehiculos.add(tf6, 1, 6);
                        Text t7=new Text("Color:");
                        PanelVehiculos.add(t7, 0, 7);
                        tf7=new TextField();
                        PanelVehiculos.add(tf7, 1, 7);
                        Text t8=new Text("Tipo de Combustible:");
                        PanelVehiculos.add(t8, 0, 8);
                        tf8=new TextField();
                        PanelVehiculos.add(tf8, 1, 8);
                        Text t9=new Text("Precio:");
                        PanelVehiculos.add(t9, 0, 9);
                        tf9=new TextField();
                        PanelVehiculos.add(tf9, 1, 9);
                        Text t10=new Text("Vidrios:");
                        PanelVehiculos.add(t10, 0, 10);
                        tf10=new TextField();
                        PanelVehiculos.add(tf10, 1, 10);
                        Text t11=new Text("Transmision:");
                        PanelVehiculos.add(t11, 0, 11);
                        tf11=new TextField();
                        PanelVehiculos.add(tf11, 1, 11);
                        
                    }
                    else if(tf0.getText().toLowerCase().equals("camioneta")){
                        PanelVehiculos.getChildren().clear();
                        Text t1=new Text("Placa:");
                        PanelVehiculos.add(t1, 0, 1);
                        tf1=new TextField();
                        PanelVehiculos.add(tf1, 1, 1);
                        Text t2=new Text("Marca:");
                        PanelVehiculos.add(t2, 0, 2);
                        tf2=new TextField();
                        PanelVehiculos.add(tf2, 1, 2);
                        Text t3=new Text("Modelo:");
                        PanelVehiculos.add(t3, 0, 3);
                        tf3=new TextField();
                        PanelVehiculos.add(tf3, 1, 3);
                        Text t4=new Text("Tipo de Motor:");
                        PanelVehiculos.add(t4, 0, 4);
                        tf4=new TextField();
                        PanelVehiculos.add(tf4, 1, 4);
                        Text t5=new Text("Año:");
                        PanelVehiculos.add(t5, 0, 5);
                        tf5=new TextField();
                        PanelVehiculos.add(tf5, 1, 5);
                        Text t6=new Text("Recorrido:");
                        PanelVehiculos.add(t6, 0, 6);
                        tf6=new TextField();
                        PanelVehiculos.add(tf6, 1, 6);
                        Text t7=new Text("Color:");
                        PanelVehiculos.add(t7, 0, 7);
                        tf7=new TextField();
                        PanelVehiculos.add(tf7, 1, 7);
                        Text t8=new Text("Tipo de Combustible:");
                        PanelVehiculos.add(t8, 0, 8);
                        tf8=new TextField();
                        PanelVehiculos.add(tf8, 1, 8);
                        Text t9=new Text("Precio:");
                        PanelVehiculos.add(t9, 0, 9);
                        tf9=new TextField();
                        PanelVehiculos.add(tf9, 1, 9);
                        Text t10=new Text("Vidrios:");
                        PanelVehiculos.add(t10, 0, 10);
                        tf10=new TextField();
                        PanelVehiculos.add(tf10, 1, 10);
                        Text t11=new Text("Transmision:");
                        PanelVehiculos.add(t11, 0, 11);
                        tf11=new TextField();
                        PanelVehiculos.add(tf11, 1, 11);
                        Text t12=new Text("Traccion:");
                        PanelVehiculos.add(t12, 0, 12);
                        tf12=new TextField();
                        PanelVehiculos.add(tf12, 1, 12);
                    }
                    else if(tf0.getText().toLowerCase().equals("moto")){
                        PanelVehiculos.getChildren().clear();
                        Text t1=new Text("Placa:");
                        PanelVehiculos.add(t1, 0, 1);
                        tf1=new TextField();
                        PanelVehiculos.add(tf1, 1, 1);
                        Text t2=new Text("Marca:");
                        PanelVehiculos.add(t2, 0, 2);
                        tf2=new TextField();
                        PanelVehiculos.add(tf2, 1, 2);
                        Text t3=new Text("Modelo:");
                        PanelVehiculos.add(t3, 0, 3);
                        tf3=new TextField();
                        PanelVehiculos.add(tf3, 1, 3);
                        Text t4=new Text("Tipo de Motor:");
                        PanelVehiculos.add(t4, 0, 4);
                        tf4=new TextField();
                        PanelVehiculos.add(tf4, 1, 4);
                        Text t5=new Text("Año:");
                        PanelVehiculos.add(t5, 0, 5);
                        tf5=new TextField();
                        PanelVehiculos.add(tf5, 1, 5);
                        Text t6=new Text("Recorrido:");
                        PanelVehiculos.add(t6, 0, 6);
                        tf6=new TextField();
                        PanelVehiculos.add(tf6, 1, 6);
                        Text t7=new Text("Color:");
                        PanelVehiculos.add(t7, 0, 7);
                        tf7=new TextField();
                        PanelVehiculos.add(tf7, 1, 7);
                        Text t8=new Text("Tipo de Combustible:");
                        PanelVehiculos.add(t8, 0, 8);
                        tf8=new TextField();
                        PanelVehiculos.add(tf8, 1, 8);
                        Text t9=new Text("Precio:");
                        PanelVehiculos.add(t9, 0, 9);
                        tf9=new TextField();
                        PanelVehiculos.add(tf9, 1, 9);
                    }
                    else if(tf0.getText().equals("") || tf0.getText().toLowerCase().equals("moto")==false || tf0.getText().toLowerCase().equals("auto")==false || tf0.getText().toLowerCase().equals("camioneta")==false){
                        Alert alert = new Alert(AlertType.WARNING,"Especifique el Tipo de Vehiculo");
                        alert.show();
                    }
                }
                }
                );
    }
    
    //Creacion del evento(Darle Click) para el boton Cambiar
    EventHandler<MouseEvent> eventoCambiar = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {
        PanelVehiculos.getChildren().clear();
        Text t0= new Text ("Ingrese el tipo de Vehiculo:");
        PanelVehiculos.add(t0,0,0);
        TextField tf0=new TextField();
        PanelVehiculos.add(tf0, 1, 0);
        tf0.requestFocus();
        tf0.setOnKeyPressed((KeyEvent e)->{
                if((e.getCode() == KeyCode.ENTER)){
                    if(tf0.getText().toLowerCase().equals("auto")){
                        PanelVehiculos.getChildren().clear();
                        Text t1=new Text("Placa:");
                        PanelVehiculos.add(t1, 0, 1);
                        tf1=new TextField();
                        PanelVehiculos.add(tf1, 1, 1);
                        Text t2=new Text("Marca:");
                        PanelVehiculos.add(t2, 0, 2);
                        tf2=new TextField();
                        PanelVehiculos.add(tf2, 1, 2);
                        Text t3=new Text("Modelo:");
                        PanelVehiculos.add(t3, 0, 3);
                        tf3=new TextField();
                        PanelVehiculos.add(tf3, 1, 3);
                        Text t4=new Text("Tipo de Motor:");
                        PanelVehiculos.add(t4, 0, 4);
                        tf4=new TextField();
                        PanelVehiculos.add(tf4, 1, 4);
                        Text t5=new Text("Año:");
                        PanelVehiculos.add(t5, 0, 5);
                        tf5=new TextField();
                        PanelVehiculos.add(tf5, 1, 5);
                        Text t6=new Text("Recorrido:");
                        PanelVehiculos.add(t6, 0, 6);
                        tf6=new TextField();
                        PanelVehiculos.add(tf6, 1, 6);
                        Text t7=new Text("Color:");
                        PanelVehiculos.add(t7, 0, 7);
                        tf7=new TextField();
                        PanelVehiculos.add(tf7, 1, 7);
                        Text t8=new Text("Tipo de Combustible:");
                        PanelVehiculos.add(t8, 0, 8);
                        tf8=new TextField();
                        PanelVehiculos.add(tf8, 1, 8);
                        Text t9=new Text("Precio:");
                        PanelVehiculos.add(t9, 0, 9);
                        tf9=new TextField();
                        PanelVehiculos.add(tf9, 1, 9);
                        Text t10=new Text("Vidrios:");
                        PanelVehiculos.add(t10, 0, 10);
                        tf10=new TextField();
                        PanelVehiculos.add(tf10, 1, 10);
                        Text t11=new Text("Transmision:");
                        PanelVehiculos.add(t11, 0, 11);
                        tf11=new TextField();
                        PanelVehiculos.add(tf11, 1, 11);
                        
                    }
                    else if(tf0.getText().toLowerCase().equals("camioneta")){
                        PanelVehiculos.getChildren().clear();
                        Text t1=new Text("Placa:");
                        PanelVehiculos.add(t1, 0, 1);
                        tf1=new TextField();
                        PanelVehiculos.add(tf1, 1, 1);
                        Text t2=new Text("Marca:");
                        PanelVehiculos.add(t2, 0, 2);
                        tf2=new TextField();
                        PanelVehiculos.add(tf2, 1, 2);
                        Text t3=new Text("Modelo:");
                        PanelVehiculos.add(t3, 0, 3);
                        tf3=new TextField();
                        PanelVehiculos.add(tf3, 1, 3);
                        Text t4=new Text("Tipo de Motor:");
                        PanelVehiculos.add(t4, 0, 4);
                        tf4=new TextField();
                        PanelVehiculos.add(tf4, 1, 4);
                        Text t5=new Text("Año:");
                        PanelVehiculos.add(t5, 0, 5);
                        tf5=new TextField();
                        PanelVehiculos.add(tf5, 1, 5);
                        Text t6=new Text("Recorrido:");
                        PanelVehiculos.add(t6, 0, 6);
                        tf6=new TextField();
                        PanelVehiculos.add(tf6, 1, 6);
                        Text t7=new Text("Color:");
                        PanelVehiculos.add(t7, 0, 7);
                        tf7=new TextField();
                        PanelVehiculos.add(tf7, 1, 7);
                        Text t8=new Text("Tipo de Combustible:");
                        PanelVehiculos.add(t8, 0, 8);
                        tf8=new TextField();
                        PanelVehiculos.add(tf8, 1, 8);
                        Text t9=new Text("Precio:");
                        PanelVehiculos.add(t9, 0, 9);
                        tf9=new TextField();
                        PanelVehiculos.add(tf9, 1, 9);
                        Text t10=new Text("Vidrios:");
                        PanelVehiculos.add(t10, 0, 10);
                        tf10=new TextField();
                        PanelVehiculos.add(tf10, 1, 10);
                        Text t11=new Text("Transmision:");
                        PanelVehiculos.add(t11, 0, 11);
                        tf11=new TextField();
                        PanelVehiculos.add(tf11, 1, 11);
                        Text t12=new Text("Traccion:");
                        PanelVehiculos.add(t12, 0, 12);
                        tf12=new TextField();
                        PanelVehiculos.add(tf12, 1, 12);
                    }
                    else if(tf0.getText().toLowerCase().equals("moto")){
                        PanelVehiculos.getChildren().clear();
                        Text t1=new Text("Placa:");
                        PanelVehiculos.add(t1, 0, 1);
                        tf1=new TextField();
                        PanelVehiculos.add(tf1, 1, 1);
                        Text t2=new Text("Marca:");
                        PanelVehiculos.add(t2, 0, 2);
                        tf2=new TextField();
                        PanelVehiculos.add(tf2, 1, 2);
                        Text t3=new Text("Modelo:");
                        PanelVehiculos.add(t3, 0, 3);
                        tf3=new TextField();
                        PanelVehiculos.add(tf3, 1, 3);
                        Text t4=new Text("Tipo de Motor:");
                        PanelVehiculos.add(t4, 0, 4);
                        tf4=new TextField();
                        PanelVehiculos.add(tf4, 1, 4);
                        Text t5=new Text("Año:");
                        PanelVehiculos.add(t5, 0, 5);
                        tf5=new TextField();
                        PanelVehiculos.add(tf5, 1, 5);
                        Text t6=new Text("Recorrido:");
                        PanelVehiculos.add(t6, 0, 6);
                        tf6=new TextField();
                        PanelVehiculos.add(tf6, 1, 6);
                        Text t7=new Text("Color:");
                        PanelVehiculos.add(t7, 0, 7);
                        tf7=new TextField();
                        PanelVehiculos.add(tf7, 1, 7);
                        Text t8=new Text("Tipo de Combustible:");
                        PanelVehiculos.add(t8, 0, 8);
                        tf8=new TextField();
                        PanelVehiculos.add(tf8, 1, 8);
                        Text t9=new Text("Precio:");
                        PanelVehiculos.add(t9, 0, 9);
                        tf9=new TextField();
                        PanelVehiculos.add(tf9, 1, 9);
                    }
                    else if(tf0.getText().equals("") || tf0.getText().toLowerCase().equals("moto")==false || tf0.getText().toLowerCase().equals("auto")==false || tf0.getText().toLowerCase().equals("camioneta")==false){
                        Alert alert = new Alert(AlertType.WARNING,"Especifique el Tipo de Vehiculo");
                        alert.show();
                    }
                }
                }
                );
        }
    };


    EventHandler<MouseEvent> eventoIngresar = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {
            if(tf0.getText().toLowerCase().equals("auto")){
                if(!(tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty() || tf4.getText().isEmpty() || tf5.getText().isEmpty() || tf6.getText().isEmpty() || tf7.getText().isEmpty() || tf8.getText().isEmpty() || tf9.getText().isEmpty() || tf10.getText().isEmpty() || tf11.getText().isEmpty())){
                    String tipoVehiculo = tf0.getText();
                    String placa = tf1.getText();
                    String marca = tf2.getText();
                    String modelo = tf3.getText();
                    String tipomotor = tf4.getText();
                    String anio = tf5.getText();
                    String recorrido = tf6.getText();
                    String color = tf7.getText();
                    String tipocombustible = tf8.getText();
                    String precio = tf9.getText();
                    String vidrios = tf10.getText();
                    String transmision = tf11.getText();
                    if(Vehiculo.validarNumeros(anio)== true && Vehiculo.validarNumeros(recorrido)== true && Vehiculo.validarNumeros(precio)== true){
                        int iAnio = Integer.parseInt(anio);
                        double dRecorrido = Double.parseDouble(recorrido);
                        double dPrecio = Double.parseDouble(precio);
                        Vehiculo v = new Vehiculo(placa,tipoVehiculo,marca,modelo,tipomotor,iAnio,dRecorrido,color,tipocombustible,vidrios,transmision,dPrecio);
                        if(Vehiculo.VerificarPlaca(v, ListaVehiculos) == false){
                            ListaVehiculos.add(v);
                            Alert a= new Alert(AlertType.CONFIRMATION,"El Vehiculo ha sido ingresado al Sistema");
                            a.show();
                            Vehiculo.RegistrarVehiculosFile(ListaVehiculos);
                        }else{
                            Alert a= new Alert(AlertType.WARNING,"La placa ya existe en el Sistema");
                            a.show();
                        }
                    }else{
                        Alert a= new Alert(AlertType.ERROR, "Tipo de dato incorrecto");
                        a.show();   
                    }
                }
                else{
                    Alert a= new Alert(AlertType.WARNING, "No deben haber campos vacios");
                    a.show();
                    tf0.requestFocus();
                }
                
            } else if(tf0.getText().toLowerCase().equals("camioneta")){
                if(!(tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty() || tf4.getText().isEmpty() || tf5.getText().isEmpty() || tf6.getText().isEmpty() || tf7.getText().isEmpty() || tf8.getText().isEmpty() || tf9.getText().isEmpty() || tf10.getText().isEmpty() || tf11.getText().isEmpty() || tf12.getText().isEmpty())){
                    String tipoVehiculo = tf0.getText();
                    String placa = tf1.getText();
                    String marca = tf2.getText();
                    String modelo = tf3.getText();
                    String tipomotor = tf4.getText();
                    String anio = tf5.getText();
                    String recorrido = tf6.getText();
                    String color = tf7.getText();
                    String tipocombustible = tf8.getText();
                    String precio = tf9.getText();
                    String vidrios = tf10.getText();
                    String transmision = tf11.getText();
                    String traccion = tf12.getText();
                    if(Vehiculo.validarNumeros(anio)== true && Vehiculo.validarNumeros(recorrido)== true && Vehiculo.validarNumeros(precio)== true){
                        int iAnio = Integer.parseInt(anio);
                        double dRecorrido = Double.parseDouble(recorrido);
                        double dPrecio = Double.parseDouble(precio);
                        Vehiculo v = new Vehiculo(placa,tipoVehiculo,marca,modelo,tipomotor,iAnio,dRecorrido,color,tipocombustible,vidrios,transmision,traccion,dPrecio);
                        if(Vehiculo.VerificarPlaca(v, ListaVehiculos) == false){
                            ListaVehiculos.add(v);
                            Alert a= new Alert(AlertType.CONFIRMATION,"El Vehiculo ha sido ingresado al Sistema");
                            a.show();
                            Vehiculo.RegistrarVehiculosFile(ListaVehiculos);
                        }else{
                            Alert a= new Alert(AlertType.WARNING,"La placa ya existe en el Sistema");
                            a.show();
                        }
                    }else{
                        Alert a= new Alert(AlertType.ERROR, "Tipo de dato incorrecto");
                        a.show();   
                    }
                }
                else{
                    Alert a= new Alert(AlertType.WARNING, "No deben haber campos vacios");
                    a.show();
                    tf0.requestFocus();
                }

            } else if(tf0.getText().toLowerCase().equals("moto")){
                if(!(tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty() || tf4.getText().isEmpty() || tf5.getText().isEmpty() || tf6.getText().isEmpty() || tf7.getText().isEmpty() || tf8.getText().isEmpty() || tf9.getText().isEmpty())){
                    String tipoVehiculo = tf0.getText();
                    String placa = tf1.getText();
                    String marca = tf2.getText();
                    String modelo = tf3.getText();
                    String tipomotor = tf4.getText();
                    String anio = tf5.getText();
                    String recorrido = tf6.getText();
                    String color = tf7.getText();
                    String tipocombustible = tf8.getText();
                    String precio = tf9.getText();
                    if(Vehiculo.validarNumeros(anio)== true && Vehiculo.validarNumeros(recorrido)== true && Vehiculo.validarNumeros(precio)== true){
                        int iAnio = Integer.parseInt(anio);
                        double dRecorrido = Double.parseDouble(recorrido);
                        double dPrecio = Double.parseDouble(precio);
                        Vehiculo v = new Vehiculo(placa,tipoVehiculo,marca,modelo,tipomotor,iAnio,dRecorrido,color,tipocombustible,dPrecio);
                        if(Vehiculo.VerificarPlaca(v, ListaVehiculos) == false){
                            ListaVehiculos.add(v);
                            Alert a= new Alert(AlertType.CONFIRMATION,"El Vehiculo ha sido ingresado al Sistema");
                            a.show();
                            Vehiculo.RegistrarVehiculosFile(ListaVehiculos);
                        }else{
                            Alert a= new Alert(AlertType.WARNING,"La placa ya existe en el Sistema");
                            a.show();
                        }
                    }else{
                        Alert a= new Alert(AlertType.ERROR, "Tipo de dato incorrecto");
                        a.show();   
                    }
                }
                else{
                    Alert a= new Alert(AlertType.WARNING, "No deben haber campos vacios");
                    a.show();
                    tf0.requestFocus();
                }
            }
            else{
                Alert a= new Alert(AlertType.WARNING, "No deben haber campos vacios");
                a.show();
                tf0.requestFocus();
            }       
        }       
    };
    

}
