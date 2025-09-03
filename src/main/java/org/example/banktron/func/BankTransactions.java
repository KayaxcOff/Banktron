package org.example.banktron.func;

public class BankTransactions {

    private final User user;
    private User recipient;
    private int balance;

    public BankTransactions(User user) {
        this.user = user;
        this.balance = user.getBalance();
    }

    public boolean deposit(int amount) {
        if(amount > 0) {
            balance += amount;
            user.setBalance(balance);
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(int amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            user.setBalance(balance);
            return true;
        } else {
            return false;
        }
    }

    public boolean transfer(int amount) {
        if(recipient == null) {
            return false;
        }

        if(amount > 0 && amount <= balance) {
            balance -= amount;
            user.setBalance(balance);
            recipient.setBalance(recipient.getBalance() + amount);
            return true;
        } else {
            return false;
        }
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}