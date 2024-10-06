package org.example.classtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MamiferoController {

    @FXML
    private Button btn_comer;

    @FXML
    private Button btn_dormir;

    @FXML
    private Button btn_envelhecer;

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
    void comer(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Mamífero Alimentado", "O mamífero se alimentou e agora está satisfeito!");
        }
    }

    @FXML
    void dormir(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Mamífero Dormindo", "O mamífero está dormindo tranquilamente. Zzz...");
        }
    }

    @FXML
    void envelhecer(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Mamífero Envelhecendo", "O mamífero está envelhecendo com graça e sabedoria.");
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
