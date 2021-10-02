/**
  * Name: Goh Zheng Teck
  * NUSNET ID: E0544321
  * Lab Class: Lab 03
*/
import java.util.ArrayList;

class coconut {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int syllables = io.getInt();
        int temp = io.getInt();
        ArrayList<Integer[]> players = new ArrayList<Integer[]>();
        for (int i = 1; i <= temp; i++) { 
            players.add(new Integer[] {i, 0});
        }
        temp = 0;
        Integer[] player;
        while (players.size() != 1) {
            temp = (temp + syllables - 1) % players.size();
            player = players.get(temp);
            switch (player[1]) {
                case 0:
                    player[1] = 1;
                    players.set(temp, player);
                    players.add(temp, new Integer[] {player[0],1});
                    break;
                case 1:
                    player[1] = 2;
                    players.set(temp, player);
                    temp++;
                    break;
                case 2:
                    players.remove(temp);
                    break;
            }
        }
        io.print(players.get(0)[0]);
        io.close();
    }
}