package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RMIInterface extends Remote {
    void printMsg() throws RemoteException;
    void addPerson(Person person) throws RemoteException;
    ArrayList<Person> searchPerson(String firstname, String lastname) throws RemoteException;
    ArrayList<Person> printAll() throws RemoteException;
    Person getPerson(String firstname, String lastname, String pesel) throws RemoteException;
    void changeData(Person person) throws RemoteException;
    void dropPerson(Person person) throws RemoteException;
}
