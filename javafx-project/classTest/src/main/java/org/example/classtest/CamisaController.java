package org.example.classtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CamisaController {

    @FXML
    private Button btn_lavar;

    @FXML
    private Button btn_tirar;

    @FXML
    private Button btn_vestir;

    @FXML
    private TextField txt_cor;

    @FXML
    private TextField txt_tamanho;

    @FXML
    private TextField txt_tipo;

    // Método para lavar a camisa
    @FXML
    void lavarCamisa(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Lavagem", "A camisa de cor " + txt_cor.getText() + " foi lavada.");
        }
    }

    // Método para tirar a camisa
    @FXML
    void tirarCamisa(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Remover", "A camisa de tipo " + txt_tipo.getText() + " foi removida.");
        }
    }

    // Método para vestir a camisa
    @FXML
    void vestirCamisa(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Vestir", "Você vestiu a camisa de tamanho " + txt_tamanho.getText() + ".");
        }
    }

    // Validação para garantir que nenhum campo esteja vazio
    private boolean validarCampos() {
        if (txt_cor.getText().isEmpty() || txt_tamanho.getText().isEmpty() || txt_tipo.getText().isEmpty()) {
            mostrarAlerta("Erro", "Por favor, preencha todos os campos.");
            return false;
        }
        return true;
    }

    // Método utilitário para mostrar popups
    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}

