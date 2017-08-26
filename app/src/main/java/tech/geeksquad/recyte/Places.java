package tech.geeksquad.recyte;

public class Places {
    private double lat;
    private double lon;
    private String place;
    private String address;

    public Places(double lat, double lon, String place, String address) {
        this.lat = lat;
        this.lon = lon;
        this.place = place;
        this.address = address;
    }

    public Places() {
    }

    public String getAddress() {
        return address;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getPlace() {
        return place;
    }
}
