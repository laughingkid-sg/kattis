import java.util.ArrayList;
import java.util.Arrays;

class whatdoesthefoxsay {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int k = io.getInt();
        for (int i = 0; i < k; i++) {
            String[] testcase = io.getLine().split(" ");
            ArrayList<String> otherSound = new ArrayList<>();
            while (true) {
               if (io.getWord().equals("what"))
                    break;
               io.getWord();
               otherSound.add(io.getWord()); 
            }
            for (int j = 0; j < testcase.length; j++) {
                if (!otherSound.contains(testcase[j])) {
                    io.print(testcase[j]);
                    io.print(" ");
                }
            }
            io.println();
        }
        io.close();
    }
}