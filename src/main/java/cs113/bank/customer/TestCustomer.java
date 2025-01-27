package cs113.bank.customer;

public class TestCustomer extends Customer {
    public TestCustomer(String name, String address, String phone, int age) {
        super(name, address, phone, age);
    }

    /**
     * Returns the type of account
     * @return A string identifier for the account
     */
    public String getAccountType() {
        // DO NOT USE THIS AS AN EXAMPLE THIS IS MERELY TO TEST GUI
        return "test";
    }

    /**
     * Returns the amount of interest savings accounts generate
     * @return a percentage from 0-1
     */
    public double getSavingInterest() {
        return 0.0;
    }

    /**
     * Returns the amount of interest checking accounts generate
     * @return a percentage from 0-1
     */
    public double getCheckInterest() {
        return 0.0;
    }

    /**
     * Returns the amount of interest retirement accounts generate
     * @return a percentage from 0-1
     */
    public double getRetirementInterest() {
        return 0.0;
    }

    /**
     * Returns any fee associated with causing an overdraft
     * @return a dollar amount fee for overdraft
     */
    public double checkOverdraftFees() {
        return 0.0;
    }

    /**
     * Returns any fees associated with an early withdrawal
     * @return a percentage from 0-1
     */
    public double checkEarlyWithdrawalFees() {
        return 0.0;
    }
}
