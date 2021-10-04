import java.util.Arrays;
import java.util.Collections;

class password {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        double[] arr = new double[io.getInt()];
        for (int i = 0; i < arr.length; i++) {
            io.getWord();
            arr[i] = io.getDouble();
        }
        Arrays.sort(arr);
        reverseArray(arr);
        double total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i] * (i + 1);
        }
        io.print(total);
        io.close();
    }

    public static void reverseArray(double[] data) {
        int left = 0;
        int right = data.length - 1;
        double temp;
        while (left < right) {
            temp = data[left];
            data[left] = data[right];
            data[right] = temp;
            left++;
            right--;
        }
    }
}