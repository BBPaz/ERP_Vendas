/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.PessoaFisica;
import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class PessoaFisicaDao {
    

    
    public boolean insertPessoaFisica(PessoaFisica cliente){
        //NÃO IMPLEMENTADO
        return(true);
    }

    public void getPessoas(){
        ArrayList<PessoaFisica> pessoas = new ArrayList<>();
        pessoas.add(new PessoaFisica().exemplo());
        pessoas.add(new PessoaFisica().exemplo2());
    }
    
    public PessoaFisica getPessoa(String id){
        ArrayList<PessoaFisica> pessoas = new ArrayList<>();
        pessoas.add(new PessoaFisica().exemplo());
        pessoas.add(new PessoaFisica().exemplo2());
        for(PessoaFisica p: pessoas){
            if(p.getCpf().equals(id)){
                return(p);
            }
        }
        return(null);
    }
}
