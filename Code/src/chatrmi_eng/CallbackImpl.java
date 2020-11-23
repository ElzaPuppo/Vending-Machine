/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi_eng;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CallbackImpl extends UnicastRemoteObject implements ICallback{

    ClienteChatGUI tela;
    
    public CallbackImpl(ClienteChatGUI telaVM) throws RemoteException{
        super();
        this.tela = telaVM;
    }
    
    @Override
    public void registrarNovoUsuario(String nome, ICallback callback, int estoque) throws RemoteException {
        tela.getUsuariosConectados().addElement(
            new Usuario(nome, callback, estoque));
        
    }

    @Override
    public void removerUsuario(String nome) throws RemoteException {

        Usuario usuarioRemover = null;
        
        /*
        vamos "varrer" a lista de usuários até encontrar 
        qual devemos remover...
        */
        boolean encontrado = false;
        int i=0;
        
        while(i<tela.getUsuariosConectados().getSize()){
            
            Usuario u = (Usuario) tela.getUsuariosConectados()
                    .getElementAt(i);
            
            if(u.getNome().equals(nome)){
                usuarioRemover = u;
                break;
            }
            i++;
        }
        
        tela.getUsuariosConectados().removeElement(usuarioRemover);
    }
    
    public void comprarItem(int item, String nome){
        
        // passar lista de itens, quantidade e valores coooomoooooo??????
        
        
    }
    
}
