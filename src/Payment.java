import java.util.ArrayList;
import java.util.Scanner;

public class Payment {
    public OnlineBank factoryMethod(String str){
        OnlineBank bank1 = new Bkash();
        OnlineBank bank2 = new Nagad();
        OnlineBank bank3 = new Rocket();
        if (str.equalsIgnoreCase(bank1.getname())){
            return bank1;
        }
        else if (str.equalsIgnoreCase(bank2.getname())){
            return bank2;
        }
        else if (str.equalsIgnoreCase(bank3.getname())){
            return bank3;
        }
        return null;
    }
    public String showAllPaymentMethods(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Payment Methods:");
        OnlineBank bank1 = new Bkash();
        System.out.println("->"+bank1.getname());
        OnlineBank bank2 = new Nagad();
        System.out.println("->"+bank2.getname());
        OnlineBank bank3 = new Rocket();
        System.out.println("->"+bank3.getname());
        String temp="0";
        while(temp.equalsIgnoreCase(bank1.getname())==false && temp.equalsIgnoreCase(bank2.getname())==false && temp.equalsIgnoreCase(bank3.getname())==false){
            System.out.print("Choose [Write Name]: ");
            temp = sc.next();
        }
        System.out.println("-".repeat(100));
        return temp;
    }
    public double billReciept(ArrayList<String> products, ArrayList<Double> price, ArrayList<Integer> quantity){
        System.out.println("Your BILL RECIEPT:\n");
        System.out.println("-".repeat(100));
        System.out.println(" "+String.format("  %1$-25s  %2$-25s        %3$-25s", "PRODUCTS", "QUANTITIES", "PRICE"));
        System.out.println("-".repeat(100));
        double ttlPrice=0;
        for(int i=0;i<products.size();i++){
            System.out.println((i+1)+". "+String.format("%1$-30sx %2$-28s%3$-30s", products.get(i), quantity.get(i), price.get(i)));
            ttlPrice=ttlPrice+(quantity.get(i)*price.get(i));
        }
        System.out.println("-".repeat(100));
        System.out.println(" "+String.format("     %1$-55s  %2$-30s", "TOTAL PRICE",ttlPrice ));
        return ttlPrice;
    }
}
