package org.linlinjava.litemall.expmts.csv_ops_exp;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

/**
 * 从CSV文件中读取内容同时自动解析为对象
 */
public class OpenCSVReadAndParseToBean {
    private static final String SAMPLE_CSV_FILE_PATH = "./file.csv";

    public static void main(String[] args) throws IOException {

        try (
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                CSVUser csvUser = csvUserIterator.next();
                System.out.println("Name : " + csvUser.getName());
                System.out.println("Email : " + csvUser.getEmail());
                // System.out.println("PhoneNo : " + csvUser.getPhoneNo());
                System.out.println("Country : " + csvUser.getCountry());
                System.out.println("==========================");
            }
        }
    }

    // // Reads all CSV contents into memory (Not suitable for large CSV files)
    // private static void readAllBeansAtOnce(CsvToBean csvToBean) {
    //     List<CSVUser> csvUsers = csvToBean.parse();

    //     for(CSVUser csvUser: csvUsers) {
    //         System.out.println("Name : " + csvUser.getName());
    //         System.out.println("Email : " + csvUser.getEmail());
    //         // System.out.println("PhoneNo : " + csvUser.getPhoneNo());
    //         System.out.println("Country : " + csvUser.getCountry());
    //         System.out.println("==========================");
    //     }
    // }
}
