package com.practise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://en.wikipedia.org/wiki/Six_degrees_of_separation
public class SixDegreeOfSeparation {

    public static void main(String[] args) {

        Person A = new Person(1);
        Person B = new Person(2);
        Person C = new Person(3);
        // A -> B,C
        A.addConnection(B);
        A.addConnection(C);

        Person D = new Person(4);
        Person E = new Person(5);
        Person F = new Person(6);
        // B - > D, E
        B.addConnection(D);
        B.addConnection(E);
        // E -> A, F
        E.addConnection(A);
        E.addConnection(F);

        SixDegreeOfSeparation s = new SixDegreeOfSeparation();

        // A-> B -> E level 2
        System.out.println(s.isSixDegreeOfSeparationTrue(A,E));



        Person a1 = new Person(1);
        Person a2 = new Person(2);
        Person a3 = new Person(3);
        Person a4 = new Person(4);
        Person a5 = new Person(5);
        Person a6 = new Person(6);
        Person a7 = new Person(7);
        Person a8 = new Person(8);
        a1.addConnection(a2);
        a2.addConnection(a3);
        a2.addConnection(a8);
        a8.addConnection(a1);
        a3.addConnection(a4);
        a4.addConnection(a5);
        a5.addConnection(a6);
        a6.addConnection(a7);
        // cycle  a1-a2-a8-a1
       // a1 -> a2 -> a3 - a4 -> a5 -> a6 -a7
        System.out.println(s.isSixDegreeOfSeparationTrue(a1,a6));
    }


    boolean isSixDegreeOfSeparationTrue(Person p1, Person p2){

        Queue<Node> q = new LinkedList<>();

        Set<Person> visited = new HashSet<>();

        Node node = new Node(p1,0);

        q.add(node);


        while(!q.isEmpty()) {

            Node c = q.remove();


            int level = c.getLevel()+1;
            for(Person p : c.getPerson().getConnections()) {
                if(p.equals(p2)) {
                    if(level < 6) {
                        return true;
                    }
                } else {
                    if(visited.contains(c.getPerson())) continue;
                    Node pNode = new Node(p, level);
                    q.add(pNode);
                    visited.add(p);
                }

            }

            if(level > 6){
                break;
            }

        }
        return  false;

    }
}
