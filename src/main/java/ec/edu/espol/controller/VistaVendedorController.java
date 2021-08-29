/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Persona;
import ec.edu.espol.model.Vendedor;
import ec.edu.espol.proyectofinal.App;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class VistaVendedorController implements Initializable {
    @FXML
    private GridPane PanelVendedor;
    private ArrayList<Vendedor>vendedores=new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.vendedores=Vendedor.LeerVendedorInFile();

    }    

    @FXML
    private void RegresardesdeVendedor(MouseEvent event) {
        try {
            FXMLLoader fxmloader=App.LoadFXMLLoader("Principal");
            App.setRoot(fxmloader);
            PrincipalController p=fxmloader.getController();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void RegistrarNuevoUsuario(MouseEvent event) {
        PanelVendedor.getChildren().clear();
        Text t1=new Text("Nombre:");
        PanelVendedor.add(t1, 1, 0);
        TextField tf1=new TextField();
        PanelVendedor.add(tf1, 2, 0);
        Text t2=new Text("Apellido:");
        PanelVendedor.add(t2, 1, 1);
        TextField tf2=new TextField();
        PanelVendedor.add(tf2, 2, 1);
        Text t3=new Text("Organización:");
        PanelVendedor.add(t3, 1, 2);
        TextField tf3=new TextField();
        PanelVendedor.add(tf3, 2, 2);
        Text t4=new Text("Correo Electronico:");
        PanelVendedor.add(t4, 1, 3);
        TextField tf4=new TextField();
        PanelVendedor.add(tf4, 2, 3);
        Text t5=new Text("Contraseña:");
        PanelVendedor.add(t5, 1, 4);
        PasswordField pw=new PasswordField();
        PanelVendedor.add(pw, 2, 4);
        Button br=new Button("REGISTRAR");
        br.prefWidth(90);
        br.prefHeight(45);
        br.setAlignment(Pos.CENTER_RIGHT);
        PanelVendedor.add(br, 3, 2);
        br.setOnMouseClicked((MouseEvent e)->{
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
            pw.setText("");
            Alert a;
            if(tf1.getText()!=null && tf2.getText()!=null && tf3.getText()!=null && tf4.getText()!=null && pw.getText()!=null){
                String Nombre=tf1.getText();
                String Apellido=tf2.getText();
                String Correo=tf4.getText();
                String Organizacion=tf3.getText();
                String Clave=Persona.convertirSHA256(pw.getText());
                Vendedor v=new Vendedor(Nombre,Apellido,Correo,Organizacion,Clave);
                if(Vendedor.ComprobarVendedorInFile(v)==false && Persona.validarEmail(tf4.getText())==true){
                        this.vendedores.add(v);
                        Vendedor.RegistrarVendedorFile(this.vendedores);
                        a=new Alert(AlertType.CONFIRMATION,"Usuario guardado con exito");
                        a.show();
                }
                else{
                    a=new Alert(AlertType.WARNING,"Espacios en Blanco/correo invalido/ correo ya registrado");
                    a.show();
                }      
            }
        });
        
        
    }

    @FXML
    private void IngresoUsuario(MouseEvent event) {
    }

    @FXML
    private void AceptarOferta(MouseEvent event) {
    }
    class CorreoException extends Exception{
        public CorreoException(String message) {
            super(message);
        }
        
    }
}
