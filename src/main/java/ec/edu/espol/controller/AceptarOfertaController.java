/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Comprador;
import ec.edu.espol.proyectofinal.App;
import ec.edu.espol.model.Oferta;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AceptarOfertaController extends VistaOfertarCompradorController implements Initializable {

    @FXML
    private TextField TextoMonto;
    ArrayList<Comprador>compradores=new ArrayList<>();
    ArrayList<Oferta>ofertas = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.compradores=Comprador.LeerCompradorInFile();
        //this.ofertas = Oferta.LeerOfertaFile();
    }    

    @FXML
    private void AceptarOferta(MouseEvent event) {
        double oferta=Double.parseDouble(TextoMonto.getText());
        String correo=this.correoComprador;
        //FALTA MATRICULA O CORREO DEL VENDEDOR
        if(!(TextoMonto.getText().isEmpty() )){
            String monto = TextoMonto.getText();
            if (monto.matches("[0-10000000000]*")) {
                Alert a = new Alert(AlertType.CONFIRMATION, "Oferta registrada");
                a.show();
            } 
            else {
                Alert a=new Alert(AlertType.WARNING,"formato precio erroneo/ No numérico");
                a.show();
            }
        }
        else{
            Alert a = new Alert(AlertType.WARNING,"ERROR, No ha realizado una oferta");
        }
        Oferta.RegistrarOfertaFile(ofertas);
        
    }

    @FXML
    private void Cancelar(MouseEvent event) {
        try {
            FXMLLoader fxmloader=App.LoadFXMLLoader("VistaOfertarComprador");
            App.setRoot(fxmloader);
            VistaOfertarCompradorController p=fxmloader.getController();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
