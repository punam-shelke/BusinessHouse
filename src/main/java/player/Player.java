package player;

import bank.Bank;

public class Player {
    private final Bank bank;
    private int balance;

    public Player(Bank bank) {
        this.bank = bank;
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

    public void transferToBank(int amount) {
        debit(amount);
        bank.credit(amount);
    }

    public void transferToPlayer(int amount) {
        credit(amount);
        bank.debit(amount);
    }
}
