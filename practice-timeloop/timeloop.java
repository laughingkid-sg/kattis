class timeloop {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        for (int i = 0; i <= n; i++ ) {
            io.println(i + " Abracadabra");
        }
        io.close();
    }
}