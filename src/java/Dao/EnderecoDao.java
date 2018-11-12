/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import entidades.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author igors
 */
public class EnderecoDao {
        public Endereco getEndereco(String id) {
        Endereco n1 = new Endereco();
        
        try {

            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM tb_endereco WHERE id= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                n1.setUf(rs.getString("estado"));
                n1.setCep(rs.getString("cep"));
                n1.setBairro(rs.getString("bairro"));
                n1.setCidade(rs.getString("cidade"));
                n1.setRua(rs.getString("rua"));
                n1.setNumero(rs.getString("numero"));
                n1.setComplemento(rs.getString("complemento"));
                n1.setId_endereco(rs.getInt("id"));

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
        
         public boolean inserirEndereco(Endereco p) {
        boolean resp = false;
        
        try {
            Connection con = Conecta.getConexao();
            String sql = "INSERT INTO tb_endereco (estado,cep,bairro,"
                    + "cidade,rua,numero,complemento) "
                    + "values(?,?,?,?,?,?,?)";
            PreparedStatement rs = con.prepareStatement(sql);
            rs.setString(1, p.getUf());
            rs.setString(2, p.getCep());
            rs.setString(3, p.getBairro());
            rs.setString(4, p.getCidade());
            rs.setString(5, p.getRua());
            rs.setString(6, p.getNumero());
            rs.setString(7, p.getComplemento());
            
            
            rs.execute();
            rs.close();
            con.close();

            resp = true;
       
        return resp;
    }       catch (Exception ex) {
                Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return resp = true;
}
         
          public boolean updateEndereco(Endereco end) {
        boolean resp = false;
        try {
            Connection con = Conecta.getConexao();
            
            String sql = "UPDATE tb_endereco SET estado = ?,cep = ? ,bairro = ?,"
                    + "cidade = ? ,rua = ? ,numero = ?,complemento = ? where id = ?" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, end.getUf());
            ps.setString(2, end.getCep());
            ps.setString(3, end.getBairro());
            ps.setString(4, end.getCidade());
            ps.setString(5, end.getRua());
            ps.setString(6, end.getNumero());
            ps.setString(7, end.getComplemento());
            ps.setInt(8, end.getId_endereco());

            ps.execute();

            ps.close();
            con.close();

            resp = true;
        } catch (Exception e) {
            resp = false;
        }
        return resp;

    }
}


