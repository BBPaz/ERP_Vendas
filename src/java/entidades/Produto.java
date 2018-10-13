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
public class Produto {
    private String produto;
    private float valor;
    private String descricao;
    private String nome;
    private String tipo;

    public Produto() {
    }

    
    
    public Produto(String produto, float valor, String descricao, String nome, String tipo) {
        this.produto = produto;
        this.valor = valor;
        this.descricao = descricao;
        this.nome = nome;
        this.tipo = tipo;
    }
    
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
