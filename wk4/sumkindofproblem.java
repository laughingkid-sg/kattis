class sumkindofproblem { 
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int c = io.getInt();
        int n, sum;
        for (int i = 1; i <= c; i++) {
            io.print(io.getInt());
            n = io.getInt();
            sum = (n*(n+1))/2;
            io.print(" ");
            io.print(sum);
            io.print(" ");
            io.print(sum*2-n);
            io.print(" ");
            io.println(sum*2);
        }
        io.close();
    }
}