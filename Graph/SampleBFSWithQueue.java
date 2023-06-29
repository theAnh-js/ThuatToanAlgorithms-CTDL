package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class SampleBFSWithQueue {

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 1, 0, 0, 0, 0, 0 },
                { 1, 0, 1, 1, 1, 0, 0 },
                { 0, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 0, 0, 0, 1, 1 },
                { 0, 1, 0, 0, 0, 0, 1 },
                { 0, 0, 1, 1, 0, 0, 0 },
                { 0, 1, 0, 1, 1, 0, 0 } };

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> daDuyet = new HashSet<>();

        queue.add(0);
        daDuyet.add(0);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");

            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] == 1 && daDuyet.contains(v) == false) {
                    queue.add(v);
                    daDuyet.add(v);
                }
            }
        }

    }
}
