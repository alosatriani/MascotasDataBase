package com.alosatriani.mascotasapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.alosatriani.mascotasapp.adaptador.PageAdapter;
import com.alosatriani.mascotasapp.fragment.FragmentDetalle;
import com.alosatriani.mascotasapp.fragment.FragmentRecycleView;
import com.alosatriani.mascotasapp.vo.MascotasVO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Intent intent;


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Activamos el ToolBar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(miActionBar);

        toolBar = (Toolbar) findViewById(R.id.toolBar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        setUpViewPager();

        if(toolBar ==  null){
            setSupportActionBar(toolBar);
        }


    }

    private  ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentRecycleView());
        fragments.add(new FragmentDetalle());

        return fragments;

    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_detalle);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);
    }


    public void inicializarListaMascotas(Bundle bdl){



        // bdl = intent.getExtras();
        ArrayList<MascotasVO> listaMascotas = null;
        try{
            listaMascotas = (ArrayList<MascotasVO> ) bdl.getSerializable("MascotasVO");

        }catch(Exception e){

        }


    }


    public void irFavoritos(View v){
        Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
        startActivity(intent);
    /*
        ArrayList<MascotasVO> mascotas = new ArrayList<MascotasVO>();


        // mascotas.add(new MascotasVO("Pelusa", R.drawable.pelusa));
        mascotas.add(new MascotasVO("Bola", R.drawable.dog5));
        // mascotas.add(new MascotasVO("Frida", R.drawable.frida));
        mascotas.add(new MascotasVO("Kika", R.drawable.dog4));
        // mascotas.add(new MascotasVO("Bombón", R.drawable.enzo));

        mascotas.add(new MascotasVO("lambda", R.drawable.dog1));
        // mascotas.add(new MascotasVO("Bombón", R.drawable.karin));

        mascotas.add(new MascotasVO("Roosky", R.drawable.dog6));


        mascotas.add(new MascotasVO("Chuky", R.drawable.dog2));

        intent.putExtra("MascotasVO",mascotas);



*/
    }




    //MENU DE OPCIONES
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    //MENU DE OPCIONES
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.mContacto:
                intent = new Intent(MainActivity.this, Contacto.class);
                break;

            case R.id.mAbout:
                intent = new Intent(MainActivity.this, DetalleBiografia.class);
                break;

        }

        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }

}
