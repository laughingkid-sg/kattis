import java.util.Arrays;
class akcija {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        int[] arr = new int[io.getInt()];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = io.getInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i % 3 != 0) {
                sum += arr[i-1];
            } 
        }
        io.print(sum);
        io.close();
    }
}