package Graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SampleDFSWithStack {

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 1, 0, 0, 0, 0, 0 },
                { 1, 0, 1, 1, 1, 0, 0 },
                { 0, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 0, 0, 0, 1, 1 },
                { 0, 1, 0, 0, 0, 0, 1 },
                { 0, 0, 1, 1, 0, 0, 0 },
                { 0, 1, 0, 1, 1, 0, 0 } };

        // khai bao
        Stack<Integer> stack = new Stack<>();
        Set<Integer> daDuyet = new HashSet<>();

        // khoi tao
        stack.add(0);
        daDuyet.add(0);

        while (!stack.isEmpty()) {
            int u = stack.pop();
            System.out.print(u + " ");
            for (int i = 0; i < graph.length; i++) {
                if (graph[u][i] == 1 && daDuyet.contains(i) == false) {
                    stack.add(i);
                    daDuyet.add(i);
                }
            }
        }
    }
}
