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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class VistaOfertasController implements Initializable {

    @FXML
    private TextField TextoMatricula;
    @FXML
    private VBox VBoxOfertas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Consultar(MouseEvent event) {
        
    }

    @FXML
    private void RegresaraVendedor(MouseEvent event) {
        try {
            FXMLLoader fxmloader=App.LoadFXMLLoader("VistaVendedor");
            App.setRoot(fxmloader);
            VistaVendedorController vvc=fxmloader.getController();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
