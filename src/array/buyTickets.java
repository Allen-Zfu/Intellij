package array;
import java.util.*;

public class buyTickets {
    public static void main(String[] args) {
        List<Integer> tickets = new ArrayList<>();
        tickets.add(5);
        tickets.add(5);
        tickets.add(2);
        tickets.add(3);
        //tickets.add(5);
        int p = 3;
        buyTickets ob = new buyTickets();
        long count = ob.waitingTime(tickets, p);
        System.out.println(count);

    }

    public static long waitingTime(List<Integer> tickets, int p) {
        if (tickets == null || tickets.size() == 0) {
            return 0;
        }
        long count = 0;
        for (int i = 0; i < p; i++) {
            if (tickets.get(i) >= tickets.get(p)) {
                count++;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < tickets.size(); i++) {
            pq.offer(tickets.get(i));
        }

        int size = pq.size();
        while (!pq.isEmpty()) {
            int leftNum = pq.poll();
            size += leftNum * size;
            while (!pq.isEmpty() && leftNum == pq.peek()) {
                pq.poll();
                size += leftNum * size;
            }
            size = pq.size();
        }
        return count;
    }
}
