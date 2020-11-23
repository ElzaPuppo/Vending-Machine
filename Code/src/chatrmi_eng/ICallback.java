/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi_eng;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Nara
 */
public interface ICallback extends Remote{
    public void registrarNovoUsuario(String nome, ICallback callback, int estoque)
            throws RemoteException;
    public void removerUsuario(String nome) throws RemoteException;
    public void comprarItem(int item, String nome) throws RemoteException;
}
