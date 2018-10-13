
package entidades;

public class NotaFiscal {

    String data_emissao;
    boolean tipo_emit;
    String numero;
    int cfop;
    float valor_total;
    String dados_adicionais;
    String estado;

    public NotaFiscal(String data_emissao, boolean tipo_emit, String numero, int cfop, float valor_total, String dados_adicionais, String estado) {
        this.data_emissao = data_emissao;
        this.tipo_emit = tipo_emit;
        this.numero = numero;
        this.cfop = cfop;
        this.valor_total = valor_total;
        this.dados_adicionais = dados_adicionais;
        this.estado = estado;
    }

    public NotaFiscal() {
        estado = "uf";
    }

    public String getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(String data_emissao) {
        this.data_emissao = data_emissao;
    }

    public boolean isTipo_emit() {
        return tipo_emit;
    }

    public void setTipo_emit(boolean tipo_emit) {
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
