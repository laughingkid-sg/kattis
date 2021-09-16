/**
  * Name: Goh Zheng Teck
  * NUSNET ID: E0544321
  * Lab Class: Lab 03
*/
import java.util.Scanner;
import java.util.ArrayList;

class coconut {

    enum Position {
        FOLDED,
        FIST,
        PALM
    }

    public static class Pair<K, V> {
        private final K first;
        private final V second;
    
        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    
        public K first() {
            return this.first;
        }
    
        public V second() {
            return this.second;
        }
    }

    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        final int syllables = sc.nextInt();
        final int playersCount = sc.nextInt();
        ArrayList<Pair<Integer, Position>> players = new ArrayList<Pair<Integer, Position>>();
        for (int i = 1; i <= playersCount; i++) {players.add(new Pair<>(i, Position.FOLDED));}
        int curr = 0;
        while (players.size() != 1) {
            curr = (curr + syllables - 1) % players.size();
            Pair<Integer, Position> player = players.get(curr);
            switch (player.second()) {
                case FOLDED:
                    players.remove(curr);
                    players.add(curr, new Pair<>(player.first(), Position.FIST));
                    players.add(curr, new Pair<>(player.first(), Position.FIST));
                    break;
                case FIST:
                    players.remove(curr);
                    players.add(curr, new Pair<>(player.first(), Position.PALM));
                    curr++;
                    break;
                case PALM:
                    players.remove(curr);
                    break;
            }
        }
        System.out.print(players.get(0).first());
    }
}