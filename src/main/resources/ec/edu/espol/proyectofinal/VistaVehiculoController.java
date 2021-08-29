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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author micha
 */
public class VistaVehiculoController implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private Button bIngresar;
    @FXML
    private PasswordField pwContraseña;
    @FXML
    private GridPane PanelVehiculos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void IngresarVehiculo(MouseEvent event) {
        PanelVehiculos.getChildren().clear();
        Text t0= new Text ("Ingrese el tipo de Vehiculo:");
        PanelVehiculos.add(t0,0,0);
        TextField tf0=new TextField();
        PanelVehiculos.add(tf0, 1, 0);
        tf0.setOnKeyPressed((KeyEvent e)->{
                if((e.getCode() == KeyCode.ENTER)){
                    Text t1=new Text("Placa:");
                    PanelVehiculos.add(t1, 0, 1);
                    TextField tf1=new TextField();
                    PanelVehiculos.add(tf1, 1, 1);
                    Text t2=new Text("Marca:");
                    PanelVehiculos.add(t2, 0, 2);
                    TextField tf2=new TextField();
                    PanelVehiculos.add(tf2, 1, 2);
                    Text t3=new Text("Modelo:");
                    PanelVehiculos.add(t3, 0, 3);
                    TextField tf3=new TextField();
                    PanelVehiculos.add(tf3, 1, 3);
                    Text t4=new Text("Tipo de Motor:");
                    PanelVehiculos.add(t4, 0, 4);
                    TextField tf4=new TextField();
                    PanelVehiculos.add(tf4, 1, 4);
                    Text t5=new Text("Año:");
                    PanelVehiculos.add(t5, 0, 5);
                    TextField tf5=new TextField();
                    PanelVehiculos.add(tf5, 1, 5);
                    Text t6=new Text("Recorrido:");
                    PanelVehiculos.add(t6, 0, 6);
                    TextField tf6=new TextField();
                    PanelVehiculos.add(tf6, 1, 6);
                    Text t7=new Text("Color:");
                    PanelVehiculos.add(t7, 0, 7);
                    TextField tf7=new TextField();
                    PanelVehiculos.add(tf7, 1, 7);
                    Text t8=new Text("Tipo de Combustible:");
                    PanelVehiculos.add(t8, 0, 8);
                    TextField tf8=new TextField();
                    PanelVehiculos.add(tf8, 1, 8);
                    Text t9=new Text("Precio:");
                    PanelVehiculos.add(t9, 0, 9);
                    TextField tf9=new TextField();
                    PanelVehiculos.add(tf9, 1, 9);
                    Text t10=new Text("Vidrios:");
                    PanelVehiculos.add(t10, 0, 10);
                    TextField tf10=new TextField();
                    PanelVehiculos.add(tf10, 1, 10);
                    Text t11=new Text("Transmision:");
                    PanelVehiculos.add(t11, 0, 11);
                    TextField tf11=new TextField();
                    PanelVehiculos.add(tf11, 1, 11);
                    Text t12=new Text("Traccion:");
                    PanelVehiculos.add(t12, 0, 12);
                    TextField tf12=new TextField();
                    PanelVehiculos.add(tf12, 1, 12);
                    Text t13=new Text("Precio:");
                    PanelVehiculos.add(t13, 0, 13);
                    TextField tf13=new TextField();
                    PanelVehiculos.add(tf13, 1, 13);
                }
        
                }
                
                );
       
        
        
    }
    
}
