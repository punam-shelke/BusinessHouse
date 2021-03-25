package bank;

public class Bank {
    private int balance;

    public Bank() {
        balance = 5000;
    }

    public void credit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}
