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
import javafx.event.EventType;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ec.edu.espol.model.Mail;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class VistaVendedorController implements Initializable {
    @FXML
    private GridPane PanelVendedor;
    @FXML
    private HBox PanelBotones;
    ArrayList<Vendedor>Lista_Vendedores=new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Vendedor.cargarArchivo();
        this.Lista_Vendedores=Vendedor.LeerVendedorFile();
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
        br.setAlignment(Pos.BOTTOM_RIGHT);
        PanelVendedor.add(br, 3, 2);
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
                Vendedor v=new Vendedor(Nombre,Apellido,Correo,Organizacion,Clave);
                if(Persona.validarEmail(tf4.getText())==true && Vendedor.comprobarEstadoenLista(v,this.Lista_Vendedores)==false){
                    Mail.sendMail(Correo);    
                    this.Lista_Vendedores.add(v);
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
            Vendedor.RegistrarVendedorFile(this.Lista_Vendedores);
        });
        
        
    }

    @FXML
    private void IngresoUsuario(MouseEvent event) {
        PanelVendedor.getChildren().clear();
        try {
            FXMLLoader fxmloader=App.LoadFXMLLoader("VistaVehiculo");
            App.setRoot(fxmloader);
            //VistaVehiculoController vv=fxmloader.getController();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void AceptarOferta(MouseEvent event) {
        PanelVendedor.getChildren().clear();
        Text t1=new Text("Correo: ");
        Text t2=new Text("Contraseña: ");
        TextField tfUser=new TextField();
        PasswordField tfPsw=new PasswordField();
        Button b=new Button("Ingresar");
        PanelVendedor.add(t1,1,1);
        PanelVendedor.add(t2,1,2);
        PanelVendedor.add(tfUser,2,1);
        PanelVendedor.add(tfPsw,2,2);
        PanelVendedor.add(b,2,3);
        b.setOnMouseClicked((MouseEvent me)->{
            String correo=tfUser.getText();
            String contraseña_sinHash=tfPsw.getText();
            String contraseña=Persona.convertirSHA256(contraseña_sinHash);
            Alert a;
            if(!(tfUser.getText().isEmpty() || tfPsw.getText().isEmpty())){
                boolean cond=false;
                for(Vendedor v:this.Lista_Vendedores){
                    if(correo.contains(v.getCorreo()) && contraseña.contains(v.getClave())){
                        cond=true;
                    }
                }
                if(cond==true){
                    a=new Alert(AlertType.CONFIRMATION,"Bienvenido "+ correo);
                    a.show();
                    try {
                        FXMLLoader fxmloader=App.LoadFXMLLoader("VistaOfertas");
                        App.setRoot(fxmloader);
                        VistaOfertasController voc=fxmloader.getController();
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

    @FXML
    private void info(MouseEvent event) {
        PanelVendedor.getChildren().clear();
        Text t1=new Text("Correo: ");
        Text t2=new Text("Contraseña: ");
        TextField tfUser=new TextField();
        PasswordField tfPsw=new PasswordField();
        Button b=new Button("Ingresar");
        PanelVendedor.add(t1,1,1);
        PanelVendedor.add(t2,1,2);
        PanelVendedor.add(tfUser,2,1);
        PanelVendedor.add(tfPsw,2,2);
        PanelVendedor.add(b,2,3);
        b.setOnMouseClicked((MouseEvent me)->{
            String correo=tfUser.getText();
            String contraseña_sinHash=tfPsw.getText();
            String contraseña=Persona.convertirSHA256(contraseña_sinHash);
            Alert a;
            if(!(tfUser.getText().isEmpty() || tfPsw.getText().isEmpty())){
                boolean cond=false;
                for(Vendedor v:this.Lista_Vendedores){
                    if(correo.contains(v.getCorreo()) && contraseña.contains(v.getClave())){
                        cond=true;
                    }
                }
                if(cond==true){
                    a=new Alert(AlertType.CONFIRMATION,"Bienvenido "+ correo);
                    a.show();
                    PanelVendedor.getChildren().clear();
                    for(Vendedor v:this.Lista_Vendedores){
                        if(correo.contains(v.getCorreo()) && contraseña.contains(v.getClave())){
                            Text tn=new Text("Nombre: "+v.getNombres());
                            Text tn2=new Text("Apellido: "+v.getApellidos());
                            Text tn3=new Text("Correo: "+v.getCorreo());
                            Text tn4=new Text("Organizacion: "+v.getOrganizacion());
                            Text tn5=new Text("Cambiar Clave:");
                            PasswordField psold=new PasswordField();
                            PasswordField psnew=new PasswordField();
                            Button bn=new Button("CAMBIAR");
                            PanelVendedor.add(tn,0,0);
                            PanelVendedor.add(tn2,0,1);
                            PanelVendedor.add(tn3,0,2);
                            PanelVendedor.add(tn4,0,3);
                            PanelVendedor.add(tn5,0,4);
                            PanelVendedor.add(psold,1,4);
                            PanelVendedor.add(psnew,2,4);
                            PanelVendedor.add(bn,3,4);
                            bn.setOnMouseClicked((MouseEvent me2)->{
                                if(!(psold.getText().isEmpty() || psnew.getText().isEmpty())){
                                    if(Persona.convertirSHA256(psold.getText()).equals(v.getClave())){
                                        v.setClave(Persona.convertirSHA256(psnew.getText()));
                                        Alert e=new Alert(AlertType.CONFIRMATION,"Clave cambiada con exito");
                                        e.show();
                                        Vendedor.RegistrarVendedorFile(Lista_Vendedores);
                                    }
                                    else{
                                        Alert e=new Alert(AlertType.WARNING,"Contraseña incorrecta");
                                        e.show();
                                    }
                                    
                                }
                                else{
                                    Alert e=new Alert(AlertType.WARNING,"Campos vacios");
                                    e.show();
                                }
                            });
                    }
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
