class exactlyelectrical {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int sX = io.getInt();
        final int sY = io.getInt();
        final int eX = io.getInt();
        final int eY = io.getInt();
        final int count = io.getInt();

        int out = Math.abs(sX - eX) + Math.abs(sY - eY);
        if (count < out || (count - out) % 2 == 1)
            io.print("N");
        else 
            io.print("Y");
        io.close();
    }
}