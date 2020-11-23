package chatrmi_eng;

import java.io.Serializable;
import java.rmi.RemoteException;

public class Itens implements Serializable{
    private String nome;
    private String preco;
    private int numEstoque;

    public Itens(String nome, String preco, int numEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.numEstoque = numEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    
    public int getNumEstoque() {
        return numEstoque;
    }

    public void setNumEstoque(int numEstoque) {
        this.numEstoque = numEstoque;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
     
}
