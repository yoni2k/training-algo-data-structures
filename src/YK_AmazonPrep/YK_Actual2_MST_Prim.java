package YK_AmazonPrep;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class YK_Actual2_MST_Prim {

    private class Vertex implements Comparable<Vertex> {
        int num;
        int cost;

        Vertex(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(@NotNull YK_Actual2_MST_Prim.Vertex o) {
            return Integer.compare(this.cost, o.cost);
        }

        @Override
        public boolean equals(Object obj) {
            if(obj.getClass() == this.getClass()) {
                Vertex other = (Vertex)obj;
                return ((this.num == other.num) && (this.cost == other.cost));
            }
            return false;
        }
    }

    private ArrayList<Vertex>[] getAdjLists (int numTotalAvailableCities,
                                      int[][] roadsAvailable,
                                      int[][] costNewRoadsConstruct) {

        ArrayList<Vertex>[] adjLists = new ArrayList[numTotalAvailableCities];

        for(int i = 0; i < numTotalAvailableCities; i++) {
            adjLists[i] = new ArrayList<>();
        }

        for(int[] road : roadsAvailable) {
            adjLists[road[0]].add(new Vertex(road[1], 0));
            adjLists[road[1]].add(new Vertex(road[0], 0));
        }

        for(int[] road : costNewRoadsConstruct) {
            adjLists[road[0]].add(new Vertex(road[1], road[2]));
            adjLists[road[1]].add(new Vertex(road[0], road[2]));
        }

        return adjLists;
    }

    //Put all relevant neighbours into pq
    // Relevant neighbour is one that wasn't visited, that is not already in queue with a lower/same cost
    private void putNeighboursInPQ(int vertex,
                                   ArrayList<Vertex>[] adjLists,
                                   HashMap<Integer, Boolean> visited,
                                   PriorityQueue<Vertex> pq,
                                   HashMap<Integer, Integer> inPq) {
        int oldCost;

        for(Vertex neighbour : adjLists[vertex]) {
            if(visited.containsKey(neighbour.num) == false) {
                if (inPq.containsKey(neighbour.num)) {//remove and put new only if lower cost
                    oldCost = inPq.get(neighbour.num);
                    if (oldCost > neighbour.cost) {
                        pq.remove(new Vertex(neighbour.num, oldCost));
                        pq.add(new Vertex(neighbour.num, neighbour.cost));
                        inPq.put(neighbour.num, neighbour.cost);//override
                    }
                } else {
                    pq.add(new Vertex(neighbour.num, neighbour.cost));
                    inPq.put(neighbour.num, neighbour.cost);
                }
            }
        }

    }

    public int getMinimumCostToConstruct(int numTotalAvailableCities,
                                         int[][] roadsAvailable,
                                         int[][] costNewRoadsConstruct) {
        int totalCost = 0;

        ArrayList<Vertex>[] adjLists;//saves costs of connections/edges, with prices 0 and real prices
        HashMap<Integer, Boolean> visited = new HashMap<>();//saves visited vertexes
        HashMap<Integer, Integer> inPq = new HashMap<>();//used to make search in PQ O(1) instead of O(V)
        PriorityQueue<Vertex> pq = new PriorityQueue<>();//saves vertexes ready to be added

        //O(V + E)
        adjLists = getAdjLists(numTotalAvailableCities, roadsAvailable, costNewRoadsConstruct);

        visited.put(0, true);
        //O(E log V) - practically it will be much less than (log V) in (E log V)
        // because not putting unknown vertexes in Priority Queue
        // also E for one is the worst case in very densely connected graph
        putNeighboursInPQ(0, adjLists, visited, pq, inPq);

        Vertex vertex;

        while (pq.size() > 0) {//outer loop O(V)
            vertex = pq.poll();
            visited.put(vertex.num, true);
            inPq.remove(vertex.num);
            totalCost += vertex.cost;

            //O(E log V) - practically it will be much less than (log V) in (E log V) because not putting unknown vertexes in Priority Queue
            // with outer loop O(V*E log V).  However, practically will be O ((V+E) log V), since needs to handle
            // both all Vertexes - outer loop, and all connections - E inner loop
            putNeighboursInPQ(vertex.num, adjLists, visited, pq, inPq);
        }

        if (visited.size() == numTotalAvailableCities) {
            return totalCost;
        } else {
            return -1;
        }
    }

}
