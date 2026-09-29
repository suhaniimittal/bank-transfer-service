package com.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Moves money between two {@link Account}s and keeps a log of every
 * transfer made.
 */
public class TransferService {

    private final List<Transaction> history = new ArrayList<>();

    /**
     * Move {@code amount} from {@code from} to {@code to}.
     *
     * @param from the account to transfer money from
     * @param to the account to transfer money to
     * @param amount the amount to transfer, must be positive
     * @return the transaction record of this transfer
     * @throws IllegalArgumentException if {@code amount} is non-positive
     */
    public Transaction transfer(Account from, Account to, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }
        from.withdraw(amount);
        to.deposit(amount);

        Transaction transaction = new Transaction(from.getAccountId(), to.getAccountId(), amount);
        history.add(transaction);
        return transaction;
    }

    public List<Transaction> getHistory() {
        return history;
    }
}
