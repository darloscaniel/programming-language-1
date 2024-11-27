package org.example.classtest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.classtest.dao.FlorDAO;
import org.example.classtest.models.Flor;

import java.sql.SQLException;
import java.util.List;

public class FlorController {

    @FXML
    private Button btn_florescer;

    @FXML
    private Button btn_prodOX;

    @FXML
    private Button btn_prodPolen;

    @FXML
    private Button btn_cadastrar;

    @FXML
    private TextField txt_cor;

    @FXML
    private TextField txt_tamanho;

    @FXML
    private TextField txt_especie;

    @FXML
    private TableView<Flor> tableFlores;

    @FXML
    private TableColumn<Flor, String> colCor;

    @FXML
    private TableColumn<Flor, String> colEspecie;

    @FXML
    private TableColumn<Flor, Double> colTamanho;

    private final FlorDAO florDAO = new FlorDAO();
    private final ObservableList<Flor> floresList = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws SQLException {
        configurarTabela();
        carregarFlores();

        btn_cadastrar.setOnAction(event -> cadastrarFlor());
        btn_florescer.setOnAction(event -> florescer());
        btn_prodOX.setOnAction(event -> produzirOX());
        btn_prodPolen.setOnAction(event -> prodPolen());
    }

    private void configurarTabela() {

        colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
        colCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        tableFlores.setItems(floresList);
    }

    private void carregarFlores() throws SQLException {
        List<Flor> flores = florDAO.getFlor();
        floresList.setAll(flores);
    }

    @FXML
    private void cadastrarFlor() {
        String cor = txt_cor.getText();
        String especie = txt_especie.getText();
        double tamanho = 0;

        // Verifica se o campo de tamanho contém um valor numérico válido
        try {
            tamanho = Double.parseDouble(txt_tamanho.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Erro", "O campo Tamanho deve ser um número válido.", Alert.AlertType.ERROR);
            return;
        }

        // Verifica se algum campo está vazio
        if (cor.isEmpty() || especie.isEmpty() || txt_tamanho.getText().isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos!", Alert.AlertType.ERROR);
            return;
        }

        // Agora você pode continuar com o processo de cadastro
        Flor flor = new Flor(especie, cor, tamanho);
        florDAO.criarFlor(flor.getEspecie(), flor.getCor(), flor.getTamanho());
        mostrarAlerta("Sucesso", "Flor cadastrada com sucesso!", Alert.AlertType.INFORMATION);

        try {
            carregarFlores();
        } catch (SQLException e) {
            mostrarAlerta("Erro", "Erro ao carregar as flores.", Alert.AlertType.ERROR);
        }
    }


    @FXML
    private void florescer() {
        Flor florSelecionada = tableFlores.getSelectionModel().getSelectedItem();
        if (florSelecionada != null) {
            mostrarAlerta("Florescer", "A flor desabrochou lindamente, espalhando sua cor " + florSelecionada.getCor() + " pelo jardim!", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione uma flor para florescer.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void produzirOX() {
        Flor florSelecionada = tableFlores.getSelectionModel().getSelectedItem();
        if (florSelecionada != null) {
            mostrarAlerta("Produzir Oxigênio", "A flor está produzindo oxigênio puro! Respire fundo e aproveite o frescor.", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione uma flor para produzir oxigênio.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void prodPolen() {
        Flor florSelecionada = tableFlores.getSelectionModel().getSelectedItem();
        if (florSelecionada != null) {
            mostrarAlerta("Produzir Pólen", "A flor produziu pólen em abundância! Os insetos estão prontos para polinizar.", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione uma flor para produzir pólen.", Alert.AlertType.ERROR);
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
