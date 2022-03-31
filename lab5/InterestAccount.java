public class InterestAccount extends BasicAccount{

    private double interestPercent;

    InterestAccount(String name, double balance, String pin){
        super(name, balance, pin);
        interestPercent = 2;
    }

    @Override
    public double calculateInterest(){
        double interest = this.interestPercent * this.getBalance()/ 100;
        return interest;
    }

    @Override
    public void monthlyUpdate(){
        this.setBalance(getBalance() + calculateInterest() - calculateFees());
    }

    @Override
    public double calculateFees(){
        return Math.min(this.getBalance() * getMonthlyChargePercent() / 100, 10);
    }

    @Override
    public String toString(){
        return "type: interest account, owner: " + getName() + ", balance: " + getBalance();
    }

}