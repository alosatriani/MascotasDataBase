package com.alosatriani.mascotasapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.alosatriani.mascotasapp.vo.MascotasVO;


import java.util.ArrayList;

/**
 * Created by Sergio on 16/08/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {

        super(context, ConstantesBD.DATA_BASE_NAME, null, ConstantesBD.DATA_BASE_VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuffer queryCreateDB = new StringBuffer( "CREATE TABLE " + ConstantesBD.TABLA_MASCOTA + " (" );
        queryCreateDB.append(ConstantesBD.TABLA_MASCOTA_ID +          " INTEGER PRIMARY KEY AUTOINCREMENT, ");
        queryCreateDB.append(ConstantesBD.TABLA_MASCOTA_NOMBRE +      " TEXT, ");
        queryCreateDB.append(ConstantesBD.TABLA_MASCOTA_FOTO +        " INTEGER");
        queryCreateDB.append(                                                   ")");

        StringBuffer queryTablaLikes = new StringBuffer("CREATE TABLE " + ConstantesBD.TABLA_RATING_MASCOTA + " (" );
        queryTablaLikes.append(ConstantesBD.TABLA_RATING_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
        queryTablaLikes.append(ConstantesBD.TABLA_RATING_MASCOTA_ID_MASCOTA + " INTEGER, ");
        queryTablaLikes.append(ConstantesBD.TABLA_RATING_MASCOTA_RATING+" INTEGER, ");

        queryTablaLikes.append("FOREIGN KEY("+ConstantesBD.TABLA_RATING_MASCOTA_ID_MASCOTA+") ");
        queryTablaLikes.append("REFERENCES "+ ConstantesBD.TABLA_MASCOTA + "("+ConstantesBD.TABLA_MASCOTA_ID+") ");
        queryTablaLikes.append(")");

        db.execSQL(queryCreateDB.toString());
        db.execSQL(queryTablaLikes.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TABLA_RATING_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TABLA_MASCOTA);
        onCreate(db);
    }

    public ArrayList<MascotasVO> obtenerMascotas(){
        ArrayList<MascotasVO> mascotas = new ArrayList<MascotasVO>();

        String query = " SELECT * FROM " + ConstantesBD.TABLA_MASCOTA + " ORDER BY " + ConstantesBD.TABLA_MASCOTA_ID;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor =  db.rawQuery(query, null);

        while (cursor.moveToNext()){
            MascotasVO vo = new MascotasVO();
            vo.setId(cursor.getInt(0));
            vo.setNombre(cursor.getString(1));
            vo.setFoto(cursor.getInt(2));



            String queryLikes = "SELECT COUNT("+ConstantesBD.TABLA_RATING_MASCOTA_RATING+") as likes " +
                    "FROM " + ConstantesBD.TABLA_RATING_MASCOTA +
                    " WHERE " + ConstantesBD.TABLA_RATING_MASCOTA_ID_MASCOTA +  "=" + vo.getId();

            Cursor cursorLikes = db.rawQuery(queryLikes, null);

            if(cursorLikes.moveToNext()) {
                vo.setRating(cursorLikes.getInt(0));
            }

            mascotas.add(vo);

        }

        db.close();

        return mascotas;

    }


    public ArrayList<MascotasVO> obtenerMascotasFavoritasConLikes(){
        ArrayList<MascotasVO> mascotas = new ArrayList<MascotasVO>();

        String query = " SELECT " +
                "sum(r." + ConstantesBD.TABLA_RATING_MASCOTA_RATING + ") as likes, " +
                "m."+ ConstantesBD.TABLA_MASCOTA_ID + " as id, " +
                "m."+ ConstantesBD.TABLA_MASCOTA_NOMBRE +" as nombre, " +
                "m."+ ConstantesBD.TABLA_MASCOTA_FOTO +" as foto" +
                " FROM " + ConstantesBD.TABLA_MASCOTA + " m, "+ConstantesBD.TABLA_RATING_MASCOTA+" r  " +
                " WHERE m." + ConstantesBD.TABLA_MASCOTA_ID + " = r." + ConstantesBD.TABLA_RATING_MASCOTA_ID_MASCOTA +
                " AND r." + ConstantesBD.TABLA_RATING_MASCOTA_RATING +" > 0 " +
                " GROUP BY " +
        "m."+ ConstantesBD.TABLA_MASCOTA_ID + ", " +
                "m."+ ConstantesBD.TABLA_MASCOTA_NOMBRE +", " +
                "m."+ ConstantesBD.TABLA_MASCOTA_FOTO +
                " ORDER BY  m." + ConstantesBD.TABLA_MASCOTA_ID;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor =  db.rawQuery(query, null);

        while (cursor.moveToNext()){
            MascotasVO vo = new MascotasVO();
            vo.setId(cursor.getInt(1));
            vo.setNombre(cursor.getString(2));
            vo.setFoto(cursor.getInt(3));
            vo.setRating(cursor.getInt(0));

            mascotas.add(vo);
        }

        db.close();

        return mascotas;

    }

    public void insertarMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(ConstantesBD.TABLA_MASCOTA, null, contentValues);

        db.close();
    }

    public void insertarRatingMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLA_RATING_MASCOTA, null, contentValues);

        db.close();

    }


    public int obtenerRatingMascota(MascotasVO mascota) {
        int rating = 0;

        String query = " SELECT COUNT("+ConstantesBD.TABLA_RATING_MASCOTA_RATING+") " +
                " FROM " + ConstantesBD.TABLA_RATING_MASCOTA +  " WHERE "+ConstantesBD.TABLA_RATING_MASCOTA_ID_MASCOTA+" = "+ mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor =  db.rawQuery(query, null);

        if(cursor.moveToNext()){
            rating = cursor.getInt(0);
        }

        db.close();

        return rating;

    }


    public int existenMascotas() {
        int numero = 0;

        String query = " SELECT COUNT("+ConstantesBD.TABLA_MASCOTA_ID+") " +
                " FROM " + ConstantesBD.TABLA_MASCOTA ;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor =  db.rawQuery(query, null);

        if(cursor.moveToNext()){
            numero = cursor.getInt(0);
        }

        db.close();

        return numero;

    }
}
