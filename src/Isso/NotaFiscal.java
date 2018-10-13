
package Isso;

public class NotaFiscal {

    public String getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(String data_emissao) {
        this.data_emissao = data_emissao;
    }

    public String getDados_adicionais() {
        return dados_adicionais;
    }

    public void setDados_adicionais(String dados_adicionais) {
        this.dados_adicionais = dados_adicionais;
    }

    public boolean isTipo_emit() {
        return tipo_emit;
    }

    public void setTipo_emit(boolean tipo_emit) {
        this.tipo_emit = tipo_emit;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public int getCfop() {
        return cfop;
    }

    public void setCfop(int cfop) {
        this.cfop = cfop;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    String data_emissao, dados_adicionais;
    boolean tipo_emit;
    float valor_total;
    int cfop;
    String estado;
    
}
