package cs113.bank.account;

import cs113.bank.transactions.Transaction;
import cs113.bank.customer.Customer;

import java.util.ArrayList;

public abstract class Account {
    static int accountCounter = 0;
    int accountNumber;
    Customer accountHolder;
    ArrayList<Transaction> transactions;

    protected Account(Customer accountHolder, double initialBalance) {
        this.accountNumber = ++accountCounter;

        this.accountHolder = accountHolder;
        this.transactions = new ArrayList<>();

        Transaction initialDeposit = new Transaction(Transaction.Type.InitialDeposit, initialBalance);
        this.transactions.add(initialDeposit);

        double newAccountFee = -1.0;
        Transaction newAccountFees = new Transaction(Transaction.Type.NewAccountFee, newAccountFee);
        this.transactions.add(newAccountFees);
    }

    public int getAccountNumber() { return accountNumber; }
    public Customer getAccountHolder() { return accountHolder; }
    public double getBalance() {
        double balance = 0;
        for (Transaction t : transactions) {
            balance += t.getAmount();
        }
        return balance;
    }
    public ArrayList<Transaction> getTransactions() { return transactions; }

    /**
     * Deposits money into the account.
     * @param amount The amount of money to deposit.
     * @return a transaction result
     */
    public Transaction.Result deposit(double amount) {
        Transaction deposit = new Transaction(Transaction.Type.Deposit, amount);
        this.transactions.add(deposit);
        return Transaction.Result.SUCCESS;
    }

    /**
     * Adds accrued interest to the account
     * @return a transaction result
     */
    public abstract Transaction.Result addInterest(double marketRate);

    /**
     * If there is sufficient money, withdraw the money and return true.
     * else return false without affecting account balance.
     * May apply withdrawal fees and overdraft fees.
     * @param amount The amount to withdrawal
     * @return a transaction result
     */
    public abstract Transaction.Result withdraw(double amount);

    /**
     * Returns a string with format:
     * Customer Name: [name] Account Type: [type] Account Balance: [balance]
     * @return an output string
     */
    public abstract String toString();
}
