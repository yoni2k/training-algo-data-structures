package YK_AmazonPrep;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
Given number of integers, return the minimum cost to assemble all the parts, where:
- every integer is a price to include this part in the assembly
- cost of assembly is cost of 2 parts that are being assembled
- after assembly of 2 parts, the cost of a new part is the sum of costs of 2 parts assembled from
- everything needs to be assembled
- total cost of assembly is the sume of all assembly operations
- number of parts >= 2

Implementation detail: Using priority queues

Implemented during interview: although I used ordered list and added from smallest, but because I didn't use priority queue,
    and didn't re-add the new assembled part, it sometimes matches the answer and sometimes not.
 */

public class YK_Actual1_AssemblyOrder {

    int minimumTime(List<Integer> parts)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(parts);

        int first;
        int second;
        int minTime = 0;
        /* while there are more than 2 parts to assemble, continue assembling:
        - assemble 2 cheapest parts
        - add the result to:
        - 1. total price
        - 2. queue of lists of parts to assemble
         */
        while (pq.size() > 1) {
            first = pq.remove();
            second = pq.remove();
            minTime += (first + second);
            pq.add(first + second);
        }

        return minTime;
    }
}
