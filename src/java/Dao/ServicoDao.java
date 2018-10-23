/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Servico;
import java.util.ArrayList;

/**
 *
 * @author logonaf
 */
public class ServicoDao {
    Servico p1 = new Servico("1243612651", 15, "Anti-depressivo", "Viagra");
    Servico p2 = new Servico("551215612",600, "Uma noite no Iate", "Passeio");
    Servico p3 = new Servico("124151241212", 15, "Garantia Extendida para produto X", "Garantia extendida");
    Servico p4 = new Servico("995455192", 15, "Conserto de produto x", "Conserto");
    
    public ArrayList<Servico> getServicos(){
        ArrayList<Servico> pList = new ArrayList();
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        pList.add(p4);
        return(pList);
    }
}
