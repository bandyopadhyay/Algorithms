package com.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {

    int id;
    List<Person> connections;

    public Person(int id) {
        this.id = id;
        connections = new ArrayList<>();
    }

    public Person(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Person> getConnections() {
        return connections;
    }

    public void setConnections(List<Person> connections) {
        this.connections = connections;
    }

    public void addConnection(Person p){
        connections.add(p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
