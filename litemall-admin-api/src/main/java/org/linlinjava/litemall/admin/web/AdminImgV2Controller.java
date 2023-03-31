package org.linlinjava.litemall.admin.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.linlinjava.litemall.core.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@RequestMapping("/admin/imgV2")
public class AdminImgV2Controller implements WebMvcConfigurer{
    // [Spring Boot搭建简单的图片服务器](https://blog.csdn.net/qq_39749527/article/details/112492160)

    // 注入我们配置文件中写好的图片保存路径  在application.yml中添加下面配置
    @Value("${user.filepath}")
    private String filePath;

    @PostMapping("/upload")
    public Object upload_v1(@RequestParam("file") MultipartFile file) throws IOException {
        // String filePath = "/home/ubuntu/Projects/litemall/storage/"; //  文件夹路径
        // 生成一个随机的名称，避免文件名重复
        UUID uuid = UUID.randomUUID();
        // 获取原文件名称
        String originalFileName = file.getOriginalFilename();
        // 获取原文件的后缀
        String fileSuffix = originalFileName.substring(originalFileName.lastIndexOf('.'));
        // 保存文件
        File saveFile = new File(filePath + uuid + fileSuffix);
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseUtil.ok("error");
        }
        // 返回图片的完整访问路径，这地方ip和端口可以改为动态获得，这样在部署到服务器上时无需改变，为了方便起见这里直接写死了
        String returnUrl = "http://localhost:3000/admin/imgV2/"+uuid+fileSuffix;
        return ResponseUtil.ok(returnUrl);
    }

    // 自定义资源映射
    // 访问图片示例：http://localhost:3000/api/images/图片名称.jpg
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/admin/imgV2/**")
                .addResourceLocations("file:"+ filePath);
    }

    //*************************************************************************** */
}
