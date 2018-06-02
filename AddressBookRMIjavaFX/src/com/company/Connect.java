package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Connect {
    private RMIInterface stub;
    private ObservableList<Person> book;

    public Connect() {
        try {
            Registry registry = LocateRegistry.getRegistry(6060);
            stub = (RMIInterface) registry.lookup("AddressBook");

            stub.printMsg();

        } catch (Exception e) {
            System.err.println("ControllerMain exception: " + e.toString());
            e.printStackTrace();
        }
    }

    public ObservableList<Person> getAllData() {
        ObservableList<Person> characters = FXCollections.observableArrayList();
        ArrayList<Person> arrayPerson = null;
        try {
            arrayPerson = stub.printAll();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        for (Person person : arrayPerson) {
            characters.add(new Person(person.getImie(),person.getNazwisko(),person.getMiasto(),person.getUlica(),person.getMr_dom(),person.getPesel()));
        }

        return characters;
    }

    public void addParson(Person person) {
        try {
            stub.addPerson(person);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Person> searchPerson(String firstname, String lastname) {
        try {
            return stub.searchPerson(firstname, lastname);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changePerson(Person person) {
        try {
            stub.changeData(person);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void dropPerson(Person person) {
        try {
            stub.dropPerson(person);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
