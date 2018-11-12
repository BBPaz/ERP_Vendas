
package Dao;

import entidades.Funcionario;
import entidades.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VendedorDao {
    public Funcionario getFuncionario(int id_vendedor) {
            Funcionario f = new Funcionario();
            
        try {

            Connection con = Conecta.getConexao();
            String sql = "SELECT id, nome from tb_funcionario where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_vendedor);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                f.setId_vendedor(rs.getInt("id"));
                f.setNome_vendedor(rs.getString("nome"));
                 
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            f = null;
        }

        return f;
    }

}
