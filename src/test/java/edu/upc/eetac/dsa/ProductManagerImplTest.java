package edu.upc.eetac.dsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class ProductManagerImplTest {
    final static Logger log = Logger.getLogger(ProductManagerImplTest.class.getName());
    ProductManager pm;
    Usuario u1, u2;
    Producto producto1, producto2, producto3, producto4, producto5, producto6;
    Pedido pedido1, pedido2,pedido3;
    //List<Pedido.LProducto> lp1,lp2,lp3;

    @Before
    public void setUp() throws Exception {

        pm = ProductManagerImpl.getInstance();
        this.pm = new ProductManagerImpl();

        //List<Producto> ListaProductos = new ArrayList<Producto>();

        pm.addUsuario("Marc");
        pm.addUsuario("Sonia");
        pm.addUsuario("Felipe");
        pm.addUsuario("Robert");

        producto1 = new Producto("Limones",1,2);
        producto2 = new Producto("Melones",3,5);
        producto3 = new Producto("Agua",2,7);
        producto4 = new Producto("Gambas",6,5);
        producto5 = new Producto("Naranjas",4,9);
        pm.addProducto(producto1);
        pm.addProducto(producto2);
        pm.addProducto(producto3);
        pm.addProducto(producto4);
        pm.addProducto(producto5);



    }

    @After
    public void tearDown() throws Exception {
        pm = null;
    }

    @Test
    public void getInstance() {
    }

    @Test
    public void getProductosOrdenados() {
        List<Producto> productosOrdenados = this.pm.getProductosOrdenados();
        assertEquals(productosOrdenados.get(0).getNombre(),"Limones");
        assertEquals(productosOrdenados.get(1).getNombre(),"Agua");
        assertEquals(productosOrdenados.get(2).getNombre(),"Melones");
        assertEquals(productosOrdenados.get(3).getNombre(),"Naranjas");
        assertEquals(productosOrdenados.get(4).getNombre(),"Gambas");

    }

    @Test
    public void realizarPedido() {
        LinkedList<LineaDePedido> lista = new LinkedList<LineaDePedido>();
        LineaDePedido lp = new LineaDePedido(producto1,4);
        LineaDePedido lp2= new LineaDePedido(producto2,3);
        lista.add(lp);
        lista.add(lp2);
        Pedido pedido = new Pedido(lista);

        log.info("Tamaño pedido"+pedido.getListaDePedidos().size());
        assertEquals(pedido.getListaDePedidos().size(),2);
    }

    @Test
    public void servirPedido() {
        LinkedList<LineaDePedido> lista = new LinkedList<LineaDePedido>();
        LineaDePedido lp = new LineaDePedido(producto1,4);
        LineaDePedido lp2= new LineaDePedido(producto2,3);
        lista.add(lp);
        lista.add(lp2);
        Pedido pedido = new Pedido(lista);
        pm.realizarPedido("Marc",pedido);

        Pedido pedido2 = new Pedido(lista);
        pm.realizarPedido("Robert",pedido2);
        pm.servirPedido();
        assertEquals(pm.getHistorial().size(),1);
    }

    @Test
    public void getPedidosdeUser() {
        LinkedList<LineaDePedido> lista = new LinkedList<LineaDePedido>();
        LineaDePedido lp = new LineaDePedido(producto1,4);
        LineaDePedido lp2= new LineaDePedido(producto2,3);
        lista.add(lp);
        lista.add(lp2);
        Pedido pedido = new Pedido(lista);
        pedido.setUsuario(pm.getUsuario("Marc"));
        pm.realizarPedido("Marc",pedido);

        Pedido pedido2 = new Pedido(lista);
        pedido2.setUsuario(pm.getUsuario("Marc"));
        pm.realizarPedido("Marc",pedido2);

        Pedido pedido3 = new Pedido(lista);
        pedido3.setUsuario(pm.getUsuario("Robert"));
        pm.realizarPedido("Robert",pedido3);

        pm.servirPedido();
        pm.servirPedido();
        pm.servirPedido();
        assertEquals(pm.getPedidosdeUser("Robert").size(),1);
        assertEquals(pm.getPedidosdeUser("Marc").size(),2);
    }

    @Test
    public void getProductosTop() {
    }
}