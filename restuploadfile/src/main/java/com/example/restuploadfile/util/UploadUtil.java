package com.example.restuploadfile.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Base64;

/*
       chuyển base64 từ client sang dạng bye
       lưu vào file root + path + ghi bye vào file
        */
@Component
public class UploadUtil {
    String root = System.getProperty("user.home");
    public void writeFile(String base64, String path) throws UnsupportedEncodingException {
        byte[] decodedString = Base64.getDecoder().decode(base64.getBytes("UTF-8"));

        String rootPath = root + File.separator +  path;
        File file = new File(StringUtils.substringBeforeLast(rootPath, "/"));
        if (!file.exists()){
            file.mkdir();
        }
        try(FileOutputStream  fileOuputStream  = new FileOutputStream(new File(rootPath))) {
            fileOuputStream.write(decodedString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
