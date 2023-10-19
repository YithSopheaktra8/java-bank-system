package account;

import card.Card;

public class PayrollAccount extends Account{

    public PayrollAccount(){

    }

    public PayrollAccount(int id, String owner, double balance, Card card){
        super(id, owner, balance, card);
    }

    @Override
    public void deposit(double balance) {
        double taxAmount = balance * 0.2; // tax = 20%
        System.out.println("Tax (20%) : "+taxAmount);
        double finalBalance = balance - taxAmount;
        this.setBalance(this.getBalance() + finalBalance);
    }

    @Override
    public double withdraw(double balance) {
        if(this.getBalance() >= balance ){
            this.setBalance(this.getBalance() - balance);
        } else {
            System.out.println("Insufficient Balance");
        }
        return this.getBalance();
    }
}
