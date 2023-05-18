package com.example.crud.shared;


import org.apache.commons.lang3.StringUtils;

import java.util.Base64;

public class Util {

    public static byte[] convertiraByte(String base64){
        if(StringUtils.isNotBlank(base64)){
            String file = base64;
            file=file.substring(file.indexOf(',') + 1);
            return Base64.getDecoder().decode(file);
        }else{
            return null;
        }
    }
}
