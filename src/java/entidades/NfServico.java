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
    
      String serie;
    String insc_municipal;
    String nome_servico;
    String nome_prestador;
    String cnpj_prestador;
    String nome_tomador;
    String cnpj_tomador;
    float val_iss;
    String cpf;
    String cnpj;
    float valor_icms;
    
    public NfServico() {
    }

    public String getInsc_municipal() {
        return insc_municipal;
    }

    public void setInsc_municipal(String insc_municipal) {
        this.insc_municipal = insc_municipal;
    }
    String codigo_servico;

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
  

    public float getValor_icms() {
        return valor_icms;
    }

    public void setValor_icms(float valor_icms) {
        this.valor_icms = valor_icms;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
