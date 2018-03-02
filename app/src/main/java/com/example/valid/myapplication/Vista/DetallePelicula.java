package com.example.valid.myapplication.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.valid.myapplication.Modelo.DTO.Pelicula;
import com.example.valid.myapplication.R;

import java.io.Serializable;

public class DetallePelicula extends AppCompatActivity {
    private Pelicula pelicula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);
        Intent intent = getIntent();
        Serializable pelicula = intent.getSerializableExtra("pelicula_detalle");
        this.pelicula = (Pelicula) pelicula;
    }
}
