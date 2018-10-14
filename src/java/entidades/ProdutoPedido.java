/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author logonaf
 */
public class ProdutoPedido extends Produto{
    private int qtd;
    private float valor_total;
    private boolean devolvido;
    private Pedido pedido;

    public ProdutoPedido() {
    }

    public ProdutoPedido(int qtd, Pedido pedido) {
        this.qtd = qtd;
        this.pedido = pedido;
        this.devolvido = false;
    }

    public ProdutoPedido(int qtd, Pedido pedido, Produto produto) {
        super(produto);
        this.qtd = qtd;
        this.pedido = pedido;
        this.devolvido = false;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public ProdutoPedido devolverProduto(int qtd){
        ProdutoPedido _new = new ProdutoPedido(this.qtd,this.pedido);
        this.devolvido = true;
        _new.qtd = _new.qtd-qtd;
        return _new;
    }
    
    public void devolverProduto(){
        this.devolvido = true;
    }
}
