/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.PessoaFisicaDao;
import Dao.PessoaJuridicaDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.*;

/**
 *
 * @author Bruno
 */
public class CadastroCliente extends HttpServlet {

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
            String tipo = request.getParameter("tipoCliente");
            if(tipo.equals("fisica")){
                PessoaFisica cliente = new PessoaFisica();
               
                cliente.setEmail(request.getParameter("emailCliente"));
                cliente.setTelefone(request.getParameter("dddNumeroCliente")+request.getParameter("numeroCliente"));
                cliente.setCad_valido(true);
                
                Endereco end = new Endereco();
                
                end.setUf(request.getParameter("estado"));
                end.setCep(request.getParameter("Cep"));
                end.setBairro(request.getParameter("bairro"));
                end.setCidade(request.getParameter("cidade"));
                end.setEndereco((request.getParameter("tipoLogradouro").equals("")?"":request.getParameter("dddNumeroCliente")+"")+request.getParameter("endereco"));
                end.setNumero(request.getParameter("numeroEndereco"));
                end.setComplemento(request.getParameter("complemento"));
                
                cliente.setEndereco(end);
                
                cliente.setCpf(request.getParameter("cpfCliente"));
                cliente.setData_nasc(request.getParameter("dataNascCliente"));
                cliente.setNome(request.getParameter("nomeCliente"));
                
                PessoaFisicaDao pfdao  = new PessoaFisicaDao();
                pfdao.insertPessoaFisica(cliente);
                
                
            }
            else{
                PessoaJuridica cliente = new PessoaJuridica();
               
                cliente.setEmail(request.getParameter("emailCliente"));
                cliente.setTelefone(request.getParameter("dddNumeroCliente")+request.getParameter("numeroCliente"));
                cliente.setCad_valido(true);
                
                Endereco end = new Endereco();
                
                end.setUf(request.getParameter("estado"));
                end.setCep(request.getParameter("Cep"));
                end.setBairro(request.getParameter("bairro"));
                end.setCidade(request.getParameter("cidade"));
                end.setEndereco((request.getParameter("tipoLogradouro").equals("")?"":request.getParameter("dddNumeroCliente")+"")+request.getParameter("endereco"));
                end.setNumero(request.getParameter("numeroEndereco"));
                end.setComplemento(request.getParameter("complemento"));
                
                cliente.setEndereco(end);
                
                cliente.setCnpj(request.getParameter("cnpjCliente"));
                cliente.setRazao_social(request.getParameter("razaoSocialCliente"));
                cliente.setInscricao_municipal(request.getParameter("inscMunicCliente"));
                
                PessoaJuridicaDao pjdao = new PessoaJuridicaDao();
                pjdao.insertPessoaJuridica(cliente);
            }
        }
        catch(Exception e){
            request.getSession().setAttribute("erro", "Ocorreu um erro no cadastro: "+e.getMessage());
            response.sendRedirect("erroCadastro.jsp");
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
