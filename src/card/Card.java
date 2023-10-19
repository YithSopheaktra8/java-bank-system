package card;

import account.Account;
import account.PayrollAccount;

import java.time.LocalDate;

public abstract class Card {
    private int pin;
    private LocalDate issueAt;
    private LocalDate thruAt;
    private double limitExpense;
    private Account account;

    public Card(){
        //provide reference
        account = new PayrollAccount();
    }
    public Card(int pin , LocalDate issueAt, LocalDate thruAt, double limitExpense, Account account){
        this.pin = pin;
        this.issueAt = issueAt;
        this.thruAt = thruAt;
        this.limitExpense = limitExpense;
        this.account = account;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public LocalDate getIssueAt() {
        return issueAt;
    }

    public void setIssueAt(LocalDate issueAt) {
        this.issueAt = issueAt;
    }

    public LocalDate getThruAt() {
        return thruAt;
    }

    public void setThruAt(LocalDate thruAt) {
        this.thruAt = thruAt;
    }

    public double getLimitExpense() {
        return limitExpense;
    }

    public void setLimitExpense(double limitExpense) {
        this.limitExpense = limitExpense;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
