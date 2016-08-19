package com.alosatriani.mascotasapp.vo;



import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Sergio on 03/08/2016.
 */
public class MascotasVO /*implements Serializable,  Comparable<MascotasVO>*/{


    private String nombre;
    private Integer rating= new Integer(0);
    private int foto;
    private int id;

    public MascotasVO() {
    }

    public MascotasVO(String nombre, int foto){
        this.nombre = nombre;
        this.foto = foto;
       // this.dtVisto = fhInicial

    }

    public MascotasVO(String nombre, int foto, Integer rating){
        this.nombre = nombre;
        this.foto = foto;
        this.rating = rating;
        // this.dtVisto = fhInicial

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /*
    public Date getDtVisto() {
        return dtVisto;
    }

    public void setDtVisto(Date dtVisto) {
        this.dtVisto = dtVisto;
    }
    */

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

/*
    @Override
        public int compareTo(MascotasVO o) {
        return o.getDtVisto().compareTo(getDtVisto());
    }
*/

}
