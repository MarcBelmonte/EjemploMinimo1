package edu.upc.eetac.dsa;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.*;

public interface ProductManager {
    //Listado de productos ordenado ascendentemente por precio
    List<Producto> getProductosOrdenados();
    /*-Realizar un pedido (que puede estar formado por diferentes productos y en
    diferentes cantidades) por parte de un usuario identificado*/
    void realizarPedido(String user, Pedido p);
    /*- Servir un pedido. Los servicios se realizan en orden de llegadas Eliminar un pedido básicamente.
     Simplemente notificar que se ha eliminado. No tiene ningún parámetro.*/
    void servirPedido();
    /*- Listado de pedidos de un usuario que ya hayan sido realizados
    Devuelve un listado de un usuario pasado por parámetro. Vamos al contenedor de usuarios,
    lo localizamos y me devuelve la lista de comandes de su historial.*/
    //LinkedList<Pedido> getPedidosdeUser(String user) throws UserPrincipalNotFoundException;
    LinkedList<Pedido> getPedidosdeUser(String user);
    /* - Listado de productos ordenado (descendentemente) por número de ventas
    No tiene ningún parámetro y devuelve una lista de productos.*/
    List<Producto> getProductosTop();

    void addUsuario(String user);
    void addProducto(Producto p);
    Queue<Pedido> getHistorial();
    Usuario getUsuario(String user);

}
