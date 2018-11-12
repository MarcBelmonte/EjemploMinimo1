package edu.upc.eetac.dsa;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.*;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

import org.apache.log4j.Logger;


public class ProductManagerImpl implements ProductManager{

   //Llamamos al archivo de propiedades de LOG4J
    final static Logger log = Logger.getLogger(ProductManagerImpl.class.getName());
    //Aplicamos la fachada usando el patrón Singleton
    private static ProductManager instance;

    private List<Producto> productos;
    private LinkedList<Pedido> pedidos;
    //Hashmap (string, usuario) de usuarios
    private HashMap<String,Usuario> usuarios;
    private Queue<Pedido> historialPedidos = new LinkedList<Pedido>();

    public ProductManagerImpl(){
        productos = new ArrayList<Producto>(); //ME SALE ERROR Y NO LO ENTIENDO
        pedidos = new LinkedList<>();
        usuarios = new HashMap<>();
    }

    public static ProductManager getInstance(){
        if(instance == null) instance = new ProductManagerImpl();
        return instance;
    }
    public void addUsuario(String user){
        usuarios.put(user, new Usuario(user));
    }

    public void addProducto(Producto p){
        this.productos.add(p);
    }
    public Queue<Pedido> getHistorial (){
        return  this.historialPedidos;
    }
    public Usuario getUsuario (String user){
       return this.usuarios.get(user);
    }


    public List<Producto> getProductosOrdenados(){
        //Copiamos la lista
        List<Producto> lista = new ArrayList<>(this.productos);

        //Aplicamos el criterio de orden
        Collections.sort(lista, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                //Ascending order
                return (int)(p1.getPrecio()-p2.getPrecio());
            }
        });

        return lista;
    }

    @Override
    public void realizarPedido(String user, Pedido p) {
        //this.pedidos = null;
        Usuario u = this.usuarios.get(user);
        if(u!=null){
            u.addPedido(p);
            this.historialPedidos.offer(p);
        }else{
            this.usuarios.put(user,new Usuario(user));
            u = this.usuarios.get(user);
            u.addPedido(p);
            this.historialPedidos.offer(p);
        }

    }

    @Override
    public void servirPedido() { //Podría ser un boolean? Habria que eliminar
        Pedido p = null;
        p = this.historialPedidos.poll();
        p.setPedidoRealizado(true);

        //p.isPedidoRealizado(true);
    }

    @Override
    //ublic LinkedList<Pedido> getPedidosdeUser(String user) throws UserPrincipalNotFoundException {
    public LinkedList<Pedido> getPedidosdeUser(String user){
        Usuario u = this.usuarios.get(user);
        LinkedList<Pedido> pedidoList = new LinkedList<>();
        for (Pedido p: u.consultaPedidos() ){
            if(p.isPedidoRealizado()){
                pedidoList.add(p);
            }else{

            }
        }
        return pedidoList;
    }

    @Override
    public List<Producto> getProductosTop() {
        List<Producto> lista = this.productos;
        lista.addAll(this.productos);

        Collections.sort(lista, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2){
                return (int) ((-1)*(p1.getPrecio()-p2.getPrecio()));
            }
        });
        return lista;
    }
}
