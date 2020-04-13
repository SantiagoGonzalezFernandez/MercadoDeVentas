package com.santiagogonzalez.mercadodeventas.Model;

import com.google.gson.annotations.SerializedName;

public class Producto {

    @SerializedName("id")
    private String myStringId;

    @SerializedName("title")
    private String myStringTitulo;

    @SerializedName("price")
    private double myDoublePrecio;

    @SerializedName("condition")
    private String myStringCondicion;

    @SerializedName("thumbnail")
    private String myStringImagen;

    public String getMyStringId() {
        return myStringId;
    }

    public void setMyStringId(String myStringId) {
        this.myStringId = myStringId;
    }

    public String getMyStringTitulo() {
        return myStringTitulo;
    }

    public void setMyStringTitulo(String myStringTitulo) {
        this.myStringTitulo = myStringTitulo;
    }

    public double getMyDoublePrecio() {
        return myDoublePrecio;
    }

    public void setMyDoublePrecio(double myDoublePrecio) {
        this.myDoublePrecio = myDoublePrecio;
    }

    public String getMyStringCondicion() {
        return myStringCondicion;
    }

    public void setMyStringCondicion(String myStringCondicion) {
        this.myStringCondicion = myStringCondicion;
    }

    public String getMyStringImagen() {
        return myStringImagen;
    }

    public void setMyStringImagen(String myStringImagen) {
        this.myStringImagen = myStringImagen;
    }
}
