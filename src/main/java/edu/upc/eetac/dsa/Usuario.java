package edu.upc.eetac.dsa;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    String nombre;
    private LinkedList<Pedido> pedidoList;
    public Usuario(String nombre){
        this.nombre = nombre;
        this.pedidoList = new LinkedList<>();
    }


    public LinkedList<Pedido> consultaPedidos(){
        return this.pedidoList;
    }
    public void addPedido(Pedido p){
        this.pedidoList.add(p);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
