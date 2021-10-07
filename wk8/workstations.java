import java.util.Arrays;
import java.util.PriorityQueue;

class workstations {

    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int[][] timeArr = new int[io.getInt()][2];
        final int limit = io.getInt();

        for (int i = 0; i < timeArr.length; i++) {
            timeArr[i][0] = io.getInt();
            timeArr[i][1] = io.getInt();
        }
        Arrays.sort(timeArr, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pcs = new PriorityQueue<>();
        int count = 0;
        int user[];

        for (int i = 0; i < timeArr.length; i++) {
            user = timeArr[i];
            while(!pcs.isEmpty()) {
                if (pcs.peek() + limit < user[0]) /* Removed Locked cos past 5mins */
                    pcs.poll();
                else break;
            }
            if (!pcs.isEmpty() && user[0] <= pcs.peek() + limit && pcs.peek() <= user[0]) {
                count++;
                pcs.poll();
            }
            pcs.add(user[0] + user[1]);
        }

        io.print(count);
        io.close();
    }
}