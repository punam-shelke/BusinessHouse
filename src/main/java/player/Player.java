package player;

public class Player {
    private int balance;

    public Player() {
        balance = 1000;
    }

    public void credit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public void debit(int amount) {
        balance -= amount;
    }
}
