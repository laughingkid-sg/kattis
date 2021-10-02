import java.util.Arrays;

/**
  * Name: Goh Zheng Teck
  * NUSNET ID: E0544321
  * Lab Class: Lab 03
*/

class teque {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int cmdCount = io.getInt();
        int[] front = new int[1_000_000];
        int[] back = new int[1_000_000];
        int frontSize, backSize, frontHead, backHead, n;
        boolean isEqual;
        frontSize = backSize =  0;
        backHead = frontHead = 499_999;
        for (int i = 0; i < cmdCount; i++) {
            isEqual = (frontSize == backSize);
            switch (io.getWord()) {
                case "push_back":
                    if (isEqual) {
                        back[backHead + backSize] = io.getInt();
                        front[frontHead + frontSize] = back[backHead];
                        backHead++;
                        frontSize++;
                    } else {
                        back[backHead + backSize] = io.getInt();
                        backSize++;
                    }
                    break;
            
                case "push_front":
                    if (isEqual) {
                        frontHead--;
                        front[frontHead] = io.getInt();
                        frontSize++;
                    } else {
                        frontHead--;
                        front[frontHead] = io.getInt();
                        backHead--;
                        back[backHead] = front[frontHead + frontSize];
                        backSize++;
                    }
                    break;
                
                case "push_middle":
                    if (isEqual) {
                        front[frontHead + frontSize] = io.getInt();
                        frontSize++;
                    } else {
                        backHead--;
                        back[backHead] = io.getInt();
                        backSize++;
                    }
                    break;
                default:
                    n = io.getInt();
                    if (n >= frontSize)
                        io.println(back[backHead + n - frontSize]);
                    else
                        io.println(front[frontHead + n]);
                    break;
            }
        }
        io.close();
    }
}