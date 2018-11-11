/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author logonaf
 */
public class NfSaida extends NotaFiscal{
    String especie;
    String serie;
    String insc_estadual;
    String cnpj;
    String procedencia;
    String cod_contabil;
    ArrayList<ProdutoNota> produtos;
    float val_icms;
    float val_ipi;
    String emitente;

    public NfSaida() {
    }

    public NfSaida(Pedido ped){
        this.estado = ped.getCliente().getEndereco().getUf();
        if(ped.getCliente() instanceof PessoaFisica){
            PessoaFisica pf = (PessoaFisica)ped.getCliente();
            this.cnpj = pf.getCpf();
        }
        else if(ped.getCliente() instanceof PessoaJuridica){
            PessoaJuridica pf = (PessoaJuridica)ped.getCliente();
            this.cnpj = pf.getCnpj();
        }
        for(ProdutoPedido p:ped.getLista_produtos()){
            ProdutoNota pnota = new ProdutoNota(p);
            produtos.add(pnota);
        }

        
        
    }


      
    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getInsc_estadual() {
        return insc_estadual;
    }

    public void setInsc_estadual(String insc_estadual) {
        this.insc_estadual = insc_estadual;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getCod_contabil() {
        return cod_contabil;
    }

    public void setCod_contabil(String cod_contabil) {
        this.cod_contabil = cod_contabil;
    }

    public float getVal_icms() {
        return val_icms;
    }

    public void setVal_icms(float val_icms) {
        this.val_icms = val_icms;
    }

    public float getVal_ipi() {
        return val_ipi;
    }

    public void setVal_ipi(float val_ipi) {
        this.val_ipi = val_ipi;
    }

    public String getEmitente() {
        return emitente;
    }

    public void setEmitente(String emitente) {
        this.emitente = emitente;
    }
    
}
