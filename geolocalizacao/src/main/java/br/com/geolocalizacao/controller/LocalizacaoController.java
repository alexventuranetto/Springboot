package br.com.geolocalizacao.controller;

import br.com.geolocalizacao.model.Localizacao;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LocalizacaoController {

    public Localizacao obterLocalizacaoPorIP() throws Exception {
        URL url = new URL("http://ip-api.com/json/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
        );

        String json = in.lines().reduce("", (acc, line) -> acc + line);
        in.close();

        JSONObject obj = new JSONObject(json);
        Localizacao loc = new Localizacao();
        loc.setQuery(obj.getString("query"));
        loc.setCountry(obj.getString("country"));
        loc.setRegionName(obj.getString("regionName"));
        loc.setCity(obj.getString("city"));
        loc.setLat(obj.getDouble("lat"));
        loc.setLon(obj.getDouble("lon"));

        return loc;
    }
}
