/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Isso;

/**
 *
 * @author logonaf
 */
public class ProdutoPedido {
    private int qtd;
    private float valor_total;
    private boolean devolvido;
    private Produto produto;

    public ProdutoPedido() {
    }

    public ProdutoPedido(int qtd, Produto produto) {
        this.qtd = qtd;
        this.produto = produto;
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
    
    public void calcValor(){
        float val;
        val = produto.getValor()*qtd;
        this.valor_total = val;
    }
    
    public ProdutoPedido devolverProduto(int qtd){
        ProdutoPedido _new = new ProdutoPedido(this.qtd,this.produto);
        this.devolvido = true;
        _new.qtd = _new.qtd-qtd;
        return _new;
    }
    
    public void devolverProduto(){
        this.devolvido = true;
    }
}
