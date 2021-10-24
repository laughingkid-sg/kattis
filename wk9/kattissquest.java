import java.util.PriorityQueue;
import java.util.Collections;
import java.util.TreeMap;

class kattissquest {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int n = io.getInt(); int energy, quest; long sum;
        TreeMap<Integer, PriorityQueue<Integer>> treemap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if ("add".equals(io.getWord())) {
                energy = io.getInt();
                if (treemap.containsKey(energy))
                    treemap.get(energy).add(io.getInt());
                else {
                    treemap.put(energy, new PriorityQueue<>(Collections.reverseOrder()));
                    treemap.get(energy).add(io.getInt());
                }
            } else {
                energy = io.getInt();
                if (treemap.floorKey(energy) == null)
                    io.println(0);
                else {
                    sum = 0;
                    while (treemap.floorKey(energy) != null) {
                        quest = treemap.floorKey(energy);
                        energy -= quest;
                        sum += treemap.get(quest).poll();
                        if (treemap.get(quest).peek() == null)
                            treemap.remove(quest);
                    }
                    io.println(sum);
                }
            }
        }
        io.close();
    }
}