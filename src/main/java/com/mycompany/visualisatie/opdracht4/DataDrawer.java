/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.visualisatie.opdracht4;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.PApplet;

/**
 *
 * @author Lars
 */
public class DataDrawer {

    private final PApplet applet;
    private Date currentDate;

    public DataDrawer(PApplet applet) {
        this.applet = applet;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            currentDate = sdf.parse("1991-02-15");
        } catch (ParseException ex) {
            Logger.getLogger(DataDrawer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void drawLocations(ArrayList<DataModel> earthquakeList, DataModel selectedEarthquake) {

        for (DataModel earthquake : earthquakeList) {
            float size = 5f;
            if (earthquake.getDate().before(currentDate)) {
                float lattitude = earthquake.convertLat();
                float longitude = earthquake.convertLong();

                if (earthquake == selectedEarthquake) {
                    size = earthquake.getMagnitude() * 10;
                }

                int mappedColor = mapColor(earthquake.getMagnitude());
                applet.fill(255, mappedColor, 0);

                applet.ellipse(lattitude, longitude, size, size);
                
                if (earthquake == selectedEarthquake) {
                    applet.fill(0,0,0);
                    String magnitude = new DecimalFormat("#.##").format(earthquake.getMagnitude());
                    applet.text(magnitude, lattitude - 8, longitude + 5);
                }
            }

        }
    }

    private int mapColor(float magnitude) {
        int mappedColor = (int) PApplet.map(magnitude, 0, 5, 255, 0);
        return mappedColor;
    }

    public void drawDate() {

        applet.fill(255, 255, 255);
        applet.rect(0, 954, 920, 1004);
        applet.fill(0, 0, 0);
        applet.text(currentDate.toString(), 400, 985);
    }

    public void nextDate(ArrayList<DataModel> earthquakeList) {
        Date nextDate = null;
        for (DataModel earthquake : earthquakeList) {
            if (earthquake.getDate().after(currentDate)) {
                if (nextDate == null) {
                    nextDate = earthquake.getDate();
                } else if (earthquake.getDate().before(nextDate)) {
                    nextDate = earthquake.getDate();
                }
            }
        }

        if (nextDate != null) {
            currentDate = nextDate;
        }
    }

    public void previousDate(ArrayList<DataModel> earthquakeList) {
        Date nextDate = null;
        for (DataModel earthquake : earthquakeList) {
            if (earthquake.getDate().before(currentDate)) {
                if (nextDate == null) {
                    nextDate = earthquake.getDate();
                } else if (earthquake.getDate().after(nextDate)) {
                    nextDate = earthquake.getDate();
                }
            }
        }
        if (nextDate != null) {
            currentDate = nextDate;
        }

    }

    public DataModel onEarthquakeHover(ArrayList<DataModel> earthquakeList) {
        for (DataModel earthquake : earthquakeList) {
            if (earthquake.getDate().before(currentDate)) {
                float x = earthquake.convertLat();
                float y = earthquake.convertLong();

                if (applet.mouseX >= x && applet.mouseX <= x + 5) {
                    if (applet.mouseY >= y && applet.mouseY <= y + 5) {
                        return earthquake;
                    }
                }
            }
        }
        return null;
    }
}
