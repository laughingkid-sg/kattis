class weakvertices {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        int size = io.getInt();
        boolean weak; 
        
        while (size != -1) {
            boolean[][] martix = new boolean[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (io.getInt() == 0)
                        martix[i][j] = false;
                    else
                        martix[i][j] = true;
                }
            }
            
            for (int i = 0; i < size; i++) {
                weak = true;
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        if (martix[i][j] && martix[j][k] && martix[i][k] && i != j  && j != k && i != k)
                            weak = false;
                    }
                }
                if (weak)
                    io.print(i + " ");
            }
            io.println();
            size = io.getInt();
        }
        io.close();
    }
}