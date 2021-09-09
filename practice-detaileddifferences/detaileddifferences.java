import java.util.Scanner;

class detaileddifferences {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        String next;
        while (n != 0) {
            next = io.getLine();
            io.print(next);
            io.print("\n");
            char[] arr1 = next.toCharArray();

            next = io.getLine();
            io.print(next);
            io.print("\n");
            char[] arr2 = next.toCharArray();

            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] == arr2[i])
                    io.print(".");
                else
                    io.print("*");         
            }

            io.print("\n\n");
            n--;
        }
        io.close();
    }
}