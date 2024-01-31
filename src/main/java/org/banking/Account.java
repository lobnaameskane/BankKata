package org.banking;

import java.text.SimpleDateFormat;
import java.util.*;

public class Account implements AccountService {
    private int balance = 0;
    private final List<Transaction> transactions = new ArrayList<>();

    /**
     * Deposits a specified amount into the account.
     * @param amount the amount to be deposited into the account.
     * @throws IllegalArgumentException if the amount is less than or equal to zero, as it is not possible
     */
    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("You can only deposit amount greater than zero.");
        }

        balance += amount;
        transactions.add(new Transaction(new Date(), amount , balance));
    }

    /**
     * Withdraws a specified amount from the account.
     * @param amount the amount to be withdrawn from the account.
     * @throws IllegalArgumentException if the amount is less than or equal to zero, as it is not possible
     * @throws IllegalArgumentException if attempting to withdraw more than the current account balance,
     */
    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("You can only withdraw amount greater than zero.");
        }
        if (balance < amount) {
            throw new IllegalArgumentException("You don't have sufficient funds");
        }
        balance -= amount;
        transactions.add(new Transaction(new Date(), -amount , balance));
    }

    /**
     * Prints the statement of account transactions.
     * Transactions are listed from the most recent to the oldest
     */
    @Override
    public void printStatement() {

        List<Transaction> Transactions = new ArrayList<>(this.transactions);
        Collections.reverse(Transactions);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Date       || Amount  || Balance");
        for (Transaction transaction : Transactions) {
            String dateStr = dateFormat.format(transaction.getDate());
            System.out.println(dateStr + " || " + transaction.getAmount() + " || " + transaction.getHistoricalBalance());
        }
    }

    public int getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
