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
public class ServicoPedido extends Servico {
    private Pedido pedido;

    public ServicoPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public ServicoPedido(Pedido pedido, Servico servico) {
        super(servico);
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    
}
