/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import entidades.Cliente;
import entidades.Endereco;
import entidades.PessoaJuridica;
import entidades.ProdutoNota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author igors
 */
public class DefautDao {
     public ProdutoNota getValorIcmsUf(ProdutoNota pn) {
         Cliente cl = new Cliente();
         
        try {

            Connection con = Conecta.getConexao();
            String sql = "SELECT valor FROM tb_default WHERE uf= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cl.getEndereco().getUf());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pn.setValor_icms(rs.getFloat("valor"));
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            pn = null;
        }

        return pn;
    }
}
