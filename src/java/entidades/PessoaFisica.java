
package entidades;

public class PessoaFisica extends Cliente {
    String cpf;
    String data_nasc;
    String nome;

    public PessoaFisica() {
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

    
    public PessoaFisica exemplo(){
        PessoaFisica pf = new PessoaFisica();
        
        pf.setEmail("igor@gmail.com.br");
        pf.setTelefone("11948601713");
        pf.setEndereco(new Endereco("SP","03576160", "Jd Elena", "São Paulo","Garuva", "97", "Casa"));
        pf.setNome("Igor Alves");
        pf.setCpf("11122233344");
        pf.setData_nasc("10/11/2018");
        boolean cad_valido = true;
        
        return pf;
    }    
    
    public PessoaFisica exemplo2(){
        PessoaFisica pf = new PessoaFisica();
        
        pf.setEmail("bruno@gmail.com.br");
        pf.setTelefone("124812840912");
        pf.setEndereco(new Endereco("SP","08310520", "Pq. São Rafael", "São Paulo", "Rua Redução de guarambaré", "330", "Casa 2"));
        pf.setNome("Bruno Batista");
        pf.setCpf("44197291809");
        pf.setData_nasc("18/02/2000");
        boolean cad_valido = true;
        
        return pf;
    }    
}
