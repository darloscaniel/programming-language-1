package org.example.classtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FrutaController {

    @FXML
    private Button btn_amadurecer;

    @FXML
    private Button btn_apodrecer;

    @FXML
    private Button btn_semear;

    @FXML
    private TextField txt_cor;

    @FXML
    private TextField txt_desc;

    @FXML
    private TextField txt_pais;

    // Validação para campos em branco
    private boolean validarCampos() {
        if (txt_cor.getText().isEmpty() || txt_desc.getText().isEmpty() || txt_pais.getText().isEmpty()) {
            mostrarAlerta("Erro", "Todos os campos devem ser preenchidos.");
            return false;
        }
        return true;
    }

    @FXML
    void amadurecerFruta(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Fruta Amadurecida", "A fruta amadureceu e está pronta para ser colhida!");
        }
    }

    @FXML
    void apodrecerFruta(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Fruta Apodrecida", "Infelizmente, a fruta apodreceu e não pode mais ser consumida.");
        }
    }

    @FXML
    void semear(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Fruta Semeada", "As sementes foram plantadas! Em breve, uma nova planta crescerá.");
        }
    }

    // Método utilitário para exibir os popups
    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
