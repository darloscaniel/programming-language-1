package org.example.classtest.dao;

import org.example.classtest.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassaroDAO extends ConnectionDAO {

    // CREATE
    public int criarPassaro(String especie, String nome, double tamanho) {
        int id_passaro = -1;
        Connection con = null;

        try {
            con = getConnection();
            String insert_sql = "INSERT INTO passaro (especie, nome, tamanho) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insert_sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, especie);
            pst.setString(2, nome);
            pst.setDouble(3, tamanho);
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                id_passaro = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar novo passaro! " + e.getMessage(), e);
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage(), e);
            }
        }

        return id_passaro;
    }

    // READ
    public List<Passaro> getPassaro() {
        List<Passaro> passaros = new ArrayList<>();
        Connection con = null;

        try {
            con = getConnection();
            String selectSql = "SELECT * FROM passaro";
            PreparedStatement pst = con.prepareStatement(selectSql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id_passaro = rs.getInt("id_passaro");
                String especie = rs.getString("especie");
                double tamanho = rs.getDouble("tamanho");
                String nome = rs.getString("nome");

                Passaro passaro = new Passaro(especie, nome, tamanho, id_passaro);
                passaros.add(passaro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar fruta: " + e.getMessage(), e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage(), e);
            }
        }

        return passaros;
    }

    // UPDATE
    public boolean atualizarPassaros(int id_passaro, String especie, String nome, double tamanho) {
        Connection con = null;
        boolean sucesso;

        try {
            con = getConnection();
            String updateSql = "UPDATE passaro SET especie = ?, habitat = ?, tamamho = ? WHERE id_passaro = ?";
            PreparedStatement pst = con.prepareStatement(updateSql);
            pst.setString(1, especie);
            pst.setString(2, nome);
            pst.setDouble(3, tamanho);
            pst.setInt(4, id_passaro);

            int rowsAffected = pst.executeUpdate();
            sucesso = true;
            if (rowsAffected == 0) {
                sucesso = false;
                throw new RuntimeException("Nenhuma camisa encontrada com o ID fornecido: " + id_passaro);
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
        String query = "SELECT COUNT(*) AS total FROM passaro WHERE " + coluna + " = ?";

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
