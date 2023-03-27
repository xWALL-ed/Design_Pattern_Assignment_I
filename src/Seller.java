import java.util.ArrayList;
import java.util.Scanner;

public class Seller {
    private static String accessPass = "553300";
    private static ArrayList<Seller> sellers = new ArrayList<>();
    private ArrayList<String> producName = new ArrayList<>();
    private ArrayList<Double> producPrice = new ArrayList<>();
    private String sellerPass, name, shop_address, contact_no;
    private Seller(){}
    static{
        Seller tempObj = new Seller();
        tempObj.name = "ABC Stationary";
        tempObj.sellerPass = "0000";
        tempObj.shop_address = "Ashulia, Savar";
        tempObj.contact_no = "015********";
        tempObj.producName.add("Pen");
        tempObj.producPrice.add(5.0);
        tempObj.producName.add("Pencil");
        tempObj.producPrice.add(2.0);
        tempObj.producName.add("A4 Paper");
        tempObj.producPrice.add(1.0);
        Seller.sellers.add(tempObj);
        Seller tempObj1 = new Seller();
        tempObj1.name = "ABC General Store";
        tempObj1.sellerPass = "1111";
        tempObj1.shop_address = "Ashulia, Savar";
        tempObj1.contact_no = "0195*****29";
        tempObj1.producName.add("Bread");
        tempObj1.producPrice.add(35.0);
        tempObj1.producName.add("All-Time Bun");
        tempObj1.producPrice.add(10.0);
        tempObj1.producName.add("Pran Peas Fry");
        tempObj1.producPrice.add(5.0);
        Seller.sellers.add(tempObj1);
    }
    public static Seller getSellers(int i){
        return sellers.get(i);
    }
    public String getProduct(int i){
        return this.producName.get(i);
    }
    public double getProductPrice(int i){
        return this.producPrice.get(i);
    }
    public static void newSeller(){
        Scanner sc = new Scanner(System.in);
        //sc.useDelimiter("\n");
        Seller tempObj = new Seller();
        System.out.print("Your Shop Name: ");
        tempObj.name = sc.next();
        System.out.print("Password to access: ");
        tempObj.sellerPass = sc.next();
        System.out.print("Your shop address: ");
        tempObj.shop_address = sc.next();
        System.out.print("Your Contact No.: ");
        tempObj.contact_no = sc.next();
        sellers.add(addProduct(tempObj));
    }
    public static void showSellerNames(){
        for(int i=0;i<sellers.size();i++) {
            System.out.println((i+1)+": "+String.format("%1$-30s%2$-30s",sellers.get(i).name,sellers.get(i).contact_no));
        }
    }
    public void showProducts(){
        System.out.println("SL  "+String.format("%1$-30s%2$-30s","Products","Price"));
        for (int i = 0; i < producName.size(); i++) {
            System.out.println((i+1)+"."+"| "+String.format("%1$-30s%2$-30s",producName.get(i),"TK "+producPrice.get(i)));
        }
    }
    public static void showAllProducts(){
        System.out.println(" SL  "+String.format("%1$-30s%2$-30s%3$-30s","Products","Price","Store"));
        for(int i = 0; i < sellers.size(); i++){
            for(int j = 0; j < sellers.get(i).producName.size(); j++) {
                System.out.println(((i+1)+"."+(j+1))+"| "+String.format("%1$-30s%2$-30s%3$-30s",sellers.get(i).producName.get(j),"TK "+sellers.get(i).producPrice.get(j),sellers.get(i).name));
            }
        }
    }
    private static Seller addProduct(Seller obj){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Products with Prices [type EXIT to Finish]: ");
        while(true){
            System.out.print("Name: ");
            String temp = sc.next();
            if(temp.equalsIgnoreCase("EXIT")) break;
            obj.producName.add(temp);
            System.out.print("Price: ");
            obj.producPrice.add(sc.nextDouble());
        }
        return obj;
    }
    private static void customize(Seller obj){
        Scanner sc = new Scanner(System.in);
        int choose;
        while(true){
            System.out.println("What do you want to edit?:\n1.Name\n2.Shop Address\n3.Contact No.\n4.Add Product\n5.Delete Product\n0.Exit");
            choose = sc.nextInt();
            if(choose==0) break;
            switch(choose) {
                case 1:
                    System.out.print("Name:");
                    obj.name = sc.next();
                    break;
                case 2:
                    System.out.print("Shop Address:");
                    obj.shop_address = sc.next();
                    break;
                case 3:
                    System.out.print("Contact No.:");
                    obj.contact_no = sc.next();
                    break;
                case 4:
                    addProduct(obj);
                    break;
                case 5:
                    int select=-1;
                    while(true){
                        obj.showProducts();
                        System.out.print("Select Product number to remove[Press '0' to end]: ");
                        select=sc.nextInt();
                        if(select==0) break;
                        obj.producName.remove(select-1);
                        obj.producPrice.remove(select-1);
                    }
                    break;
                default:
                    break;
            }
        }
    }
    public static class Access_Class{
        public static void seller(){
            Scanner sc = new Scanner(System.in);
            showSellerNames();
            System.out.print("Input the SellerPass: ");
            String verify = sc.next();
            for(int i=0;i<sellers.size();i++){
                if(sellers.get(i).sellerPass.equals(verify)){
                    customize(sellers.get(i));
                }
            }
        }
        public static String admin(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Admin Pass Please: ");
            String str = sc.next();
            if(accessPass.compareTo(str)!=0) return "Admin Pass Invalid";
            System.out.println("Select a Seller: ");
            showSellerNames();
            int select = sc.nextInt();
            customize(sellers.get(select-1));
            return null;
        }
    }
}