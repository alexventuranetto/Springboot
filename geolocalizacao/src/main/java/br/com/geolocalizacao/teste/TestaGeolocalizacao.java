package br.com.geolocalizacao.teste;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.stream.Collectors;

public class TestaGeolocalizacao {
    public static void main(String[] args) {
        try {
            // === OBTENDO O IP LOCAL DO COMPUTADOR ===
            // Classe InetAddress representa o endereço IP da máquina local
            InetAddress localHost = InetAddress.getLocalHost();

            // Recupera o endereço IP no formato String
            String ipLocal = localHost.getHostAddress();

            // Exibe o IP local no console
            System.out.println("IP Local: " + ipLocal);

            // === CONSUMINDO A API ip-api.com PARA PEGAR IP PÚBLICO E LOCALIZAÇÃO ===
            // Cria o objeto URL apontando para a API pública
            URL url = new URL("http://ip-api.com/json/");

            // Abre a conexão HTTP com a URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Define o método HTTP como GET
            conn.setRequestMethod("GET");

            // Cria um BufferedReader para ler a resposta da API
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            // Lê todas as linhas da resposta e junta em uma única String JSON
            String json = in.lines().collect(Collectors.joining());

            // Converte a String JSON em um objeto JSONObject
            JSONObject obj = new JSONObject(json);

            // Extrai os dados desejados do JSON
            String ipPublico = obj.getString("query");         // IP público
            String cidade = obj.getString("city");             // Cidade
            String estado = obj.getString("regionName");       // Estado ou região
            String pais = obj.getString("country");            // País

            // === EXIBINDO OS DADOS NO CONSOLE ===
            System.out.println("IP Público: " + ipPublico);
            System.out.println("Cidade: " + cidade);
            System.out.println("Estado: " + estado);
            System.out.println("País: " + pais);

        } catch (Exception e) {
            // Em caso de erro, imprime a pilha de exceções no console
            e.printStackTrace();
        }
    }
}
