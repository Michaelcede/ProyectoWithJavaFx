/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.proyectofinal.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class PrincipalController implements Initializable {

    @FXML
    private Button botonVendedor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void irMenuVendedor(MouseEvent event) {
        try {
            FXMLLoader fxmloader=App.LoadFXMLLoader("VistaVendedor");
            App.setRoot(fxmloader);
            VistaVendedorController vvc=fxmloader.getController();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    @FXML
    private void irMenuComprador(MouseEvent event) {
        try {
            FXMLLoader fxmloader=App.LoadFXMLLoader("VistaComprador");
            App.setRoot(fxmloader);
            VistaCompradorController vcc=fxmloader.getController();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void Salir(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void RegistrarAmbos(MouseEvent event) {
        try {
            FXMLLoader fxmloader=App.LoadFXMLLoader("RegistroAmbos");
            App.setRoot(fxmloader);
            RegistroAmbosController vcc=fxmloader.getController();
        } catch (IOException ex) {
            ex.printStackTrace();
        }                
                
    }
    
}
