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
public class NfSaida extends NotaFiscal{
    String especie;
    String serie;
    String insc_estadual;
    String cnpj;
    String procedencia;
    String cod_contabil;
    float val_icms;
    float val_ipi;
    String emitente;

    public NfSaida() {
    }

    public NfSaida(String especie, String serie, String insc_estadual, String cnpj, String procedencia, String cod_contabil, float val_icms, float val_ipi, String emitente, String data_emissao, boolean tipo_emit, String numero, int cfop, float valor_total, String dados_adicionais, String estado) {
        super(data_emissao, tipo_emit, numero, cfop, valor_total, dados_adicionais, estado);
        this.especie = especie;
        this.serie = serie;
        this.insc_estadual = insc_estadual;
        this.cnpj = cnpj;
        this.procedencia = procedencia;
        this.cod_contabil = cod_contabil;
        this.val_icms = val_icms;
        this.val_ipi = val_ipi;
        this.emitente = emitente;
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
