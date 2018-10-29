/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.ProdutoDao;
import entidades.Produto;
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
            String ret = "";
            String op = request.getParameter("op");
            if(op.equals("pesqProduto")){
                Produto prod = new Produto();
                prod = pdao.getProduto(request.getParameter("textProduto"));
                if(prod!=null){
                    ret+=(prod.getNome()+"<br>");
                    ret+=(prod.getDescricao()+"<br>");
                    ret+=(prod.getValor()+"<br>");
                }else{
                    ret+=("Produto não encontrado");
                }
            }
            else
                if(op.equals("addProduto")){
                Produto prod = new Produto();
                prod = pdao.getProduto(request.getParameter("textProduto"));
                boolean exist = false;
                for(Produto p:VendaTemp.listaProdutos){
                    if(prod.equals(p)){
                        exist = true;
                        break;
                    }
                }
                if(!exist){
                    VendaTemp.listaProdutos.add(prod);
                }
            }
                else if(op.equals("attProdutos")){
                    for(Produto p:VendaTemp.listaProdutos){
                            out.print("<tr>");
                                out.print("<td>"+p.getId()+"</td>");
                                out.print("<td>"+p.getNome()+"</td>");
                                out.print("<td>R$"+p.getValor()+"</td>");
                                out.print("<td><input type='number' class='form-control' name='qte"+p.getId()+"'></td>");
                                out.print("<td><button class='removeProd' value='"+p.getId()+"'>Remover</td>");
                            out.print("</tr>");
                    }
                }
            out.print(ret);
            out.flush();
            }
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
