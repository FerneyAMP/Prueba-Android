package com.example.valid.myapplication.Vista;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.valid.myapplication.Modelo.DTO.Pelicula;
import com.example.valid.myapplication.R;

/**
 * Created by Valid on 2/03/2018.
 */

public class AdapterPeliculas extends BaseAdapter {
    Pelicula[] peliculas;
    Context context;
    public AdapterPeliculas(Context context, Pelicula[] peliculas) {
        this.peliculas = peliculas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return peliculas.length; //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return peliculas[position]; //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View fila, ViewGroup parent) {

        if (fila == null) {

            fila = LayoutInflater.from(context).
                    inflate(R.layout.fila_lista_peliculas, parent, false);

        }
        // get current item to be displayed
        Pelicula p = peliculas[position];

        // get the TextView for item name and item description
        TextView tituloPelicula = (TextView)
                fila.findViewById(R.id.titulo_pelicula);

        //sets the text for item name and item description from the current item object
        tituloPelicula.setText(p.getOriginal_title());

        return fila;

    }

}
