/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Hussain
 */
public interface ProcessIF extends Remote {
    public int getID() throws RemoteException;    
    public boolean isActive() throws RemoteException;
    public void setActive(boolean active)throws RemoteException;
    public boolean isCoordinator()throws RemoteException;
    public void setCoordinator(boolean isCoordinator)throws RemoteException;

}
