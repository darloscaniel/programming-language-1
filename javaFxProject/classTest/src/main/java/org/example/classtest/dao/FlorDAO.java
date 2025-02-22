package org.example.classtest.dao;

import org.example.classtest.models.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlorDAO extends ConnectionDAO {

    // CREATE
    public int criarFlor(String especie, String cor, double tamanho) {
        int id_flor = -1;
        Connection con = null;

        try {
            con = getConnection();
            String insert_sql = "INSERT INTO flor (especie, cor, tamanho) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insert_sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, especie);
            pst.setString(2, cor);
            pst.setDouble(3, tamanho);
            pst.executeUpdate();


            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                id_flor= rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar nova bandeira! " + e.getMessage(), e);
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage(), e);
            }
        }

        return id_flor;
    }

    // READ
    public List<Flor> getFlor() {
        List<Flor> flores = new ArrayList<>();
        Connection con = null;

        try {
            con = getConnection();
            String selectSql = "SELECT * FROM flor";
            PreparedStatement pst = con.prepareStatement(selectSql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id_flor = rs.getInt("id_flor");
                String cor = rs.getString("cor");
                String especie = rs.getString("especie");
                double tamanho = rs.getDouble("tamanho");

                Flor flor = new Flor(especie, cor, tamanho, id_flor);
                flores.add(flor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar flor: " + e.getMessage(), e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage(), e);
            }
        }

        return flores;
    }

    // UPDATE
    public boolean atualizarFlor(int id_flor, String especie, String cor, double tamanho) {
        Connection con = null;
        boolean sucesso;

        try {
            con = getConnection();
            String updateSql = "UPDATE flor SET cor = ?, especie = ?, tamanho = ? WHERE id_flor = ?";
            PreparedStatement pst = con.prepareStatement(updateSql);
            pst.setString(1, cor);
            pst.setString(2, especie);
            pst.setDouble(3, tamanho);
            pst.setInt(4, id_flor);

            int rowsAffected = pst.executeUpdate();
            sucesso = true;
            if (rowsAffected == 0) {
                sucesso = false;
                throw new RuntimeException("Nenhuma camisa encontrada com o ID fornecido: " + id_flor);
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
        String query = "SELECT COUNT(*) AS total FROM flor WHERE " + coluna + " = ?";

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
