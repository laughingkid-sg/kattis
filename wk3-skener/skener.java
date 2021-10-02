class skener {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int x = io.getInt();
        final int y = io.getInt();
        final int z1 = io.getInt();
        final int z2 = io.getInt();

        for (int i = 0; i < x; i++) {
            char[] arr = new String(io.getLine()).toCharArray();
            for (int c = 0; c < z1; c++) {
                for (int k = 0; k < arr.length; k++) {
                    for (int j = 0; j < z2; j++) {
                        io.print(arr[k]);
                    }
                }
                io.println();
            }
        }
        io.close();
    }
}