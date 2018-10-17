/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author logonaf
 */
public class PessoaJuridica extends Cliente {
    String cnpj;
    String razao_social;
    String inscricao_municipal;

    public PessoaJuridica() {
    }
    
    public PessoaJuridica(String cnpj, String razao_social, String inscricao_municipal, int id_cliente, String email, String telefone, Endereco endereco, boolean cad_valido) {
        super(id_cliente, email, telefone, endereco, cad_valido);
        this.cnpj = cnpj;
        this.razao_social = razao_social;
        this.inscricao_municipal = inscricao_municipal;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getInscricao_municipal() {
        return inscricao_municipal;
    }

    public void setInscricao_municipal(String inscricao_municipal) {
        this.inscricao_municipal = inscricao_municipal;
    }

}
