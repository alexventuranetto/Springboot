package br.com.ia.view;

import br.com.ia.model.Pergunta;
import br.com.ia.service.IAService;

import java.util.Scanner;

public class ChatIA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🤖 IA Humanizada - Digite 'sair' para encerrar");

        while (true) {
            System.out.print("Você: ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            Pergunta pergunta = new Pergunta(entrada);
            String resposta = IAService.obterResposta(pergunta.getTexto());
            System.out.println("IA: " + resposta);
        }

        scanner.close();
    }
}
