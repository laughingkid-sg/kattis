import java.util.Arrays;
import java.util.Comparator;

class sortofsorting {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out); int n;
        while (io.hasMoreTokens()) {
            n = io.getInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {arr[i] = io.getWord();}
            Arrays.sort(arr, (a,b) -> a.substring(0,2).compareTo(b.substring(0,2)));
            Arrays.stream(arr).forEach(io::println);
            io.println();
        }
        io.close();
    }
}