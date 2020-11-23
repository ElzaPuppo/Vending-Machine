/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi_eng;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

public class ChatImpl extends UnicastRemoteObject implements IChat {

    ArrayList<Usuario> usuariosConectados;
    ArrayList<String> nomeProduto;
    ArrayList<String> precoProduto;
    ArrayList<Integer> quantidadeProduto;
    ArrayList<Itens> listaProdutos;

    public ChatImpl() throws RemoteException {
        super();
        usuariosConectados = new ArrayList<Usuario>();
        nomeProduto = new ArrayList<String>();
        precoProduto = new ArrayList<String>();
        quantidadeProduto = new ArrayList<Integer>();
        listaProdutos = new ArrayList<Itens>();
    }

    public ArrayList<String> retornaNome() throws RemoteException {
        return nomeProduto;
    }

    public ArrayList<Usuario> registrar(String nome, ICallback callback, int estoque) throws RemoteException {

        //Primeiro, temos que avisar a todos os usuários 
        //que um novo usuário entrou no chat...
        for (Usuario u : usuariosConectados) {
            u.getCallback().registrarNovoUsuario(nome, callback, estoque);
        }

        //Agora, precisamos adicionar este usuário na lista 
        //de usuários conectados do servidor:
        usuariosConectados.add(new Usuario(nome, callback, estoque));
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
        for (int i = 0; i < 19; i++) {
            quantidadeProduto.add(estoque);
        }

        System.out.println("Usuario " + nome + " se conectou!");

        return usuariosConectados;
    }

    @Override
    public String buscaPrecoProduto(String nome) throws RemoteException {
        for (Itens u : listaProdutos) {
            if (u.getNome().equalsIgnoreCase(nome)) {
                return (u.getPreco());
            }
        }
        return "";
    }

    @Override
    public void realizaVenda(String nome) throws RemoteException {
        for (Itens u : listaProdutos) {
            if (u.getNome().equalsIgnoreCase(nome)) {
                u.setNumEstoque(u.getNumEstoque() - 1);
            }
        }
    }

    @Override
    public ArrayList<Itens> cadastrarProduto(String nome, String preco, int numEstoque) throws RemoteException {
        listaProdutos.add(new Itens(nome, preco, numEstoque));
        //System.out.println("Produto " + nome + " cadastrado!");

        return listaProdutos;
    }

    @Override
    public ArrayList<Itens> addQtdProduto(String nome, int numEstoque) throws RemoteException {

        for (Itens u : listaProdutos) {
            if (u.getNome().equalsIgnoreCase(nome)) {
                u.setNumEstoque(u.getNumEstoque() + numEstoque);
            }
        }
        //System.out.println(numEstoque + " unidades do produto " + nome + " adicionadas!");
        return listaProdutos;
    }

    @Override
    public void desconectar(String nome) throws RemoteException {

        Usuario usuarioRemover = null;

        /*  Vamos "varrer" a lista de usuários conectados
            até encontrar qual remover...
            Já aproveitamos o mesmo laço para avisar aos
            demais que um usuário está sendo desconectado. 
         */
        for (Usuario u : usuariosConectados) {
            if (u.getNome().equals(nome)) {
                usuarioRemover = u;
            } else {
                u.getCallback().removerUsuario(nome);
            }
        }

        //Remover o usuário da lista de usuários registrados/conectados:
        usuariosConectados.remove(usuarioRemover);
        System.out.println("Usuario " + nome + " se desconectou.");
    }

    @Override
    public void realizarCompra(int item, String nome) throws RemoteException {

        Iterator it = usuariosConectados.iterator();

        ICallback usuarioConectado;

        while (it.hasNext()) {

            Usuario u = (Usuario) it.next();

            if (!u.getNome().equals(nome)) {
                usuarioConectado = u.getCallback();
                usuarioConectado.comprarItem(item, nome);
            }
        }
    }

}
