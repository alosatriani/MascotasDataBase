package com.alosatriani.mascotasapp.adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alosatriani.mascotasapp.R;
import com.alosatriani.mascotasapp.db.ConstructorMascotas;
import com.alosatriani.mascotasapp.vo.MascotasVO;

import java.util.ArrayList;


/**
 * Created by Sergio on 03/08/2016.
 */
public class MascotasAdapter  extends RecyclerView.Adapter<MascotasAdapter.MascotaViewHolder>  {

    Activity activity;
    ArrayList<MascotasVO> mascotas;
    boolean blnFavoritos = false;


    public MascotasAdapter(ArrayList<MascotasVO> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    public MascotasAdapter(ArrayList<MascotasVO> mascotas, Activity activity, boolean blnFavoritos){
        this.mascotas = mascotas;
        this.activity = activity;
        this.blnFavoritos =blnFavoritos;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final MascotasVO mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.nombreTV.setText(mascota.getNombre());
        mascotaViewHolder.ratingTV.setText(""+mascota.getRating());

        mascotaViewHolder.likeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(activity, "Le diste rating a: " +mascota.getNombre(),Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darRatingMascota(mascota);

                mascotaViewHolder.ratingTV.setText(""+constructorMascotas.obtenerRatingMascota(mascota) );
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder{


        private ImageView imgFoto;
        private TextView nombreTV;
        private TextView ratingTV;
        private ImageButton likeCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById(R.id.fotoMascotaIV);
            nombreTV        = (TextView) itemView.findViewById(R.id.nombreMascotaTV);
            likeCV        = (ImageButton) itemView.findViewById(R.id.btnLikeHueso);
            ratingTV        = (TextView) itemView.findViewById(R.id.ratingMascota);

        }
    }
}
