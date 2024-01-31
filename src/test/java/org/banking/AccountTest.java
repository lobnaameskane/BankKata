package org.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void depositIncreasesBalance() {
        Account account = new Account();
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
    }

    @Test
    void withdrawDecreasesBalance() {
        Account account = new Account();
        account.deposit(1000);
        account.withdraw(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    void depositRecordsTransaction() {
        Account account = new Account();
        account.deposit(1000);
        Transaction transaction = account.getTransactions().get(0);
        assertEquals(1000, transaction.getAmount());
        assertNotNull(transaction.getDate());
    }

    @Test
    void withdrawRecordsTransaction() {
        Account account = new Account();
        account.deposit(1000);
        account.withdraw(500);
        assertEquals(2, account.getTransactions().size());
        Transaction lastTransaction = account.getTransactions().get(1);
        assertEquals(-500, lastTransaction.getAmount());
        assertNotNull(lastTransaction.getDate());
    }

    @Test
    void depositNegativeOrZeroAmountThrowsException() {
        Account account = new Account();
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
    }

    @Test
    void withdrawNegativeOrZeroAmountThrowsException() {
        Account account = new Account();
        account.deposit(500);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
    }

}