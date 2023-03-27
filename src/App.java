import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("-".repeat(100));
        System.out.println("Welcome to the E-Commerse Site!!");
        while(true){
            System.out.println("-".repeat(100));
            System.out.println("MENU");
            System.out.println("-".repeat(100));
            System.out.print("1.Register New Customer\n2.LogIn Customer\n3.Do Shopping\n4.Add Store to the Site\n5.Customize my Store\n6.Admin Access to Stores\n0.Exit Site\nChoose: ");
            int chooses = sc.nextInt();
            if(chooses==0) break;
            switch (chooses) {
                case 1:
                    System.out.println("-".repeat(100));
                    System.out.println("MENU//");
                    System.out.println("      NEW CUSTOMER");
                    System.out.println("-".repeat(100));
                    System.out.println("Welcome to out Family\nPlease Fill these up.");
                    Customer.newCustomer();
                    break;
                case 2:
                    System.out.println("-".repeat(100));
                    System.out.println("MENU//");
                    System.out.println("      CUSTOMER");
                    System.out.println("-".repeat(100));
                    System.out.print("HELLO our treasure. Please Enter the Password to verify and Customize you account\nPassword: ");
                    String pass1 = sc.next();
                    Customer customer1 = Customer.exCustomer(pass1);
                    while(true){
                        System.out.println("1.View Profile\n2.View History\n3.Clear History\n0.Exit\nChoose: ");
                        int cho = sc.nextInt();
                        System.out.println("-".repeat(100));
                        if(cho==1) customer1.getInfo();
                        else if(cho==2) customer1.displayHistory();
                        else if(cho==3) customer1.clearHistory();
                        else break;
                        System.out.println("-".repeat(100));
                    }
                    break;
                case 3:
                    System.out.println("-".repeat(100));
                    System.out.println("MENU//");
                    System.out.println("      VERIFY CUSTOMER");
                    System.out.println("-".repeat(100));
                    System.out.print("HELLO our treasure. Please Enter the Password to verify and Enter the MARKET\nPassword: ");
                    String pass = sc.next();
                    Customer customer = Customer.exCustomer(pass);
                    MarketPlace market = new MarketPlace(customer);
                    market.greet();
                    break;
                case 4:
                    System.out.println("-".repeat(100));
                    System.out.println("MENU//");
                    System.out.println("      ADD STORE");
                    System.out.println("-".repeat(100));
                    Seller.newSeller();
                    Seller.showSellerNames();
                    break;
                case 5:
                    System.out.println("-".repeat(100));
                    System.out.println("MENU//");
                    System.out.println("      CUSTOMIZE STORE");
                    System.out.println("-".repeat(100));
                    Seller.Access_Class.seller();
                    break;
                case 6:
                    System.out.println("-".repeat(100));
                    System.out.println("MENU//");
                    System.out.println("      ADMIN ACCESS to stores");
                    System.out.println("-".repeat(100));
                    Seller.Access_Class.admin();
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}