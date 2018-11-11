/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.PessoaJuridica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Bruno
 */
public class PessoaJuridicaDao {
    
    public PessoaJuridica getPessoaJuridica(String cnpj){
        PessoaJuridica p = new PessoaJuridica();
        
        try {

            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM tb_cliente_juridico WHERE cnpj= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getCnpj());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                p.setCnpj(rs.getString("cnpj"));
                p.setEmail(rs.getString("email"));
                p.setTelefone(rs.getString("telefone"));
                //p.set(rs.getString("estado"));
               // p.setCep(rs.getFloat("valor_total"));
                //(rs.getString("rodizioVeiculo"));
                

            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            p = null;
        }

        
        
        
        
        return p; 
    }
    
    public boolean insertPessoaJuridica(PessoaJuridica cliente){
        //NÃO IMPLEMENTADO
        return(true);
    }
}
