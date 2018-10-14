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
public class Servico {
    private String id;
    private float valor;
    private String descricao;
    private String nome;

    public Servico() {
    }

    public Servico(String id, float valor, String descricao, String nome) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.nome = nome;
    }
    
    public Servico(Servico servico) {
        this.id = servico.getId();
        this.valor = servico.getValor();
        this.descricao = servico.getDescricao();
        this.nome = servico.getNome();
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
    
    
}
