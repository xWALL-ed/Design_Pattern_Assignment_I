public class Rocket implements OnlineBank{
    private String name;
    private double charge;
    private String desc;
    Rocket(){
        this.name="Rocket";
        this.charge=5.50;
        this.desc="Rocket, Bangladesh first afordable online banking Service for the Common People.";
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
