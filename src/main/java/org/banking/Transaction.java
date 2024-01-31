package org.banking;

import java.util.Date;

public class Transaction {
    private final Date date;
    private final int amount;

    private final int historicalBalance; // stores the account balance right after the transaction

    public Transaction(Date date, int amount , int historicalBalance) {
        this.date = date;
        this.amount = amount;
        this.historicalBalance = historicalBalance;

    }

    public int getHistoricalBalance() {
        return historicalBalance;
    }

    public Date getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }
}
