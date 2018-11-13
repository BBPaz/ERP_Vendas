/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.ProdutoNota;
import entidades.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author logonaf
 */
public class ServicoDao {
    Servico p1 = new Servico("1", 40, "Manutenção de produto", "Manutenção");
    Servico p2 = new Servico("2", 15, "Garantia Extendida", "Garantia extendida");
    Servico p3 = new Servico("3", 60, "Conserto de produto", "Conserto");
    
    public ArrayList<Servico> getServicos(){
        ArrayList<Servico> pList = new ArrayList();
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        return(pList);
    }
    
    public Servico getServico(String id){
        ArrayList<Servico> pList = new ArrayList();
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        for(Servico p: pList){
            if(p.getId().equals(id)){
                return(p);
            }
        }
        return(null);
    }
    
    
}
