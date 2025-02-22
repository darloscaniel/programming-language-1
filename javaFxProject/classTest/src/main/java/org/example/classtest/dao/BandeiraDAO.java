package org.example.classtest.dao;

import org.example.classtest.models.Bandeira;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class BandeiraDAO extends ConnectionDAO {

    // CREATE
    public int criarBandeira(String pais, String cor, String descricao) {
        int id_bandeira = -1;
        Connection con = null;

        try {
            con = getConnection();
            String insert_sql = "INSERT INTO bandeira (pais, cor, descricao) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insert_sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, pais);
            pst.setString(2, cor);
            pst.setString(3, descricao);
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                id_bandeira = rs.getInt(1);
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

        return id_bandeira;
    }

    // READ
    public List<Bandeira> getBandeiras() {
        List<Bandeira> bandeiras = new ArrayList<>();
        Connection con = null;

        try {
            con = getConnection();
            String selectSql = "SELECT * FROM bandeira";
            PreparedStatement pst = con.prepareStatement(selectSql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id_bandeira = rs.getInt("id_bandeira");
                String pais = rs.getString("pais");
                String cor = rs.getString("cor");
                String descricao = rs.getString("descricao");

                Bandeira bandeira = new Bandeira(pais, cor, descricao, id_bandeira);
                bandeiras.add(bandeira);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar bandeiras: " + e.getMessage(), e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage(), e);
            }
        }

        return bandeiras;
    }

    // UPDATE
    public void atualizarBandeira(int id_bandeira, String pais, String cor, String descricao) {
        Connection con = null;

        try {
            con = getConnection();
            String updateSql = "UPDATE bandeira SET pais = ?, cor = ?, descricao = ? WHERE id_bandeira = ?";
            PreparedStatement pst = con.prepareStatement(updateSql);
            pst.setString(1, pais);
            pst.setString(2, cor);
            pst.setString(3, descricao);
            pst.setInt(4, id_bandeira);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected == 0) {
                throw new RuntimeException("Nenhuma bandeira encontrada com o ID fornecido: " + id_bandeira);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar bandeira: " + e.getMessage(), e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage(), e);
            }
        }
    }

    // DELETE
    public boolean excluirBandeira(int id_bandeira) {
        Connection con = null;
        String deleteSql = "DELETE FROM bandeira WHERE id_bandeira = ?";

        try {
            con = getConnection();
            con.setAutoCommit(false);


            PreparedStatement pst = con.prepareStatement(deleteSql);
            pst.setInt(1, id_bandeira);
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
        String query = "SELECT COUNT(*) AS total FROM bandeira WHERE " + coluna + " = ?";

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