package com.company;

import java.util.ArrayList;

public class ImplAddressBook implements RMIInterface {

    private ArrayList<Person> book = new ArrayList<>();

    public ImplAddressBook() {
        book.add(new Person("Adrian", "Zolti", "Warszawa", "Kaczynska", "12", "99712345611"));
        book.add(new Person("Magda", "Zolti", "Poznan", "Wroclawska", "23", "99346312343"));
        book.add(new Person("Adrian", "Zolti", "Wroclaw", "Lisia", "166", "45612312343"));
        book.add(new Person("Artur", "Tkaczynski", "Wies", "Lesna", "132", "99245312343"));
        book.add(new Person("Marian", "Paluch", "Zamosc", "Moja", "11", "99562312335"));
        book.add(new Person("Adrian", "Taki", "Lubsko", "Kaczynska", "1", "99712345332"));
        book.add(new Person("Rafal", "Kowalski", "Zielona Gora", "Wiejska", "18", "99712852366"));
    }

    @Override
    public void printMsg() {
        System.out.println("Nowy klient");
    }

    @Override
    public ArrayList<Person> printAll() {
        return book;
    }

    @Override
    public void addPerson(Person person) {
        book.add(person);
    }

    @Override
    public ArrayList<Person> searchPerson(String firstname, String lastname) {
        ArrayList<Person> tmp = new ArrayList<>();
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getImie().equals(firstname) && book.get(i).getNazwisko().equals(lastname)) {
                tmp.add(book.get(i));
            }
        }
        return tmp;
    }

    public Person getPerson(String firstname, String lastname, String pesel) {
        Person personTMP = null;
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getImie().equals(firstname) && book.get(i).getNazwisko().equals(lastname) && book.get(i).getPesel().equals(pesel)) {
                personTMP = book.get(i);
            }
        }
        return personTMP;
    }

    @Override
    public void dropPerson(Person person) {
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getPesel().equals(person.getPesel())) {
                book.remove(book.get(i));
            }
        }
    }

    @Override
    public void changeData(Person person) {
        dropPerson(person);
        book.add(person);
    }

}
