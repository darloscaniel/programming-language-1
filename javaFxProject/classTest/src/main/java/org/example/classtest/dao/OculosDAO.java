package org.example.classtest.dao;

import org.example.classtest.models.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OculosDAO extends ConnectionDAO {

    // CREATE
    public int criarOculos(String cor, String tipo, String material) {
        int id_oculos = -1;
        Connection con = null;

        try {
            con = getConnection();
            String insert_sql = "INSERT INTO oculos (cor, tipo, material) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insert_sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, cor);
            pst.setString(2, tipo);
            pst.setString(3, material);
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                id_oculos = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar nova oculos! " + e.getMessage(), e);
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage(), e);
            }
        }

        return id_oculos;
    }

    // READ
    public List<Oculos> getOculos() {
        List<Oculos> oculoss = new ArrayList<>();
        Connection con = null;

        try {
            con = getConnection();
            String selectSql = "SELECT * FROM oculos";
            PreparedStatement pst = con.prepareStatement(selectSql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id_oculos = rs.getInt("id_oculos");
                String cor = rs.getString("cor");
                String tipo = rs.getString("tipo");
                String material = rs.getString("material");
                Oculos oculos = new Oculos(cor, tipo, material, id_oculos);
                oculoss.add(oculos);
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

        return oculoss;
    }

    // UPDATE
    public boolean atualizarOculos(int id_oculos, String cor, String tipo, String material) {
        Connection con = null;
        boolean sucesso;

        try {
            con = getConnection();
            String updateSql = "UPDATE oculos SET cor = ?, tipo = ?, material = ? WHERE id_mamifero = ?";
            PreparedStatement pst = con.prepareStatement(updateSql);
            pst.setString(1, cor);
            pst.setString(2, tipo);
            pst.setString(3, material);
            pst.setInt(4, id_oculos);

            int rowsAffected = pst.executeUpdate();
            sucesso = true;
            if (rowsAffected == 0) {
                sucesso = false;
                throw new RuntimeException("Nenhuma camisa encontrada com o ID fornecido: " + id_oculos);
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
        String query = "SELECT COUNT(*) AS total FROM oculos WHERE " + coluna + " = ?";

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

