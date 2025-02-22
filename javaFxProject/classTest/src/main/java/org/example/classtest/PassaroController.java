package org.example.classtest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.classtest.dao.PassaroDAO;
import org.example.classtest.models.Passaro;

import java.sql.SQLException;
import java.util.List;

public class PassaroController {

    @FXML
    private Button btn_comer;

    @FXML
    private Button btn_cantar;

    @FXML
    private Button btn_voar;

    @FXML
    private Button btn_cadastrar;

    @FXML
    private TextField txt_especie;

    @FXML
    private TextField txt_tamanho;

    @FXML
    private TextField txt_nome;

    @FXML
    private TableView<Passaro> tablePassaros;

    @FXML
    private TableColumn<Passaro, String> colEspecie;

    @FXML
    private TableColumn<Passaro, String> colNome;

    @FXML
    private TableColumn<Passaro, Double> colTamanho;

    private final PassaroDAO passaroDAO = new PassaroDAO();
    private final ObservableList<Passaro> passarosList = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws SQLException {
        configurarTabela();
        carregarPassaros();

        btn_cadastrar.setOnAction(event -> cadastrarPassaro());
        btn_comer.setOnAction(event -> comer());
        btn_cantar.setOnAction(event -> cantar());
        btn_voar.setOnAction(event -> voar());
    }

    private void configurarTabela() {
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        tablePassaros.setItems(passarosList);
    }

    private void carregarPassaros() throws SQLException {
        List<Passaro> passaros = passaroDAO.getPassaro();
        passarosList.setAll(passaros);
    }

    @FXML
    private void cadastrarPassaro() {
        String especie = txt_especie.getText();
        String nome = txt_nome.getText();
        double tamanho = 0;
        System.out.println(especie);

        try {
            tamanho = Double.parseDouble(txt_tamanho.getText()); // Aqui estamos usando o campo "cor" para o tamanho
        } catch (NumberFormatException e) {
            mostrarAlerta("Erro", "O campo Tamanho deve ser um número válido.", Alert.AlertType.ERROR);
            return;
        }

        // Verifica se algum campo está vazio
        if (especie.isEmpty() || nome.isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos!", Alert.AlertType.ERROR);
            return;
        }

        // Criação do objeto Passaro e cadastro no banco de dados
        Passaro passaro = new Passaro(especie, nome, tamanho);
        System.out.println(passaro.getEspecie());
        passaroDAO.criarPassaro(passaro.getEspecie(), passaro.getNome(), passaro.getTamanho());
        mostrarAlerta("Sucesso", "Pássaro cadastrado com sucesso!", Alert.AlertType.INFORMATION);

        try {
            carregarPassaros();
        } catch (SQLException e) {
            mostrarAlerta("Erro", "Erro ao carregar os pássaros.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void cantar() {
        Passaro passaroSelecionado = tablePassaros.getSelectionModel().getSelectedItem();
        if (passaroSelecionado != null) {
            mostrarAlerta("Pássaro Cantando", "O pássaro está cantando alegremente!", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione um pássaro para cantar.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void comer() {
        Passaro passaroSelecionado = tablePassaros.getSelectionModel().getSelectedItem();
        if (passaroSelecionado != null) {
            mostrarAlerta("Pássaro Alimentado", "O pássaro está se alimentando.", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione um pássaro para alimentar.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void voar() {
        Passaro passaroSelecionado = tablePassaros.getSelectionModel().getSelectedItem();
        if (passaroSelecionado != null) {
            String especie = passaroSelecionado.getEspecie().toLowerCase();

            if (especie.equals("galinha")) {
                mostrarAlerta("Não Voa", "A galinha não voa!", Alert.AlertType.INFORMATION);
            } else {
                mostrarAlerta("Pássaro Voando", "O pássaro está voando majestuosamente!", Alert.AlertType.INFORMATION);
            }
        } else {
            mostrarAlerta("Erro", "Selecione um pássaro para voar.", Alert.AlertType.ERROR);
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
