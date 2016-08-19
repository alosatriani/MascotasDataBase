package com.alosatriani.mascotasapp.fragment;

import com.alosatriani.mascotasapp.adaptador.MascotasAdapter;
import com.alosatriani.mascotasapp.vo.MascotasVO;


import java.util.ArrayList;

/**
 * Created by Sergio on 17/08/2016.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotasAdapter crearAdaptador(ArrayList<MascotasVO> mascotas);

    public void inicializarAdaptadorRV(MascotasAdapter adaptador);
}
