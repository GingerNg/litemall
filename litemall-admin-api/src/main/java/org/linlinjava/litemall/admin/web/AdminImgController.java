package org.linlinjava.litemall.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.linlinjava.litemall.core.storage.StorageService;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallStorage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/admin/img")
public class AdminImgController {
    @Autowired
    private StorageService storageService;

    @PostMapping("/upload")
    public Object upload(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        LitemallStorage litemallStorage = storageService.store(file.getInputStream(), file.getSize(),
                file.getContentType(), originalFilename);
        return ResponseUtil.ok(litemallStorage);
    }

    @GetMapping("/show")
    public void show(String imgId, HttpServletResponse response){
        String imgPath = "/home/ubuntu/Projects/litemall/storage/12345.jpeg"; // todo
        try {
            File file = new File(imgPath);
            byte[] imageData = Files.readAllBytes(file.toPath());

            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            response.setContentLength(imageData.length);

            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(imageData);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @GetMapping("/download")
    public Object download(String imgId){
        return null;
    }

}
