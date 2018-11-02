
package entidades;

import Dao.ProdutoDao;
import java.util.ArrayList;

public class Pedido {
    private String id;
    private String rastreabilidade;
    private String data_abertura;
    private String data_fechamento;
    private String forma_pagamento;
    private ArrayList<ProdutoPedido> lista_produtos = new ArrayList<ProdutoPedido>();
    private ArrayList<ServicoPedido> lista_servicos = new ArrayList<ServicoPedido>();
    private Funcionario vendedor;
    private Cliente cliente;
    private String tipo_pagamento;
    private float valor_total;

    public Pedido() {
    }
    
    public Pedido exemplo (){
        String id = "2";
        String rastreabilidade = "Fechado";
        String data_abertura = "02/03/1999";
        String data_fechamento = "02/03/1999";
        String forma_pagamento = "Vista";
        Funcionario f1 = new Funcionario("Igor", 2);
        Cliente c1 = new Cliente().exemplo();
        String tipo_pagemento = "Dinheiro";
        float valor_total = 10000.0f;
        ProdutoDao d1 = new ProdutoDao();
        
        Produto pdt = new Produto();
        pdt.setId("124125");
        pdt.setValor(1.2f);
        pdt.setDescricao("Uma panela bem bonita.");
        pdt.setNome("Panela bonita");

        Produto pdt2 = new Produto();
        pdt2.setId("3");
        pdt2.setValor(1.8f);
        pdt2.setDescricao("Uma panela bem feia.");
        pdt2.setNome("Panela feia");

        ProdutoPedido pdp = new ProdutoPedido();
        pdp.setProduto(pdt);
        pdp.setPedido(this);
        pdp.setDevolvido(false);
        pdp.setQtd(3);

        ProdutoPedido pdp2 = new ProdutoPedido();
        pdp2.setProduto(pdt2);
        pdp2.setPedido(this);
        pdp2.setDevolvido(false);
        pdp2.setQtd(3);
        
        
        
        lista_produtos.add(pdp);
        lista_produtos.add(pdp2);
        
        Servico sp = new Servico();
        sp.setId(String.valueOf(12));
        sp.setValor(100);
        sp.setDescricao("Dia bosta");
        sp.setNome("Fogo nos nazistas");
        
        ServicoPedido p1 = new ServicoPedido();
        p1.setServico(sp);
        p1.setPedido(this);
        p1.setMeses_duracao(5);
        
 
        
        lista_servicos.add(p1);
        return this;
    }

    public Pedido(String id, String rastreabilidade, String data_abertura, String data_fechamento, String forma_pagamento, Funcionario vendedor, Cliente cliente, String tipo_pagamento) {
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
