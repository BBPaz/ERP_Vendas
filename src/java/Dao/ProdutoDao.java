/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Item;
import entidades.Produto;
import entidades.ProdutoNota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author logonaf
 */
public class ProdutoDao {
    Produto p1 = new Produto("1234",10.00f, "Panela Sequencial", "Panela S");
    Produto p2 = new Produto("12231",544.00f, "Panela Centigrada", "Panela C");
    Produto p3 = new Produto("51125",512.00f, "Panela Periférica", "Panela P");
    Produto p4 = new Produto("71724",46.00f, "Panela Maxografa", "Panela M");
    
    public ArrayList<Produto> getProdutos(){
        ArrayList<Produto> pList = new ArrayList();
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        pList.add(p4);
        return(pList);
    }
    
    public Produto getProduto(String id){
        ArrayList<Produto> pList = new ArrayList();
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        pList.add(p4);
        for(Produto p: pList){
            if(p.getId().equals(id)){
                return(p);
            }
        }
        return(null);
    }
    
    
    public ProdutoNota getProdutos(int id){
         ProdutoNota pn  = new ProdutoNota();
         try {

            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM ProdutoNota WHERE id_produto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pn.setId_produto(rs.getInt("id_produto"));
                pn.setNome(rs.getString("nome"));
                pn.setValor_total(rs.getFloat("valor_total"));
                pn.setValor_unitario(rs.getFloat("valor_unitario"));
                pn.setQtd_item(rs.getInt("quantidade"));
                


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

