package com.example.valid.myapplication.Vista;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Valid on 2/03/2018.
 */

public class ManejadorFilaListaSelected implements AdapterView.OnItemSelectedListener {
    Principal contexto;
    public ManejadorFilaListaSelected(Principal contexto){
        this.contexto = contexto;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        contexto.verDetallePelicula(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
