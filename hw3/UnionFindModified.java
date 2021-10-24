class UnionFindModified {                                              
  public int[] p;
  public int[][] rank;

  public UnionFindModified(int N) {
    p = new int[N];
    rank = new int[N][3]; // [0] Rank [1] DS Size [2] Taken
    for (int i = 0; i < N; i++) {
      p[i] = i;
      rank[i][1] = 1;
    }
  }

  public int findSet(int i) { 
    if (p[i] == i) return i;
    else {
      p[i] = findSet(p[i]);
      return p[i]; 
    } 
  }

  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

  public void unionSet(int i, int j) { 
    if (!isSameSet(i, j)) { 
      int x = findSet(i), y = findSet(j);
      if (rank[x][0] > rank[y][0]) {
        p[y] = x;
        rank[x][1] += rank[y][1];
        rank[x][2] += rank[y][2];
      } else { 
      	p[x] = y;
        rank[y][1] += rank[x][1];
        rank[y][2] += rank[x][2];
        if (rank[x][0] == rank[y][0]) 
          rank[y][0] = rank[y][0]+1; 
      } 
    } 
  }

  public boolean isNotFull(int i, int j) {
    unionSet(i, j);
    int p = findSet(i);
    if (rank[p][1] > rank[p][2]) {
      rank[p][2]++;
      return true;
    }
    return false;
  }
}