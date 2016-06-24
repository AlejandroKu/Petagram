package com.culturacampeche.petagram;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lstMiLista;
    Adapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB();

        // Me permite manipular el elemento XML desde un código Java
        // En este caso el elemento sfiMiIndicadorRefresh está identificado en activity_main.java
        // (SwiperefresLayout) y (ListView) hacen un casteo
        sfiMiIndicadorRefresh = (SwipeRefreshLayout) findViewById(R.id.sfiMiIndicadorRefresh);
        lstMiLista = (ListView) findViewById(R.id.lstMiLista);

        // Le asignamos al arreglo planetas toda la lista que habíamos hecho en strings.xml
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));

        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }

    public void refrescandoContenido() {
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        sfiMiIndicadorRefresh.setRefreshing(false);
    }

    public void agregarFAB() {
        // Me permite manipular el elemento XML desde un código Java
        // En este caso el elemento fabMiFAB está identificado en activity_main.java
        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.fabMiFAB);
        miFAB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();
                // Snack bar para noticicaciones con una acción integrada
                Snackbar.make(v, getResources().getString(R.string.mensaje), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            public void onClick(View v) {
                                Log.i("SNACKBAR", "Click en Snackbar");
                            }
                        })
                        // Cambiar color
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });
    }
}
