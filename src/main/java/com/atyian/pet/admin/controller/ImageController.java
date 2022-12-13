package com.atyian.pet.admin.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-12-10:52
 */
@Controller
@RequestMapping("/image")
public class ImageController {
    @RequestMapping("/show")
    public void headImage(String fileName,HttpServletResponse response) throws ServletException, IOException {
        File file=new File("D:/image",fileName);
        InputStream is=new FileInputStream(file);
        IOUtils.copy(is,response.getOutputStream());
    }
}
