import java.util.Scanner;

class peasoup { 

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        // Get total number of stores
        int shopCounter = sc.nextInt();
        sc.nextLine();

        // Loop through all the shops
        for (int i = 0; i < shopCounter; i++) {

            String shopName = "";
            boolean ps = false, pc = false;

            // Get total number of items in  shop
            int shopItems = sc.nextInt();
            sc.nextLine();
            shopName = sc.nextLine();
            
            // Loop through every item in shop
            for (int k = 0; k < shopItems; k++) {
                String item = sc.nextLine();

                if (item.equals("pea soup")) {
                    ps = true;
                } else if (item.equals("pancakes")) {
                    pc = true;
                }
        }

        // If shop has both items, print shopName and exit app
        // Else reset both to false for next shop
        if (ps && pc) {
            System.out.println(shopName);
            return;            
        } else {
            ps = false;
            pc = false;
        }
    }
    
    // If loop is completed and matching pair isn't found
    System.out.println("Anywhere is fine I guess");
    sc.close();
    } 
}