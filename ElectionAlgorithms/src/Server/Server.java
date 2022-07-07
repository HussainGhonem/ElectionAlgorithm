/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author Hussain
 */
public class Server {
    public static void main(String[] args)throws Exception {
        ServerClass sc=new ServerClass();
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.rebind("Ring",sc); 
    }
    
}
