import java.util.Scanner;

class autori {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuilder result = new StringBuilder();
        String[] arr = input.split("-");
        
        for (int i = 0; i < arr.length; i++ ) {
            result.append(arr[i].substring(0,1));
        }

        System.out.println(result);
        sc.close();
    }
}