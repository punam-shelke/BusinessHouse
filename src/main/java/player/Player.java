package player;

import bank.Bank;

public class Player {
    private final Bank bank;
    private int balance;
    private int position;

    public Player(Bank bank) {
        this.bank = bank;
        balance = 1000;
        position = -1;
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

    public void payRent(Player player, int rent) {
        debit(rent);
        player.credit(rent);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
