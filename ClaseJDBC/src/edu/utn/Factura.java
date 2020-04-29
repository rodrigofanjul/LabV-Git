package edu.utn;

import java.util.Date;
import java.util.List;

public class Factura {

    Integer idFactura;
    String nombreCliente;
    Date fecha;
    List<Item> items;


    public Factura(Integer idFactura, String nombreCliente, Date fecha, List<Item> items) {
        this.idFactura = idFactura;
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.items = items;
    }

    public Factura(String nombreCliente, Date fecha, List<Item> items) {
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.items = items;
    }


    public double getPrecioTotal() {
        double precioTotal = 0;
        for (Item i :  this.getItems()) {
                precioTotal = precioTotal + i.getPrecio() * i.getCantidad();
        }
        return precioTotal;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
