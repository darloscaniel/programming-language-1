package org.example.classtest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.classtest.dao.SapatoDAO;
import org.example.classtest.models.Caderno;
import org.example.classtest.models.Sapato;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SapatoController {

    @FXML
    private Button btn_amarrar;

    @FXML
    private Button btn_limpar;

    @FXML
    private Button btn_trocTamanho;

    @FXML
    private Button btn_cadastrar;

    @FXML
    private TextField txt_cor;

    @FXML
    private TextField txt_tamanho;

    @FXML
    private TextField txt_tipo;

    @FXML
    private TableView<Sapato> tableSapatos;

    @FXML
    private TableColumn<Sapato, String> colCor;

    @FXML
    private TableColumn<Sapato, Double> colTamanho;

    @FXML
    private TableColumn<Sapato, String> colTipo;

    private final SapatoDAO sapatoDAO = new SapatoDAO();
    private final ObservableList<Sapato> sapatosList = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws SQLException {
        configurarTabela();
        carregarSapatos();

        btn_cadastrar.setOnAction(event -> cadastrarSapato());
        btn_amarrar.setOnAction(event -> amarrar());
        btn_limpar.setOnAction(event -> limpar());
        btn_trocTamanho.setOnAction(event -> {
            try {
                trocarTamanho();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void configurarTabela() {
        colCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tableSapatos.setItems(sapatosList);
    }

    private void carregarSapatos() throws SQLException {
        List<Sapato> sapatos = sapatoDAO.getSapato();
        sapatosList.setAll(sapatos);
    }

    @FXML
    private void cadastrarSapato() {
        String cor = txt_cor.getText();
        String tipo = txt_tipo.getText();
        double tamanho = 0;

        try {
            tamanho = Double.parseDouble(txt_tamanho.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Erro", "O campo Tamanho deve ser um número válido.", Alert.AlertType.ERROR);
            return;
        }

        // Verifica se algum campo está vazio
        if (cor.isEmpty() || tipo.isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos!", Alert.AlertType.ERROR);
            return;
        }

        // Criação do objeto Sapato e cadastro no banco de dados
        Sapato sapato = new Sapato(tamanho, cor, tipo); // Exemplo de valores para marca e preço
        sapato.setId_sapato(sapatoDAO.criarSapato(sapato.getTamanho(), sapato.getCor(), sapato.getTipo()));
        mostrarAlerta("Sucesso", "Sapato cadastrado com sucesso!", Alert.AlertType.INFORMATION);

        try {
            carregarSapatos();
        } catch (SQLException e) {
            mostrarAlerta("Erro", "Erro ao carregar os sapatos.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void amarrar() {
        Sapato sapatoSelecionado = tableSapatos.getSelectionModel().getSelectedItem();
        if (sapatoSelecionado != null) {
            mostrarAlerta("Sapato Amarrado", "O sapato foi amarrado com sucesso!", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione um sapato para amarrar.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void limpar() {
        Sapato sapatoSelecionado = tableSapatos.getSelectionModel().getSelectedItem();
        if (sapatoSelecionado != null) {
            mostrarAlerta("Sapato Limpo", "O sapato foi limpo e está brilhando!", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione um sapato para limpar.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void trocarTamanho() throws IOException {
        Sapato sapatoselecionado = tableSapatos.getSelectionModel().getSelectedItem();
        System.out.println(sapatoselecionado.getId_sapato());
        if (sapatoselecionado == null) {
            mostrarAlerta("Erro", "Selecione um sapato para trocar tamanho.", Alert.AlertType.ERROR);
            return;
        }

        sapatoselecionado.getId_sapato();

        double novotamanho = Double.parseDouble(txt_tamanho.getText());

        try {
            novotamanho = Double.parseDouble(txt_tamanho.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Erro", "O campo Tamanho deve ser um número válido.", Alert.AlertType.ERROR);
            return;
        }

        sapatoDAO.atualizarTamanhoSapato(sapatoselecionado.getId_sapato(), novotamanho);
        mostrarAlerta("Sucesso", "Tamanho trocado!", Alert.AlertType.INFORMATION);

        try {
            carregarSapatos();
        } catch (SQLException e) {
            mostrarAlerta("Erro", "Erro ao carregar os sapatos.", Alert.AlertType.ERROR);
        }

    }

    // Método para mostrar os alertas
    private void mostrarAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
