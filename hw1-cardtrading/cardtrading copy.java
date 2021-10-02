import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

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

            Collections.sort(cards, (f,s) -> {
                int n = (f.getBuy() + f.getSell()) - (s.getBuy() + s.getSell());
                    if (n == 0) {
                        return f.getBuy() - s.getBuy();
                    } else {
                        return n;
                    }
            });

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
}

