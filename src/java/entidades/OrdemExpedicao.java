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
public class OrdemExpedicao {
    private String status;
    private String numero_nota;
    private String data_entrega;
    private String id_vendedor;
    private Pedido Pedido;

    public OrdemExpedicao(String status, String numero_nota, String data_entrega, String id_vendedor, Pedido Pedido) {
        this.status = status;
        this.numero_nota = numero_nota;
        this.data_entrega = data_entrega;
        this.id_vendedor = id_vendedor;
        this.Pedido = Pedido;
    }

    public OrdemExpedicao() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumero_nota() {
        return numero_nota;
    }

    public void setNumero_nota(String numero_nota) {
        this.numero_nota = numero_nota;
    }

    public String getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(String data_entrega) {
        this.data_entrega = data_entrega;
    }

    public String getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(String id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public Pedido getPedido() {
        return Pedido;
    }

    public void setPedido(Pedido Pedido) {
        this.Pedido = Pedido;
    }
   
    
}
