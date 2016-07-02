/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.visualisatie.opdracht4;

import java.util.Date;
import static processing.core.PApplet.map;



/**
 *
 * @author KevinPC
 */
public class DataModel {
    private float longitude;
    private float latitude;
    private int objectid;
    private String location;
    private float magnitude;
    private float depth;
    private Date date;

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public int getObjectid() {
        return objectid;
    }

    public void setObjectid(int objectid) {
        this.objectid = objectid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(float magnitude) {
        this.magnitude = magnitude;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public float convertLat(){
        float mapLat = map(getLatitude(), 52.822716f, 53.489790f, 0, 920);
        return mapLat;      
    }
    public float convertLong(){
        float mapLong = map(getLongitude(), 7.189256f, 6.128558f, 0, 904);
        return mapLong;
    }
}
