package br.com.viacep.teste;


import br.com.viacep.controller.ClienteController;
import br.com.viacep.model.Cliente;

import java.util.Scanner;


//Classe principal com menu para cadastrar ou listar clientes

public class TestarCep { 
 public static void main(String[] args) {    // Método principal.java
     Scanner sc = new Scanner(System.in);
     ClienteController controller = new ClienteController();

     System.out.println("1 - Cadastrar Cliente");
     System.out.println("2 - Listar Clientes");
     System.out.print("Escolha uma opção: ");
     int opcao = Integer.parseInt(sc.nextLine());

     if (opcao == 1) {
         Cliente cliente = new Cliente();

         System.out.print("Digite o nome: ");
         cliente.setNome(sc.nextLine());

         System.out.print("Digite o telefone: ");
         cliente.setTelefone(sc.nextLine());

         System.out.print("Digite o CEP: ");
         String cep = sc.nextLine();
         Cliente endereco = controller.buscarEnderecoViaCEP(cep);

         if (endereco == null) {
             System.out.println("CEP inválido ou não encontrado!");
             return;
         }

         cliente.setCep(cep);
         cliente.setLogradouro(endereco.getLogradouro());
         cliente.setBairro(endereco.getBairro());
         cliente.setCidade(endereco.getCidade());
         cliente.setEstado(endereco.getEstado());
         cliente.setPais(endereco.getPais());

         System.out.print("Digite o número da residência: ");
         cliente.setNumero(sc.nextLine());

         controller.salvarCliente(cliente);
     } else if (opcao == 2) {
    	 System.out.println("########## LISTA ###########");
         controller.listarClientes();
         System.out.println("#################2###########");
     } else {
         System.out.println("Opção inválida!");
     }
 }
}

