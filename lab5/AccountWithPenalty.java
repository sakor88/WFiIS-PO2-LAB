public abstract class AccountWithPenalty extends BasicAccount{

    private double minBalance;
    private double balancePenalty;
    private double interestPercent;

    AccountWithPenalty(String name, double balance, String pin, int minBalance, int balancePenalty){
        super(name, balance, pin);
        this.minBalance = minBalance;
        this.balancePenalty = balancePenalty;
        this.interestPercent = 2;
    }

    public double getBalancePenalty(){
        return this.balancePenalty;
    }

    public double getMinBalance(){
        return this.minBalance;
    }

    @Override
    public double calculateFees(){
        return Math.min(this.getBalance() * getMonthlyChargePercent() / 100, 10);
    }



}