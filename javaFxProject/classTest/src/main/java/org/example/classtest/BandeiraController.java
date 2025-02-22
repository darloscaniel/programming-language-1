package org.example.classtest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.classtest.models.*;
import org.example.classtest.dao.*;

import java.sql.SQLException;
import java.util.List;



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
    @FXML
    private Button btn_cadstrar;
    @FXML
    private TableView<Bandeira> tableBandeiras;
    @FXML
    private TableColumn<Bandeira, String> colPais;
    @FXML
    private TableColumn<Bandeira, String> colCor;

    private final BandeiraDAO bandeiraDAO = new BandeiraDAO();
    private final ObservableList<Bandeira> bandeirasList = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws SQLException {
        configurarTabela();
        carregarBandeiras();

        btn_cadstrar.setOnAction(event -> cadastrarBandeira());
        btn_balancar.setOnAction(event -> balancarBandeira());
        btn_desc.setOnAction(event -> mostrarDescricao());
        btn_curiosidade.setOnAction(event -> mostrarCuriosidade());
    }

    private void configurarTabela() {
        colPais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        colCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        tableBandeiras.setItems(bandeirasList);
    }

    private void carregarBandeiras() throws SQLException {
        List<Bandeira> bandeiras = bandeiraDAO.getBandeiras();
        bandeirasList.setAll(bandeiras);
    }

    private void cadastrarBandeira() {
        String pais = txt_pais.getText();
        String cor = txt_cor.getText();
        String descricao = txt_desc.getText();

        if (pais.isEmpty() || cor.isEmpty() || descricao.isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos!", Alert.AlertType.ERROR);
            return;
        }

        if (bandeiraDAO.isEntityCadastrada("pais", pais)) {
            mostrarAlerta("Erro", "A bandeira já foi cadastrada.", Alert.AlertType.ERROR);
            return;
        }

        Bandeira bandeira = new Bandeira(pais, cor, descricao);
        bandeiraDAO.criarBandeira(bandeira.getPais(), bandeira.getCor(), bandeira.getDescricao());
        bandeirasList.add(bandeira);
        mostrarAlerta("Sucesso", "Bandeira cadastrada com sucesso!", Alert.AlertType.INFORMATION);
    }
    @FXML
    private void balancarBandeira() {
        Bandeira bandeiraSelecionada = tableBandeiras.getSelectionModel().getSelectedItem();
        if (bandeiraSelecionada != null) {
            mostrarAlerta("Bandeira", bandeiraSelecionada.balancar(), Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione uma bandeira para balançar.", Alert.AlertType.ERROR);
        }
    }

    private void mostrarDescricao() {
        Bandeira bandeiraSelecionada = tableBandeiras.getSelectionModel().getSelectedItem();
        System.out.println(bandeiraSelecionada.getId_bandeira());
        if (bandeiraSelecionada != null) {
            mostrarAlerta("Descrição da Bandeira", bandeiraSelecionada.mostrarDescricao(), Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Erro", "Selecione uma bandeira para mostrar a descrição.", Alert.AlertType.ERROR);
        }
    }

    private void mostrarCuriosidade() {
        mostrarAlerta("Curiosidade", "O tamanho padrão de uma bandeira nacional é 1,20m por 0,80m.", Alert.AlertType.INFORMATION);
    }

    private void mostrarAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
