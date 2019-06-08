package com.g;

import java.util.*;

public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> flights = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!flights.containsKey(ticket.get(0))) {
                flights.put(ticket.get(0), new PriorityQueue<String>());
                flights.get(ticket.get(0)).add(ticket.get(1));
            }else {
                flights.get(ticket.get(0)).add(ticket.get(1));
            }
        }

        LinkedList<String> path = new LinkedList<>();
        dfs("JFK", flights,path);
        return path;
    }

    public void dfs(String from, HashMap<String, PriorityQueue<String>> flights, LinkedList<String> path) {
        PriorityQueue<String> destList = flights.get(from);
        while (destList != null && !destList.isEmpty()) {
            dfs(destList.poll(),flights,path);
        }
        path.addFirst(from);
    }
}

