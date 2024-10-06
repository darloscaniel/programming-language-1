package org.example.classtest;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.classtest.models.Caderno;

public class CadernoController {

    @FXML
    private TextField txt_cor;
    @FXML
    private TextField txt_pagina;
    @FXML
    private TextField txt_escrever;
    @FXML
    private Button btn_escrever;
    @FXML
    private Button btn_remover;
    @FXML
    private Button btn_fechar;

    private Caderno caderno;

    // Método chamado ao inicializar o controlador
    @FXML
    public void initialize() {
        // Adicionando filtro para aceitar apenas números no campo de páginas
        txt_pagina.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txt_pagina.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    private boolean inicializarCaderno() {
        String cor = txt_cor.getText();
        String paginasText = txt_pagina.getText();

        if (cor.isEmpty() || paginasText.isEmpty()) {
            mostrarAlerta("Erro", "Preencha a cor e o número de páginas.");
            return false;
        }

        try {
            int paginas = Integer.parseInt(paginasText);
            caderno = new Caderno(cor, paginas);
            return true;
        } catch (NumberFormatException e) {
            mostrarAlerta("Erro", "Por favor, insira um número válido para páginas.");
            return false;
        }
    }

    @FXML
    public void escreverNoCaderno() {
        if (caderno == null && !inicializarCaderno()) {
            return;
        }

        String texto = txt_escrever.getText();
        if (texto.isEmpty()) {
            mostrarAlerta("Erro", "Por favor, insira algum texto para escrever no caderno.");
        } else {
            caderno.escrever(texto);
            mostrarAlerta("Sucesso", "Texto adicionado ao caderno.");
        }
    }

    @FXML
    public void removerPagina() {
        if (caderno == null && !inicializarCaderno()) {
            return;
        }

        if (caderno.getPaginas() > 0) {
            boolean sucesso = caderno.removerPagina();
            if (sucesso) {
                mostrarAlerta("Sucesso", "Uma página foi removida.");
                txt_pagina.setText(String.valueOf(caderno.getPaginas()));
            } else {
                mostrarAlerta("Erro", "Não há páginas suficientes para remover.");
            }
        } else {
            mostrarAlerta("Erro", "O caderno já está vazio.");
        }
    }


    @FXML
    public void fecharJanela() {
        Stage stage = (Stage) btn_fechar.getScene().getWindow();
        stage.close(); // Fecha a janela
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
