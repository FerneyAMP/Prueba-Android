package com.example.valid.myapplication.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.valid.myapplication.Modelo.DTO.Pagina;
import com.example.valid.myapplication.Modelo.DTO.Pelicula;
import com.example.valid.myapplication.R;

import java.io.IOException;

import com.example.valid.myapplication.Controlador.*;

public class Principal extends AppCompatActivity implements manejadorPeliculas {

    private TextView mTextMessage;
    private ListView listaPeliculas;
    Pagina PaginaActual;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        mTextMessage = (TextView) findViewById(R.id.message);
        listaPeliculas = (ListView) findViewById(R.id.listaPeliculas);
        listaPeliculas.setOnItemSelectedListener(new ManejadorFilaListaSelected(this));
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new ManejadorMenuInferior(this));


    }

    protected void onStart(){
        super.onStart();
        Controlador.ObtenerPeliculas(this.getResources().getString(R.string.opc_popular),this);
    }

    @Override
    public void peliculasRecibidas(Pagina peliculas) {
        PaginaActual = peliculas;
        TextView t = (TextView)findViewById(R.id.message);

        AdapterPeliculas a = new AdapterPeliculas(this, peliculas.getResults());

        listaPeliculas.setAdapter(a);

    }

    @Override
    public void errorObteniendoPeliculas(IOException e) {
        TextView t = (TextView)findViewById(R.id.titulo_pelicula);
        t.setText("Error al obtener las peliculas por medio del servicio");
    }

    public void obtenerListaPeliculas(String opc){
        Controlador.ObtenerPeliculas(opc,this);
    }

    public void verDetallePelicula(int index){
        Intent intent = new Intent(this, DetallePelicula.class);
        Pelicula[] peliculas = this.PaginaActual.getResults();
        intent.putExtra("pelicula_detalle", peliculas[index]);
        startActivity(intent);
    }
}
