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
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.PApplet;
import static processing.core.PApplet.lerp;
import processing.core.PImage;

public class Window extends PApplet {
    PImage img;
    ArrayList<DataModel> model;
    
    @Override
    public void setup() {
        size(920, 954);
        img = loadImage("Kaartgron.png");
        DataReader dr = new DataReader();
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
        drawLocations(model);
    }
    
    public void drawLocations(ArrayList<DataModel> earthquakeList) {

        for (DataModel earthquake : earthquakeList) {
            float lattitude = earthquake.convertLat();
            float longitude = earthquake.convertLong();
            this.ellipse(lattitude, longitude, 5, 5);

            //System.out.println("X: " + mouseX);
            //System.out.println("Y: " + mouseY);
            /*if ((mouseX > lattitude - 5 && mouseX < lattitude + 5) && (mouseY > longitude - 5 && mouseY < longitude + 5)) {
                float height = lerp(0, -10, depth);
                this.rect(lattitude - 2.5f, longitude - 5, 5, height);

                this.fill(0, 0, 0);
                DecimalFormat df = new DecimalFormat("#.#");
                String newDepth = df.format(depth);
                String depthText = newDepth + " km";
                this.text(depthText, lattitude - 15, longitude + height - 8);
*/
            
        }
    }
}
