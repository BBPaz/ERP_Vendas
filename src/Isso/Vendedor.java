
package Isso;

public class Vendedor {
    
    private String nome_vendedor;
    private int id_vendedor;
    
    //construtor vendedor
    public Vendedor() {
    }
    
    public Vendedor(String nome_vendedor, int id_vendedor) {
        this.nome_vendedor = nome_vendedor;
        this.id_vendedor = id_vendedor;
    }
    
    //get's set's
    public String getNome_vendedor() {
        return nome_vendedor;
    }

    public void setNome_vendedor(String nome_vendedor) {
        this.nome_vendedor = nome_vendedor;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }
    

    
}
