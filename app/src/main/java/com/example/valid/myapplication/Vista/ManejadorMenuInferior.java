package com.example.valid.myapplication.Vista;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.valid.myapplication.Controlador.Controlador;
import com.example.valid.myapplication.R;

/**
 * Created by Valid on 2/03/2018.
 */

public class ManejadorMenuInferior implements BottomNavigationView.OnNavigationItemSelectedListener {

    Principal contexto;
    TextView tituloLista;

    public ManejadorMenuInferior(Principal contexto){
        this.contexto = contexto;
        TextView tituloLista = (TextView) contexto.findViewById(R.id.message);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:

                Controlador.ObtenerPeliculas(contexto.getResources().getString(R.string.opc_popular),contexto);
                tituloLista.setText(contexto.getResources().getString(R.string.opc_popular));


                return true;
            case R.id.navigation_dashboard:
                Controlador.ObtenerPeliculas(contexto.getResources().getString(R.string.opc_topRated),contexto);
                tituloLista.setText(R.string.opc_topRated);

                return true;
            case R.id.navigation_notifications:
                Controlador.ObtenerPeliculas(contexto.getResources().getString(R.string.opc_upcoming),contexto);
                tituloLista.setText(contexto.getResources().getString(R.string.opc_upcoming));
                return true;
        }
        return false;
    }
}
