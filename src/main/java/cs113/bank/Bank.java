package cs113.bank;

import cs113.bank.account.Account;
import cs113.bank.account.TestAccount;
import cs113.bank.controllers.BankController;
import cs113.bank.customer.Customer;
import cs113.bank.customer.TestCustomer;
import cs113.bank.transactions.Transaction;

import java.util.ArrayList;

public class Bank {
    ArrayList<Account> accounts;
    ArrayList<Customer> customers;
    BankController GUIController;

    public enum AccountType {
        CHECKING,
        SAVINGS,
        RETIREMENT
    };

    public enum CustomerType {
        STUDENT,
        ADULT,
        SENIOR
    };

    public Bank() {
        accounts = new ArrayList<>();
        customers = new ArrayList<>();
        testAccount();
    }

    private void testAccount() {
        Customer c = new TestCustomer("Not A. Person", "123 Nowhere Drive", "555-555-5555", 30);
        customers.add(c);

        Account a = new TestAccount(c, 1.0);
        accounts.add(a);

        a.deposit(50.0);
        a.addInterest(0.01);
        a.withdraw(60.0);
    }

    public BankController getGUIController() { return GUIController; }
    public void setGUIController(BankController GUIController) { this.GUIController = GUIController; }

    /**
     * Returns an account if it exists
     * @param accountNumber
     * @return returns an account if it exists, otherwise returns null
     */
    public Account getAccount(int accountNumber) {
        for (Account a : accounts) {
            if (a.getAccountNumber() == accountNumber) {
                return a;
            }
        }
        return null;
    }

    /**
     * Returns all accounts in the bank
     * @return
     */
    public ArrayList<Account> getAccounts() { return accounts; }

    /**
     * Returns all customers in the bank
     * @return
     */
    public ArrayList<Customer> getCustomers() { return customers; }

    public Transaction.Result makeDeposit(Account account, double amount) {
        return account.deposit(amount);
    }

    public Transaction.Result makeWithdrawal(Account account, double amount) {
        return account.withdraw(amount);
    }
}
