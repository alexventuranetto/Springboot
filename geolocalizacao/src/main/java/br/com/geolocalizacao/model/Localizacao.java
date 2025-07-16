package br.com.geolocalizacao.model;

public class Localizacao {
    private String query;
    private String country;
    private String regionName;
    private String city;
    private double lat;
    private double lon;

    // Getters e Setters
    public String getQuery() { return query; }
    public void setQuery(String query) { this.query = query; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getRegionName() { return regionName; }
    public void setRegionName(String regionName) { this.regionName = regionName; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public double getLat() { return lat; }
    public void setLat(double lat) { this.lat = lat; }
    public double getLon() { return lon; }
    public void setLon(double lon) { this.lon = lon; }
}
