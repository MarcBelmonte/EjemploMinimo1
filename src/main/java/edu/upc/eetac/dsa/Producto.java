package edu.upc.eetac.dsa;

import java.util.Comparator;

public class Producto {
    private String nombre;
    private double precio;
    private int numeroVentas=0;

    public Producto(String nombre, double precio, int numeroVentas) {
        this.nombre = nombre;
        this.precio = precio;
        this.numeroVentas = numeroVentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumeroVentas() {
        return numeroVentas;
    }

    public void setNumeroVentas(int numeroVentas) {
        this.numeroVentas = numeroVentas;
    }
}
