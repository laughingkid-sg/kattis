class ladice {
    public static void main(String[] args) {
        
        final Kattio io = new Kattio(System.in, System.out);
        final int items = io.getInt();
        final UnionFindModified uf = new UnionFindModified(io.getInt());

        for (int i = 0; i < items; i++) {
            if (uf.isNotFull(io.getInt() - 1, io.getInt() - 1)) io.println("LADICA");
            else io.println("SMECE");
        }
        io.close();
    }
}