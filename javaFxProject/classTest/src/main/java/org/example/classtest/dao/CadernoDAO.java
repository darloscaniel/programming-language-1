package org.example.classtest.dao;

import org.example.classtest.models.Caderno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CadernoDAO extends ConnectionDAO {

    // CREATE
    public int criarCaderno(String cor, int paginas, String texto) {
        int id_caderno = -1;
        Connection con = null;

        try {
            con = getConnection();
            String insert_sql = "INSERT INTO caderno (cor, num_paginas, texto) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insert_sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, cor);
            pst.setInt(2, paginas);
            pst.setString(3, texto);
            pst.executeUpdate();


            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                id_caderno = rs.getInt(1);
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

        return id_caderno;
    }

    // READ
    public List<Caderno> getCaderno() {
        List<Caderno> cadernos = new ArrayList<>();
        Connection con = null;

        try {
            con = getConnection();
            String selectSql = "SELECT * FROM caderno";
            PreparedStatement pst = con.prepareStatement(selectSql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id_caderno = rs.getInt("id_caderno");
                String cor = rs.getString("cor");
                int paginas = rs.getInt("num_paginas");
                String texto = rs.getString("texto");

                Caderno caderno = new Caderno(cor, paginas, texto, id_caderno);
                cadernos.add(caderno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar cadernos: " + e.getMessage(), e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage(), e);
            }
        }

        return cadernos;
    }

    // UPDATE
    public boolean atualizarCaderno(int id_caderno, String cor, int paginas, String texto) {
        Connection con = null;
        boolean sucesso;

        try {
            con = getConnection();
            String updateSql = "UPDATE caderno SET cor = ?, num_paginas = ?, texto = ? WHERE id_caderno = ?";
            PreparedStatement pst = con.prepareStatement(updateSql);
            pst.setString(1, cor);
            pst.setInt(2, paginas);
            pst.setString(3, texto);
            pst.setInt(4, id_caderno);

            int rowsAffected = pst.executeUpdate();
            sucesso = true;
            if (rowsAffected == 0) {
                sucesso = false;
                throw new RuntimeException("Nenhum caderno encontrada com o ID fornecido: " + id_caderno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar caderno: " + e.getMessage(), e);
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

    // DELETE
    public boolean excluirCaderno(int id_caderno) {
        Connection con = null;
        String deleteSql = "DELETE FROM caderno WHERE id_caderno = ?";

        try {
            con = getConnection();
            con.setAutoCommit(false);


            PreparedStatement pst = con.prepareStatement(deleteSql);
            pst.setInt(1, id_caderno);
            int linhasAfetadas = pst.executeUpdate();

            con.commit();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (con != null) con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage(), e);
            }
        }
    }

    // Método para verificar se uma entidade já está cadastrada com base em uma coluna e valor
    public boolean isEntityCadastrada(String coluna, String valor) {
        Connection con = null;
        String query = "SELECT COUNT(*) AS total FROM caderno WHERE " + coluna + " = ?";

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
