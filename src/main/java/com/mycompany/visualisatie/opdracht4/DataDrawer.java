/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.visualisatie.opdracht4;

import java.util.ArrayList;
import processing.core.PApplet;

/**
 *
 * @author Lars
 */
public class DataDrawer {

    private final PApplet applet;

    public DataDrawer(PApplet applet) {
        this.applet = applet;

    }

    public void drawLocations(ArrayList<DataModel> earthquakeList) {

        for (DataModel earthquake : earthquakeList) {
            float lattitude = earthquake.convertLat();
            float longitude = earthquake.convertLong();

            int mappedColor = mapColor(earthquake.getMagnitude());
            applet.fill(255, mappedColor, 0);

            applet.ellipse(lattitude, longitude, 5, 5);

        }
    }

    private int mapColor(float magnitude) {
        int mappedColor = (int) PApplet.map(magnitude, 0, 5, 255,0 );
        System.out.println(magnitude + " => " + mappedColor);
        return mappedColor;
    }
}
