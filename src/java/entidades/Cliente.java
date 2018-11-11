
package entidades;

public class Cliente{
    //atributos
    int id;
    String email;
    String telefone;
    Endereco endereco;
    boolean cad_valido;

    public Cliente(int id_cliente, String email, String telefone, Endereco endereco, boolean cad_valido) {
        this.id = id_cliente;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cad_valido = cad_valido;
    }

    public Cliente() {
    }
    
    public Cliente exemplo(){
        int id = 1;
        String email = "igor@igor.com.br";
        String telefone = "11948601713";
        Endereco c1 = new Endereco("03576160", "Jd Elena", "igor@igor.com.br", 
                "São Paulo", "Garuva", "97", "Casa");
        boolean cad_valido = true;

        return null;
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
