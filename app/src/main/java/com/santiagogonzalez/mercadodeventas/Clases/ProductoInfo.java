package com.santiagogonzalez.mercadodeventas.Clases;

public class ProductoInfo {

    private String myStringNombreDelProducto;
    private String myStringPrecioDelProducto;
    private int myIntImagenDelProducto;

    public ProductoInfo(String myStringNombreDelProducto, String myStringPrecioDelProducto, int myIntImagenDelProducto){
        this.myStringNombreDelProducto = myStringNombreDelProducto;
        this.myStringPrecioDelProducto = myStringPrecioDelProducto;
        this.myIntImagenDelProducto = myIntImagenDelProducto;
    }

    public String getMyStringNombreDelProducto() {
        return myStringNombreDelProducto;
    }

    public void setMyStringNombreDelProducto(String myStringNombreDelProducto) {
        this.myStringNombreDelProducto = myStringNombreDelProducto;
    }

    public String getMyStringPrecioDelProducto() {
        return myStringPrecioDelProducto;
    }

    public void setMyStringPrecioDelProducto(String myStringPrecioDelProducto) {
        this.myStringPrecioDelProducto = myStringPrecioDelProducto;
    }

    public int getMyIntImagenDelProducto() {
        return myIntImagenDelProducto;
    }

    public void setMyIntImagenDelProducto(int myIntImagenDelProducto) {
        this.myIntImagenDelProducto = myIntImagenDelProducto;
    }
}
