package com.example.bms.entidades;

import java.io.Serializable;

public class TemaVo implements Serializable {
    private  String titulo;
    private  String info;
    private  String descripcion;
    private  int imgID;
    private int imageDetalle;


    public TemaVo() {

    }
    public TemaVo(String titulo, String info, String descripcion,int imgID, int imageDetalle) {
        this.titulo = titulo;
        this.info = info;
        this.descripcion = descripcion;
        this.imgID = imgID;
        this.imageDetalle = imageDetalle;

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImageDetalle() {
        return imageDetalle;
    }

    public void setImageDetalle(int imageDetalle) {
        this.imageDetalle = imageDetalle;
    }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getInfo() { return info; }

    public void setInfo(String info) { this.info = info; }

    public int getImgID() { return imgID; }

    public void setImgID(int imgID) { this.imgID = imgID; }
}
