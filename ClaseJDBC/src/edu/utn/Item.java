package edu.utn;

public class Item {

    int idItem;
    String nombreProducto;
    int cantidad;
    double precio;

    public Item(Integer idItem, String nombreProducto, int cantidad, double precio) {
        this.idItem = idItem;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Item(String nombreProducto, int cantidad, double precio) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
