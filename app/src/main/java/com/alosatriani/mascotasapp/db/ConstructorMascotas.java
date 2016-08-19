package com.alosatriani.mascotasapp.db;

import android.content.ContentValues;
import android.content.Context;

import com.alosatriani.mascotasapp.vo.MascotasVO;
import com.alosatriani.mascotasapp.R;

import java.util.ArrayList;

/**
 * Created by Sergio on 15/08/2016.
 */
public class ConstructorMascotas {
    private Context context;
    private final static int LIKE = 1;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<MascotasVO> obtenerDatos(boolean crear){


        BaseDatos db = new BaseDatos(context);

        if(db.existenMascotas()== 0 && crear) {
            insertarCincoMascotas(db);
        }
        return db.obtenerMascotas();
    }

    public ArrayList<MascotasVO> obtenerMascotasFavoritas(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerMascotasFavoritasConLikes();
    }

    public void insertarCincoMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();


        contentValues.put(ConstantesBD.TABLA_MASCOTA_NOMBRE,"Huesos");
        contentValues.put(ConstantesBD.TABLA_MASCOTA_FOTO, R.drawable.dog1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLA_MASCOTA_NOMBRE,"Choco");
        contentValues.put(ConstantesBD.TABLA_MASCOTA_FOTO, R.drawable.dog2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLA_MASCOTA_NOMBRE,"Luna");
        contentValues.put(ConstantesBD.TABLA_MASCOTA_FOTO, R.drawable.dog3);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLA_MASCOTA_NOMBRE,"Pinky");
        contentValues.put(ConstantesBD.TABLA_MASCOTA_FOTO, R.drawable.dog4);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLA_MASCOTA_NOMBRE,"Rodny");
        contentValues.put(ConstantesBD.TABLA_MASCOTA_FOTO, R.drawable.dog5);
        db.insertarMascota(contentValues);


    }

    public void darRatingMascota(MascotasVO mascota){

        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBD.TABLA_RATING_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBD.TABLA_RATING_MASCOTA_RATING, LIKE );
        db.insertarRatingMascota(contentValues);
    }

    public int obtenerRatingMascota(MascotasVO mascota){
            BaseDatos db = new BaseDatos(context);

        return db.obtenerRatingMascota(mascota);

    }
}
