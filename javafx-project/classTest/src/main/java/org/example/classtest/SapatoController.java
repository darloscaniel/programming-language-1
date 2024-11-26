package org.example.classtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SapatoController {

    @FXML
    private Button btn_amarrar;

    @FXML
    private Button btn_limpar;

    @FXML
    private Button btn_trocTamanho;

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
    void amarrar(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Amarrar", "O sapato foi amarrado com sucesso!");
        }
    }

    @FXML
    void limpar(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Limpar", "O sapato foi limpo e está brilhando!");
        }
    }

    @FXML
    void trocarTamanho(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Trocar Tamanho", "O tamanho do sapato foi trocado com sucesso!");
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
