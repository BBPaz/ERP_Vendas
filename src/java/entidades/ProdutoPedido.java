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
public class ProdutoPedido{
    private int qtd;
    private float valor_total;
    private boolean devolvido;
    private Pedido pedido;
    private Produto produto;

    public ProdutoPedido() {
    }
    
    public ProdutoPedido(Produto produto) {
        qtd = 1;
        this.produto = produto;
        valor_total = this.calcValor();
        devolvido = false;
    }

    public ProdutoPedido(int qtd, Pedido pedido, Produto produto) {
        this.qtd = qtd;
        this.pedido = pedido;
        this.produto = produto;
        valor_total = this.calcValor();
        devolvido = false;
    }  

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
        this.valor_total = calcValor();
    }

    public float getValor_total() {
        return valor_total;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
        
    public ProdutoPedido devolverProduto(int qtd){
        ProdutoPedido _new = new ProdutoPedido(this.qtd,this.pedido,this.produto);
        this.devolvido = true;
        _new.qtd = _new.qtd-qtd;
        return _new;
    }
    
    public void devolverProduto(){
        this.devolvido = true;
    }
    
    public float calcValor(){
        return qtd*produto.getValor();
    }
    
}
