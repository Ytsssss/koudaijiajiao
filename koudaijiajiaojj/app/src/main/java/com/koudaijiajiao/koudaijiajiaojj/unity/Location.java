package com.koudaijiajiao.koudaijiajiaojj.unity;

/**
 * Created by killandy on 2016/10/28.
 */

public class Location {
    public String address;
    public double latitude;
    public double longitude;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }
}
