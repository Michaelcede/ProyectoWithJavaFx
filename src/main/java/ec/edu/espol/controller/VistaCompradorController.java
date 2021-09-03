/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Persona;
import ec.edu.espol.proyectofinal.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class VistaCompradorController implements Initializable {

    @FXML
    private GridPane PanelComprador;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void RegresardesdeComprador(MouseEvent event) {
        try {
            FXMLLoader fxmloader=App.LoadFXMLLoader("Principal");
            App.setRoot(fxmloader);
            PrincipalController p=fxmloader.getController();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void RegistrarNuevoUsuario(MouseEvent event){
        PanelComprador.getChildren().clear();
        Text t1 = new Text("Nombre: ");
        PanelComprador.add(t1, 1, 0);
        TextField tf1 = new TextField();
        PanelComprador.add(tf1, 4, 0);
        Text t2 = new Text("Apellido: ");
        PanelComprador.add(t2, 1, 1);
        TextField tf2 = new TextField();
        PanelComprador.add(tf2, 4, 1);
        Text t3=new Text("Organización:");
        PanelComprador.add(t3, 1, 2);
        TextField tf3=new TextField();
        PanelComprador.add(tf3, 4, 2);
        Text t4=new Text("Correo Electronico:");
        PanelComprador.add(t4, 1, 3);
        TextField tf4=new TextField();
        PanelComprador.add(tf4, 4, 3);
        Text t5=new Text("Contraseña:");
        PanelComprador.add(t5, 1, 4);
        PasswordField pw=new PasswordField();
        PanelComprador.add(pw, 4, 4);
        Button br=new Button("REGISTRAR");
        br.prefWidth(90);
        br.prefHeight(45);
        br.setAlignment(Pos.CENTER_RIGHT);
        PanelComprador.add(br, 5, 2);
        br.setOnMouseClicked((MouseEvent e)->{
            Alert a;
            if(tf1.getText()!=null && tf2.getText()!=null && tf3.getText()!=null && tf4.getText()!=null && pw.getText()!=null){
                String Nombre=tf1.getText();
                String Apellido=tf2.getText();
                String Correo=tf4.getText();
                String Organizacion=tf3.getText();
                String Clave=Persona.convertirSHA256(pw.getText());
                if(Persona.validarEmail(tf4.getText())!=false){
                    Comprador c=new Comprador(Nombre,Apellido,Organizacion,Correo,Clave);
                    //METODO REGISTRAR COMPRADOR HACERRRRRRRRRR
                    a=new Alert(Alert.AlertType.CONFIRMATION,"Usuario guardado con exito");
                    a.show();
                }
                else{
                    a=new Alert(Alert.AlertType.WARNING,"Espacios en Blanco o correo invalido");
                    a.show();
                }
            }
            else{
               a=new Alert(Alert.AlertType.WARNING,"No deben haber campos vacios"); 
               a.show();
            }
        });
        
    }
    
    @FXML
    private void Ofertar(MouseEvent event) {
        PanelComprador.getChildren().clear();
        Text t1 = new Text("Tipo de vehículo: ");
        PanelComprador.add(t1, 1, 0);
        TextField tf1 = new TextField();
        tf1.setMaxWidth(75);
        PanelComprador.add(tf1, 2, 0);
        Text t2 = new Text("Recorrido: ");
        PanelComprador.add(t2, 1, 1);
        TextField tf2 = new TextField();
        tf2.setMaxWidth(75);
        PanelComprador.add(tf2, 2, 1);
        Text g1 = new Text(":");
        PanelComprador.add(g1, 3, 1);
        TextField tf7 = new TextField();
        tf7.setMaxWidth(75);
        PanelComprador.add(tf7, 4, 1);
        Text t3=new Text("Año:");
        PanelComprador.add(t3, 1, 2);
        TextField tf3=new TextField();
        tf3.setMaxWidth(75);
        PanelComprador.add(tf3, 2, 2);
        Text g2 = new Text(":");
        PanelComprador.add(g2, 3, 2);
        TextField tf8 = new TextField();
        tf8.setMaxWidth(75);
        PanelComprador.add(tf8, 4, 2);
        Text t4=new Text("Precio:");
        PanelComprador.add(t4, 1, 3);
        TextField tf4=new TextField();
        tf4.setMaxWidth(75);
        PanelComprador.add(tf4, 2, 3);
        Text g3 = new Text(":");
        PanelComprador.add(g3, 3, 3);
        TextField tf9 = new TextField();
        tf9.setMaxWidth(75);
        PanelComprador.add(tf9, 4, 3);
        Button br=new Button("BUSCAR");
        br.prefWidth(90);
        br.prefHeight(45);
        br.setAlignment(Pos.CENTER_RIGHT);
        PanelComprador.add(br, 2, 4);
        br.setOnMouseClicked((MouseEvent e)->{
            PanelComprador.getChildren().clear();
            Text t11 = new Text("Placa: ");
            PanelComprador.add(t11, 1, 0);
            Text t12 = new Text("Marca: ");
            PanelComprador.add(t12, 1, 1);
            Text t13 = new Text("Modelo: ");
            PanelComprador.add(t13, 1, 2);
            Text t14 = new Text("Tipo Motor: ");
            PanelComprador.add(t14, 1, 3);
            PanelComprador.add(t3, 1, 4);
            Text t15 = new Text("Recorrido: ");
            PanelComprador.add(t15, 1, 5);
            Text t16 = new Text("Color: ");
            PanelComprador.add(t16, 4, 0);
            Text t17 = new Text("Tipo combustible: ");
            PanelComprador.add(t17, 4, 1);
            Text t18 = new Text("Vidrios: ");
            PanelComprador.add(t18, 4, 2);
            Text t19 = new Text("Transmisión: ");
            PanelComprador.add(t19, 4, 3);
            Text t10 = new Text("Tracción: ");
            PanelComprador.add(t10, 4, 4);
            PanelComprador.add(t4, 4, 5);
            Button br1 = new Button("BEFORE");
            br.prefWidth(90);
            br.prefHeight(45);
            br.setAlignment(Pos.CENTER_RIGHT);
            PanelComprador.add(br1, 6, 1);
            Button br2 = new Button("AFTER");
            br.prefWidth(90);
            br.prefHeight(45);
            br.setAlignment(Pos.CENTER_RIGHT);
            PanelComprador.add(br2, 6, 3);
            
            
            
        });
        
    }
    class CorreoException extends Exception{
        public CorreoException(String message) {
            super(message);
        }
        
    }

    
}

