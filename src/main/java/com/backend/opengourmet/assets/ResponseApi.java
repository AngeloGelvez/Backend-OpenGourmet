package com.backend.opengourmet.assets;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ResponseApi {

    public static HashMap<String, Object> responseJson = new HashMap<>();

    public static void setResponseJson(String titulo, Object value) {
        /*
        * Estructura
        * "Estado": 200
        * "mensaje": "SALIO ok"
        * "Contenido": [ListUsuarios]
        * */
        responseJson.put(titulo, value);
    }
}
