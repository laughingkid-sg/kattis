/**
  * Name: Goh Zheng Teck
  * NUSNET ID: E0544321
  * Lab Class: Lab 03
*/

import java.util.Arrays;
import java.util.Comparator;

class cardtrading {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int a = io.getInt();int b = io.getInt();int c = io.getInt(); 
        int[] d = new int[b + 1];
        for (int i = 0; i < a; i++) {d[io.getInt()]++;}
        int[][] e = new int[b + 1][2];
        for (int i = 1; i <= b; i++) {e[i][0] = io.getInt() * Math.max(2 - d[i], 0);e[i][1] = io.getInt() * d[i];}
        Arrays.sort(e, (f,s) -> {
            int n = (f[0] + f[1]) - (s[0] + s[1]);
                if (n == 0) 
                    return f[0] - s[0];
                return n;
        });
        long m = 0;
        for (int i = 1; i <= c; i++) {m -= e[i][0];}
        for (int i = c + 1; i < e.length; i++) {m += e[i][1];}
        io.print(m);
        io.close();
    }
}