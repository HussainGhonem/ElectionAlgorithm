/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import Process.ProcessIF;
/**
 *
 * @author Hussain
 */
public interface ServerIF extends Remote {    
    
    public void addProcess(ProcessIF p) throws RemoteException;
    public int getmax() throws RemoteException;
    public void performElection() throws RemoteException;
}
