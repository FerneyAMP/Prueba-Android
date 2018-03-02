package com.example.valid.myapplication.Modelo.DTO;

/**
 * Created by Valid on 2/03/2018.
 */

public class Pagina {
    private int page;
    private Pelicula[] results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Pelicula[] getResults() {
        return results;
    }

    public void setResults(Pelicula[] peliculas) {
        this.results = peliculas;
    }


}
