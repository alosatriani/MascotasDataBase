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
import com.alosatriani.mascotasapp.vo.MascotasVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Sergio on 03/08/2016.
 */
public class DetalleAdapter extends RecyclerView.Adapter<DetalleAdapter.MascotaViewHolder>  {

    Activity activity;
    ArrayList<MascotasVO> mascotas;
    boolean blnFavoritos = false;

    public DetalleAdapter(ArrayList<MascotasVO> mascotas, Activity activity, boolean blnFavoritos){
        this.mascotas = mascotas;
        this.activity = activity;
        this.blnFavoritos =blnFavoritos;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detalle_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final MascotasVO mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
       // mascotaViewHolder.nombreTV.setText(mascota.getNombre());
        mascotaViewHolder.ratingTV.setText(""+mascota.getRating());

        /*
        mascotaViewHolder.likeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!blnFavoritos){
                    if(mascota.getRating()>4) {
                        Toast.makeText(activity, mascota.getNombre() + " ya tiene el máximo rating.", Toast.LENGTH_SHORT).show();
                    }else{
                        mascota.setRating(mascota.getRating()+1);
                        mascotaViewHolder.ratingTV.setText(""+mascota.getRating());
                        Toast.makeText(activity, "Le has dado "+mascota.getRating()+" hueso"+((mascota.getRating()==1)?"":"s")+" a " + mascota.getNombre() + ", wauf wauf! (gracias).", Toast.LENGTH_SHORT).show();
                        mascota.setDtVisto(new Date());
                    }
                }
            }
        });
        */

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder{


        private ImageView imgFoto;
        //private TextView nombreTV;
        private TextView ratingTV;
       // private ImageButton likeCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById(R.id.fotoMascotaIV);
          //  nombreTV        = (TextView) itemView.findViewById(R.id.nombreMascotaTV);
           // likeCV        = (ImageButton) itemView.findViewById(R.id.btnLikeHueso);
            ratingTV        = (TextView) itemView.findViewById(R.id.ratingMascota);

        }
    }
}
