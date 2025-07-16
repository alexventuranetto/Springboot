package br.com.viacep.dao;

//ClienteDAO.java (Data Access Object)
//Responsável por salvar e listar os dados no banco

import br.com.viacep.model.Cliente;

import java.sql.*;

public class ClienteDAO {
 private static final String URL = "jdbc:mysql://localhost:3306/viacep?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

 private static final String USER = "root";
 private static final String PASSWORD = "alunolab";

 // Salvar cliente no banco
 public void salvar(Cliente cliente) {
     String sql = "INSERT INTO cliente (nome, telefone, cep, logradouro, numero, bairro, cidade, estado, pais) " +
                  "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
     try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
          PreparedStatement stmt = conn.prepareStatement(sql)) {

         stmt.setString(1, cliente.getNome());
         stmt.setString(2, cliente.getTelefone());
         stmt.setString(3, cliente.getCep());
         stmt.setString(4, cliente.getLogradouro());
         stmt.setString(5, cliente.getNumero());
         stmt.setString(6, cliente.getBairro());
         stmt.setString(7, cliente.getCidade());
         stmt.setString(8, cliente.getEstado());
         stmt.setString(9, cliente.getPais());

         stmt.executeUpdate();
         System.out.println("Cliente salvo com sucesso!");
     } catch (Exception e) {
         e.printStackTrace();
     }
 }

 // Listar clientes do banco
 public void listarClientes() {
     String sql = "SELECT * FROM cliente";
     try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
          PreparedStatement stmt = conn.prepareStatement(sql);
          ResultSet rs = stmt.executeQuery()) {

         while (rs.next()) {
             System.out.println("ID: " + rs.getInt("id"));
             System.out.println("Nome: " + rs.getString("nome"));
             System.out.println("Telefone: " + rs.getString("telefone"));
             System.out.println("CEP: " + rs.getString("cep"));
             System.out.println("Logradouro: " + rs.getString("logradouro"));
             System.out.println("Número: " + rs.getString("numero"));
             System.out.println("Bairro: " + rs.getString("bairro"));
             System.out.println("Cidade: " + rs.getString("cidade"));
             System.out.println("Estado: " + rs.getString("estado"));
             System.out.println("País: " + rs.getString("pais"));
             System.out.println("------------------------------");
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}
