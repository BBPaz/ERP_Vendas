/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import entidades.PessoaFisica;
import entidades.Endereco;
import entidades.PessoaJuridica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igors
 */
public class ClienteFisicoDao {
      public PessoaFisica getPessoaFisica(String cpf) {
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
      
       public boolean inserirPessoaFisica(PessoaFisica p) {
        
        
        boolean resp = false;
        
        try {
            Connection con = Conecta.getConexao();
            String sql = "INSERT INTO tb_cliente_fisico(nome,cpf,data_nasc,email,telefone) "
                    + "values(?,?,?,?,?)";
            PreparedStatement rs = con.prepareStatement(sql);
            rs.setString(1, p.getCpf());
            rs.setString(2, p.getNome());
            rs.setString(4, p.getData_nasc());
            rs.setString(5, p.getEmail());
            rs.setString(6, p.getTelefone());
            rs.execute();
            rs.close();
            con.close();

            resp = true;
        } catch (Exception ex) { 
            Logger.getLogger(PessoaJuridicaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    
}
