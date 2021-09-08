public class pot {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(); int s = 0; int p; int b; int e;
        String str;
        while (n != 0){
            str = io.getLine();
            p = String.valueOf(str).length();
            b = Integer.parseInt(str.substring(0, p-1));
            e = Integer.parseInt(str.substring(p-1, p));
            s += Math.pow(b, e);
            n--;
        }
        io.println(s);
        io.close();
    }
}