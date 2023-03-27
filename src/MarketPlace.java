import java.util.ArrayList;
import java.util.Scanner;

public class MarketPlace {
    private ArrayList<String> cartProduct = new ArrayList<>();
    private ArrayList<Double> cartPrice = new ArrayList<>();
    private ArrayList<Integer> cartQuantity = new ArrayList<>();

    public ArrayList<String> getCartProduct(){
        return cartProduct;
    }
    public ArrayList<Double> getCartPrice(){
        return cartPrice;
    }
    public ArrayList<Integer> getCartQuantity(){
        return cartQuantity;
    }
    public MarketPlace(Customer customer){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("-".repeat(100));
            System.out.println("MARKET MENU");
            System.out.println("-".repeat(100));
            System.out.print("\n>Add to Cart:\n    Product View:\n    1.View by Store\n    2.View all\n>3.View & Edit Cart\n>4.Delete Cart\n>5.Go To Payment\n>0.Exit\nChoose:");
            int choose = sc.nextInt();
            if(choose==0) break;
            switch(choose){
                case 1:
                    while(true){
                        System.out.println("-".repeat(100));
                        System.out.println("MARKET MENU//");
                        System.out.println("             STORES ['0' to <--MARKET MENU]");
                        System.out.println("-".repeat(100));
                        Seller.showSellerNames();
                        System.out.println("Choose a Store['0' to exit]:");
                        int temp = sc.nextInt();
                        if (temp==0) break;
                        Seller obj = Seller.getSellers(temp-1);
                        System.out.println("-".repeat(100));
                        System.out.println("MARKET MENU//STORES//");
                        System.out.println("                     PRODUCTS ['0' to <--STORES]");
                        System.out.println("-".repeat(100));
                        obj.showProducts();
                        while(true){
                            System.out.print("Product No.['0' to exit]: ");
                            temp = sc.nextInt();
                            if (temp==0) break;
                            System.out.print("Quantity: ");
                            int qnt = sc.nextInt();
                            cartQuantity.add(qnt);
                            cartProduct.add(obj.getProduct(temp-1));
                            cartPrice.add(obj.getProductPrice(temp-1));
                        }
                    }
                    break;
                case 2:
                    System.out.println("-".repeat(100));
                    System.out.println("MARKET MENU//");
                    System.out.println("             PRODUCTS ['0' to <--MARKET MENU]");
                    System.out.println("-".repeat(100));
                    Seller.showAllProducts();
                    while(true){
                        System.out.print("[Format #.# || '0' to exit]\nProduct No.: ");
                        String[] temp = sc.next().split("\\.+");
                        if(temp[0].equals("0")) break;
                        System.out.print("Quantity: ");
                        int qnt = sc.nextInt();
                        cartQuantity.add(qnt);
                        Seller obj = Seller.getSellers(Integer.parseInt(temp[0])-1);
                        cartProduct.add(obj.getProduct(Integer.parseInt(temp[1])-1));
                        cartPrice.add(obj.getProductPrice(Integer.parseInt(temp[1])-1));
                    }
                    break;
                case 3:
                    System.out.println("-".repeat(100));
                    System.out.println("MARKET MENU//");
                    System.out.println("             CART ['0' to <--MARKET MENU]");
                    System.out.println("-".repeat(100));
                    while(true){
                        showCart();
                        System.out.println("Select product no. to remove['0' to exit]:");
                        int temp=sc.nextInt();
                        if(temp==0) break;
                        cartProduct.remove(temp-1);
                        cartQuantity.remove(temp-1);
                        cartPrice.remove(temp-1);
                    }
                    break;
                case 4:
                    System.out.println("-".repeat(100));
                    System.out.println("MARKET MENU//");
                    System.out.println("             REMOVE CART ['0' to <--MARKET MENU]");
                    System.out.println("-".repeat(100));
                    showCart();
                    System.out.println("Are you Sure to remove the whole Cart?[YES/NO]");
                    String confirm=sc.next();
                    if (confirm.equalsIgnoreCase("yes")) {
                        cartPrice.clear();
                        cartProduct.clear();
                        cartQuantity.clear();
                    }
                    break;
                case 5:
                    System.out.println("-".repeat(100));
                    System.out.println("MARKET MENU//");
                    System.out.println("             PAYMENT ['0' to <--MARKET MENU]");
                    System.out.println("-".repeat(100));
                    Payment pay = new Payment();
                    double totalBill = pay.billReciept(cartProduct, cartPrice, cartQuantity);
                    while(true){
                        String method = pay.showAllPaymentMethods();
                        OnlineBank bank = pay.factoryMethod(method);
                        double dueTk = bank.calculate(totalBill);
                        System.out.println("Your have to pay: "+dueTk+". The charge is: "+bank.getCharge()+" per Thousand.");
                        System.out.println("Your total charge for using "+bank.getname()+" is "+(dueTk-totalBill));
                        System.out.println("-".repeat(100));
                        System.out.println("Do You want to Procced['yes' to continue/'no' to try again / '0' to exit payment]:");
                        String ch = sc.next();
                        if(ch.equalsIgnoreCase("yes")){
                                System.out.println("Congrates Its All Yours!!!");
                                customer.setItemHistory(cartProduct);
                                cartPrice.clear();
                                cartProduct.clear();
                                cartQuantity.clear();
                                break;
                        }
                        else if(ch.equals("0"))
                            {break;}
                    }
                    break;
                default:
                    System.out.println(" -_- ata barabari silo, ami ki onno kiso input dite bolsi? bhag ber hoe e ja!!!");
                    break;
            }
        }
    }
    private void showCart(){
        System.out.println("Your Cart Products:");
        for(int i=0;i<cartProduct.size();i++){
            System.out.println((i+1)+". "+String.format("%1$-30sx %2$-30s%3$-30s", cartProduct.get(i), cartQuantity.get(i), cartPrice.get(i)));
        }
    }
    public void greet(){
        System.out.println("Bye!! Visit Again");
        System.out.println("-".repeat(100));
    }
}