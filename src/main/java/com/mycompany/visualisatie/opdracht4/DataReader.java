/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.visualisatie.opdracht4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author KevinPC
 */
public class DataReader {

    public String reader() throws FileNotFoundException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("aardbevingen.csv").getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String data = sb.toString();
        br.close();
        return data;
    }

    public ArrayList<DataModel> parser() throws IOException, ParseException {
        String data = reader();
        String regex = ",";
        Scanner sc = new Scanner(data);
        String[] split = sc.nextLine().split(regex);
        ArrayList<DataModel> list = new ArrayList();
        //System.out.println(Arrays.toString(header));
        while (sc.hasNext()) {
            String[] row = sc.nextLine().split(regex);
            DataModel dm = new DataModel();

            dm.setLongitude(Float.parseFloat(row[0]));
            dm.setLatitude(Float.parseFloat(row[1]));
            dm.setObjectid(Integer.parseInt(row[2]));
            dm.setLocation(row[3]);
            dm.setMagnitude(Float.parseFloat(row[4]));
            dm.setDepth(Float.parseFloat(row[5]));

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date date = formatter.parse(row[6]);
            dm.setDate(date);

            list.add(dm);
        }

        return list;
    }

}
