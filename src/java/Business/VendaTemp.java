/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.PedidoDao;
import entidades.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author logonaf
 */
public class VendaTemp {
    
    public static String id = "";
    public static ArrayList<ProdutoPedido> listaProdutosPed = new ArrayList<ProdutoPedido>();
    public static ArrayList<ServicoPedido> listaServicosPed = new ArrayList<ServicoPedido>();
    public static Pedido pedido = new Pedido();
    public static Cliente cliente = new Cliente();
    
    public static void limpaVenda(){
         id = "";

        listaProdutosPed = new ArrayList<ProdutoPedido>();
        listaServicosPed = new ArrayList<ServicoPedido>();
        pedido = new Pedido();
        cliente = new Cliente();
    }
    
    public static void apontar(){
        pedido.setLista_produtos(listaProdutosPed);
        pedido.setLista_servicos(listaServicosPed);
        pedido.setCliente(cliente);
    }
    
    public static void finalizarVenda(){
        try{
        ZonedDateTime data = ZonedDateTime.now();
        pedido.setData(String.valueOf(data.getYear())+"-"+String.valueOf(data.getMonthValue())+"-"+String.valueOf(data.getDayOfMonth()));
        pedido.setStatus("Aberto");
        pedido.setVendedor(new Funcionario("André Marques",1));
        PedidoDao pddao = new PedidoDao();
        pddao.inserirPedido(pedido);
        }
        catch(Exception e){
            
        }
    }
}
