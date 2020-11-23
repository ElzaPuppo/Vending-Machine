
package chatrmi_eng;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IEstoqueGlobal extends Remote{
    public ArrayList<Usuario> registrar(String nome, ICallback callback) 
            throws RemoteException;
    public void desconectar(String nome) throws RemoteException;
    public ArrayList<Itens> cadastrarProduto(String nome, double preco, int numEstoque) throws RemoteException;
    public ArrayList<Itens> addQtdProduto(String nome, int numEstoque) throws RemoteException;
    public double buscaPrecoProduto(String nome) throws RemoteException;
    public void realizaVenda(String nome) throws RemoteException;
    //public void enviarMsgTodos(String de, String msg) throws RemoteException;
}
