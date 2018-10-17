
package entidades;

public class PessoaFisica extends Cliente {
    String cpf;
    String data_nasc;
    String nome;
    char sexo;

    public PessoaFisica() {
    }

    public PessoaFisica(String cpf, String data_nasc, String nome, char sexo, int id_cliente, String email, String telefone, Endereco endereco, boolean cad_valido) {
        super(id_cliente, email, telefone, endereco, cad_valido);
        this.cpf = cpf;
        this.data_nasc = data_nasc;
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
}
