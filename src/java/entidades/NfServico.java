/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Bruno
 */
public class NfServico extends NotaFiscal{
    String codigo_servico;
    String nome_servico;
    String nome_prestador;
    String cnpj_prestador;
    String nome_tomador;
    String cnpj_tomador;
    float val_iss;



    public NfServico() {
    }

    
    
    public String getCodigo_servico() {
        return codigo_servico;
    }

    public void setCodigo_servico(String codigo_servico) {
        this.codigo_servico = codigo_servico;
    }

    public String getNome_servico() {
        return nome_servico;
    }

    public void setNome_servico(String nome_servico) {
        this.nome_servico = nome_servico;
    }

    public String getNome_prestador() {
        return nome_prestador;
    }

    public void setNome_prestador(String nome_prestador) {
        this.nome_prestador = nome_prestador;
    }

    public String getCnpj_prestador() {
        return cnpj_prestador;
    }

    public void setCnpj_prestador(String cnpj_prestador) {
        this.cnpj_prestador = cnpj_prestador;
    }

    public String getNome_tomador() {
        return nome_tomador;
    }

    public void setNome_tomador(String nome_tomador) {
        this.nome_tomador = nome_tomador;
    }

    public String getCnpj_tomador() {
        return cnpj_tomador;
    }

    public void setCnpj_tomador(String cnpj_tomador) {
        this.cnpj_tomador = cnpj_tomador;
    }

    public float getVal_iss() {
        return val_iss;
    }

    public void setVal_iss(float val_iss) {
        this.val_iss = val_iss;
    }
    
    
}
