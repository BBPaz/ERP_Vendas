/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.NfSaida;
import entidades.NfServico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igors
 */
public class NotaFiscalServicoDao {
    public boolean inserirNotaSicalServico (NfServico s) {
        boolean resp = false;
        
        try {
            Connection con = Conecta.getConexao();
            String sql = "INSERT INTO notafiscal_servico (data_emisao,cfop,valor_total,dados_adicionais,estado,serie,insc_estadual,cpf,cnpj,val_icms)"
                   
                    + "values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement rs = con.prepareStatement(sql);
            rs.setString(1, s.getData_emissao());
            rs.setInt(2, s.getCfop());
            rs.setFloat(3, s.getValor_total());
            rs.setString(4, s.getDados_adicionais());
            rs.setString(5, s.getEstado());
            rs.setString(6, s.getSerie());
            rs.setString(7, s.getInsc_municipal());
            rs.setString(8, s.getCnpj());
            rs.setString(9, s.getCpf());
            rs.setFloat(10, s.getValor_icms());
            
            
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
}
