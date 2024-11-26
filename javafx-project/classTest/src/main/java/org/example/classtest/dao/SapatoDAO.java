package org.example.classtest.dao;

import org.example.classtest.models.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SapatoDAO extends ConnectionDAO {

    // CREATE
    public int criarSapato(double tamanho, String cor, String tipo, String marca, double preco) {
        int id_sapato = -1;
        Connection con = null;

        try {
            con = getConnection();
            String insert_sql = "INSERT INTO sapato (tamanho, cor, tipo, marca, preco) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insert_sql, Statement.RETURN_GENERATED_KEYS);
            pst.setDouble(1, tamanho);
            pst.setString(2, cor);
            pst.setString(3, tipo);
            pst.setString(4, marca);
            pst.setDouble(5, preco);
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                id_sapato = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar novo sapato! " + e.getMessage(), e);
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage(), e);
            }
        }

        return id_sapato;
    }

    // READ
    public List<Sapato> getSapato() {
        List<Sapato> sapatos = new ArrayList<>();
        Connection con = null;

        try {
            con = getConnection();
            String selectSql = "SELECT * FROM sapato";
            PreparedStatement pst = con.prepareStatement(selectSql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id_sapato = rs.getInt("id_sapato");
                String cor = rs.getString("cor");
                String tipo = rs.getString("tipo");
                double tamanho = rs.getDouble("tamanho");
                String marca = rs.getString("marca");
                double preco = rs.getDouble("preco");
                Sapato sapato = new Sapato(tamanho, cor, tipo, marca, preco, id_sapato);
                sapatos.add(sapato);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar oculos: " + e.getMessage(), e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage(), e);
            }
        }

        return sapatos;
    }

    // UPDATE
    public boolean atualizarSapatos(int id_sapato, String cor, String tipo, String marca, double preco, double tamanho) {
        Connection con = null;
        boolean sucesso;

        try {
            con = getConnection();
            String updateSql = "UPDATE sapato SET cor = ?, tipo = ?, marca = ?, preco = ?, tamanho = ? WHERE id_mamifero = ?";
            PreparedStatement pst = con.prepareStatement(updateSql);
            pst.setString(1, cor);
            pst.setString(2, tipo);
            pst.setString(3, marca);
            pst.setDouble(4, preco);
            pst.setDouble(5, tamanho);
            pst.setInt(6, id_sapato);

            int rowsAffected = pst.executeUpdate();
            sucesso = true;
            if (rowsAffected == 0) {
                sucesso = false;
                throw new RuntimeException("Nenhuma camisa encontrada com o ID fornecido: " + id_sapato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar camisa: " + e.getMessage(), e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage(), e);
            }
        }
        return sucesso;
    }


    // Método para verificar se uma entidade já está cadastrada com base em uma coluna e valor
    public boolean isEntityCadastrada(String coluna, String valor) {
        Connection con = null;
        String query = "SELECT COUNT(*) AS total FROM sapato WHERE " + coluna + " = ?";

        try {
            con = getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, valor);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int total = rs.getInt("total");
                return total > 0; // Retorna true se encontrar ao menos uma ocorrência
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao verificar entidade cadastrada: " + e.getMessage(), e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage(), e);
            }
        }
        return false;
    }

}

