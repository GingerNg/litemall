package org.linlinjava.litemall.expmts.csv_ops_exp;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class CSVReaderExample {

    public static void main(String[] args) {

        String csvFile = "./file.csv";
        CSVReader reader = null;

        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.println("Column 1: " + line[0]);
                System.out.println("Column 2: " + line[1]);
                System.out.println("Column 3: " + line[2]);
                System.out.println("==========================");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
