package org.example.classtest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.classtest.dao.FrutaDAO;
import org.example.classtest.models.Fruta;

import java.sql.SQLException;
import java.util.List;

public class FrutaController {

    @FXML
    private Button btn_amadurecer;

    @FXML
    private Button btn_apodrecer;

    @FXML
    private Button btn_semear;

    @FXML
    private Button btn_cadastrar;

    @FXML
    private TextField txt_tipo;

    @FXML
    private TextField txt_tamanho;

    @FXML
    private TextField txt_nome;

    @FXML
    private TableView<Fruta> tableFrutas;

    @FXML
    private TableColumn<Fruta, String> colTipo;

    @FXML
    private TableColumn<Fruta, String> colTamanho;

    @FXML
    private TableColumn<Fruta, String> colNome;

    private final FrutaDAO frutaDAO = new FrutaDAO();
    private final ObservableList<Fruta> frutasList = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws SQLException {
        configurarTabela();
        carregarFrutas();

        btn_cadastrar.setOnAction(event -> cadastrarFruta());
        btn_amadurecer.setOnAction(event -> amadurecerFruta());
        btn_apodrecer.setOnAction(event -> apodrecerFruta());
        btn_semear.setOnAction(event -> semear());
    }

    private void configurarTabela() {
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableFrutas.setItems(frutasList);
    }

    private void carregarFrutas() throws SQLException {
        List<Fruta> frutas = frutaDAO.getFruta();
        frutasList.setAll(frutas);
    }

    @FXML
    private void cadastrarFruta() {
        String tipo = txt_tipo.getText();
        String tamanho = txt_tamanho.getText();
        String nome = txt_nome.getText();

        // Verifica se algum campo está vazio
        if (tipo.isEmpty() || tamanho.isEmpty() || nome.isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos!", Alert.AlertType.ERROR);
            return;
        }

        // Agora você pode continuar com o processo de cadastro
        Fruta fruta = new Fruta(tipo, tamanho, nome);
        frutaDAO.criarFruta(fruta.getTipo(), fruta.getTamanho(), fruta.getNome());
        mostrarAlerta("Sucesso", "Fruta cadastrada com sucesso!", Alert.AlertType.INFORMATION);

        try {
            carregarFrutas();
        } catch (SQLException e) {
            mostrarAlerta("Erro", "Erro ao carregar as frutas.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void amadurecerFruta() {
        Fruta frutaSelecionada = tableFrutas.getSelectionModel().getSelectedItem();
        if (frutaSelecionada != null) {
            mostrarAlerta("Fruta Amadurecida", "A fruta amadureceu e está pronta para ser colhida!", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione uma fruta para amadurecer.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void apodrecerFruta() {
        Fruta frutaSelecionada = tableFrutas.getSelectionModel().getSelectedItem();
        if (frutaSelecionada != null) {
            mostrarAlerta("Fruta Apodrecida", "Infelizmente, a fruta apodreceu e não pode mais ser consumida.", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione uma fruta para apodrecer.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void semear() {
        Fruta frutaSelecionada = tableFrutas.getSelectionModel().getSelectedItem();
        if (frutaSelecionada != null) {
            mostrarAlerta("Fruta Semeada", "As sementes foram plantadas! Em breve, uma nova planta crescerá.", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione uma fruta para semear.", Alert.AlertType.ERROR);
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
