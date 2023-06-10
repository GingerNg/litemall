package org.linlinjava.litemall.expmts.csv_ops_exp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.excel.EasyExcel;

// https://segmentfault.com/a/1190000038566393

// head()用来放表头数据，dataList()用来放每一行的数据。

public class ExcelOpsExp {
    private static List<List<String>> head() {
        List<List<String>> list = new ArrayList<>();
        List<String> head0 = new ArrayList<>();
        head0.add("姓名");
        List<String> head1 = new ArrayList<>();
        head1.add("年龄");
        List<String> head2 = new ArrayList<>();
        head2.add("生日");
        list.add(head0);
        list.add(head1);
        list.add(head2);
        return list;
    }

    private static List<List<Object>> dataList() {
        List<List<Object>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Object> data = new ArrayList<>();
            data.add("张三");
            data.add(25);
            data.add(new Date());
            list.add(data);
        }
        return list;
    }

    public static void main(String[] args) {
        // 生成Excel路径
        String fileName = "/home/ubuntu/Projects/litemall/litemall-admin-api/src/main/java/org/linlinjava/litemall/expmts/测试.xlsx";
                EasyExcel.write(fileName).head(head()).sheet("模板").doWrite(dataList());
    }
}


