
package chatrmi_eng;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class EstoqueImpl extends UnicastRemoteObject implements Iestoque{
    ArrayList<Itens> listaProdutosLocal;
    
    public EstoqueImpl() throws RemoteException{
        super();
        listaProdutosLocal = new ArrayList<Itens>();
    }
    
    @Override
    public void cadastrarProduto(String nome, String preco, int numEstoque) throws RemoteException
    {
        listaProdutosLocal.add(new Itens(nome, preco, numEstoque));
        //System.out.println("Produto "+nome+" cadastrado!");
    }
    
    @Override
    public void addQtdProduto(String nome, int numEstoque) throws RemoteException
    {
        for(Itens u: listaProdutosLocal){
            if(u.getNome().equalsIgnoreCase(nome))
            {
                u.setNumEstoque(u.getNumEstoque()+numEstoque);
            }
        }
       // System.out.println(numEstoque+" unidades do produto "+nome+" adicionadas!");
    }
    
    @Override
    public boolean produtoEmEstoque(String nome) throws RemoteException
    {
        for(Itens u: listaProdutosLocal){
            if(u.getNome().equalsIgnoreCase(nome))
            {
                return(u.getNumEstoque()>0);
            }
        }
        
        return false;
    }
    
    @Override
    public void realizaVenda(String nome) throws RemoteException
    {
        for(Itens u: listaProdutosLocal){
            if(u.getNome().equalsIgnoreCase(nome))
            {
                u.setNumEstoque(u.getNumEstoque()-1);
                //System.out.print("deu menos");
            }
            //else System.out.print("deu em nada bicho");
        }
    }
}






