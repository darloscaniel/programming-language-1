package org.example.classtest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.classtest.dao.CarroDAO;
import org.example.classtest.models.Carro;

import java.sql.SQLException;
import java.util.List;

public class CarroController {

    @FXML
    private TextField txt_modelo;

    @FXML
    private TextField txt_marca;

    @FXML
    private TextField txt_cor;

    @FXML
    private TextField txt_placa;

    @FXML
    private Button btn_acelerar;

    @FXML
    private Button btn_freiar;

    @FXML
    private Button btn_ligar;

    @FXML
    private Button btn_cadastrar;

    @FXML
    private TableView<Carro> tableCarros;

    @FXML
    private TableColumn<Carro, String> colModelo;

    @FXML
    private TableColumn<Carro, String> colMarca;

    @FXML
    private TableColumn<Carro, String> colCor;

    @FXML
    private TableColumn<Carro, String> colPlaca;

    private final CarroDAO carroDAO = new CarroDAO();
    private final ObservableList<Carro> carrosList = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws SQLException {
        configurarTabela();
        carregarCarros();
        configurarCampoPlaca();

        btn_cadastrar.setOnAction(event -> cadastrarCarro());
        btn_acelerar.setOnAction(event -> acelerarCarro());
        btn_freiar.setOnAction(event -> freiarCarro());
        btn_ligar.setOnAction(event -> ligarCarro());
    }

    private void configurarCampoPlaca() {
        // Força o texto para maiúsculas enquanto digita
        txt_placa.textProperty().addListener((observable, oldValue, newValue) -> {
            txt_placa.setText(newValue.toUpperCase());
        });

        // Valida o formato apenas quando o campo perde o foco
        txt_placa.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Campo perdeu o foco
                String placa = txt_placa.getText();
                if (!placa.matches("^[A-Z]{3}[0-9]{4}$") && !placa.matches("^[A-Z]{3}[0-9][A-Z][0-9]{2}$")) {
                    mostrarAlerta("Erro", "Formato da placa inválido. Use o formato ABC1234 ou ABC1D23.", Alert.AlertType.ERROR);
                    txt_placa.clear();
                }
            }
        });
    }



    private void configurarTabela() {
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        tableCarros.setItems(carrosList);
    }

    private void carregarCarros() throws SQLException {
        List<Carro> carros = carroDAO.getCarro();
        carrosList.setAll(carros);
    }

    @FXML
    private void cadastrarCarro() {
        String modelo = txt_modelo.getText();
        String marca = txt_marca.getText();
        String cor = txt_cor.getText();
        String placa = txt_placa.getText();



        if (modelo.isEmpty() || marca.isEmpty() || cor.isEmpty() || placa.isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos!", Alert.AlertType.ERROR);
            return;
        }

        if (carroDAO.isEntityCadastrada("placa", placa)) {
            mostrarAlerta("Erro", "O carro já foi cadastrado.", Alert.AlertType.ERROR);
            return;
        }

        Carro carro = new Carro(modelo, marca, cor, placa);
        carroDAO.criarCarro(modelo, marca, cor, placa);
        carrosList.add(carro);
        mostrarAlerta("Sucesso", "Carro cadastrado com sucesso!", Alert.AlertType.INFORMATION);
    }

    @FXML
    private void acelerarCarro() {
        Carro carroSelecionado = tableCarros.getSelectionModel().getSelectedItem();
        if (carroSelecionado != null) {
            mostrarAlerta("Ação", "VRUM VRUM! O carro está acelerando.", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione um carro para acelerar.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void freiarCarro() {
        Carro carroSelecionado = tableCarros.getSelectionModel().getSelectedItem();
        if (carroSelecionado != null) {
            mostrarAlerta("Ação", "O carro está freiando!", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione um carro para freiar.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void ligarCarro() {
        Carro carroSelecionado = tableCarros.getSelectionModel().getSelectedItem();
        if (carroSelecionado != null) {
            mostrarAlerta("Ação", "O carro foi ligado.", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione um carro para ligar.", Alert.AlertType.ERROR);
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
