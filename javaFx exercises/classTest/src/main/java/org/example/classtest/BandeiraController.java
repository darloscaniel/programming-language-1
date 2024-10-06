package org.example.classtest;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.classtest.models.Bandeira;

public class BandeiraController {

    @FXML
    private TextField txt_pais;

    @FXML
    private TextField txt_cor;

    @FXML
    private TextField txt_desc;

    @FXML
    private Button btn_balancar;

    @FXML
    private Button btn_desc;

    @FXML
    private Button btn_curiosidade;

    private Bandeira bandeira;

    @FXML
    public void initialize() {
        // Cria a bandeira ao clicar nos botões, com as informações fornecidas nos campos de texto
        btn_balancar.setOnAction(event -> balancarBandeira());
        btn_desc.setOnAction(event -> mostrarDescricao());
        btn_curiosidade.setOnAction(event -> mostrarCuriosidade());
    }

    // Método para mostrar a curiosidade (tamanho padrão da bandeira)
    private void mostrarCuriosidade() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Curiosidade");
        alert.setHeaderText(null);
        alert.setContentText("O tamanho padrão de uma bandeira nacional é 1,20m por 0,80m.");
        alert.showAndWait();
    }

    // Método para mostrar a descrição da bandeira
    private void mostrarDescricao() {
        if (criarBandeira()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Descrição da Bandeira");
            alert.setHeaderText(null);
            alert.setContentText(bandeira.mostrarDescricao());
            alert.showAndWait();
        }
    }

    // Método para balançar a bandeira
    @FXML
    private void balancarBandeira() {
        if (criarBandeira()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bandeira");
            alert.setHeaderText(null);
            alert.setContentText(bandeira.balancar());
            alert.showAndWait();
        }
    }

    // Método para criar a bandeira usando as informações dos TextFields
    private boolean criarBandeira() {
        String pais = txt_pais.getText();
        String cor = txt_cor.getText();
        String descricao = txt_desc.getText();

        if (pais.isEmpty() || cor.isEmpty() || descricao.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Preencha todos os campos!");
            alert.showAndWait();
            return false;
        }

        bandeira = new Bandeira(pais, cor, descricao);
        return true;
    }
}
