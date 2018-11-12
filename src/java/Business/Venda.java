/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.EstoqueDao;
import Dao.ProdutoDao;
import Dao.ServicoDao;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import entidades.Produto;
import entidades.Servico;
import entidades.ProdutoPedido;
import entidades.ServicoPedido;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruno
 */
public class Venda extends HttpServlet {

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
            VendaTemp.apontar();
            //out.print(request.getParameter("dado"));
            VendaTemp vt = new VendaTemp();
            ProdutoDao pdao = new ProdutoDao();
            ServicoDao sdao = new ServicoDao();
            String ret = "";
            String op = "";
            op = request.getParameter("op");
            switch (op) {
                case "pesqProduto":
                    {
                        Produto prod = new Produto();
                        prod = pdao.getProduto(request.getParameter("textProduto"));
                        out.print(buscarProduto(prod));
                        break;
                    }
                case "addProduto":
                    {
                        Produto prod = new Produto();
                        prod = pdao.getProduto(request.getParameter("textProduto"));
                        addProd(prod);
                        break;
                    }
                case "attProdutos":
                    for(ProdutoPedido p:VendaTemp.listaProdutosPed){
                        out.print("<tr id='"+p.getProduto().getId()+"'>");
                        out.print("<td>"+p.getProduto().getId()+"</td>");
                        out.print("<td>"+p.getProduto().getNome()+"</td>");
                        out.print("<td>R$"+String.format("%.2f", p.getProduto().getValor())+"</td>");
                        out.print("<td><input min='1' max='"+qteDisp(p.getProduto())+"' data-produto='"+p.getProduto().getId()+"' type='number' class='form-control' id='qte"+p.getProduto().getId()+"' value='"+p.getQtd()+"'></td>");
                        out.print("<td id='valTotalP"+p.getProduto().getId()+"''>R$"+String.format("%.2f", p.getValor_total())+"</td>");
                        out.print("<td><button class='removeProd btn btn-danger' value='"+p.getProduto().getId()+"'>X</button></td>");
                        out.print("</tr>");
                    }
                    break;
                case "removeProduto":
                    {
                        String codProd = request.getParameter("textProduto");
                        removeProd(codProd);
                        
                    }
                    break;
                case "verDisp":
                {
                    String codProd = request.getParameter("textProduto");
                    break;
                }
                case "altQuantProduto":
                {
                    String codProd = request.getParameter("textProduto");
                    int qte = Integer.parseInt(request.getParameter("qte"));
                    float val = altQuant(codProd, qte);
                    if(val!=0){
                        out.print("R$"+String.format("%.2f",val));
                    }
                    break;
                }
                case "pesqServico":
                {
                    Servico serv = new Servico();
                    serv = sdao.getServico(request.getParameter("textServico"));
                    out.print(buscarServico(serv));
                    break;
                }
                case "addServico":
                {
                    Servico serv = new Servico();
                    serv = sdao.getServico(request.getParameter("textServico"));
                    addServ(serv);
                    break;
                }
                case "attServicos":
                    for(ServicoPedido s:VendaTemp.listaServicosPed){
                        out.print("<tr id='"+s.getServico().getId()+"'>");
                        out.print("<td>"+s.getServico().getId()+"</td>");
                        out.print("<td>"+s.getServico().getNome()+"</td>");
                        out.print("<td>R$"+String.format("%.2f", s.getServico().getValor())+"</td>");
                        out.print("<td><input data-servico='"+s.getServico().getId()+"' type='number' class='form-control' id='dur"+s.getServico().getId()+"' value='"+s.getMeses_duracao()+"'></td>");
                        out.print("<td id='valTotalS"+s.getServico().getId()+"''>R$"+String.format("%.2f", s.getValor_total())+"</td>");
                        out.print("<td><button class='removeServ btn btn-danger' value='"+s.getServico().getId()+"'>X</button></td>");
                        out.print("</tr>");
                    }
                    break;
                case "removeServico":
                {
                    String codServ = request.getParameter("textServico");
                    removeServ(codServ);
                    break;
                }
                case "altDurServico":
                {
                    String codServ = request.getParameter("textServico");
                    int dur = Integer.parseInt(request.getParameter("dur"));
                    float val = altDur(codServ, dur);
                    if(val!=0){
                        out.print("R$"+String.format("%.2f",val));
                    }
                    break;
                }
                case "valTot":
                {
                    VendaTemp.pedido.valorTotal();
                    out.print(String.format("%.2f", VendaTemp.pedido.getValor_total()));
                }
                break;
                case "exibirCliente":
                {
                    if(VendaTemp.cliente instanceof PessoaFisica){
                        PessoaFisica pf = (PessoaFisica)VendaTemp.cliente;
                        ret+="$(\"#nomeCliente\").val(\""+pf.getNome()+"\");$(\"#idCliente\").val(\""+pf.getCpf()+"\")";
                    }
                    else if(VendaTemp.cliente instanceof PessoaJuridica){
                        PessoaJuridica pj = (PessoaJuridica)VendaTemp.cliente;
                        ret+="$(\"#nomeCliente\").val(\""+pj.getRazao_social()+"\");$(\"#idCliente\").val(\""+pj.getCnpj()+"\")";
                    }
                }
                break;
                case "ConfirmarFimVenda":
                {
                    if(VendaTemp.cliente instanceof PessoaFisica){
                        ret = confirmaVendaPf();
                    }
                    else if(VendaTemp.cliente instanceof PessoaFisica){
                        ret = confirmaVendaPj();
                    }
                    
                }
                break;
                case "setPagamento":
                {
                    VendaTemp.pedido.setTipo_pagamento(request.getParameter("tipo"));
                    VendaTemp.pedido.setForma_pagamento(request.getParameter("forma"));
                }
                break;
                case "FinalizarVenda":
                {
                    VendaTemp.finalizarVenda();
                }
                    break;
                default:
                    break;
            }
            out.print(ret);
            out.flush();
            }
        }
    
    public void removeProd(String codProd){
        int count = 0;
        for(int c = 0; c<VendaTemp.listaProdutosPed.size();c++){
            ProdutoPedido p = VendaTemp.listaProdutosPed.get(c);
             if(p.getProduto().getId().equals(codProd)){
                VendaTemp.listaProdutosPed.remove(count);
                break;
            }
            count++;
        }
    }
    
    public void addProd(Produto prod){
        boolean exist = false;
                for(ProdutoPedido p:VendaTemp.listaProdutosPed){
                    if(prod.equals(p.getProduto())){
                        exist = true;
                        break;
                    }
                }
                if(!exist){
                    ProdutoPedido prodPed = new ProdutoPedido(prod);
                    VendaTemp.listaProdutosPed.add(prodPed);
                    prodPed.setPedido(VendaTemp.pedido);
                }
    }
    
    public int qteDisp(Produto prod){
        EstoqueDao estDao = new EstoqueDao();
        int qte = 0;
        qte = estDao.quantidadeDisponivelProduto(prod.getId());
        return qte;
    }
    
    public float altQuant(String codProd,int qte){
        for(ProdutoPedido p: VendaTemp.listaProdutosPed){
            if(p.getProduto().getId().equals(codProd)){
                p.setQtd(qte);
                p.calcValor();
                return p.getValor_total();
            }
            
        }
        return 0;
    }
    
    public String  buscarProduto(Produto prod){
        String ret = "";
                if(prod!=null){
                    
                    int qteEst = 0;
                    
                    qteEst = qteDisp(prod);
                    ret+=("<table class='table table-bordered'>"    
                            + "<tr>"
                            + "<th>Código</th>"
                            + "<td>");
                    ret+=(prod.getId());
                    ret+=("</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<th>Nome</th>"
                            +"<td>"
                            +prod.getNome()
                            +"</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<th>Descrição</th>"
                            +"<td>"
                            +prod.getDescricao()
                            +"</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<th>Valor</th>"
                            +"<td>R$");
                        ret+=String.format("%.2f", prod.getValor());
                        ret+=("</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<th>Qte. Disponível no estoque</th>"
                            +"<td>"
                            +qteEst
                            +"</td>"
                            + "</tr>"
                            +"</table>");
                        if(qteEst<=0){
                            ret+="<p>Produto Indisponível</p>";
                        }
                        else{
                            ret+="<input type=\"button\" value=\"Adicionar Produto\" class=\"btn btn-primary\" id=\"addProduto\">";
                        }
                }else{
                    ret+=("Produto não encontrado");
                }
                return ret;
    }
    
    public String  buscarServico(Servico serv){
        String ret = "";
                if(serv!=null){

                    ret+=("<table class='table table-bordered'>"    
                            + "<tr>"
                            + "<th>Código</th>"
                            + "<td>");
                    ret+=(serv.getId());
                    ret+=("</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<th>Nome</th>"
                            +"<td>"
                            +serv.getNome()
                            +"</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<th>Descrição</th>"
                            +"<td>"
                            +serv.getDescricao()
                            +"</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<th>Valor</th>"
                            +"<td>R$");
                        ret+=String.format("%.2f", serv.getValor());
                        ret+=("</td>"
                            + "</tr>"
                            +"</table>");
                            ret+="<input type=\"button\" value=\"Adicionar Serviço\" class=\"btn btn-primary\" id=\"addServico\">";
                }else{
                    ret+=("Serviço não encontrado");
                }
                return ret;
    }
    
    public void addServ(Servico serv){
        boolean exist = false;
                for(ServicoPedido s:VendaTemp.listaServicosPed){
                    if(serv.getId().equals(s.getServico().getId())){
                        exist = true;
                        break;
                    }
                }
                if(!exist){
                    ServicoPedido servPed = new ServicoPedido(serv);
                    VendaTemp.listaServicosPed.add(servPed);
                    servPed.setPedido(VendaTemp.pedido);
                }
    }
    
    public void removeServ(String codProd){
        int count = 0;
        for(int c = 0; c<VendaTemp.listaServicosPed.size();c++){
            ServicoPedido s = VendaTemp.listaServicosPed.get(c);
             if(s.getServico().getId().equals(codProd)){
                VendaTemp.listaServicosPed.remove(count);
                break;
            }
            count++;
        }
    }
    
    public float altDur(String codServ,int dur){
        for(ServicoPedido s: VendaTemp.listaServicosPed){
            if(s.getServico().getId().equals(codServ)){
                s.setMeses_duracao(dur);
                s.valorTotal();
                return s.valorTotal();
            }
            
        }
        return 0;
    }
    
    public String confirmaVendaPf(){
        String ret = "";
        if(VendaTemp.listaProdutosPed.isEmpty()&&VendaTemp.listaServicosPed.isEmpty()){
            return("Insira itens antes de prosseguir");
        }
        PessoaFisica pf = (PessoaFisica)VendaTemp.cliente;
        ret+=("<table class='table'>");
        ret+=("<tr>"
            + "<th>CPF:</th>"
            + "<td>"+
            pf.getCpf()+
            "</td></tr>");
        ret+=("<tr>"
            + "<th>Nome:</th>"
            + "<td>"+
            pf.getNome()+
            "</td></tr>");
        ret+=("<tr>"
            + "<th>Valor total:</th>"
            + "<td>"+
            "R$"+String.format("%.2f", VendaTemp.pedido.getValor_total())+
            "</td></tr>");
        ret+=("<tr>"
            + "<th>Tipo de pagamento:</th>"
            + "<td>"+
            VendaTemp.pedido.getTipo_pagamento()+
            "</td></tr>");
        ret+=("<tr>"
            + "<th>Forma de pagamento:</th>"
            + "<td>"+
            VendaTemp.pedido.getForma_pagamento()+
            "</td></tr>");
        
        ret+=("</table>");
        ret+="<input type=\"button\" value=\"Finalizar Venda\" class=\"btn btn-primary\" id=\"finalizaVenda\">";
        return ret;
    }
    
    public String confirmaVendaPj(){
        String ret = "";
        if(VendaTemp.listaProdutosPed.isEmpty()&&VendaTemp.listaServicosPed.isEmpty()){
            return("Insira itens antes de prosseguir");
        }
        PessoaJuridica pj = (PessoaJuridica)VendaTemp.cliente;
        ret+=("<table class='table'>");
        ret+=("<tr>"
            + "<th>CPF:</th>"
            + "<td>"+
            pj.getCnpj()+
            "</td></tr>");
        ret+=("<tr>"
            + "<th>Nome:</th>"
            + "<td>"+
            pj.getRazao_social()+
            "</td></tr>");
        ret+=("<tr>"
            + "<th>Valor total:</th>"
            + "<td>"+
            "R$"+String.format("%.2f", VendaTemp.pedido.getValor_total())+
            "</td></tr>");
        ret+=("<tr>"
            + "<th>Tipo de pagamento:</th>"
            + "<td>"+
            VendaTemp.pedido.getTipo_pagamento()+
            "</td></tr>");
        ret+=("<tr>"
            + "<th>Forma de pagamento:</th>"
            + "<td>"+
            VendaTemp.pedido.getForma_pagamento()+
            "</td></tr>");
        
        ret+=("</table>");
        ret+="<input type=\"button\" value=\"Finalizar Venda\" class=\"btn btn-primary\" id=\"finalizaVenda\">";
        return ret;
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
