package account;

public interface Transaction {
    void deposit(double balance);
    double withdraw(double balance);
}
