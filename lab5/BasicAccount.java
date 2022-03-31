import java.lang.Math;

public abstract class BasicAccount{

    private double monthlyChargeValue;
    private double monthlyChargePercent;
    private double balance;
    private String name;
    private String pinCode;

    BasicAccount(String name, double balance, String pin){
        this.name = name;
        this.balance = balance;
        this.pinCode = pin;
    }

    public double getBalance(){
        return balance;
    }

    public String getName(){
        return name;
    }

    public double getMonthlyChargePercent(){
        return monthlyChargePercent;
    }

    protected void setBalance(double balance){
        this.balance = balance;
    }

    public abstract double calculateFees();
    public abstract double calculateInterest();
    public abstract void monthlyUpdate();

    public void withdraw(double amount){
        balance = balance - amount;
    }

    public void deposit(double amount){
        balance = balance + amount;
    }      

    

}