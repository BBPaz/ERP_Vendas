
package entidades;

import java.util.ArrayList;

public class Pedido {
    private String id;
    private String rastreabilidade;
    private String data_abertura;
    private String data_fechamento;
    private String forma_pagamento;
    private ArrayList<ProdutoPedido> lista_produtos = new ArrayList<ProdutoPedido>();
    private ArrayList<ServicoPedido> lista_servicos = new ArrayList<ServicoPedido>();
    private Vendedor vendedor;
    private Cliente cliente;
    private String tipo_pagamento;

    public Pedido() {
    }

    public Pedido(String id, String rastreabilidade, String data_abertura, String data_fechamento, String forma_pagamento, Vendedor vendedor, Cliente cliente, String tipo_pagamento) {
        this.id = id;
        this.rastreabilidade = rastreabilidade;
        this.data_abertura = data_abertura;
        this.data_fechamento = data_fechamento;
        this.forma_pagamento = forma_pagamento;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.tipo_pagamento = tipo_pagamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRastreabilidade() {
        return rastreabilidade;
    }

    public void setRastreabilidade(String rastreabilidade) {
        this.rastreabilidade = rastreabilidade;
    }

    public String getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(String data_abertura) {
        this.data_abertura = data_abertura;
    }

    public String getData_fechamento() {
        return data_fechamento;
    }

    public void setData_fechamento(String data_fechamento) {
        this.data_fechamento = data_fechamento;
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

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
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
    
    public float valorTotal(){
        float val = 0f;
        for(ProdutoPedido p:lista_produtos){
            val+=p.getValor_total();
        }
        for(ServicoPedido s:lista_servicos){
            val+=s.valorTotal();
        }
        return val;
    }
    
    
    
}
