/**
  * Name: Goh Zheng Teck
  * NUSNET ID: E0544321
  * Lab Class: Lab 03
*/
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class conforminity {

    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int stdCount = io.getInt();
        String currCombi= "";
        int max = 0, temp = 0;
        HashMap<String, Integer> combi = new HashMap<String, Integer>();
        String[] distCombi = new String[5];
        for (int i = 0; i < stdCount; i++) {
            for (int k = 0; k < 5; k++) {
                distCombi[k] = io.getWord();
            }
            Arrays.sort(distCombi);
            currCombi = String.join("", distCombi);
            if (combi.containsKey(currCombi)) // if item doesn't exist set then 1 reutrn 1, if exist reutnrs null
                temp = combi.computeIfPresent(currCombi, (k, v) -> v + 1); // increwmant
            else {
                temp = 1;
                combi.put(currCombi, 1);
            }
                
            if (temp > max)
                max = temp;
        }
        temp = 0;
        for (Map.Entry<String, Integer> curr : combi.entrySet()) {
            if (curr.getValue() == max)
                temp += max;
        }
        io.print(temp);
        io.close();
    }
}