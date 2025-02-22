package org.example.classtest.dao;

import org.example.classtest.models.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO extends ConnectionDAO {

    // CREATE
    public int criarCarro(String modelo, String marca, String cor, String placa) {
        int id_carro = -1;
        Connection con = null;

        try {
            con = getConnection();
            String insert_sql = "INSERT INTO carro (modelo, marca, cor, placa) VALUES (?, ?, ?,?)";
            PreparedStatement pst = con.prepareStatement(insert_sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, modelo);
            pst.setString(2, marca);
            pst.setString(3, cor);
            pst.setString(4, placa);
            pst.executeUpdate();


            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                id_carro = rs.getInt(1);
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

        return id_carro;
    }

    // READ
    public List<Carro> getCarro() {
        List<Carro> carros = new ArrayList<>();
        Connection con = null;

        try {
            con = getConnection();
            String selectSql = "SELECT * FROM carro";
            PreparedStatement pst = con.prepareStatement(selectSql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id_carro = rs.getInt("id_carro");
                String cor = rs.getString("cor");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String placa = rs.getString("placa");

                Carro carro = new Carro(modelo, marca, cor, placa, id_carro);
                carros.add(carro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar carros: " + e.getMessage(), e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão: " + e.getMessage(), e);
            }
        }

        return carros;
    }

    // UPDATE
    public boolean atualizarCarro(int id_carro, String modelo, String marca, String cor, String placa) {
        Connection con = null;
        boolean sucesso;

        try {
            con = getConnection();
            String updateSql = "UPDATE carro SET cor = ?, modelo = ?, marca = ?, placa = ? WHERE id_carro = ?";
            PreparedStatement pst = con.prepareStatement(updateSql);
            pst.setString(1, cor);
            pst.setString(2, modelo);
            pst.setString(3, marca);
            pst.setString(4, placa);
            pst.setInt(5, id_carro);

            int rowsAffected = pst.executeUpdate();
            sucesso = true;
            if (rowsAffected == 0) {
                sucesso = false;
                throw new RuntimeException("Nenhuma camisa encontrada com o ID fornecido: " + id_carro);
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
        String query = "SELECT COUNT(*) AS total FROM carro WHERE " + coluna + " = ?";

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
