package org.example.classtest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.classtest.dao.OculosDAO;
import org.example.classtest.models.Oculos;

import java.sql.SQLException;
import java.util.List;

public class OculosController {

    @FXML
    private Button btn_ajustar;

    @FXML
    private Button btn_limpar;

    @FXML
    private Button btn_trocar;

    @FXML
    private Button btn_cadastrar;

    @FXML
    private TextField txt_cor;

    @FXML
    private TextField txt_tipo;

    @FXML
    private TextField txt_material;

    @FXML
    private TableView<Oculos> tableOculos;

    @FXML
    private TableColumn<Oculos, String> colCor;

    @FXML
    private TableColumn<Oculos, String> colTipo;

    @FXML
    private TableColumn<Oculos, String> colMaterial;

    private final OculosDAO oculosDAO = new OculosDAO();
    private final ObservableList<Oculos> oculosList = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws SQLException {
        configurarTabela();
        carregarOculos();

        btn_cadastrar.setOnAction(event -> cadastrarOculos());
        btn_ajustar.setOnAction(event -> ajustarOculos());
        btn_limpar.setOnAction(event -> limparOculos());
        btn_trocar.setOnAction(event -> trocarLentes());
    }

    private void configurarTabela() {
        colCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colMaterial.setCellValueFactory(new PropertyValueFactory<>("material"));
        tableOculos.setItems(oculosList);
    }

    private void carregarOculos() throws SQLException {
        List<Oculos> oculos = oculosDAO.getOculos();
        oculosList.setAll(oculos);
    }

    @FXML
    private void cadastrarOculos() {
        String cor = txt_cor.getText();
        String tipo = txt_tipo.getText();
        String material = txt_material.getText();

        // Validação para campos em branco
        if (cor.isEmpty() || tipo.isEmpty() || material.isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos!", Alert.AlertType.ERROR);
            return;
        }

        // Criação do objeto Óculos e cadastro no banco de dados
        Oculos oculos = new Oculos(cor, tipo, material);
        oculosDAO.criarOculos(oculos.getCor(), oculos.getTipo(), oculos.getMaterial());
        mostrarAlerta("Sucesso", "Óculos cadastrados com sucesso!", Alert.AlertType.INFORMATION);

        try {
            carregarOculos();
        } catch (SQLException e) {
            mostrarAlerta("Erro", "Erro ao carregar os óculos.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void ajustarOculos() {
        Oculos oculosSelecionado = tableOculos.getSelectionModel().getSelectedItem();
        if (oculosSelecionado != null) {
            mostrarAlerta("Óculos Ajustados", "Seus óculos estão agora perfeitamente ajustados!", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione um óculos para ajustar.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void limparOculos() {
        Oculos oculosSelecionado = tableOculos.getSelectionModel().getSelectedItem();
        if (oculosSelecionado != null) {
            mostrarAlerta("Óculos Limpos", "Ótimo! Seus óculos estão limpos e prontos para uso.", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione um óculos para limpar.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void trocarLentes() {
        Oculos oculosSelecionado = tableOculos.getSelectionModel().getSelectedItem();
        if (oculosSelecionado != null) {
            mostrarAlerta("Lentes Trocadas", "As lentes foram trocadas com sucesso!", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione um óculos para trocar as lentes.", Alert.AlertType.ERROR);
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
