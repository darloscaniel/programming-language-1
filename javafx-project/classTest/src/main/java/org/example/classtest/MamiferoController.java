package org.example.classtest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.classtest.dao.MamiferoDAO;
import org.example.classtest.models.Mamifero;

import java.sql.SQLException;
import java.util.List;

public class MamiferoController {

    @FXML
    private Button btn_comer;

    @FXML
    private Button btn_dormir;

    @FXML
    private Button btn_envelhecer;

    @FXML
    private Button btn_cadastrar;

    @FXML
    private TextField txt_especie;

    @FXML
    private TextField txt_tamanho;

    @FXML
    private TextField txt_habitat;

    @FXML
    private TableView<Mamifero> tableMamiferos;

    @FXML
    private TableColumn<Mamifero, String> colEspecie;

    @FXML
    private TableColumn<Mamifero, Double> colTamanho;

    @FXML
    private TableColumn<Mamifero, String> colHabitat;

    private final MamiferoDAO mamiferoDAO = new MamiferoDAO();
    private final ObservableList<Mamifero> mamiferosList = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws SQLException {
        configurarTabela();
        carregarMamiferos();

        btn_cadastrar.setOnAction(event -> cadastrarMamifero());
        btn_comer.setOnAction(event -> comer());
        btn_dormir.setOnAction(event -> dormir());
        btn_envelhecer.setOnAction(event -> envelhecer());
    }

    private void configurarTabela() {
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
        colTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        colHabitat.setCellValueFactory(new PropertyValueFactory<>("habitat"));
        tableMamiferos.setItems(mamiferosList);
    }

    private void carregarMamiferos() throws SQLException {
        List<Mamifero> mamiferos = mamiferoDAO.getMamifero();
        mamiferosList.setAll(mamiferos);
    }

    @FXML
    private void cadastrarMamifero() {
        String especie = txt_especie.getText();
        String habitat = txt_habitat.getText();
        double tamanho = 0;

        try {
            tamanho = Double.parseDouble(txt_tamanho.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Erro", "O campo Tamanho deve ser um número válido.", Alert.AlertType.ERROR);
            return;
        }

        // Verifica se algum campo está vazio
        if (especie.isEmpty()  || habitat.isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos!", Alert.AlertType.ERROR);
            return;
        }

        // Criação do objeto Mamífero e cadastro no banco de dados
        Mamifero mamifero = new Mamifero(especie, habitat, tamanho);
        mamiferoDAO.criarMamifero(mamifero.getEspecie(), mamifero.getHabitat(), mamifero.getTamanho());
        mostrarAlerta("Sucesso", "Mamífero cadastrado com sucesso!", Alert.AlertType.INFORMATION);

        try {
            carregarMamiferos();
        } catch (SQLException e) {
            mostrarAlerta("Erro", "Erro ao carregar os mamíferos.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void comer() {
        Mamifero mamiferoSelecionado = tableMamiferos.getSelectionModel().getSelectedItem();
        if (mamiferoSelecionado != null) {
            mostrarAlerta("Mamífero Alimentado", "O mamífero se alimentou e agora está satisfeito!", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione um mamífero para alimentar.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void dormir() {
        Mamifero mamiferoSelecionado = tableMamiferos.getSelectionModel().getSelectedItem();
        if (mamiferoSelecionado != null) {
            mostrarAlerta("Mamífero Dormindo", "O mamífero está dormindo tranquilamente. Zzz...", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione um mamífero para dormir.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void envelhecer() {
        Mamifero mamiferoSelecionado = tableMamiferos.getSelectionModel().getSelectedItem();
        if (mamiferoSelecionado != null) {
            mostrarAlerta("Mamífero Envelhecendo", "O mamífero está envelhecendo com graça e sabedoria.", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione um mamífero para envelhecer.", Alert.AlertType.ERROR);
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
