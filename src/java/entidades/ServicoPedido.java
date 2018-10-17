/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Bruno
 */
public class ServicoPedido {
    private Pedido pedido;
    private Servico servico;
    private int duracao;

    public ServicoPedido() {
    }

    public ServicoPedido(Pedido pedido, Servico servico) {
        this.pedido = pedido;
        this.servico = servico;
    }
    
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    public float valorTotal(){
        float val = 0f;
        val = servico.getValor()*duracao;
        return val;
    }

    
    
}
