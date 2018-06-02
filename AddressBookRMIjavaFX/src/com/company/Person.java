package com.company;

import java.io.Serializable;

public class Person implements Serializable {

    static final long serialVersionUID = 42L;

    private String imie;
    private String nazwisko;
    private String miasto;
    private String ulica;
    private String mr_dom;
    private String pesel;

    public Person(String imie, String nazwisko, String miasto, String ulica, String mr_dom, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.miasto = miasto;
        this.ulica = ulica;
        this.mr_dom = mr_dom;
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public String getMr_dom() {
        return mr_dom;
    }

    public String getPesel() {
        return pesel;
    }
}
