/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi_eng;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 *
 * @author Nara
 */
public class Servidor {
    
    private IChat chat;
    
    public Servidor() throws RemoteException{
        chat = new ChatImpl();
        
        ArrayList<String> nomeProduto;
        ArrayList<String> precoProduto;
        ArrayList<Integer> quantidadeProduto;
        nomeProduto = new ArrayList<String>();
        precoProduto = new ArrayList<String>();
        quantidadeProduto = new ArrayList<Integer>();
        
        nomeProduto.add("Vitamina C");
        nomeProduto.add("Colirio");
        nomeProduto.add("Bombinha de Asma");
        nomeProduto.add("Protetor Labial");
        nomeProduto.add("Marcara Higienica");
        nomeProduto.add("Adesivo para Dor");
        nomeProduto.add("Esparadrapo");
        nomeProduto.add("Band-Aid");
        nomeProduto.add("Aspirina");
        nomeProduto.add("Neosaldina");
        nomeProduto.add("Dorflex");
        nomeProduto.add("Buscopan");
        nomeProduto.add("Eno");
        nomeProduto.add("Tums");
        nomeProduto.add("Epocler");
        nomeProduto.add("Drasil");
        nomeProduto.add("Loratadina");
        nomeProduto.add("Vick");
        nomeProduto.add("Xarope da Rochelle");
        
        precoProduto.add("R$ 6,00");
        precoProduto.add("R$ 8.50");
        precoProduto.add("R$ 12.00");
        precoProduto.add("R$ 5.00");
        precoProduto.add("R$ 2.00");
        precoProduto.add("R$ 2.00");
        precoProduto.add("R$ 2.50");
        precoProduto.add("R$ 1.00");
        precoProduto.add("R$ 2.00");
        precoProduto.add("R$ 2.00");
        precoProduto.add("R$ 3.00");
        precoProduto.add("R$ 2.00");
        precoProduto.add("R$ 3.00");
        precoProduto.add("R$ 3.00");
        precoProduto.add("R$ 2.00");
        precoProduto.add("R$ 3.00");
        precoProduto.add("R$ 2.00");
        precoProduto.add("R$ 3.00");
        precoProduto.add("R$ 2.00");
        System.out.println("chegou aqui");
        for(int n=0;n<19;n++){
            quantidadeProduto.add(50);
        }
        
        
        for (int a=0;a<19;a++){
         chat.cadastrarProduto(nomeProduto.get(a), precoProduto.get(a), quantidadeProduto.get(a));
         //chat.addQtdProduto(nomeProduto.get(a), quantidadeProduto.get(a));
        }
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("nossoChat", chat);
        System.out.println("Servidor executando / Atendendo na "
                + "porta 1099.");
    }
    
    public static void main(String[] args) throws RemoteException {
        new Servidor();
    }
}
