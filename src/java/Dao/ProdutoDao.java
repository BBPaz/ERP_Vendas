/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Produto;
import java.util.ArrayList;

/**
 *
 * @author logonaf
 */
public class ProdutoDao {
    Produto p1 = new Produto("1234",10.00f, "Panela Sequencial", "Panela S", "a");
    Produto p2 = new Produto("12231",544.00f, "Panela Centigrada", "Panela C", "a");
    Produto p3 = new Produto("51125",512.00f, "Panela Periférica", "Panela P", "a");
    Produto p4 = new Produto("71724",46.00f, "Panela Maxografa", "Panela M", "a");
    
    public ArrayList<Produto> getProdutos(){
        ArrayList<Produto> pList = new ArrayList();
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        pList.add(p4);
        return(pList);
    }
    
    public Produto getProduto(){
        ArrayList<Produto> pList = new ArrayList();
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        pList.add(p4);
        for(Produto p: pList){
            
        }
        return(null);
    }
    
}