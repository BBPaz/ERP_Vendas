
package entidades;

public class Cliente{
    //atributos
    int id_cliente;
    String email;
    String telefone;
    Endereco endereco;
    boolean cad_valido;

    public Cliente(int id_cliente, String email, String telefone, Endereco endereco, boolean cad_valido) {
        this.id_cliente = id_cliente;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cad_valido = cad_valido;
    }

    public Cliente() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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
