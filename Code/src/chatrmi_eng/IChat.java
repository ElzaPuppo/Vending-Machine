/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi_eng;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Nara
 */
public interface IChat extends Remote{
    public ArrayList<Usuario> registrar(String nome, ICallback callback, int estoque) 
            throws RemoteException;
    public void desconectar(String nome) throws RemoteException;
    public void realizarCompra(int item, String nome) throws RemoteException;
    public ArrayList<Itens> cadastrarProduto(String nome, String preco, int numEstoque) throws RemoteException;
    public void realizaVenda(String nome) throws RemoteException;
    public String buscaPrecoProduto(String nome) throws RemoteException;
     public ArrayList<Itens> addQtdProduto(String nome, int numEstoque) throws RemoteException;
}
