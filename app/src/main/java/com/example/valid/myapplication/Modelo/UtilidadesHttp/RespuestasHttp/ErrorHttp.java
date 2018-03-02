package com.example.valid.myapplication.Modelo.UtilidadesHttp.RespuestasHttp;

import com.example.valid.myapplication.Vista.manejadorPeliculas;

import java.io.IOException;

/**
 * Created by Valid on 2/03/2018.
 */

public class ErrorHttp implements Runnable {
    public IOException e;
    public manejadorPeliculas contextoHttp;
    public ErrorHttp(IOException e,manejadorPeliculas contextoHttp){
        this.e  = e;
        this.contextoHttp = contextoHttp;
    }


    public void run() {

        contextoHttp.errorObteniendoPeliculas(e);

    }
}
