package org.example.classtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PassaroController {

    @FXML
    private Button btn_cantar;

    @FXML
    private Button btn_comer;

    @FXML
    private Button btn_voar;

    @FXML
    private TextField txt_cor;

    @FXML
    private TextField txt_desc;

    @FXML
    private TextField txt_especie;

    // Validação para campos em branco
    private boolean validarCampos() {
        if (txt_cor.getText().isEmpty() || txt_desc.getText().isEmpty() || txt_especie.getText().isEmpty()) {
            mostrarAlerta("Erro", "Todos os campos devem ser preenchidos.");
            return false;
        }
        return true;
    }

    @FXML
    void cantar(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Cantar", "O pássaro está cantando alegremente!");
        }
    }

    @FXML
    void comer(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Comer", "O pássaro está se alimentando.");
        }
    }

    @FXML
    void voar(ActionEvent event) {
        if (validarCampos()) {
            String especie = txt_especie.getText().toLowerCase();

            if (especie.equals("galinha")) {
                mostrarAlerta("Não Voa", "A galinha não voa!");
            } else {
                mostrarAlerta("Voar", "O pássaro está voando majestuosamente!");
            }
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
