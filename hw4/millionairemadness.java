import java.util.Comparator;
import java.util.PriorityQueue;

class millionairemadness {
    static int m, n;
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int[][] shift = {{1, -1, 0, 0}, {0, 0, 1, -1}};
        m = io.getInt(); n = io.getInt();
        int[][][] grid = new int[m][n][3]; // 0 -> value || 1 -> shortest || 2 -> visited, 0 false, 1 true
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j][0] = io.getInt();
                grid[i][j][1] = Integer.MAX_VALUE;
            }
        }
        grid[0][0][1] = 0;
        PriorityQueue<Vector> queue = new PriorityQueue<>(); // enqueued vectors indepdent of grid matrix
        queue.add(new Vector(0, 0, 0));
        while (!queue.isEmpty()) {
            Vector curr = queue.poll();
            if (grid[curr.y][curr.x][2] == 1)
                continue;
            grid[curr.y][curr.x][2] = 1;

            for (int i = 0; i < 4; i++) {
                int x = curr.x + shift[1][i];
                int y = curr.y + shift[0][i];

                if (!(x >= 0 && y >= 0 && y < m && x < n))
                    continue;
                
                int smallestEdge = Math.max(Math.max(0, grid[y][x][0] - grid[curr.y][curr.x][0]), grid[curr.y][curr.x][1]);

                if (grid[y][x][1] > smallestEdge) {
                    grid[y][x][1] = smallestEdge;
                    queue.add(new Vector(x, y, smallestEdge));
                }
            }
        }
        io.print(grid[m-1][n-1][1]);
        io.close();
    }

    
}

class Vector implements Comparable<Vector> {
    public int x, y, value;

    public Vector(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(Vector v) {
        if (this.value - v.value == 0)
            if (this.y == v.y)
                return v.x - this.x;
            else return v.y - this.y;
        return this.value - v.value;
    }
}