import java.util.Scanner;

class twostones {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int input = io.getInt() % 2;

            if (input == 0) {
                io.println("Bob");
            } else {
                io.println("Alice");
            }
        
        io.close();
    }
}