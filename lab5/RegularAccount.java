public class RegularAccount extends AccountWithPenalty{

    RegularAccount(String name, double balance, String pin){
        super(name, balance, pin, 500, 10);
    }

    @Override
    public void monthlyUpdate(){
        this.setBalance(getBalance() - calculateFees());
    }


    @Override
    public double calculateInterest(){
        System.out.println("To konto nie posiada odsetek!");
        return 0.0;
    } 

    @Override
    public String toString(){
        return "type: regular account, owner: " + getName() + ", balance: " + getBalance();
    }

}