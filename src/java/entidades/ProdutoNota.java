/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author igors
 */
public class ProdutoNota {


    
    private String nome;
    private int qtd_item;
    private float valor_total;
    private float valor_unitario;
    private int id_produto;
    private float valor_icms;
    private float valor_ipi;

    public ProdutoNota() {
    }
    
    public ProdutoNota(ProdutoPedido p) {
        //this.id_produto = p.getProduto().getId();
        this.nome = p.getProduto().getNome();
        this.qtd_item = p.getQtd();
        //MEU CELULAR REINICIOU<<<<<<<<<<<<<<<<
        this.valor_total = p.getValor_total();
        this.valor_unitario = p.getProduto().getValor();
        //tendeu?
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd_item() {
        return qtd_item;
    }

    public void setQtd_item(int qtd_item) {
        this.qtd_item = qtd_item;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public float getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(float valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public float getValor_icms() {
        return valor_icms;
    }

    public void setValor_icms(float valor_icms) {
        this.valor_icms = valor_icms;
    }

    public float getValor_ipi() {
        return valor_ipi;
    }

    public void setValor_ipi(float valor_ipi) {
        this.valor_ipi = valor_ipi;
    }

    
}
