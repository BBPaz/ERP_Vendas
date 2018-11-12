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
                        for(Pedido p : ped){
                            out.print("<tr class='linhaPedido' value='"+p.getId()+"'>");
                            Cliente c = p.getCliente();
                            out.print("<td>"+p.getId()+"</td>"); 
                            if(c instanceof PessoaFisica){
                               out.print("<td>"+((PessoaFisica) c).getCpf()+"</td>"); 
                            }
                            else if(c instanceof PessoaJuridica){
                               out.print("<td>"+((PessoaJuridica) c).getCnpj()+"</td>"); 
                            }
                            if(c instanceof PessoaFisica){
                               out.print("<td>"+((PessoaFisica) c).getNome()+"</td>"); 
                            }
                            else if(c instanceof PessoaJuridica){
                               out.print("<td>"+((PessoaJuridica) c).getRazao_social()+"</td>"); 
                            }
                            out.print("<td>R$"+String.format("%.2f", p.getValor_total())+"</td>");
                            out.print("<td>"+formatData(p.getData())+"</td>");
                            out.print("</tr>");
                        }
                        
                    }
                    break;
            }
        }
    }
    
    public static String formatData(String data){
        String novadata = "";
        String[] aux = data.split("-");
        novadata =(aux[2])+"/"+(aux[1])+"/"+(aux[0]);
        return novadata;
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
