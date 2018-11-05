/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.EstoqueDao;
import Dao.ProdutoDao;
import Dao.ServicoDao;
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
            //out.print(request.getParameter("dado"));
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
                        out.print("<td id='valTotal"+p.getProduto().getId()+"''>R$"+String.format("%.2f", p.getValor_total())+"</td>");
                        out.print("<td><button class='removeProd btn btn-danger' value='"+p.getProduto().getId()+"'>X</button></td>");
                        out.print("</tr>");
                    }
                    break;
                case "removeProduto":
                    {
                        String codProd = request.getParameter("textProduto");
                        removeProd(codProd);
                        break;
                    }
                case "verDisp":
                    {
                        String codProd = request.getParameter("textProduto");
                        break;
                    }
                case "altQuantProduto":
                    {
                        String codProd = request.getParameter("textProduto");
                        int qte = Integer.parseInt(request.getParameter("qte"));
                        altQuant(codProd, qte);
                        break;
                    }
                case "pesqServico":
                {
                    Servico serv = new Servico();
                    serv = sdao.getServico(request.getParameter("textServico"));
                    out.print(buscarServico(serv));
                    break;
                }
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
                for(Produto p:VendaTemp.listaProdutos){
                    if(prod.equals(p)){
                        exist = true;
                        break;
                    }
                }
                if(!exist){
                    ProdutoPedido prodPed = new ProdutoPedido(prod);
                    VendaTemp.listaProdutosPed.add(prodPed);
                }
    }
    
    public int qteDisp(Produto prod){
        EstoqueDao estDao = new EstoqueDao();
        int qte = 0;
        qte = estDao.quantidadeDisponivelProduto(prod.getId());
        return qte;
    }
    
    public void altQuant(String codProd,int qte){
        for(ProdutoPedido p: VendaTemp.listaProdutosPed){
            if(p.getProduto().getId().equals(codProd)){
                p.setQtd(qte);
                p.calcValor();
            }
            
        }
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
