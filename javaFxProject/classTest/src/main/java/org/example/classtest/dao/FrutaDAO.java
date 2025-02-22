package org.example.classtest.dao;

import org.example.classtest.models.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FrutaDAO extends ConnectionDAO {

    // CREATE
    public int criarFruta(String tipo, String tamanho, String nome) {
        int id_fruta = -1;
        Connection con = null;

        try {
            con = getConnection();
            String insert_sql = "INSERT INTO fruta (tipo, tamanho, nome) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insert_sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, tipo);
            pst.setString(2, tamanho);
            pst.setString(3, nome);
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                id_fruta= rs.getInt(1);
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

        return id_fruta;
    }

    // READ
    public List<Fruta> getFruta() {
        List<Fruta> frutas = new ArrayList<>();
        Connection con = null;

        try {
            con = getConnection();
            String selectSql = "SELECT * FROM fruta";
            PreparedStatement pst = con.prepareStatement(selectSql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id_fruta = rs.getInt("id_fruta");
                String tipo = rs.getString("tipo");
                String tamanho = rs.getString("tamanho");
                String nome = rs.getString("nome");

                Fruta fruta = new Fruta(tipo, tamanho, nome, id_fruta);
                frutas.add(fruta);
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

        return frutas;
    }

    // UPDATE
    public boolean atualizarFrutas(int id_fruta, String tipo, String tamanho, String  nome) {
        Connection con = null;
        boolean sucesso;

        try {
            con = getConnection();
            String updateSql = "UPDATE fruta SET tipo = ?, tamanho = ?, nome = ? WHERE id_fruta = ?";
            PreparedStatement pst = con.prepareStatement(updateSql);
            pst.setString(1, tipo);
            pst.setString(2, tamanho);
            pst.setString(3, nome);
            pst.setInt(4, id_fruta);

            int rowsAffected = pst.executeUpdate();
            sucesso = true;
            if (rowsAffected == 0) {
                sucesso = false;
                throw new RuntimeException("Nenhuma camisa encontrada com o ID fornecido: " + id_fruta);
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
        String query = "SELECT COUNT(*) AS total FROM fruta WHERE " + coluna + " = ?";

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

