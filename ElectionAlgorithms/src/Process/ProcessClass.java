/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Hussain
 */
public class ProcessClass extends UnicastRemoteObject implements ProcessIF{
    int pid;
    boolean active;
    boolean isCoordinator;

    public ProcessClass(int pid) throws RemoteException {
        this.pid=pid;
        active=true;
        isCoordinator=false;
    }
   
    @Override
    public int getID() throws RemoteException {
        return pid;
    }

    @Override
    public boolean isActive() throws RemoteException {
        return active;
    }

    @Override
    public void setActive(boolean active) throws RemoteException {
        this.active=active;
    }

    @Override
    public boolean isCoordinator() throws RemoteException {
        return this.isCoordinator;
    }
    @Override
    public void setCoordinator(boolean isCoordinator){        
        this.isCoordinator=isCoordinator;
    }
    
}
