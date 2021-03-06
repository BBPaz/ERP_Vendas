/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Dao.PessoaFisicaDao;
import Dao.PessoaJuridicaDao;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;
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
public class IniciarVenda extends HttpServlet {

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
            PessoaFisicaDao pfdao = new PessoaFisicaDao();
            PessoaJuridicaDao pjdao = new PessoaJuridicaDao();
            String ret = "";
            String op = "";
            op = request.getParameter("op");
            switch (op) {
                case "BuscaPf":
                    {
                        PessoaFisica pf = null;
                        pf = pfdao.getPessoa(request.getParameter("idCliente"));
                        if(pf.getCpf()!=null){
                            out.print("true");    
                        }
                        else
                        out.print("false");
                    }
                    break;
                case "BuscaPj":
                {
                    PessoaJuridica pj = new PessoaJuridica();
                    pj = pjdao.getPessoaJuridica(request.getParameter("idCliente"));
                    if(pj.getCnpj()!=null){
                        out.print("true");    
                    }
                    else
                    out.print("false");
                }
                break;
                case "PopularCliente":
                {
                    String tipo = request.getParameter("tipo");
                    if(tipo.equals("fisica")){
                        PessoaFisica pf = new PessoaFisica();
                        pf = pfdao.getPessoa(request.getParameter("idCliente"));
                        ret+="$(\"#nomeCliente\").val(\""+pf.getNome()+"\");";
                        ret+="$(\"#cpfCliente\").val(\""+pf.getCpf()+"\");";
                        ret+="$(\"#dataNascCliente\").val(\""+pf.getData_nasc()+"\");";
                        ret+="$(\"#emailCliente\").val(\""+pf.getEmail()+"\");";
                        ret+="$(\"#numeroCliente\").val(\""+pf.getTelefone()+"\");";
                        ret+="$(\"#log\").val(\""+pf.getEndereco().getRua()+"\");";
                        ret+="$(\"#numeroEndereco\").val(\""+pf.getEndereco().getNumero()+"\");";
                        ret+="$(\"#bairro\").val(\""+pf.getEndereco().getBairro()+"\");";
                        ret+="$(\"#cidade\").val(\""+pf.getEndereco().getCidade()+"\");";
                        ret+="$(\"#cep\").val(\""+pf.getEndereco().getCep()+"\");";
                        ret+="$(\"#estado\").val(\""+pf.getEndereco().getUf()+"\");";
                        ret+="$(\"#complemento\").val(\""+pf.getEndereco().getComplemento()+"\");";
                        ret+="$(\"#idEndereco\").html(\""+pf.getEndereco().getId_endereco()+"\");";
                        out.print(ret);
                    }
                    else if(tipo.equals("juridica")){//MUDAR PARA PESSOA JURIDICA
                        PessoaJuridica pj = new PessoaJuridica();
                        pj = pjdao.getPessoaJuridica(request.getParameter("idCliente"));
                        ret+="$(\"#razaoSocialCliente\").val(\""+pj.getRazao_social()+"\");";
                        ret+="$(\"#cnpjCliente\").val(\""+pj.getCnpj()+"\");";
                        ret+="$(\"#inscMunicCliente\").val(\""+pj.getInscricao_municipal()+"\");";
                        ret+="$(\"#inscEstCliente\").val(\""+pj.getInscricao_estadual()+"\");";
                        ret+="$(\"#emailCliente\").val(\""+pj.getEmail()+"\");";
                        ret+="$(\"#numeroCliente\").val(\""+pj.getTelefone()+"\");";
                        ret+="$(\"#log\").val(\""+pj.getEndereco().getRua()+"\");";
                        ret+="$(\"#numeroEndereco\").val(\""+pj.getEndereco().getNumero()+"\");";
                        ret+="$(\"#bairro\").val(\""+pj.getEndereco().getBairro()+"\");";
                        ret+="$(\"#cidade\").val(\""+pj.getEndereco().getCidade()+"\");";
                        ret+="$(\"#cep\").val(\""+pj.getEndereco().getCep()+"\");";
                        ret+="$(\"#complemento\").val(\""+pj.getEndereco().getComplemento()+"\");";
                        ret+="$(\"#estado\").val(\""+pj.getEndereco().getUf()+"\");";
                        out.print(ret);
                    }
                }
                break;
                case "IniciarVenda":
                {
                    String tipo = request.getParameter("tipo");
                    VendaTemp.limpaVenda();
                     if(tipo.equals("fisica")){
                        VendaTemp.cliente = pfdao.getPessoa(request.getParameter("idCliente"));
                     }
                     else if(tipo.equals("juridica")){
                         VendaTemp.cliente = pjdao.getPessoaJuridica(request.getParameter("idCliente"));
                     }
                }
                break;
            }
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
