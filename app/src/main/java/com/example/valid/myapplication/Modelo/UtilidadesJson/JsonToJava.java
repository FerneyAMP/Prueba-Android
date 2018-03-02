package com.example.valid.myapplication.Modelo.UtilidadesJson;
import com.example.valid.myapplication.Modelo.DTO.Pagina;
import com.google.gson.Gson;
import com.example.valid.myapplication.Modelo.DTO.Pelicula;

/**
 * Created by Valid on 2/03/2018.
 */

public class JsonToJava {

    private static JsonToJava instancia = null;
    private Gson gson;

    private JsonToJava(){
        gson = new Gson();
    }

    public static JsonToJava getInstance(){
        if(instancia == null){
            instancia = new JsonToJava();
        }
        return instancia;
    }

    public Pagina DesSerializarPeliculas(String JsonPeliculas){
        Pagina pagina = gson.fromJson(JsonPeliculas, Pagina.class);
        return pagina;
    }
}
