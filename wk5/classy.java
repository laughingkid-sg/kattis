import java.util.Arrays;

class classy {
    public static void main(String[] args) {
        final Kattio io = new Kattio(System.in, System.out);
        final int q = io.getInt();
        for (int i = 0; i < q; i++) {
            Person[] people = new Person[io.getInt()];
            for (int k = 0; k < people.length; k++) {
                people[k] = new Person(io.getWord() , io.getWord());
                io.getWord();
            }
            Arrays.sort(people);
            for (Person himfromocs : people) 
                io.println(himfromocs);
            io.println("==============================");
        }
        io.close();
    }
}

class Person implements Comparable<Person> {
    String name;
    int[] rank;

    public Person(String name, String str) {
        this.name = name.substring(0 , name.length() - 1);
        this.rank = generateRank(str);
    }

    private int[] generateRank(String str) {
        String[] arr = str.split("-");
        int[] rank = new int[] {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int l = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            rank[l] = rankValue(arr[i]);
            l++;
        }
        return rank;
    }

    private int rankValue(String rank) {
        switch (rank) {
            case "upper":
                return 3;
            case "middle":
                return 2;
            default:
                return 1;
        }
    }

    public int compareTo(Person p) {
        for (int i = 0; i < 10; i++) {
            if (this.rank[i] - (p.rank[i]) == 0)
                continue;
            else
                return p.rank[i] - this.rank[i];
        }
        return this.name.compareTo(p.name);
    }

    public String toString() {
        return this.name;
    }
}