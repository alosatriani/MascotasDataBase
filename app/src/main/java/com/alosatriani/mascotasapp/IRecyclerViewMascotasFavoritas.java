package com.alosatriani.mascotasapp;

import com.alosatriani.mascotasapp.adaptador.MascotasAdapter;


/**
 * Created by Sergio on 17/08/2016.
 */
public interface IRecyclerViewMascotasFavoritas {

    public void generarLinearLayoutVertical();

    public MascotasAdapter crearAdaptador();

    public void inicializarAdaptadorRV();
}
