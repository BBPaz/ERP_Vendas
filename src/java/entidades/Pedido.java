
package entidades;

import java.util.ArrayList;

public class Pedido {
    private String id_pedido;
    private String rastreabilidade_pedido;
    private String data_abertura;
    private String data_fechamento;
    private String forma_pagamento;
    private String tipo_pedido;
    private ArrayList<ProdutoPedido> lista_produtos;
    private ArrayList<ServicoPedido> lista_servicos;
    private Vendedor vendedor;
    private Cliente cliente;
    private String tipo_pagamento;

    public Pedido() {
    }

    public Pedido(String id_pedido, String rastreabilidade_pedido, String data_abertura, String data_fechamento, String forma_pagamento, String tipo_pedido, ArrayList<ProdutoPedido> lista_produtos, ArrayList<ServicoPedido> lista_servicos, Vendedor vendedor, Cliente cliente, String tipo_pagamento) {
        this.id_pedido = id_pedido;
        this.rastreabilidade_pedido = rastreabilidade_pedido;
        this.data_abertura = data_abertura;
        this.data_fechamento = data_fechamento;
        this.forma_pagamento = forma_pagamento;
        this.tipo_pedido = tipo_pedido;
        this.lista_produtos = lista_produtos;
        this.lista_servicos = lista_servicos;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.tipo_pagamento = tipo_pagamento;
    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getRastreabilidade_pedido() {
        return rastreabilidade_pedido;
    }

    public void setRastreabilidade_pedido(String rastreabilidade_pedido) {
        this.rastreabilidade_pedido = rastreabilidade_pedido;
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

    public String getTipo_pedido() {
        return tipo_pedido;
    }

    public void setTipo_pedido(String tipo_pedido) {
        this.tipo_pedido = tipo_pedido;
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
    
    
}
