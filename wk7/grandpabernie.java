import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

class grandpabernie {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        String word; ArrayList<Integer> arr;
        for (int i = 0; i < n; i++) {
            word = io.getWord();
            if (map.get(word) == null) {
                arr = new ArrayList<Integer>();
                arr.add(io.getInt());
                map.put(word, arr);
            } else {
                arr = map.get(word);
                arr.add(io.getInt());
            }
        }
        n = io.getInt();
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }
        for (int i = 0; i < n; i++) {
            arr = map.get(io.getWord());
            io.println(arr.get(io.getInt()-1));
        }
        io.close();
    }
}