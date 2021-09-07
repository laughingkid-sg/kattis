import java.util.Arrays;
import java.util.*;
import java.util.ArrayList;

class cardtrading {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        while (io.hasMoreTokens()) {
            int cardCount = io.getInt();
            int typeCount = io.getInt();
            int maxComboCount = io.getInt();

            long money = 0;

            int[] cardArray = new int[typeCount + 1];

            for (int i = 0; i < cardCount; i++) {
                cardArray[io.getInt()]++;
            }

            ArrayList<Card> cards = new ArrayList<Card>();
            for (int i = 1; i <= typeCount; i++) {
                cards.add(new Card(io.getInt() * Math.max(2 - cardArray[i], 0), io.getInt() * cardArray[i]));
            }

            Collections.sort(cards, new SortByBuySellSum());

            Card temp;
            for (int i = 0; i < maxComboCount; i++) {
                temp = cards.get(i);
                money = money - temp.getBuy();

            }

            for (int i = maxComboCount; i < cards.size(); i++) {
                temp = cards.get(i);
                money = money + temp.getSell();
                
            }
            io.println(money);
            
        }

        io.close();
    }
}

class Card {

    protected int buy; 
    protected int sell;

    public Card(int buy, int sell) {
        this.buy = buy;
        this.sell = sell;
    }

    public int getBuy() {
        return this.buy;
    }

    public int getSell() {
        return this.sell;
    }


    public String toString() {
        return String.valueOf(this.buy) + ", " + String.valueOf(this.sell);
    }
}

class SortByBuySellSum implements Comparator<Card> {
    
    public int compare(Card f, Card s) {
        int a = f.getBuy() + f.getSell();
        int b = s.getBuy() + s.getSell();

        if ((a - b) > 0) {
            return 1;
        } else if ((a-b) < 0) {
            return -1;
        } else if (f.getBuy() > s.getBuy()) {
            return -1;
        } else {
            return 1;
        }
    }
}
