/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author logonaf
 */
public class EstoqueDao {
    
    /*public int quantidadeDisponivelProduto(String idProduto){
        //Não implementado
        if(idProduto.equals("71724")){
            return 0;
        }
        return 2;
    }*/
    
    
   public int quantidadeDisponivelProduto(String idProduto){
        //Não implementado
        if(idProduto.equals("2")){
            return 5;
        }
        Item i = new Item();
         try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM item WHERE id_item = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idProduto));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                i.setId_item(rs.getInt("id_item"));
                i.setNome(rs.getString("nome"));
                i.setDescricao(rs.getString("descricao"));
                i.setPreco(rs.getDouble("preco"));
                i.setQuantidade(rs.getInt("quantidade"));
                


            }
            
            rs.close();
            ps.close();
            con.close();
        return i.getQuantidade();
        }
        catch(Exception e){
        
        }
         return 0;
    }
    
    public boolean updateEstoque(int qte,int id) {
        boolean resp = false;
        
        
        try {
            Connection con = Conecta.getConexao();
            String sql = "UPDATE item SET quantidade = ? "
                    + "WHERE id_item = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, qte);
            ps.setInt(2, id);
            ps.execute();
            ps.close();
            con.close();

            resp = true;
        } catch (Exception e) {
            resp = false;
        }
        return resp = true;

    }
    


    public Item getProduto(int id){
            Item i = new Item();
         try {

            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM item WHERE id_item = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                i.setId_item(rs.getInt("id_item"));
                i.setNome(rs.getString("nome"));
                i.setDescricao(rs.getString("descricao"));
                i.setPreco(rs.getDouble("preco"));
                i.setQuantidade(rs.getInt("quantidade"));
                


            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            i = null;
        }

        return i;
       
    }
            
}
