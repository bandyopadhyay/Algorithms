package com.practise;

public class Node {
    Person person;
    int level;

    public Node(Person person, int level) {
        this.person = person;
        this.level = level;
    }
    public Node(){

    }

    public Person getPerson() {
        return person;
    }

    public int getLevel() {
        return level;
    }
}
