package com.company;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends ImplAddressBook {

    public static void main(String[] args) {
        try {
            // Instantiating the implementation class
            RMIInterface obj = new ImplAddressBook();

            // Exporting the object of implementation class
            // (here we are exporting the remote object to the stub)
            RMIInterface stub = (RMIInterface) UnicastRemoteObject.exportObject(obj, 0);

            // Binding the remote object (stub) in the registry
            Registry registry = LocateRegistry.createRegistry(6060);

            registry.rebind("AddressBook", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
