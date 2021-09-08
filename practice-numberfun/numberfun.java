class numberfun {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();int a = 0;int b = 0;int c = 0;
        while (n != 0) {
            a = io.getInt(); b = io.getInt(); c = io.getInt();
            if(a+b==c) io.println("Possible");
            else if(Math.abs(a-b)==c) io.println("Possible");
            else if(a*b==c) io.println("Possible");
            else if((a/b==c&&a%b==0)||(b/a==c&&b%a==0)) io.println("Possible");
            else io.println("Impossible");
            n--;
        }
        io.close();
    }
}