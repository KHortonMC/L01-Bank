package cs113.bank.account;

import cs113.bank.customer.Customer;
import cs113.bank.transactions.Transaction;

public class TestAccount extends Account {
    public TestAccount(Customer accountHolder, double initialBalance) {
        super(accountHolder, initialBalance);
    }

    public Transaction.Result withdraw(double amount) {
        // DO NOT USE THIS AS AN EXAMPLE THIS IS MERELY TO TEST GUI
        Transaction withdrawal = new Transaction(Transaction.Type.Withdrawal, 40.0);
        transactions.add(withdrawal);
        return Transaction.Result.SUCCESS;
    }

    public Transaction.Result addInterest(double marketRate) {
        // DO NOT USE THIS AS AN EXAMPLE THIS IS MERELY TO TEST GUI
        Transaction interest = new Transaction(Transaction.Type.Interest, 1);
        transactions.add(interest);
        return Transaction.Result.SUCCESS;
    }

    public String toString() {
        // DO NOT USE THIS AS AN EXAMPLE THIS IS MERELY TO TEST GUI
        return "test";
    }

}
