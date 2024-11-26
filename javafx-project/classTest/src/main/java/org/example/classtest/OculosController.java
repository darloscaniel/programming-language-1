package org.example.classtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class OculosController {

    @FXML
    private Button btn_ajustar;

    @FXML
    private Button btn_limpar;

    @FXML
    private Button btn_trocar;

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
    void ajustarOculos(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Óculos Ajustados", "Seus óculos estão agora perfeitamente ajustados!");
        }
    }

    @FXML
    void limparOculos(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Óculos Limpos", "Ótimo! Seus óculos estão limpos e prontos para uso.");
        }
    }

    @FXML
    void trocarLentes(ActionEvent event) {
        if (validarCampos()) {
            mostrarAlerta("Lentes Trocadas", "As lentes foram trocadas com sucesso!");
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
