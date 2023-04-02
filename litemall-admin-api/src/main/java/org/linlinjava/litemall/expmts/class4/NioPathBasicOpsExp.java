package org.linlinjava.litemall.expmts.class4;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
// Java NIO File API使用总结 https://g.nereusyi.com/post/2020/08/java-file-nio-demo/
public class NioPathBasicOpsExp {

    public static void main(String[] args) throws Exception{
        String demoPath = "/home/ubuntu/Projects/litemall/storage22";
        URI uri = new URI("file:///" + demoPath);
        // method 1
        Path path1 = Paths.get(demoPath);

        // method 2
        Path path2 = Paths.get(uri);

        // method 3
        Path path3 = Path.of(demoPath);

        // method 4
        Path path4 = Path.of(uri);
        System.out.println(path1);
    }
}
