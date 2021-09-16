/**
  * Name: Goh Zheng Teck
  * NUSNET ID: E0544321
  * Lab Class: Lab 03
*/

import java.util.Arrays;
import java.util.ArrayList;

class joinstrings {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        // Get size of N
        int wordsCount = io.getInt();

        // Store words in Array
        String[] words = new String[wordsCount];
        for (int i = 0; i < wordsCount; i++) {
            words[i] = io.getWord();
        }

        // Nested 2D Array of ArrayList
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] printQ = new ArrayList[wordsCount];
        for (int i = 0; i < wordsCount; i++) {
            printQ[i] = new ArrayList<Integer>();
        }

        // Storing pos of String a and String b & last String
        int a; int b; int last = 0;
        
        /**
         * For ea instance of String A, add String B pos to ArrayList of String A
         * 
         * Example
         * e.g. [cute, cat kattis, is]
         * 3,2 -> [[],[],[2],[]]
         * 4,1 -> [[],[],[2],[1]]
         * 3,4 -> [[],[],[2,4],[1]]
         */
        
        for (int i = 0; i < wordsCount-1; i++) {
            a = io.getInt() - 1;
            b = io.getInt() - 1;
            printQ[a].add(b);
            last = a;
        }

        // Print last String which will appear first in order
        io.print(words[last]);

        // Print remaining nested String recursively
        printer(io, printQ, words, last);
        io.close();
    }

    private static void printer(Kattio io, ArrayList<Integer>[] printQ, String[] words, int last) {
        /**
         * * for ea item in [2,4]
         * 1. Print the String
         * 2. Print nested String recursively if any
         * 
         * Example (cont.)
         * Print word at pos 2
         * -> ArrayList of pos 2 is empty
         * -> Print word at pos 4
         * -> ArrayList of pos 4 includes [1]
         * -> Print word at pos 1
         */
        for (int i = 0; i < printQ[last].size(); i++) {
            int curr = printQ[last].get(i);
            io.print(words[curr]);
            printer(io, printQ, words, curr);
        }
    }
}