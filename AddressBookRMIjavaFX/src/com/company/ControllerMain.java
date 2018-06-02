package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerMain implements Initializable {

    private Connect connect;
    private Person person;

    public ControllerMain() {
        connect = new Connect();
    }

    @FXML
    private TableView<Person> table;
    @FXML
    private TableColumn<Person, String> imieTable;
    @FXML
    private TableColumn<Person, String> nazwiskoTable;
    @FXML
    private TableColumn<Person, String> miastoTable;
    @FXML
    private TableColumn<Person, String> ulicaTable;
    @FXML
    private TableColumn<Person, String> nrDomuTable;
    @FXML
    private TableColumn<Person, String> peselTable;
    @FXML
    private TextField imieInput;
    @FXML
    private TextField nazwiskoInput;
    @FXML
    private TextField imie;
    @FXML
    private TextField nazwisko;
    @FXML
    private TextField miasto;
    @FXML
    private TextField ulica;
    @FXML
    private TextField nrDomu;
    @FXML
    private TextField pesel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imieTable.setCellValueFactory(new PropertyValueFactory<>("imie"));
        nazwiskoTable.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        miastoTable.setCellValueFactory(new PropertyValueFactory<>("miasto"));
        ulicaTable.setCellValueFactory(new PropertyValueFactory<>("ulica"));
        nrDomuTable.setCellValueFactory(new PropertyValueFactory<>("mr_dom"));
        peselTable.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        table.setItems(connect.getAllData());

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                person = table.getSelectionModel().getSelectedItem();
                imie.setText(person.getImie());
                nazwisko.setText(person.getNazwisko());
                miasto.setText(person.getMiasto());
                ulica.setText(person.getUlica());
                nrDomu.setText(person.getMr_dom());
                pesel.setText(person.getPesel());

            }
        });

    }



    @FXML
    private ObservableList<Person> search() {
        ObservableList<Person> characters = FXCollections.observableArrayList();
        ArrayList<Person> arrayPerson = connect.searchPerson(imieInput.getText(), nazwiskoInput.getText());
        for (Person person : arrayPerson) {
            characters.add(new Person(person.getImie(), person.getNazwisko(), person.getMiasto(), person.getUlica(), person.getMr_dom(), person.getPesel()));
        }

        table.setItems(characters);
        table.refresh();
        return characters;
    }

    @FXML
    private void addPerson() {
        person = new Person(imie.getText(), nazwisko.getText(), miasto.getText(), ulica.getText(), nrDomu.getText(), pesel.getText());
        connect.addParson(person);
        refreshTable();
    }

    @FXML
    private void dropPerson() {
        person = new Person(imie.getText(), nazwisko.getText(), miasto.getText(), ulica.getText(), nrDomu.getText(), pesel.getText());
        connect.dropPerson(person);
        refreshTable();
    }

    @FXML
    private void changePerson() {
        person = new Person(imie.getText(),nazwisko.getText(),miasto.getText(),ulica.getText(),nrDomu.getText(),pesel.getText());
        connect.changePerson(person);
        refreshTable();
    }

    private void refreshTable() {
        table.setItems(connect.getAllData());
        table.sort();
        table.refresh();
    }

}
