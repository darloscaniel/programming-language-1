package org.example.classtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CarroController {

    @FXML
    private Button btn_acelerar;

    @FXML
    private Button btn_freiar;

    @FXML
    private Button btn_ligar;

    @FXML
    private TextField txt_cor;

    @FXML
    private TextField txt_desc;

    @FXML
    private TextField txt_pais;

    @FXML
    private TextField txt_pais1;

    @FXML
    void AcelerarCarro(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Ação", "VRUM VRUM !!!!!!!!!!!!!!!");
        }
    }

    @FXML
    void FreiarCarro(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Ação", "CUIDADO RAPAZ!!");
        }
    }

    @FXML
    void LigarCarro(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Ação", "O carro foi ligado.");
        }
    }

    // Método para validar se todos os campos estão preenchidos
    private boolean validarCampos() {
        if (txt_cor.getText().isEmpty() || txt_desc.getText().isEmpty() ||
                txt_pais.getText().isEmpty() || txt_pais1.getText().isEmpty()) {
            mostrarAlerta("Erro", "Todos os campos devem ser preenchidos.");
            return false;
        }
        return true;
    }

    // Método para exibir popups
    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
