/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Cliente;
import entidades.Endereco;
import entidades.Funcionario;
import entidades.Pedido;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import entidades.ProdutoPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class PedidoDao {
    
    
    
    public boolean inserirPedido (Pedido ped) throws Exception {
        boolean resp;
        Cliente cl = ped.getCliente();

        try {
            Connection con = Conecta.getConexao();
            String sql = "INSERT INTO tb_pedido (valor_total,_status, _data, forma_pagamento,id_vendedor, id_cliente,tipo_pagamento, pago)"
                    + "values(?,?,?,?,?,?,?,?)";
            PreparedStatement rs = con.prepareStatement(sql);
            rs.setFloat(1, ped.getValor_total());
            rs.setString(2, ped.getStatus());
            rs.setString(3, ped.getData());
            rs.setString(4, ped.getForma_pagamento());
            rs.setString(5, String.valueOf(ped.getVendedor().getId_vendedor()));
            
            if (cl instanceof PessoaFisica){
                rs.setString(6, ((PessoaFisica) cl).getCpf());
            }else if (cl instanceof PessoaJuridica){
                rs.setString(6, ((PessoaJuridica) cl).getCnpj());
            }
            
            rs.setString(7, ped.getTipo_pagamento());
            rs.setInt(8, ped.isPago()?1:0);
            
            rs.execute();
            rs.close();
            con.close();

            resp = true;
        }   catch (Exception e) {
            resp = false;
        }
      
        return resp = true;
    }
      public Pedido getPedido(int id) {
        Pedido p = new Pedido();
        VendedorDao f = new VendedorDao();
        try {
            
            Connection con = Conecta.getConexao();
            String sql = "SELECT id_pedido, valor_total, _status"
                    + "_data, forma_pagamento, id_vendedor,id_cliente,tipo_pagamento"
                    + "pago FROM tb_pedido WHERE id_pedido= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                p.setId(rs.getString("id_pedido"));
                p.setStatus(rs.getString("_status"));
                p.setData(rs.getString("_data"));
                p.setForma_pagamento(rs.getString("forma_pagamento"));
                p.setTipo_pagamento(rs.getString("tipo_pagamento"));
                p.setPago(rs.getBoolean("pago"));
                int id_ven = rs.getInt("id_vendedor");
                p.setVendedor(f.getFuncionario(id_ven));
                
                
                 
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            p = null;
        }

        return p;
    }
      
    public ArrayList<Pedido> listaPedidos(){
        ArrayList<Pedido> p = new ArrayList<Pedido>();
        VendedorDao f = new VendedorDao();
        PessoaFisicaDao pfdao = new PessoaFisicaDao();
        PessoaJuridicaDao pjdao = new PessoaJuridicaDao();
        try {
            
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM tb_pedido";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedido pd = new Pedido();
                pd.setId(rs.getString("id_pedido"));
                pd.setStatus(rs.getString("_status"));
                pd.setData(rs.getString("_data"));
                pd.setForma_pagamento(rs.getString("forma_pagamento"));
                pd.setTipo_pagamento(rs.getString("tipo_pagamento"));
                pd.setPago(rs.getBoolean("pago"));
                int id_ven = rs.getInt("id_vendedor");
                pd.setVendedor(f.getFuncionario(id_ven));
                pd.setValor_total(rs.getFloat("valor_total"));
                if(rs.getString("id_cliente").length()==11){
                    pd.setCliente(pfdao.getPessoa(rs.getString("id_cliente")));
                }
                else if(rs.getString("id_cliente").length()==14){
                    pd.setCliente(pjdao.getPessoaJuridica(rs.getString("id_cliente")));
                }
                
                p.add(pd);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            p = null;
        }
        return p;
    }
    
    public boolean insertProdutoPedido(ProdutoPedido ped) throws Exception {
        boolean resp;
        //Cliente cl = ped.getCliente();
        

        try {
            Connection con = Conecta.getConexao();
            String sql = "INSERT INTO tb_produto_pedido (id_pedido, id_produto, quantidade)"
                    + "values(?,?,?)";
            PreparedStatement rs = con.prepareStatement(sql);
            rs.setString(1, ped.getPedido().getId());
            rs.setInt(3, ped.getQtd());
            rs.setString(2, ped.getProduto().getId());
      
            rs.execute();
            rs.close();
            con.close();

            resp = true;
        }   catch (Exception e) {
            resp = false;
        }
      
        return resp = true;
    }
    
     public ProdutoPedido getProdutoPedido(String id) {
         ProdutoPedido p = new ProdutoPedido();
         Pedido ped = new Pedido();
        try {
            
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM tb_produto_pedido WHERE id_pedido= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                
                
                String id_ped = rs.getString("id_pedido");
                
                
                
                
                
                 
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            p = null;
        }

        return p;
    }

    
}
