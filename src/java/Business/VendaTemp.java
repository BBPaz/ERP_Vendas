/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.PedidoDao;
import entidades.*;
import java.util.ArrayList;

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
    }
    
    public static void finalizarVenda(){
        PedidoDao pddao = new PedidoDao();
        pddao.insertPedido(pedido);
    }
}
