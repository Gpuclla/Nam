package com.example.am;

public class Restaurante {
    int id;
    int fotorest;
    String titulo;
    String ubica;
    String descrip;
    String LongLat;

    public Restaurante(int id, int fotorest, String titulo, String ubica, String descrip, String LongLat) {
        this.id = id;
        this.fotorest = fotorest;
        this.titulo = titulo;
        this.ubica = ubica;
        this.descrip = descrip;
        this.LongLat = LongLat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFotorest() {
        return fotorest;
    }

    public void setFotorest(int fotorest) {
        this.fotorest = fotorest;
    }

    public String getUbica() {
        return ubica;
    }

    public void setUbica(String ubica) {
        this.ubica = ubica;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLongLat() {
        return LongLat;
    }

    public void setLongLat(String longLat) {
        LongLat = longLat;
    }
}
