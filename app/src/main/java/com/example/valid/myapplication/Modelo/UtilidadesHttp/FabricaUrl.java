package com.example.valid.myapplication.Modelo.UtilidadesHttp;

import android.content.Context;

import com.example.valid.myapplication.R;

import okhttp3.HttpUrl;

/**
 * Created by Valid on 2/03/2018.
 */

public class FabricaUrl {
    public static String obtenerUrl(Context contexto, String opcion){

        String rutaUrl = contexto.getResources().getString(R.string.ruta_url_api);
        String campoApiKey = contexto.getResources().getString(R.string.campo_api_key);
        String apiKey = contexto.getResources().getString(R.string.api_key_moviedb);

        if(opcion == contexto.getResources().getString(R.string.opc_popular)){
            rutaUrl += contexto.getResources().getString(R.string.ruta_popular);
        }else
        if(opcion == contexto.getResources().getString(R.string.opc_topRated)){
            rutaUrl += contexto.getResources().getString(R.string.ruta_top_rated);
        }else
        if(opcion == contexto.getResources().getString(R.string.opc_upcoming)){
            rutaUrl += contexto.getResources().getString(R.string.ruta_upcoming);
        }else{
            rutaUrl += contexto.getResources().getString(R.string.ruta_popular);
        }

        HttpUrl.Builder urlBuilder = HttpUrl.parse(rutaUrl).newBuilder();
        urlBuilder.addQueryParameter(campoApiKey, apiKey);
        return urlBuilder.build().toString();
    }
}
