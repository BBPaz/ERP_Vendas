/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.NfSaida;
import entidades.NotaFiscal;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.xml.transform.Result;
/**
 *
 * @author igors
 */
public class NotaProdutosDao {
     public NotaFiscal buscaPorId(String numero ) {
        NotaFiscal n1 = new NfSaida();
        try {

            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM tb_nf_produtos WHERE numero= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, n1.getNumero());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                n1.setData_emissao(rs.getString("data_emissao"));
                n1.setTipo_emit(rs.getString("tipo_emit"));
                n1.setNumero(rs.getString("numero"));
                n1.setCfop(rs.getInt("cfop"));
                n1.setValor_total(rs.getFloat("valor_total"));
                //(rs.getString("rodizioVeiculo"));
                

            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            n1 = null;
        }

        return n1;
    }
}
