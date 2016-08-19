package com.alosatriani.mascotasapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alosatriani.mascotasapp.R;
import com.alosatriani.mascotasapp.adaptador.MascotasAdapter;
import com.alosatriani.mascotasapp.presentador.IRecyclerViewFragmentPresenter;
import com.alosatriani.mascotasapp.presentador.RecyclerViewFragmentPresenter;
import com.alosatriani.mascotasapp.vo.MascotasVO;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecycleView extends Fragment implements IRecyclerViewFragmentView {
    ArrayList<MascotasVO> mascotas;
    private RecyclerView rvListaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    public FragmentRecycleView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);


        rvListaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this,getContext());
        return v;
    }



    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //GridLayoutManager glm = new GridLayoutManager(this,2);

        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotasAdapter crearAdaptador(ArrayList<MascotasVO> mascotas) {
        MascotasAdapter mascotasAdapter = new MascotasAdapter(mascotas, getActivity());
        return mascotasAdapter;
    }

    @Override
    public void inicializarAdaptadorRV(MascotasAdapter adaptador) {
        rvListaMascotas.setAdapter(adaptador);
    }
}
