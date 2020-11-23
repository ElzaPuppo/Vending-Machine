package chatrmi_eng;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Iestoque extends Remote{
    public void cadastrarProduto(String nome, String preco, int numEstoque) throws RemoteException;
    public void addQtdProduto(String nome, int numEstoque) throws RemoteException;
    public boolean produtoEmEstoque(String nome) throws RemoteException;
    public void realizaVenda(String nome) throws RemoteException;
}