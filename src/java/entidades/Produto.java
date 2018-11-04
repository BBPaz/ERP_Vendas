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
    private String id;
    private float valor;
    private String descricao;
    private String nome;

    public Produto() {
    }
    
    public Produto Exemplo(){
        
    return null;
    }
    public Produto(String id, float valor, String descricao, String nome) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.nome = nome;
    }
    
    public Produto(Produto produto){
        this.setId(produto.getId()); 
        this.setValor(produto.getValor()); 
        this.setNome(produto.getNome()); 
        this.setDescricao(produto.getDescricao()); 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    public boolean equals(Produto p){
        boolean isEqual= false;

        if (p != null && p instanceof Produto)
        {
            isEqual = (this.id == p.id);
        }
        return isEqual;
    }
}
