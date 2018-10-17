package entidades;


public class Endereco {
    
    String uf;
    String cep;
    String bairro;
    String cidade;
    String rua;
    String numero;
    String complemento;

    public Endereco(String uf, String cep, String bairro, String cidade, String rua, String numero, String complemento) {
        this.uf = uf;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Endereco() {
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
}
