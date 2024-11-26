package org.example.classtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FlorController {

    @FXML
    private Button btn_florescer;

    @FXML
    private Button btn_prodOX;

    @FXML
    private Button btn_prodPolen;

    @FXML
    private TextField txt_cor;

    @FXML
    private TextField txt_desc;

    @FXML
    private TextField txt_pais;

    // Método para fazer a flor florescer
    @FXML
    void florescer(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Florescer", "A flor desabrochou lindamente, espalhando sua cor " + txt_cor.getText() + " pelo jardim!");
        }
    }

    // Método para produzir oxigênio
    @FXML
    void produzirOX(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Produzir Oxigênio", "A flor está produzindo oxigênio puro! Respire fundo e aproveite o frescor.");
        }
    }

    // Método para produzir pólen
    @FXML
    void ProdPolen(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Produzir Pólen", "A flor produziu pólen em abundância! Os insetos estão prontos para polinizar.");
        }
    }

    // Método para validar se os campos estão preenchidos
    private boolean validarCampos() {
        if (txt_cor.getText().isEmpty() || txt_desc.getText().isEmpty() || txt_pais.getText().isEmpty()) {
            mostrarAlerta("Erro", "Todos os campos devem estar preenchidos.");
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

