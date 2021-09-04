/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Comprador;
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
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class VistaCompradorController implements Initializable {

    @FXML
    private GridPane PanelComprador;
    ArrayList<Comprador> Lista_Compradores = new ArrayList<>();
    public String correoComprador;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Comprador.cargarArchivo();
        this.Lista_Compradores=Comprador.LeerCompradorInFile();
    }

    public String getCorreoComprador() {
        return correoComprador;
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
        br.setLayoutX(450);
        br.setLayoutY(30);
        br.setOnMouseClicked((MouseEvent e)->{
            Alert a;
            if(!(tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty() || tf4.getText().isEmpty() || pw.getText().isEmpty())){
                String Nombre=tf1.getText();
                String Apellido=tf2.getText();
                String Correo=tf4.getText();
                String Organizacion=tf3.getText();
                String Clave=Persona.convertirSHA256(pw.getText());
                Comprador c = new Comprador(Nombre,Apellido,Correo,Organizacion,Clave);
                if(Persona.validarEmail(tf4.getText())==true && Comprador.comprobarEstadoenLista(c,this.Lista_Compradores)==false){
                        this.Lista_Compradores.add(c);
                        a=new Alert(AlertType.CONFIRMATION,"Usuario guardado con exito");
                        a.show();  
                }
                else{
                    a=new Alert(AlertType.WARNING,"formato correo erroneo/ correo ya registrado");
                    a.show();
                }
            }
            else{
               a=new Alert(AlertType.WARNING,"No deben haber campos vacios"); 
               a.show();
            }
            Comprador.RegistrarCompradorFile(this.Lista_Compradores);
        });
        
    }
    
    @FXML
    private void Ofertar(MouseEvent event) {
        PanelComprador.getChildren().clear();
        Text t1=new Text("Correo: ");
        Text t2=new Text("Contraseña: ");
        TextField tfUser=new TextField();
        PasswordField tfPsw=new PasswordField();
        Button b=new Button("Ingresar");
        PanelComprador.add(t1,1,1);
        PanelComprador.add(t2,1,2);
        PanelComprador.add(tfUser,2,1);
        PanelComprador.add(tfPsw,2,2);
        PanelComprador.add(b,2,3);
        b.setOnMouseClicked((MouseEvent me)->{
            String correo=tfUser.getText();
            String contraseña_sinHash=tfPsw.getText();
            String contraseña=Persona.convertirSHA256(contraseña_sinHash);
            Alert a;
            if(!(tfUser.getText().isEmpty() || tfPsw.getText().isEmpty())){
                boolean cond=false;
                for(Comprador c:this.Lista_Compradores){
                    if(correo.contains(c.getCorreo()) && contraseña.contains(c.getClave())){
                        cond=true;
                    }
                }
                if(cond==true){
                    this.correoComprador=correo;
                    a=new Alert(AlertType.CONFIRMATION,"Bienvenido "+ correo);
                    a.show();
                    
                    try {
                        FXMLLoader fxmloader=App.LoadFXMLLoader("VistaOfertarComprador");
                        App.setRoot(fxmloader);
                        VistaOfertarCompradorController voc=fxmloader.getController();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } 
                }
                else{
                    a=new Alert(AlertType.ERROR,"El correo no se encuentra registrado o introdujo datos erroneos");
                    a.show();
                }
            }
            else{
                a=new Alert(AlertType.WARNING,"Existen campos en blanco");
                a.show();
            }

        });
    }    
}

