package br.com.ia.service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class IAService {
    // Substitua pela sua chave da API do Google
    private static final String API_KEY = "AIzaSyBb25EhJLHPV-az_SrgSeXwWOtUP5azC_U";
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent";

    public static String obterResposta(String pergunta) {
        try {
            // Construindo o corpo da requisição
            JSONObject requestBody = new JSONObject();
            JSONArray contents = new JSONArray();
            JSONObject content = new JSONObject();
            JSONArray parts = new JSONArray();
            JSONObject part = new JSONObject();
            part.put("text", pergunta);
            parts.put(part);
            content.put("parts", parts);
            contents.put(content);
            requestBody.put("contents", contents);

            // Conexão HTTP
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("x-goog-api-key", API_KEY); // Usando a chave da API
            conn.setDoOutput(true);

            // Enviando os dados
            OutputStream os = conn.getOutputStream();
            os.write(requestBody.toString().getBytes());
            os.flush();
            os.close();

            // Verificando o status da resposta
            int status = conn.getResponseCode();
            if (status != 200) {
                return "Erro: Código HTTP " + status + " - " + conn.getResponseMessage();
            }

            // Lendo a resposta da API
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String response = in.lines().reduce("", (acc, line) -> acc + line);
            in.close();

            // Processando a resposta JSON
            JSONObject jsonResponse = new JSONObject(response);
            JSONArray candidates = jsonResponse.getJSONArray("candidates");
            JSONObject firstCandidate = candidates.getJSONObject(0);
            JSONArray responseParts = firstCandidate.getJSONObject("content").getJSONArray("parts");
            return responseParts.getJSONObject(0).getString("text");

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
}
