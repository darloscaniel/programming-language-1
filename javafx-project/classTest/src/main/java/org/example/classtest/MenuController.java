package org.example.classtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuController {

    @FXML
    private Button btn_bandeira;

    @FXML
    private Button btn_caderno;

    @FXML
    private Button btn_camisa;

    @FXML
    private Button btn_carro;

    @FXML
    private Button btn_flor;

    @FXML
    private Button btn_fruta;

    @FXML
    private Button btn_mamifero;

    @FXML
    private Button btn_oculos;

    @FXML
    private Button btn_passaro;

    @FXML
    private Button btn_sapato;

    @FXML
    public void openWindow(String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btn_bandeira) {
            openWindow("bandeiraView.fxml");
        } else if (event.getSource() == btn_caderno) {
            openWindow("cadernoView.fxml");
        } else if (event.getSource() == btn_camisa) {
            openWindow("camisaView.fxml");
        }else if (event.getSource() == btn_carro) {
            openWindow("carroView.fxml");
        }else if (event.getSource() == btn_flor) {
            openWindow("florView.fxml");
        }else if (event.getSource() == btn_fruta) {
            openWindow("frutaView.fxml");
        }else if (event.getSource() == btn_mamifero) {
            openWindow("mamiferoView.fxml");
        }else if (event.getSource() == btn_oculos) {
            openWindow("oculosView.fxml");
        }else if (event.getSource() == btn_passaro) {
            openWindow("passaroView.fxml");
        }else if (event.getSource() == btn_sapato) {
            openWindow("sapatoView.fxml");
        }
    }


}

