package org.linlinjava.litemall.expmts.csv_ops_exp;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
// 简单向csv文件写入内容
public class CSVWriterExample {

    public static void main(String[] args) {

        String csvFile = "./file.csv";
        CSVWriter writer = null;

        try {
            writer = new CSVWriter(new FileWriter(csvFile));
            String[] header = {"Column 1", "Column 2", "Column 3"};
            writer.writeNext(header);

            String[] data1 = {"Data 1", "1", "2"};
            writer.writeNext(data1);

            String[] data2 = {"Data 2", "3", "4"};
            writer.writeNext(data2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
