package com.alosatriani.mascotasapp.db;

/**
 * Created by Sergio on 16/08/2016.
 */
public final class ConstantesBD {

    public final static  String DATA_BASE_NAME  = "mascotas";
    public final static  int DATA_BASE_VERSION = 1;

    public final static String TABLA_MASCOTA                    = "mascota";
    public final static String TABLA_MASCOTA_ID                 = "id";
    public final static String TABLA_MASCOTA_NOMBRE             = "nombre";
    public final static String TABLA_MASCOTA_FOTO               = "foto";

    public final static String TABLA_RATING_MASCOTA             = "mascota_rating";
    public final static String TABLA_RATING_MASCOTA_ID          = "id";
    public final static String TABLA_RATING_MASCOTA_ID_MASCOTA  = "id_mascota";
    public final static String TABLA_RATING_MASCOTA_RATING       = "cantidadRatings";

}
