package atm;

import account.Account;
import account.PayrollAccount;
import card.Card;
import card.CreditCard;
import repository.SystemUserRepository;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class BankATM implements ATMFeatures{

    Account[] accounts;
    Card card;

    private void loadAccount(){
        accounts = new Account[2];
        accounts[0] = new PayrollAccount(1001, "Yith Sopheaktra",80000d,null);
        accounts[1] = new PayrollAccount(1002,"James Gosling",70000d,null);
    }

    private void showUserInfo(){
        System.out.println("*".repeat(30));
        System.out.println("Account Name    : "+card.getAccount().getOwner());
        System.out.println("Account Balance ($): "+card.getAccount().getBalance());
        System.out.println("Account limitExpense ($): "+card.getLimitExpense());
        System.out.println("*".repeat(30));
    }

    @Override
    public void boot(String username, String password) {
        if(SystemUserRepository.getAdminUser().getUsername().equals(username) && SystemUserRepository.getAdminUser().getPassword().equals(password)){
            loadAccount();
            card = new CreditCard();
            card.setAccount(accounts[0]);
            System.out.println("*".repeat(30));
            System.out.println("successfully boot ATM");
            System.out.println("*".repeat(30));
        }else{
            System.out.println("Incorrect Admin User! failed to boot ATM");
        }
    }

    @Override
    public void shutdown(String username, String password) {
        if(SystemUserRepository.getAdminUser().getUsername().equals(username) && SystemUserRepository.getAdminUser().getPassword().equals(password)){
            accounts = null;
            card = null;
        }else{
            System.out.println("Failed to shutdown");
        }
    }

    @Override
    public void plugInCard(Card card) {
        card.setAccount(this.card.getAccount());
        this.card = card;
    }

    @Override
    public void plugOutCard() {
        this.card = null;
    }

    @Override
    public void doWithdraw() {
        Scanner input = new Scanner(System.in);
        if(card == null){
            System.out.println("Invalid Card");
            return;
        }
        System.out.println("Enter your card PIN : ");
        int pin = input.nextInt();
        if(LocalDate.now().isBefore(card.getThruAt()) && card.getPin() == pin){
            showUserInfo();
            System.out.println("Enter amount to withdraw : ");
            double amount = input.nextDouble();
            if(amount <= card.getLimitExpense()){
                card.getAccount().withdraw(amount);
                System.out.println("Successfully withdraw");
                System.out.println("Account balance after withdraw($) : "+card.getAccount().getBalance());
            }else{
                System.out.println("Amount of withdraw exceed limit expense!");
                showUserInfo();
            }

        }else {
            System.out.println("Invalid Credentials!");
        }

    }

    @Override
    public void doDeposit() {
        Scanner input = new Scanner(System.in);
        if(card == null){
            System.out.println("Invalid Card");
            return;
        }
        System.out.println("Enter your card PIN : ");
        int pin = input.nextInt();
        if(LocalDate.now().isBefore(card.getThruAt()) && card.getPin() == pin){
            showUserInfo();
            System.out.println("Enter amount to deposit($) : ");
            double amount = input.nextDouble();
            card.getAccount().deposit(amount);
            System.out.println("Successfully deposit");
            showUserInfo();

        }else {
            System.out.println("Invalid Credentials!");
        }

    }
}
