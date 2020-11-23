/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi_eng;

import java.io.Serializable;

/**
 *
 * @author Nara
 */
public class Usuario implements Serializable{
    private String nome;
    private ICallback callback;
    private int estoque;

    public Usuario(String nome, ICallback callback, int estoque) {
        this.nome = nome;
        this.callback = callback;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }
    
    public void setEstoque(Integer estoque){
        this.estoque = estoque;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ICallback getCallback() {
        return callback;
    }

    public void setCallback(ICallback callback) {
        this.callback = callback;
    }

    @Override
    public String toString() {
        return nome;
    }
}
