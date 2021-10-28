class island3 {

    private static char[][] grid;
    private static boolean[][] visited;

    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        grid = new char[io.getInt()][io.getInt()];
        visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            grid[i] = io.getWord().toCharArray();
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 'L') {
                    dfs(i, j);
                    count++; 
                }
            }
        }

        io.print(count);
        io.close();
    }

    private static void dfs(int i, int j) {
        if (visited[i][j])
            return;
        visited[i][j] = true;
        
        if (!(i + 1 >= grid.length) && (grid[i+1][j] == 'L' || grid[i+1][j] == 'C'))
            dfs(i + 1, j);
        if (!(i - 1 < 0) && (grid[i-1][j] == 'L' || grid[i-1][j] == 'C'))
            dfs(i - 1, j);
        if (!(j + 1 >= grid[i].length) && (grid[i][j+1] == 'L' || grid[i][j+1] == 'C'))
            dfs(i, j + 1);
        if (!(j - 1 < 0) && (grid[i][j-1] == 'L' || grid[i][j-1] == 'C'))
            dfs(i, j - 1);
    }
}