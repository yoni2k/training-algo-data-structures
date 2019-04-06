package YK_AmazonPrep;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.PriorityQueue;

/* Given a number of cities, and a number of already connected cities, and a number of possible connections with their costs,
 build a tree with minimal cost and return the cost

 This is a variation of the MST - minimal spanning tree problem.
 I think what I implemented is a variation of Prim's algorithm.   Complexity O(E log E) where E is the number of connections / roads which is in worst case
 O(V^2 log V^2).
 There are a few other algorithms that can be implemented, but the are more complicated to implement

 Includes very partial implementation done during interview in comment below
 */

public class YK_Actual2_MST_MinimalCitiesConnected {

    private class Conn implements Comparable<Conn> {
        int from;
        int to;
        int cost;

        public Conn(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(@NotNull YK_Actual2_MST_MinimalCitiesConnected.Conn o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    private PriorityQueue<Conn> buildPriorityQueue( int[][] roadsAvailable,
                                                    int[][] costNewRoadsConstruct) {
        PriorityQueue<Conn> pq = new PriorityQueue<>();

        for (int[] road : roadsAvailable) {
            pq.add(new Conn(road[0], road[1], 0));
        }

        for (int[] road : costNewRoadsConstruct) {
            pq.add(new Conn(road[0], road[1], road[2]));
        }

        return  pq;
    }

    /* Prototype in the question
    public int getMinimumCostToConstruct(int numTotalAvailableCities,
                                  int numTotalAvailableRoads,
                                  List<List<Integer>> roadsAvailable,
                                  int numNewRoadsConstruct,
                                  List<List<Integer>> costNewRoadsConstruct) */
    public int getMinimumCostToConstruct(int numTotalAvailableCities,
                                         int[][] roadsAvailable,
                                         int[][] costNewRoadsConstruct) {

        PriorityQueue<Conn> pq = buildPriorityQueue(roadsAvailable, costNewRoadsConstruct);
        PriorityQueue<Conn> pqTemp;
        HashMap<Integer, Boolean> connected = new HashMap<>();
        int totalPrice = 0;
        int sizeBefore;
        Conn conn;

        connected.put(0, true);

        do {
            sizeBefore = pq.size();
            pqTemp = new PriorityQueue<>(pq);

            while((conn = pqTemp.poll()) != null) {
                if (connected.containsKey(conn.from) && !connected.containsKey(conn.to)) {
                    connected.put(conn.to, true);
                    totalPrice += conn.cost;
                    pq.remove(conn);
                    break;
                } else if (connected.containsKey(conn.to) && !connected.containsKey(conn.from)) {
                    connected.put(conn.from, true);
                    totalPrice += conn.cost;
                    pq.remove(conn);
                    break;
                } else if (connected.containsKey(conn.to) && (connected.containsKey(conn.from))) {
                    pq.remove(conn);
                }
            }

        } while (sizeBefore != pq.size());

        if (connected.size() == numTotalAvailableCities) {
            return totalPrice;
        } else {
            return -1;
        }
    }

    // Partial code done in interview
//    class Conn implements Comparator<Conn> {
//        int price;
//        int from;
//        int to;
//
//        Conn(int price, int from, int to) {
//            this.price = price;
//            this.from = from;
//            this.to = to;
//        }
//
//
//        @Override
//        public int compare(Conn o1, Conn o2) {
//            if(o1.price < o2.price) {
//                return -1;
//            } else if (o1.price == o2.price) {
//                return 0;
//            } else {
//                return 1;
//            }
//        }
//    }
//
//    private void findAllConnected(int index, int[][] cons, int numCities, HashMap<Integer, Boolean> inGraph) {
//        HashMap<Integer, Boolean> visited = new HashMap<>();
//        LinkedList<Integer> toVisit = new LinkedList<>();
//        toVisit.add(index);
//        int visiting;
//
//        while(toVisit.size() > 0) {
//            visiting = toVisit.remove().intValue();
//            inGraph.put(index, true);
//
//            for(int i = 0; i < numCities; i++) {
//                if(cons[visiting][i] == -1) {
//                    inGraph.put(i, true);
//                    if (visited.containsKey(i) == false) {
//                        toVisit.add(i);
//                    }
//                }
//            }
//        }
//    }
//
//    int getMinimumCostToConstruct(int numTotalAvailableCities,
//                                  int numTotalAvailableRoads,
//                                  List<List<Integer>> roadsAvailable,
//                                  int numNewRoadsConstruct,
//                                  List<List<Integer>> costNewRoadsConstruct)
//    {
//        int totalCost = 0;
//        /* Algorithm:
//            1. Take random node
//            2. Find all connected nodes
//            3. Find all roads "out"
//            4. Find the minimum of all roads out
//            5. Connect the new "island"
//
//            6. Connect new nodes of new island
//            7. Merge the minimum of all roads
//            8. Go to 5
//        */
//
//        // -1 - already connected, 0 - can't connect, > 0 - price to connect
//        //initialized to 0 - can't connect
//        int[][] cons = new int[numTotalAvailableCities][numTotalAvailableCities];
//        int from;
//        int to;
//
//        for (List<Integer> con : roadsAvailable) {
//            from = con.get(0) - 1;
//            to = con.get(1) - 1;
//
//            cons[from][to] = -1;
//            cons[to][from] = -1;
//        }
//
//        PriorityQueue<Conn> priceToConnect = new PriorityQueue<Conn>(); //for putting in prices to Connect
//
//        int singleCost;
//        for (List<Integer> cost : costNewRoadsConstruct) {
//            from = cost.get(0) - 1;
//            to = cost.get(1) - 1;
//            singleCost = cost.get(2);
//
//            priceToConnect.add(new Conn(singleCost,from,to));
//
//            cons[from][to] = singleCost;
//            cons[to][from] = singleCost;
//        }
//
//        HashMap<Integer, Boolean> inGraph = new HashMap<>();
//        inGraph.put(0,true);
//
//        findAllConnected(0, cons, numTotalAvailableCities, inGraph);
//
//        return totalCost;
//    }
}
