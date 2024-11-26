package org.example.classtest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.classtest.models.Caderno;
import org.example.classtest.dao.CadernoDAO;

import java.sql.SQLException;
import java.util.List;

public class CadernoController {

    @FXML
    private Button btn_fechar;

    @FXML
    private TextField txt_cor;
    @FXML
    private TextField txt_pagina;
    @FXML
    private TextField txt_escrever;
    @FXML
    private Button btn_escrever;
    @FXML
    private Button btn_remover;
    @FXML
    private Button btn_cadastrar;
    @FXML
    private TableView<Caderno> tableCadernos;
    @FXML
    private TableColumn<Caderno, String> colCor;
    @FXML
    private TableColumn<Caderno, Integer> colPaginas;

    private final CadernoDAO cadernoDAO = new CadernoDAO();
    private final ObservableList<Caderno> cadernosList = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws SQLException {
        configurarTabela();
        carregarCadernos();

        btn_cadastrar.setOnAction(event -> cadastrarCaderno());
        btn_escrever.setOnAction(event -> escreverNoCaderno());
        btn_remover.setOnAction(event -> removerPagina());
        btn_fechar.setOnAction(event -> fecharJanela());
    }

    @FXML
    private void fecharJanela() {
        btn_fechar.getScene().getWindow().hide();
    }

    private void configurarTabela() {
        colCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colPaginas.setCellValueFactory(new PropertyValueFactory<>("paginas"));
        tableCadernos.setItems(cadernosList);
    }

    private void carregarCadernos() throws SQLException {
        List<Caderno> cadernos = cadernoDAO.getCaderno();
        cadernosList.setAll(cadernos);
    }

    private void cadastrarCaderno() {
        String cor = txt_cor.getText();
        String paginasText = txt_pagina.getText();

        if (cor.isEmpty() || paginasText.isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos!", Alert.AlertType.ERROR);
            return;
        }

        try {
            int paginas = Integer.parseInt(paginasText);

            if (cadernoDAO.isEntityCadastrada("cor", cor)) {
                mostrarAlerta("Erro", "Um caderno com esta cor já foi cadastrado.", Alert.AlertType.ERROR);
                return;
            }

            Caderno caderno = new Caderno(cor, paginas);
            caderno.setId_caderno(cadernoDAO.criarCaderno(cor, paginas, ""));
            cadernosList.add(caderno);
            mostrarAlerta("Sucesso", "Caderno cadastrado com sucesso!", Alert.AlertType.INFORMATION);

        } catch (NumberFormatException e) {
            mostrarAlerta("Erro", "Número de páginas inválido.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void escreverNoCaderno() {
        Caderno cadernoSelecionado = tableCadernos.getSelectionModel().getSelectedItem();
        System.out.println(cadernoSelecionado.getId_caderno());
        if (cadernoSelecionado == null) {
            mostrarAlerta("Erro", "Selecione um caderno para escrever.", Alert.AlertType.ERROR);
            return;
        }

        String texto = txt_escrever.getText();

        if (texto.isEmpty()) {
            mostrarAlerta("Erro", "Digite algum texto para escrever.", Alert.AlertType.ERROR);
            return;
        }

        cadernoSelecionado.escrever(texto);
        cadernoDAO.atualizarCaderno(cadernoSelecionado.getId_caderno(), cadernoSelecionado.getCor(), cadernoSelecionado.getPaginas(), texto);
        mostrarAlerta("Sucesso", "Texto adicionado ao caderno!", Alert.AlertType.INFORMATION);
    }

    @FXML
    private void removerPagina() {
        Caderno cadernoSelecionado = tableCadernos.getSelectionModel().getSelectedItem();

        cadernoSelecionado.removerPagina();

        if (cadernoSelecionado == null) {
            mostrarAlerta("Erro", "Selecione um caderno para remover.", Alert.AlertType.ERROR);
            return;
        }

        boolean sucesso = cadernoDAO.atualizarCaderno(cadernoSelecionado.getId_caderno(), cadernoSelecionado.getCor(), cadernoSelecionado.removerPagina(), cadernoSelecionado.getTexto());

    }

    private void mostrarAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
