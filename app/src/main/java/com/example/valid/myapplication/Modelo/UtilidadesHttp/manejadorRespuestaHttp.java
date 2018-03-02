package com.example.valid.myapplication.Modelo.UtilidadesHttp;

import android.content.Context;
import android.os.Handler;

import com.example.valid.myapplication.Modelo.UtilidadesHttp.RespuestasHttp.ErrorHttp;
import com.example.valid.myapplication.Modelo.UtilidadesHttp.RespuestasHttp.RespuestaHttpExitosa;
import com.example.valid.myapplication.Vista.manejadorPeliculas;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import com.example.valid.myapplication.Modelo.UtilidadesJson.JsonToJava;

/**
 * Created by Valid on 2/03/2018.
 */

public class manejadorRespuestaHttp implements Callback {
    Context contexto;
    JsonToJava convertidor;

    public manejadorRespuestaHttp(Context contexto){
        this.contexto = contexto;
        convertidor = JsonToJava.getInstance();
    }

    public void onFailure(Call call, IOException e) {
        Handler mainHandler = new Handler(contexto.getMainLooper());
        mainHandler.post(new ErrorHttp(e,(manejadorPeliculas)contexto));

    }

    public void onResponse(Call call, Response response) throws IOException {

        Handler mainHandler = new Handler(contexto.getMainLooper());
        mainHandler.post(new RespuestaHttpExitosa(response.code(),response.body().string(),convertidor,(manejadorPeliculas)contexto));

    }
}
