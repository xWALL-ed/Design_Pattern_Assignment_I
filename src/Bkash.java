public class Bkash implements OnlineBank{
    private String name;
    private double charge;
    private String desc;
    Bkash(){
        this.name="Bkash";
        this.charge=18.50;
        this.desc="Bkash, Bangladesh First and popular Online Banking Service";
    }
    @Override
    public void setCharge(double crg) {
        this.charge=crg;
    }
    @Override
    public double getCharge() {
        return charge;
    }
    @Override
    public void setname(String name) {
        this.name=name;
    }
    @Override
    public String getname() {
        return name;
    }
    @Override
    public void paymentMethodDescription() {
        System.out.println(desc);
    }
    @Override
    public void setDescription(String str) {
        this.desc=str;
    }
    public double calculate(double taka){
        return taka+((this.charge/1000.0)*taka);
    }
}
