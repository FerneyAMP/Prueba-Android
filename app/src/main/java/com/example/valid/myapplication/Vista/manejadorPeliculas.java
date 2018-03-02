package com.example.valid.myapplication.Vista;

import com.example.valid.myapplication.Modelo.DTO.Pagina;
import com.example.valid.myapplication.Modelo.DTO.Pelicula;

import java.io.IOException;

/**
 * Created by Valid on 2/03/2018.
 */

public interface manejadorPeliculas {
    public void peliculasRecibidas(Pagina peliculas);
    public void errorObteniendoPeliculas(IOException e);


}
