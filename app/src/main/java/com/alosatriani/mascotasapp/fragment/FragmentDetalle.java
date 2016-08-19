package com.alosatriani.mascotasapp.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alosatriani.mascotasapp.R;
import com.alosatriani.mascotasapp.adaptador.DetalleAdapter;
import com.alosatriani.mascotasapp.adaptador.MascotasAdapter;
import com.alosatriani.mascotasapp.vo.MascotasVO;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalle extends Fragment {

    ArrayList<MascotasVO> mascotas;
    private RecyclerView rvListaMascotas;

    public FragmentDetalle() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detalle, container, false);


        CircularImageView circularImageView = (CircularImageView)v.findViewById(R.id.imgCirculo);
        // Set Border
        circularImageView.setBorderColor(getResources().getColor(R.color.colorPrimaryDark));
        circularImageView.setBorderWidth(10);
        circularImageView.addShadow();
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(R.color.colorPrimary);
        circularImageView.setBackgroundColor(getResources().getColor(R.color.fondo));




        rvListaMascotas = (RecyclerView)v.findViewById(R.id.rvFragMascotaDetalle);
        GridLayoutManager llm = new GridLayoutManager(getActivity(),2);

        llm.setOrientation(GridLayoutManager.VERTICAL);
        rvListaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();

        inicializarAdaptadorMascotas();

        return v;
    }



    public void inicializarListaMascotas(){


        mascotas = new ArrayList<MascotasVO>();


        mascotas.add(new MascotasVO("Bola", R.drawable.husk1,9));
        mascotas.add(new MascotasVO("Bola", R.drawable.husk2, 7));
        mascotas.add(new MascotasVO("Bola", R.drawable.husk3, 4));
        mascotas.add(new MascotasVO("Bola", R.drawable.husk10, 10));
        mascotas.add(new MascotasVO("Bola", R.drawable.husk5, 8));
        mascotas.add(new MascotasVO("Bola", R.drawable.husk6, 4));
        mascotas.add(new MascotasVO("Bola", R.drawable.husk7, 7));
        mascotas.add(new MascotasVO("Bola", R.drawable.husk9 ,0));






    }


    public void inicializarAdaptadorMascotas(){
        DetalleAdapter detalleAdapter = new DetalleAdapter(mascotas, getActivity(), false);
        rvListaMascotas.setAdapter(detalleAdapter);
    }

}
