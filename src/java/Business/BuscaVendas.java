/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.PedidoDao;
import entidades.Cliente;
import entidades.Pedido;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import entidades.ProdutoPedido;
import entidades.ServicoPedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author k
 */
public class BuscaVendas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            PedidoDao pdao = new PedidoDao();
            String op = "";
            op = request.getParameter("op");
            switch (op) {
                case "exibirVendas":
                    {
                        ArrayList<Pedido> ped = pdao.listaPedidos();
                        
                        String ret = "";
                         
                        for(Pedido p : ped){
                            Cliente c = p.getCliente();
                            ret += "t.row.add( ['"+p.getId()+"','";
                            if(c instanceof PessoaFisica){
                                ret+=((PessoaFisica) c).getCpf()+"','";
                                ret+=((PessoaFisica) c).getNome()+"','";
                             }
                             else if(c instanceof PessoaJuridica){
                                ret+=((PessoaJuridica) c).getCnpj()+"','"; 
                                ret+=((PessoaJuridica) c).getRazao_social()+"','"; 
                             }
                             ret+="R$";
                             ret+=String.format("%.2f", p.getValor_total())+"','";
                             ret+=p.getData()+"']).draw(false);";
                        }
                        out.print(ret);
                        
                    }
                    break;
                case "exibirPedido":
                {
                    String id = VendaTemp.pdBusca;
                    VendaTemp.pdBusca = "";
                    Pedido p = new PedidoDao().getPedido(Integer.parseInt(id));
                    out.print(exibirPedido(p));
                }
                    break;
                case "colocarIdPedido":
                {
                    String id = request.getParameter("idPedido");
                    VendaTemp.pdBusca = id;
                }
                    break;
                default:
                    break;
            }
        }
        catch(Exception e){
            
        }
    }
    
    public String exibirPedido(Pedido p){
        String ret = "debugger;";
        Cliente c = p.getCliente();
        if(c instanceof PessoaFisica){
            ret+="$('#dados-pf').show();";
            ret+="$('#dados-pj').hide();";
            ret+="$('#nomeCliente').val('"+((PessoaFisica) c).getNome()+"');";
            ret+="$('#cpfCliente').val('"+((PessoaFisica) c).getCpf()+"');";
        }
        else if(c instanceof PessoaJuridica){
            ret+="$('#dados-pf').hide();";
            ret+="$('#dados-pj').show();";
            ret+="$('#razaoSocialCliente').val('"+((PessoaJuridica) c).getRazao_social()+"');";
            ret+="$('#cnpjCliente').val('"+((PessoaJuridica) c).getCnpj()+"');";
        }
        ret+="";
        

        
        
        ret+="$('#statusPedido').val('"+p.getStatus()+"');";
        ret+="$('#pagoPedido').val('"+(p.isPago()?"Sim":"Não")+"');";
        ret+="$('#dataPedido').val('"+p.getData()+"');";
        ret+="$('#tipoPagamento').val('"+p.getTipo_pagamento()+"');";
        ret+="$('#formaPagamento').val('"+p.getForma_pagamento()+"');";
        ret+="$('#valTotal').val('R$"+String.format("%.2f", p.getValor_total())+"');";
        
        if(p.getLista_produtos().isEmpty()){
            ret+="$('#tabelaProdutos').hide();";
        }
        else{
            ret+="$('#tabelaProdutos').show();";
            String tb = "";
            for(ProdutoPedido pp : p.getLista_produtos()){
                tb+="<tr>";
                tb+="<td>"+pp.getProduto().getId()+"</td>";
                tb+="<td>"+pp.getProduto().getNome()+"</td>";
                tb+="<td>R$"+String.format("%.2f", pp.getProduto().getValor())+"</td>";
                tb+="<td>"+pp.getQtd()+"</td>";
                tb+="<td>R$"+String.format("%.2f", pp.getValor_total())+"</td>";
                tb+="</tr>";
            }
            ret+="$('#tbody_produtos').html('"+tb+"');";
        }
        
        if(p.getLista_servicos().isEmpty()){
            ret+="$('#tabelaServicos').hide();";
        }
        else{
            ret+="$('#tabelaServicos').show();";
            String tb = "";
            for(ServicoPedido sp : p.getLista_servicos()){
                tb+="<tr>";
                tb+="<td>"+sp.getServico().getId()+"</td>";
                tb+="<td>"+sp.getServico().getNome()+"</td>";
                tb+="<td>R$"+String.format("%.2f", sp.getServico().getValor())+"</td>";
                tb+="<td>"+sp.getMeses_duracao()+"</td>";
                tb+="<td>R$"+String.format("%.2f", sp.getValor_total())+"</td>";
                tb+="</tr>";
            }
            ret+="$('#tbody_servicos').html('"+tb+"');";
        }

        return(ret);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
