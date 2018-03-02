package com.example.valid.myapplication.Modelo.UtilidadesHttp;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Valid on 2/03/2018.
 */

public class ConexionHttp {
    private static ConexionHttp instancia = null;
    private OkHttpClient client;

    private ConexionHttp(){
        OkHttpClient client = new OkHttpClient();
    }

    public static ConexionHttp getInstance(){
        if(instancia == null){
            instancia = new ConexionHttp();
        }
        return instancia;
    }

    public void obtenerRespuesta(String url, manejadorRespuestaHttp handler){

        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();

        client.newCall(request).enqueue(handler);

    }
}
