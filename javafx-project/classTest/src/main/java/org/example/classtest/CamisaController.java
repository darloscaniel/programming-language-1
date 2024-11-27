package org.example.classtest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.classtest.models.Camisa;
import org.example.classtest.dao.CamisaDAO;

import java.sql.SQLException;
import java.util.List;

public class CamisaController {

    @FXML
    private TextField txt_cor;

    @FXML
    private TextField txt_tamanho;

    @FXML
    private TextField txt_tipo;

    @FXML
    private Button btn_lavar;

    @FXML
    private Button btn_tirar;

    @FXML
    private Button btn_vestir;

    @FXML
    private Button btn_cadastrar;

    @FXML
    private TableView<Camisa> tableCamisas;

    @FXML
    private TableColumn<Camisa, String> colTamanho;

    @FXML
    private TableColumn<Camisa, String> colCor;

    @FXML
    private TableColumn<Camisa, String> colTipo;

    private final CamisaDAO camisaDAO = new CamisaDAO();
    private final ObservableList<Camisa> camisasList = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws SQLException {
        configurarTabela();
        carregarCamisas();

        btn_cadastrar.setOnAction(event -> cadastrarCamisa());
        btn_lavar.setOnAction(event -> lavarCamisa());
        btn_tirar.setOnAction(event -> tirarCamisa());
        btn_vestir.setOnAction(event -> vestirCamisa());
    }

    private void configurarTabela() {
        colTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        colCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tableCamisas.setItems(camisasList);
    }

    private void carregarCamisas() throws SQLException {
        List<Camisa> camisas = camisaDAO.getCamisa();
        camisasList.setAll(camisas);
    }

    private void cadastrarCamisa() {
        String tamanho = txt_tamanho.getText();
        String cor = txt_cor.getText();
        String tipo = txt_tipo.getText();

        if (tamanho.isEmpty() || cor.isEmpty() || tipo.isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos!", Alert.AlertType.ERROR);
            return;
        }

        if (camisaDAO.isEntityCadastrada("cor", cor)) {
            mostrarAlerta("Erro", "Uma camisa com essa cor já foi cadastrada.", Alert.AlertType.ERROR);
            return;
        }

        Camisa camisa = new Camisa(tamanho, cor, tipo, -1);
        camisaDAO.criarCamisa(tamanho, cor, tipo);
        camisasList.add(camisa);
        mostrarAlerta("Sucesso", "Camisa cadastrada com sucesso!", Alert.AlertType.INFORMATION);
    }

    @FXML
    private void lavarCamisa() {
        Camisa camisaSelecionada = tableCamisas.getSelectionModel().getSelectedItem();
        if (camisaSelecionada != null) {
            mostrarAlerta("Lavagem", "A camisa de cor " + camisaSelecionada.getCor() + " foi lavada.", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione uma camisa para lavar.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void tirarCamisa() {
        Camisa camisaSelecionada = tableCamisas.getSelectionModel().getSelectedItem();
        if (camisaSelecionada != null) {
            mostrarAlerta("Remover", "A camisa de tipo " + camisaSelecionada.getTipo() + " foi removida.", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione uma camisa para remover.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void vestirCamisa() {
        Camisa camisaSelecionada = tableCamisas.getSelectionModel().getSelectedItem();
        if (camisaSelecionada != null) {
            mostrarAlerta("Vestir", "Você vestiu a camisa de tamanho " + camisaSelecionada.getTamanho() + ".", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione uma camisa para vestir.", Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
