import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private String pass, email, name, address, contact_no;
    private static ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<String> itemHistory = new ArrayList<>();
    private Customer(){}
    static{
        Customer tempCus = new Customer();
        tempCus.name = "Shamima Akter";
        tempCus.address = "Rangpur";
        tempCus.contact_no = "01954284554";
        tempCus.email = "shamima35-725@diu.edu.bd";
        tempCus.pass = "0000";
        customers.add(tempCus);
    }
    public static void newCustomer(){
        Scanner sc = new Scanner(System.in);
        //sc.useDelimiter("\n");
        Customer tempCus = new Customer();
        System.out.print("Welcome Customer\nName: ");
        tempCus.name = sc.next();
        System.out.print("Address: ");
        tempCus.address = sc.next();
        System.out.print("Contact no.: ");
        tempCus.contact_no = sc.next();
        System.out.print("Email: ");
        tempCus.email = sc.next();
        System.out.print("Enter a unique Password for your account: ");
        tempCus.pass = sc.next();
        customers.add(tempCus);
    }
    public static Customer exCustomer(String password){
        for (Customer customer : customers) {
            if (customer.pass.equals(password)) {
                System.out.println("Success!!!");
                return customer;
            }
        }
        System.out.println("Customer ID Not Found!!!");
        return null;
    }
    public void setItemHistory(ArrayList<String> items){
        itemHistory.addAll(items);
    }
    public void displayHistory(){
        System.out.println("Your Product Purchase History.\n Products:");
        for(String item : itemHistory) {
            System.out.println(item);
        }
    }
    public void clearHistory(){
        itemHistory.clear();
        System.out.println("Successfully Clears Product History");
    }
    public void getInfo(){
        System.out.println("Name: "+name);
        System.out.println("Address: "+address);
        System.out.println("Contact No.: "+contact_no);
        System.out.println("Email: "+email);
    }
}