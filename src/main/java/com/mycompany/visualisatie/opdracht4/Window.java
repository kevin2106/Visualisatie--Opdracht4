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
    private PImage img;
    private ArrayList<DataModel> model;
    
    private DataDrawer dataDrawer;
    
    @Override
    public void setup() {
        size(920, 954);
        applet = this;
        img = loadImage("Kaartgron.png");
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
        image(img, 0, 0);
        dataDrawer.drawLocations(model);
    }
    
    
}
