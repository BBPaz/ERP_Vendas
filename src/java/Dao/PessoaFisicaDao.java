/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.PessoaFisica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class PessoaFisicaDao {
    

    
    public boolean insertPessoaFisica(PessoaFisica cliente){
        //NÃO IMPLEMENTADO
        return(true);
    }

    public void getPessoas(){
        ArrayList<PessoaFisica> pessoas = new ArrayList<>();
        pessoas.add(new PessoaFisica().exemplo());
        pessoas.add(new PessoaFisica().exemplo2());
    }
    
    public PessoaFisica getPessoa(String cpf) {
        PessoaFisica p = new PessoaFisica();
        EnderecoDao edao = new EnderecoDao();

        try {

            Connection con = Conecta.getConexao();
            String sql = "SELECT nome,cpf,data_nasc,email,telefone,id_endereco FROM tb_cliente_fisico WHERE cpf= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                p.setCpf(rs.getString("cpf"));
                p.setEmail(rs.getString("email"));
                p.setTelefone(rs.getString("telefone"));
                p.setData_nasc(rs.getString("data_nasc"));
                p.setNome(rs.getString("nome"));
                String end = rs.getString("id_endereco");
                p.setEndereco(edao.getEndereco(end)); 

            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            p = null;
        }

        return p;
    }
    /*public PessoaFisica getPessoa(String id){
        ArrayList<PessoaFisica> pessoas = new ArrayList<>();
        pessoas.add(new PessoaFisica().exemplo());
        pessoas.add(new PessoaFisica().exemplo2());
        for(PessoaFisica p: pessoas){
            if(p.getCpf().equals(id)){
                return(p);
            }
        }
        return(null);
    }*/
}
