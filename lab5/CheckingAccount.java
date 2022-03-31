public class CheckingAccount extends AccountWithPenalty{

    private double transactionPenalty;
    private double interestPercent;

    CheckingAccount(String name, double balance, String pin){
        super(name, balance, pin, 100, 10);
        this.transactionPenalty = 0.5;
        this.interestPercent = 2;
    }

    @Override
    public void withdraw(double amount){
        this.setBalance(this.getBalance() - amount);
        this.setBalance(this.getBalance() - getBalancePenalty());
    }

    @Override
    public void deposit(double amount){
        this.setBalance(this.getBalance() + amount);
        this.setBalance(this.getBalance() - getBalancePenalty());
    }

    @Override
    public void monthlyUpdate(){
        this.setBalance(this.getBalance() - this.calculateFees() + this.calculateInterest());
        if(this.getBalance() < getMinBalance()){
            this.setBalance(this.getBalance() - getBalancePenalty());
        }
    }

    @Override
    public double calculateInterest(){
        double interest = this.interestPercent * this.getBalance() / 100;
        return interest;
    }

    @Override
    public String toString(){
        return "type: checking account, owner: " + getName() + ", balance: " + getBalance();
    }

}

