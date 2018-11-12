/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import entidades.Endereco;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class PessoaJuridicaDao {

    public PessoaJuridica getPessoaJuridica(String cnpj) {
        PessoaJuridica p = new PessoaJuridica();
        Endereco p1 = new Endereco();
        EnderecoDao edao = new EnderecoDao();

        try {

            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM tb_cliente_juridico WHERE cnpj= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cnpj);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                p.setCnpj(rs.getString("cnpj"));
                p.setEmail(rs.getString("email"));
                p.setTelefone(rs.getString("telefone"));
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

    public boolean inserirPessoaJuridica(PessoaJuridica p) {
        
        
        boolean resp = false;
        
        try {
            Connection con = Conecta.getConexao();
            String sql = "INSERT INTO tb_cliente_juridico(cnpj,inscricao_estadual" 
                    + "razao_social,"

                    + "email,telefone) "

                    + "cnpj,email,telefone) "

                    + "values(?,?,?,?,?,?,?)";
            PreparedStatement rs = con.prepareStatement(sql);
            rs.setString(1, p.getCnpj());
            rs.setString(2, p.getInscricao_estadual());
            rs.setString(3, p.getRazao_social());

            rs.setString(4, p.getEmail());
            rs.setString(5, p.getTelefone());

            rs.setString(4, p.getCnpj());
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
    
    public boolean updatePessoaJuridica(PessoaJuridica cj) {
        boolean resp = false;
        try {
            Connection con = Conecta.getConexao();
            String sql = "UPDATE tb_cliente_juridico SET,inscricao_estadual = ?, razao_social = ? ,email = ?,telefone = ? "
                    + "WHERE cpf = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cj.getInscricao_estadual());
            ps.setString(2, cj.getRazao_social());
            ps.setString(3, cj.getEmail());
            ps.setString(4, cj.getTelefone());
            ps.execute();
            ps.close();
            con.close();

            resp = true;
        } catch (Exception e) {
            resp = false;
        }
        return resp = true;

    }
    
    public boolean insertPessoaJuridica(PessoaJuridica cliente){
        //NÃO IMPLEMENTADO
        return(true);
    }
}
