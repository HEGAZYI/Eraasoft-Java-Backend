package Service;

import Model.Transaction;

import java.util.ArrayList;
import java.util.List;

public interface TransactionService {

    final List<Transaction> transactions = new ArrayList<>();

    void add(Transaction t);

    void printUserHistory(String username);
}
