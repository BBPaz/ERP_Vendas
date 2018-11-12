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
    Servico p1 = new Servico("1", 15, "Anti-depressivo", "Manutenção");
    Servico p2 = new Servico("2",600, "Uma noite no Iate", "Passeio");
    Servico p3 = new Servico("3", 15, "Garantia Extendida para produto X", "Garantia extendida");
    Servico p4 = new Servico("4", 15, "Conserto de produto x", "Conserto");
    
    public ArrayList<Servico> getServicos(){
        ArrayList<Servico> pList = new ArrayList();
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        pList.add(p4);
        return(pList);
    }
    
    public Servico getServico(String id){
        ArrayList<Servico> pList = new ArrayList();
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        pList.add(p4);
        for(Servico p: pList){
            if(p.getId().equals(id)){
                return(p);
            }
        }
        return(null);
    }
    
    
}
