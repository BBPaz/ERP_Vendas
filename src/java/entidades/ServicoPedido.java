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
    private int meses_duracao;

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

    public int getMeses_duracao() {
        return meses_duracao;
    }

    public void setMeses_duracao(int meses_duracao) {
        this.meses_duracao = meses_duracao;
    }
    
    public float valorTotal(){
        float val = 0f;
        val = servico.getValor()*meses_duracao;
        return val;
    }

    
    
}
