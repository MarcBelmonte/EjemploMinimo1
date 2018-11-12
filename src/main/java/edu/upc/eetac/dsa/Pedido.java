package edu.upc.eetac.dsa;
import java.util.LinkedList;
import java.util.List;

public class Pedido {

    Usuario usuario = null;
    private boolean pedidoRealizado = false;
    private List<LineaDePedido> lp = null;

    public Pedido(List<LineaDePedido> lp) {
        this.lp = new LinkedList<LineaDePedido>(lp);
    }

    public Pedido() {
    }

    public void addUser (Usuario user){
        this.usuario = user;
    }

    public void add(Producto pd, int num){
        this.lp.add(new LineaDePedido(pd,num));
    }
    public List<LineaDePedido> getListaDePedidos(){
        return this.lp;
    }
    public void setListaDePedidos(LinkedList pedido){
        this.lp = pedido;
    }
    public void getUsuario(){
        this.usuario=usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public boolean isPedidoRealizado() {
        return pedidoRealizado;
    }

    public void setPedidoRealizado(boolean pedidoRealizado) {
        this.pedidoRealizado = pedidoRealizado;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Pedido pedido = (Pedido) o;

        if (pedidoRealizado != pedido.pedidoRealizado) return false;
        if(!usuario.equals(pedido.usuario)) return false;
        return lp.equals(pedido.lp);
    }

}
