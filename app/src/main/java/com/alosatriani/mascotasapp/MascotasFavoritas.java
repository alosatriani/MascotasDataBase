package com.alosatriani.mascotasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.alosatriani.mascotasapp.adaptador.MascotasAdapter;
import com.alosatriani.mascotasapp.db.ConstructorMascotas;
import com.alosatriani.mascotasapp.presentador.IRecyclerViewFragmentPresenter;
import com.alosatriani.mascotasapp.presentador.IRecyclerViewMascotasFavoritasPresenter;
import com.alosatriani.mascotasapp.vo.MascotasVO;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity implements IRecyclerViewMascotasFavoritas {

    ArrayList<MascotasVO> mascotas;
    ArrayList<MascotasVO> mascotasFavoritas;
    private RecyclerView rvListaMascotasFavoritas;
    private IRecyclerViewMascotasFavoritasPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        ImageView starIV = (ImageView) findViewById(R.id.star);
        starIV.setVisibility(View.GONE);

        //Activamos el ToolBar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        rvListaMascotasFavoritas = (RecyclerView)findViewById(R.id.rvMascotasFavoritas);

        generarLinearLayoutVertical();

        inicializarAdaptadorRV();


    }


    public void irFavoritos(View v){}


    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        //GridLayoutManager glm = new GridLayoutManager(this,2);

        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotasFavoritas.setLayoutManager(llm);
    }


    public MascotasAdapter crearAdaptador() {

        ConstructorMascotas constructorMascotas = new ConstructorMascotas(this.getBaseContext());
        return new MascotasAdapter(constructorMascotas.obtenerMascotasFavoritas(), this);
    }



    public void inicializarAdaptadorRV() {
        rvListaMascotasFavoritas.setAdapter(crearAdaptador());
    }

}
