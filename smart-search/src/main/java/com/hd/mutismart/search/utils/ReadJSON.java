package com.hd.mutismart.search.utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.springframework.core.io.ClassPathResource;

public class ReadJSON {

    public static String readFromJson(String path) {

        String jsonStr = "";
        ClassPathResource classPathResource = new ClassPathResource(path);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(classPathResource.getFile());
            Reader reader = new InputStreamReader(new FileInputStream(classPathResource.getFile()), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
