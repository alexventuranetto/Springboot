package br.com.viacep.controller;

//ClienteController.java
//Controla a lógica entre API ViaCEP, cliente e DAO

import br.com.viacep.dao.ClienteDAO;
import br.com.viacep.model.Cliente;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClienteController {
 private ClienteDAO dao = new ClienteDAO();

 // Busca o endereço na API ViaCEP
 public Cliente buscarEnderecoViaCEP(String cep) {
     try {
         URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
         HttpURLConnection con = (HttpURLConnection) url.openConnection();
         con.setRequestMethod("GET");

         BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
         StringBuilder json = new StringBuilder();
         String line;

         while ((line = in.readLine()) != null) {
             json.append(line);
         }
         in.close();

         JSONObject obj = new JSONObject(json.toString());
         if (obj.has("erro")) return null;

         Cliente cliente = new Cliente();
         cliente.setCep(obj.getString("cep"));
         cliente.setLogradouro(obj.getString("logradouro"));
         cliente.setBairro(obj.getString("bairro"));
         cliente.setCidade(obj.getString("localidade"));
         cliente.setEstado(obj.getString("uf"));
         cliente.setPais("Brasil");

         return cliente;
     } catch (Exception e) {
         e.printStackTrace();
         return null;
     }
 }

 public void salvarCliente(Cliente cliente) {
     dao.salvar(cliente);
 }

 public void listarClientes() {
     dao.listarClientes();
 }
}