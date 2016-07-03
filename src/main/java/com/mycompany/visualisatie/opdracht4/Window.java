/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.visualisatie.opdracht4;

/**
 *
 * @author KevinPC
 */
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.PApplet;
import processing.core.PImage;

public class Window extends PApplet {

    private PApplet applet;
    private PImage map, prevButton, nextButton, winLocatieImg;
    private ArrayList<DataModel> model;

    private DataDrawer dataDrawer;

    @Override
    public void setup() {
        frame.setTitle("Aardbevingen tegenover gaswinlocaties");
        size(920, 1004);
        applet = this;

        map = loadImage("Kaartgron.png");
        prevButton = loadImage("prev_button.png");
        nextButton = loadImage("next_button.png");
        winLocatieImg = loadImage("gaswinlocatie.png");

        DataReader dr = new DataReader();
        dataDrawer = new DataDrawer(applet);
        try {
            model = dr.parser();
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void draw() {

        
        
        dataDrawer.drawDate();
        image(map, 0, 0);
        DataModel selectedEarthquake = dataDrawer.onEarthquakeHover(model);
        dataDrawer.drawLocations(model, selectedEarthquake);
        image(prevButton, 0, 954);
        image(nextButton, 820, 954);
        image(winLocatieImg, 600, 300);
        image(winLocatieImg, 175, 500);
        image(winLocatieImg, 5, 85);
        ellipse(25, 25, 20, 20);
        fill(0,0,0);
        text("0.0", 18, 28);
        text("= Bevings sterkte", 38, 28);

    }

    @Override
    public void mousePressed() {
        if (mouseX >= 0 && mouseX <= 100) {
            if (mouseY >= 954 && mouseY <= 1004) {
                //prev button
                dataDrawer.previousDate(model);
            }
        }

        if (mouseX >= 820 && mouseX <= 920) {
            if (mouseY >= 954 && mouseY <= 1004) {
                //next button
                dataDrawer.nextDate(model);

            }
        }
    }

}
