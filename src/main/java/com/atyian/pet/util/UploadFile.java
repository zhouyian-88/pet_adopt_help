package com.atyian.pet.util;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.UUID;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-13-11:24
 */
public class UploadFile {

    public static String uploadImage(MultipartFile multipartFile) throws IOException {
        InputStream is = multipartFile.getInputStream();
        String originalFilename = multipartFile.getOriginalFilename();
        //得到后缀名
        String extension = FilenameUtils.getExtension(originalFilename);
        String newFileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + extension;
        //创建一个文件对象
        FileOutputStream os = new FileOutputStream(new File("D:/image",newFileName));
        IOUtils.copy(is,os);
        return newFileName;
    }
}
