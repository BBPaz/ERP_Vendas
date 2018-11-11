
package entidades;

import Dao.ProdutoDao;
import java.util.ArrayList;

public class Pedido {
    private String id;
    private String status;
    private String data;
    private String forma_pagamento;
    private ArrayList<ProdutoPedido> lista_produtos = new ArrayList<ProdutoPedido>();
    private ArrayList<ServicoPedido> lista_servicos = new ArrayList<ServicoPedido>();
    private Funcionario vendedor;
    private Cliente cliente;
    private String tipo_pagamento;
    private float valor_total;
    private boolean pago;
    
  
    
    public Pedido() {
        valorTotal();
    }
    
    public Pedido(String id, String data, String forma_pagamento, Funcionario vendedor, Cliente cliente, String tipo_pagamento) {
        this.id = id;
        this.data = data;
        this.forma_pagamento = forma_pagamento;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.tipo_pagamento = tipo_pagamento;
        this.pago = false;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public ArrayList<ProdutoPedido> getLista_produtos() {
        return lista_produtos;
    }

    public void setLista_produtos(ArrayList<ProdutoPedido> lista_produtos) {
        this.lista_produtos = lista_produtos;
    }

    public ArrayList<ServicoPedido> getLista_servicos() {
        return lista_servicos;
    }

    public void setLista_servicos(ArrayList<ServicoPedido> lista_servicos) {
        this.lista_servicos = lista_servicos;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipo_pagamento() {
        return tipo_pagamento;
    }

    public void setTipo_pagamento(String tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }
    
    
    
    public void valorTotal(){
        float val = 0f;
        for(ProdutoPedido p:lista_produtos){
            val+=p.getValor_total();
        }
        for(ServicoPedido s:lista_servicos){
            val+=s.valorTotal();
        }
        valor_total = val;
    }
    
    
    
}
