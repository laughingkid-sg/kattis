class fizzbuzz {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int a = io.getInt();
        final int b = io.getInt();
        final int count = io.getInt();

        for (int i = 1; i <= count; i++) {
            if (i % a == 0 && i % b == 0) {
                io.println("FizzBuzz");
            } else if (i % a == 0) {
                io.println("Fizz");
            } else if (i % b == 0) {
                io.println("Buzz");
            } else {
                io.println(i);
            }
        }
        io.close();
    }
}