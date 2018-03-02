package com.example.valid.myapplication.Controlador;

import android.content.Context;

import com.example.valid.myapplication.Modelo.UtilidadesHttp.FabricaUrl;
import com.example.valid.myapplication.Modelo.UtilidadesHttp.ConexionHttp;
import com.example.valid.myapplication.Modelo.UtilidadesHttp.manejadorRespuestaHttp;

/**
 * Created by Valid on 2/03/2018.
 */

public class Controlador {
    public static void ObtenerPeliculas(String opcion, Context contexto){
        String url = FabricaUrl.obtenerUrl(contexto,opcion);
        ConexionHttp conexion = ConexionHttp.getInstance();
        conexion.obtenerRespuesta(url, new manejadorRespuestaHttp(contexto));
    }
}
