import java.util.HashMap;
class boatparts {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int pCount = io.getInt();
        final int k = io.getInt();
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        for (int i = 0; i < k; i++) {
            map.put(io.getWord(), true);
            if (map.size() == pCount) {
                io.print(i+1);
                break;
            }
        }
        if (map.size() < pCount) {
            io.print("paradox avoided");
        }
        io.close();
    }
}