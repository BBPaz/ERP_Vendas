
package entidades;

public class Cliente{
    //atributos
    int id;
    String email;
    String telefone;
    Endereco endereco;
    boolean cad_valido;
    String estado;

 

    public Cliente() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isCad_valido() {
        return cad_valido;
    }

    public void setCad_valido(boolean cad_valido) {
        this.cad_valido = cad_valido;
    }
   
    
}
