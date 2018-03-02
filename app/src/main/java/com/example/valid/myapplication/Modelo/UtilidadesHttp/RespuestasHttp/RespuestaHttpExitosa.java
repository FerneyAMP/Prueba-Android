package com.example.valid.myapplication.Modelo.UtilidadesHttp.RespuestasHttp;

import com.example.valid.myapplication.Modelo.DTO.Pagina;
import com.example.valid.myapplication.Modelo.UtilidadesJson.JsonToJava;
import com.example.valid.myapplication.Vista.manejadorPeliculas;

import java.io.IOException;

/**
 * Created by Valid on 2/03/2018.
 */

public class RespuestaHttpExitosa implements Runnable {
    int codigoHttp;
    String cuerpoHttp;
    JsonToJava convertidor;
    manejadorPeliculas contextoHttp;


    public RespuestaHttpExitosa(int codigoHttp,String cuerpoHttp , JsonToJava convertidor, manejadorPeliculas contextoHttp){
        this.codigoHttp = codigoHttp;
        this.cuerpoHttp = cuerpoHttp;
        this.convertidor = convertidor;
        this.contextoHttp = contextoHttp;

    }

    @Override
    public void run() {
        switch(codigoHttp){
            case 200:
                Pagina peliculas = null;
                peliculas = convertidor.DesSerializarPeliculas(cuerpoHttp);

                contextoHttp.peliculasRecibidas(peliculas);
                break;

            default:
                IOException e = new IOException(cuerpoHttp);
                contextoHttp.errorObteniendoPeliculas(e);
        }
    }
}
