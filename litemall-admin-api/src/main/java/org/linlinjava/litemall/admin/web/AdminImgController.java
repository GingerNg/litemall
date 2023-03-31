package org.linlinjava.litemall.admin.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.io.IOUtils;
import org.linlinjava.litemall.core.util.ResponseUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin/img")
public class AdminImgController {

    @PostMapping("/upload")
    public Object upload(@RequestBody String body, HttpServletRequest request) {
        Map<Object, Object> result = new HashMap<Object, Object>();
        // result.put("token", currentUser.getSession().getId());
        // result.put("adminInfo", adminInfo);
        return ResponseUtil.ok(result);
    }

    @GetMapping("/show")
    public byte[] show(String imgId){
        InputStream in = getClass()
          .getResourceAsStream("/root/Projects/litemall/storage/12345.jpeg");
        try {
            return IOUtils.toByteArray(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/download")
    public Object download(String imgId){
        return null;
    }

}
