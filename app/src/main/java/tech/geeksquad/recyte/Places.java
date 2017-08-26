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

    @Override
    public String toString() {
        return "Places{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", place='" + place + '\'' +
                ", address='" + address + '\'' +
                '}';
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
