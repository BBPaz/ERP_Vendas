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
    private float valor_total;

    public ServicoPedido() {
    }
    
    public ServicoPedido(Servico serv) {
        this.servico = serv;
        meses_duracao = 1;
        valor_total = valorTotal();
    }

    public ServicoPedido(Pedido pedido, Servico servico, int meses_duracao, float valor_total) {
        this.pedido = pedido;
        this.servico = servico;
        this.meses_duracao = meses_duracao;
        valor_total = valorTotal();
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
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
        valor_total = valorTotal();
    }
    
    public float valorTotal(){
        float val = 0f;
        val = servico.getValor()*meses_duracao;
        return val;
    }

    
    
}
