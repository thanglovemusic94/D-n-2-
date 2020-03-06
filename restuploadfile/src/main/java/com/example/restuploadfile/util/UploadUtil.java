package com.example.restuploadfile.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Base64;

/*
       chuyển base64 từ client sang dạng bye
       lưu vào file root + path + ghi bye vào file
        */
@Component
public class UploadUtil {
    //String root = System.getProperty("user.home");\
    @Value("${upload.path}")
    private String pathFolder;

    public void writeFile(String base64, String path) {
        String rootPath = pathFolder + File.separator + path;
        File file = new File(StringUtils.substringBeforeLast(rootPath, File.separator));
        if (!file.exists()) {
            file.mkdir();
        }
        byte[] decodedString = Base64.getDecoder().decode(base64.getBytes());
        try (FileOutputStream fileOuputStream = new FileOutputStream(new File(rootPath))) {
            fileOuputStream.write(decodedString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile(String path) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(new File(pathFolder + path));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }

}
