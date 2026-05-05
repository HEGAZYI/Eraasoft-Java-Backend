package Service.Impl;

import Model.Transaction;
import Service.TransactionService;

import java.util.ArrayList;
import java.util.List;

public class TransactionImpl implements TransactionService {
    private final List<Transaction> transactions = new ArrayList<>();

    public void add(Transaction t) {
        transactions.add(t);
    }

    public void printUserHistory(String username) {
        System.out.println("===== TRANSACTION HISTORY =====");

        for (Transaction t : transactions) {
            if (t.toString().contains(username)) {
                System.out.println(t);
            }
        }
    }
}
