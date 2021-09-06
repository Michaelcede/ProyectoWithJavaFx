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
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class RegistroAmbosController implements Initializable {

    @FXML
    private TextField TFNombre;
    @FXML
    private TextField TFApellido;
    @FXML
    private TextField TFOrganizacion;
    @FXML
    private TextField TFCorreo;
    ArrayList<Comprador> Lista_Compradores = new ArrayList<>();
    ArrayList<Vendedor>Lista_Vendedores=new ArrayList<>();
    @FXML
    private PasswordField PFClave;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.Lista_Vendedores=Vendedor.LeerVendedorFile();
        this.Lista_Compradores=Comprador.LeerCompradorInFile();
    }    

    @FXML
    private void Regresar(MouseEvent event) {
        try {
            FXMLLoader fxmloader=App.LoadFXMLLoader("Principal");
            App.setRoot(fxmloader);
            PrincipalController p=fxmloader.getController();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void Guardar(MouseEvent event) {
        Alert a;
            if(!(TFNombre.getText().isEmpty() || TFApellido.getText().isEmpty() || TFCorreo.getText().isEmpty() || TFOrganizacion.getText().isEmpty() || PFClave.getText().isEmpty())){
                String Nombre=TFNombre.getText();
                String Apellido=TFApellido.getText();
                String Correo=TFCorreo.getText();
                String Organizacion=TFOrganizacion.getText();
                String Clave=Persona.convertirSHA256(PFClave.getText());
                Vendedor v = new Vendedor(Nombre,Apellido,Correo,Organizacion,Clave);
                Comprador c = new Comprador(Nombre,Apellido,Correo,Organizacion,Clave);
                if(Persona.validarEmail(TFCorreo.getText())==true && Comprador.comprobarEstadoenLista(c,this.Lista_Compradores)==false && Vendedor.comprobarEstadoenLista(v,this.Lista_Vendedores)==false){
                        this.Lista_Compradores.add(c);
                        this.Lista_Vendedores.add(v);
                        a=new Alert(Alert.AlertType.CONFIRMATION,"Usuario guardado con exito");
                        a.show();  
                }
                else{
                    a=new Alert(Alert.AlertType.WARNING,"formato correo erroneo/ correo ya registrado");
                    a.show();
                }
            }
            else{
               a=new Alert(Alert.AlertType.WARNING,"No deben haber campos vacios"); 
               a.show();
            }
            Comprador.RegistrarCompradorFile(this.Lista_Compradores);
            Vendedor.RegistrarVendedorFile(this.Lista_Vendedores);
    }
    
}
