/**
  * Name: Goh Zheng Teck
  * NUSNET ID: E0544321
  * Lab Class: Lab 03
*/

import java.util.Arrays;
import java.util.ArrayList;

class joinstrings {

    static int last;
    static String[] words;
    static ArrayList<Integer>[] printQ;
    final static Kattio io = new Kattio(System.in, System.out);

    public static void main(String[] args) {
        final int wordsCount = io.getInt();
        words = new String[wordsCount];
        for (int i = 0; i < wordsCount; i++) {words[i] = io.getWord();}
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] temp = new ArrayList[wordsCount];
        printQ = temp;
        for (int i = 0; i < wordsCount-1; i++) {
            last = io.getInt() - 1;
            if (printQ[last] == null)
                printQ[last] = new ArrayList<Integer>();
            printQ[last].add(io.getInt() - 1);
        }
        io.print(words[last]);
        if (printQ[last] != null) {
            printer(last);
        }
        io.close();
    }
    private static void printer(int last) {
        int curr;
        for (int i = 0; i < printQ[last].size(); i++) {
                curr = printQ[last].get(i);
                io.print(words[curr]);
                if (printQ[curr] != null) 
                    printer(curr);
        }
    }
}