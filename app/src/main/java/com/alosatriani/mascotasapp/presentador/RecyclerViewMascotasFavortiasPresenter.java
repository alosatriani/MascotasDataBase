package com.alosatriani.mascotasapp.presentador;

import android.content.Context;

import com.alosatriani.mascotasapp.db.ConstructorMascotas;
import com.alosatriani.mascotasapp.IRecyclerViewMascotasFavoritas;
import com.alosatriani.mascotasapp.vo.MascotasVO;

import java.util.ArrayList;

/**
 * Created by Sergio on 15/08/2016.
 */
public class RecyclerViewMascotasFavortiasPresenter implements IRecyclerViewMascotasFavoritasPresenter {


    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<MascotasVO> mascotas;
    private IRecyclerViewMascotasFavoritas iRecyclerViewMascotasFavoritas;

    public RecyclerViewMascotasFavortiasPresenter(IRecyclerViewMascotasFavoritas iRecyclerViewMascotasFavoritas, Context context) {
        this.iRecyclerViewMascotasFavoritas = iRecyclerViewMascotasFavoritas;
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
        iRecyclerViewMascotasFavoritas.inicializarAdaptadorRV();
        iRecyclerViewMascotasFavoritas.generarLinearLayoutVertical();
    }
}
