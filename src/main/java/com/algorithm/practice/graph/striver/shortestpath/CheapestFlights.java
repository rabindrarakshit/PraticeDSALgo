package com.algorithm.practice.graph.striver.shortestpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Ref: https://takeuforward.org/data-structure/g-38-cheapest-flights-within-k-stops/

/*
* Time Complexity: O( N ) { Additional log(N) of time eliminated here because we’re using a simple queue rather than a priority queue which is usually used in Dijkstra’s Algorithm }.

Where N = Number of flights / Number of edges.

Space Complexity:  O( |E| + |V| ) { for the adjacency list, priority queue, and the dist array }.

Where E = Number of edges (flights.size()) and V = Number of Airports.
*
* */

public class CheapestFlights {
    static class Flight {
        int cityId;
        int cost;

        Flight(int cityId, int cost) {
            this.cityId = cityId;
            this.cost = cost;
        }
    }

    static class Cost {
        int cityId;
        int price;
        int hop;

        Cost(int cityId, int price, int hop) {
            this.cityId = cityId;
            this.price = price;
            this.hop = hop;
        }
    }

    static List<List<Flight>> createAdjList(int[][] flights, int cities) {
        List<List<Flight>> flightList = new ArrayList<>();
        for (int i = 0; i < cities; i++) {
            flightList.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int source = flight[0];
            int target = flight[1];
            int cost = flight[2];

            flightList.get(source).add(new Flight(target, cost));
        }
        return flightList;
    }

    static int cheapestFlight(int[][] flights, int cities, int src, int dest, int allowedHops) {
        List<List<Flight>> flightList = createAdjList(flights, cities);
        int[] costs = new int[cities];
        Queue<Cost> q = new LinkedList<>();

        for (int i = 0; i < cities; i++) {
            costs[i] = (int) 1e9;
        }

        q.add(new Cost(src, 0, 0));
        costs[src] = 0;

        while (!q.isEmpty()) {
            Cost cost = q.poll();
            int cityId = cost.cityId;
            if (cost.hop > allowedHops) continue;
            for (Flight flight : flightList.get(cityId)) {
                int currentDest = flight.cityId;
                int currentCost = cost.price + flight.cost;

                if (currentCost < costs[currentDest] && cost.hop <= allowedHops) {
                    costs[currentDest] = currentCost;
                    q.add(new Cost(currentDest, currentCost, cost.hop + 1));
                }
            }
        }

        if (costs[dest] == (int) 1e9) return -1;
        else return costs[dest];
    }

    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, K = 1;
        //  int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int[][] flights = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        int ans = cheapestFlight(flights, n, src, dst, K);

        System.out.print(ans);
        System.out.println();
    }
}
