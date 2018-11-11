/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import entidades.CentroCusto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CentroCustoDao {
        public CentroCusto getCentro() {
        CentroCusto cc = new CentroCusto();
        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM tb_centro_custo";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cc.setCnpj(rs.getString("cnpj"));
                cc.setRazao_social(rs.getString("razao_socia;"));
                cc.setFantasia(rs.getString("fantasia"));
                cc.setLongradouro(rs.getString("longradouro"));
                cc.setNro(rs.getInt("nro"));
                cc.setBairro(rs.getString("bairro"));
                cc.setUf(rs.getString("estado"));
                cc.setCep(rs.getString("cep"));
                cc.setTelefone(rs.getString("telefone"));
                cc.setInscricao_estadual(rs.getString("inscricao_estadual"));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            cc = null;
        }
        return cc;
    }
}

    

