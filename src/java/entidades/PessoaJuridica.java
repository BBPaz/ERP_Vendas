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
    String inscricao_estadual;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String cnpj, String razao_social, String inscricao_municipal, String inscricao_estadual) {
        this.cnpj = cnpj;
        this.razao_social = razao_social;
        this.inscricao_municipal = inscricao_municipal;
        this.inscricao_estadual = inscricao_estadual;
    }

    public String getInscricao_estadual() {
        return inscricao_estadual;
    }

    public void setInscricao_estadual(String inscricao_estadual) {
        this.inscricao_estadual = inscricao_estadual;
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
