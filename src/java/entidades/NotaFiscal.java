
package entidades;

import java.util.Random;

public class NotaFiscal {
    String chave_autorizacao;
    String data_emissao;
    String tipo_emit;
    String numero;
    int cfop;
    float valor_total;
    String dados_adicionais;
    String estado;

    public String getChave_autorizacao() {
        return chave_autorizacao;
    }

    public void setChave_autorizacao(String chave_autorizacao) {
        this.chave_autorizacao = chave_autorizacao;
    }


 

    public NotaFiscal() {
        chave_autorizacao = gerar();
    }
    
    public String gerar(){
         Random random = new Random();
            String chave ="NFe" +  "";
            for (int c = 0; c < 45; c++) {
                int r = random.nextInt(10);
                chave += r;
        
        
        
    }
        return numero;    
    }

    public String getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(String data_emissao) {
        this.data_emissao = data_emissao;
    }

    public String isTipo_emit() {
        return tipo_emit;
    }

    public void setTipo_emit(String tipo_emit) {
        this.tipo_emit = tipo_emit;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCfop() {
        return cfop;
    }

    public void setCfop(int cfop) {
        this.cfop = cfop;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public String getDados_adicionais() {
        return dados_adicionais;
    }

    public void setDados_adicionais(String dados_adicionais) {
        this.dados_adicionais = dados_adicionais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
