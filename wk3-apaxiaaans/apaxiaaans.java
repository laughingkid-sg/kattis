class apaxiaaans{ 
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        char[] arr = new String(io.getWord()).toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i+1]) {
                io.print(arr[i]);
            }
        }
        io.print(arr[arr.length-1]);
        io.close();
    }
}