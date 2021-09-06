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
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class VistaOfertarCompradorController extends VistaCompradorController implements Initializable {

    @FXML
    private VBox VBoxOfertas;
    @FXML
    private TextField tipoVehiculoTF;
    @FXML
    private TextField RecorrioIniTF;
    @FXML
    private TextField RecorrioFinTF;
    @FXML
    private TextField AnioIniTF;
    @FXML
    private TextField AnioFinTF;
    @FXML
    private TextField PrecioIniTF;
    @FXML
    private TextField PrecioFinTF;
    
    private ArrayList<Vehiculo>vehiculos=new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Vehiculo.cargarArchivo();
        this.vehiculos=Vehiculo.LeerVehiculosFile();
        this.vehiculos.remove(0);
        this.vehiculos.sort((Vehiculo v1,Vehiculo v2)->{
            return Double.compare(v2.getPrecio(),v1.getPrecio());
        });
    }    

    @FXML
 private void BuscarOferta(MouseEvent event) {
        VBoxOfertas.getChildren().clear();
        if(tipoVehiculoTF.getText().isEmpty() || RecorrioIniTF.getText().isEmpty() || RecorrioFinTF.getText().isEmpty() || AnioIniTF.getText().isEmpty() || AnioFinTF.getText().isEmpty() || PrecioIniTF.getText().isEmpty() || PrecioFinTF.getText().isEmpty()){
           for(Vehiculo v:this.vehiculos){
                   Text t=new Text(v.toString());
                   t.setTextAlignment(TextAlignment.JUSTIFY);
                   t.setWrappingWidth(300);
                   VBoxOfertas.getChildren().add(t);
                   Button b=new Button("OFERTAR");
                    b.setOnMouseClicked((MouseEvent e)->{
                        try {
                            FXMLLoader fxmloader=App.LoadFXMLLoader("AceptarOferta");
                            App.setRoot(fxmloader);
                            AceptarOfertaController p=fxmloader.getController();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });                   
                   VBoxOfertas.getChildren().add(b);
           }     
        }
        else if(!(tipoVehiculoTF.getText().isEmpty() && RecorrioIniTF.getText().isEmpty() && RecorrioFinTF.getText().isEmpty() && AnioIniTF.getText().isEmpty() && AnioFinTF.getText().isEmpty() && PrecioIniTF.getText().isEmpty() && PrecioFinTF.getText().isEmpty())){
            String tipo_vehiculo=tipoVehiculoTF.getText();
            double recorridoIni=Double.parseDouble(RecorrioIniTF.getText());
            double recorridoFin=Double.parseDouble(RecorrioFinTF.getText());
            int añoIni=Integer.parseInt(AnioIniTF.getText());
            int añoFin=Integer.parseInt(AnioFinTF.getText());
            double precioIni=Double.parseDouble(PrecioIniTF.getText());
            double precioFin=Double.parseDouble(PrecioFinTF.getText());
            for(Vehiculo v:this.vehiculos){
                if(tipo_vehiculo.equals(v.getTipo()) && v.getRecorrido()<=recorridoFin && v.getRecorrido()>=recorridoIni && v.getAño()<=añoFin && v.getAño()>=añoIni && v.getPrecio()<=precioFin && v.getPrecio()>=precioIni){
                    Text t=new Text(v.toString());
                    t.setTextAlignment(TextAlignment.JUSTIFY);
                    t.setWrappingWidth(300);
                    VBoxOfertas.getChildren().add(t);
                    Button b=new Button("OFERTAR");
                    b.setOnMouseClicked((MouseEvent e)->{
                        try {
                            FXMLLoader fxmloader=App.LoadFXMLLoader("AceptarOferta");
                            App.setRoot(fxmloader);
                            AceptarOfertaController p=fxmloader.getController();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
                    VBoxOfertas.getChildren().add(b);
                }
            }
        }
    }
    @FXML
    private void RegresaraComprador(MouseEvent event) {
        try {
            FXMLLoader fxmloader=App.LoadFXMLLoader("Principal");
            App.setRoot(fxmloader);
            PrincipalController p=fxmloader.getController();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
