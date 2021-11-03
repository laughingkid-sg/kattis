import java.util.ArrayList;
import java.util.Stack;
import java.util.HashSet;

class dominos {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        int testcases = io.getInt();
        int m; AdjacencyList graph;
        while (testcases != 0) {
            graph = new AdjacencyList(io.getInt());
            m = io.getInt();
            for (int j = 0; j < m; j++) graph.adj.get(io.getInt() - 1).add(io.getInt() - 1);
            io.println(graph.scc());
            testcases--;
        }
        io.close();
    }
}

class AdjacencyList {

    ArrayList<ArrayList<Integer>> adj;
    boolean visited[];
    Stack<Integer> stack;
    HashSet<Integer> map;

    AdjacencyList(int size) {
        adj = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            adj.add(new ArrayList<Integer>());
        }
        visited = new boolean[size];
        stack = new Stack<>();
    }

    int scc() {
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) DFS(i, true);
        }
        int result = 0;
        map = new HashSet<>(adj.size());
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!map.contains(vertex)) {
                DFS(vertex, false);
                result++;
            }
        }
        return result;
    }

    void DFS(int vertex, boolean type) {
        if (type) visited[vertex] = true;
        else map.add(vertex);
        for (int i = 0; i < adj.get(vertex).size(); i++) {
            int edge = adj.get(vertex).get(i);
            if (type && !visited[edge]) DFS(edge, type);
            else if (!type && !map.contains(edge)) DFS(edge, type);
        }
        if (type) stack.push(vertex);
    }
}