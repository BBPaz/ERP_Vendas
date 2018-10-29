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
public class CalculoImpostoNfs {
    float valor_cofins;
    float valor_ipi;
    float valor_iss;
    float base_calculo;
    float valor_nfse;

    public float getValor_cofins() {
        return valor_cofins;
    }

    public void setValor_cofins(float valor_cofins) {
        this.valor_cofins = valor_cofins;
    }

    public float getValor_ipi() {
        return valor_ipi;
    }

    public void setValor_ipi(float valor_ipi) {
        this.valor_ipi = valor_ipi;
    }

    public float getValor_iss() {
        return valor_iss;
    }

    public void setValor_iss(float valor_iss) {
        this.valor_iss = valor_iss;
    }

    public float getBase_calculo() {
        return base_calculo;
    }

    public void setBase_calculo(float base_calculo) {
        this.base_calculo = base_calculo;
    }

    public float getValor_nfse() {
        return valor_nfse;
    }

    public void setValor_nfse(float valor_nfse) {
        this.valor_nfse = valor_nfse;
    }
    
    public void calcCofins(){
        
    }
    
    public void calcIpi(){
        
    }
}
