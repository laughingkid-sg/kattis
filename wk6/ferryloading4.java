
import java.util.Queue;
import java.util.LinkedList;

class ferryloading4 {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int q = io.getInt();
        int length, count = 0, currLength;
        for (int k = 0; k < q; k++) {
            length = io.getInt() * 100;
            count = io.getInt();
            Queue<Integer> left = new LinkedList<Integer>();
            Queue<Integer> right = new LinkedList<Integer>();
            for (int i = 0; i < count; i++) {
                currLength = io.getInt();
                if ("left".equals(io.getWord()))
                    left.offer(currLength);
                else
                    right.offer(currLength);
            }
            count = 0;
            boolean side = true; // left is true, right is false
            while (!left.isEmpty() || !right.isEmpty()) {
                currLength = length;
                if (side) {
                    while (!left.isEmpty()) {
                        if (currLength - left.peek() >= 0)
                            currLength -= left.poll();
                        else break;
                    }
                    side = false;
                } else if (!side) {
                    while (!right.isEmpty()) {
                        if (currLength - right.peek() >= 0) 
                            currLength -= right.poll();
                        else break;
                    }
                    side = true;
                }
                count++;
            }
            io.println(count);
        }
        io.close();
    }
}
