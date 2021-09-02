import java.util.Scanner;
import java.util.HashMap;

class t9spelling {

    public static void main(String[] args) {
        
        HashMap<Character, String> key = new HashMap<>();
        key.put('a', "2");
        key.put('b', "22");
        key.put('c', "222");
        key.put('d', "3");
        key.put('e', "33");
        key.put('f', "333");
        key.put('g', "4");
        key.put('h', "44");
        key.put('i', "444");
        key.put('j', "5");
        key.put('k', "55");
        key.put('l', "555");
        key.put('m', "6");
        key.put('n', "66");
        key.put('o', "666");
        key.put('p', "7");
        key.put('q', "77");
        key.put('r', "777");
        key.put('s', "7777");
        key.put('t', "8");
        key.put('u', "88");
        key.put('v', "888");
        key.put('w', "9");
        key.put('x', "99");
        key.put('y', "999");
        key.put('z', "9999");
        key.put(' ', "0");
        
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        sc.nextLine();

        if (cases >= 1 && cases <= 100) {
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= cases; i++) {
                String sentence = sc.nextLine();
                char[] characters = sentence.toCharArray();
                
                result.append("Case #");
                result.append(String.valueOf(i));
                result.append(": ");

                char prev = '#';
                for (int k = 0; k < characters.length; k++) {
                    String curr = key.get(characters[k]);
                    if (curr.charAt(0) == prev)
                        result.append(" ");                 
                    result.append(curr);
                    prev = curr.charAt(curr.length() - 1);
                }
                result.append("\n");
            }
            sc.close();
            System.out.println(result);
        }
    }
}