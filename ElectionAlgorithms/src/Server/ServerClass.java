/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.server.UnicastRemoteObject;
import Process.ProcessIF;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Hussain
 */
public class ServerClass extends UnicastRemoteObject implements ServerIF{
    ArrayList<ProcessIF> processes;    
    int c=0;
    boolean coordinatorexists;
    int q=0;
    public ServerClass() throws RemoteException{
        processes= new ArrayList<ProcessIF>();
    }
    @Override
    public void addProcess(ProcessIF p) throws RemoteException {      
        this.processes.add(p);
        System.out.println("Process "+processes.get(q).getID()+" has joined the ring");
        if(this.coordinatorexists==false){
            processes.get(c).setCoordinator(true);
            System.out.println("Process "+processes.get(q).getID()+" is a coordinator");
            this.coordinatorexists=true;
            c=processes.get(q).getID();
        }
        q++;
    }

    @Override
    public int getmax() throws RemoteException {
        int maxID=0;
        for(int i=0;i<processes.size();i++){
            if(maxID<=processes.get(i).getID()&&processes.get(i).isActive()){
                maxID=processes.get(i).getID();
            }
        }
        return maxID;
    }

    @Override
    public void performElection() throws RemoteException {
        int i=0;
        int k=c+1;
        while(i<processes.size()){
            if(k<processes.size()){
                if(processes.get(k).isActive()){
                    System.out.println("Process "+k+" which ID number equals "+processes.get(k).getID()+" passes elections to Process "+(k+1));
                }k++;
            }
            if(k>=processes.size()){
                k=0;
            }
            i++;            
        }  
        c=getmax();      
        System.out.println(c);
        for (i=0;i<processes.size();i++){
            if(processes.get(i).getID()==c){
                processes.get(i).setCoordinator(true);
                break;
            }
        }
        k=c+1;
        i=0;
        while(i<processes.size()){
            if(k<processes.size()){
                System.out.println("Process "+k+" receives that the ID of the coordinator equals "+processes.get(c).getID()+" passes declaration to Process "+(k+1));
                k++;
            }
            if(k>=processes.size()){
                k=0;
            }
            i++;            
        } 
    }


}
