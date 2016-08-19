package com.alosatriani.mascotasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalleBiografia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_biografia);


        TextView txBio = (TextView)findViewById(R.id.tvBiografia);

        txBio.setText("Nombre: Sergio Alosno Del Villar Orozco\n\nEdad: 37 años\n\n" +
                "Escolaridad: Ingenierio en Computación.\n\nCon 10 años trabajando en para la industria de " +
                "la programación Web, buscando iniciar un camino por el sendero de Android.\n\n" +
                "Orgulloso programador Java. ");
    }
}
