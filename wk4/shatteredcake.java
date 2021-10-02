class shatteredcake {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int w = io.getInt();
        final int p = io.getInt();
        int area = 0;

        for (int i = 0; i < p; i++) {
            area += io.getInt() * io.getInt();
        }
        io.print(area/w);
        io.close();
    }
}