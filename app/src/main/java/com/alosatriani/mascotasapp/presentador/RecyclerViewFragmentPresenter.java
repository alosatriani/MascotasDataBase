package com.alosatriani.mascotasapp.presentador;

import android.content.Context;

import com.alosatriani.mascotasapp.db.ConstructorMascotas;
import com.alosatriani.mascotasapp.fragment.IRecyclerViewFragmentView;
import com.alosatriani.mascotasapp.vo.MascotasVO;


import java.util.ArrayList;

/**
 * Created by Sergio on 15/08/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{


    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<MascotasVO> mascotas;
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }



    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos(true);
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
