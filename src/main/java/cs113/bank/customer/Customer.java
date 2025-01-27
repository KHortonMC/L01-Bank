package cs113.bank.customer;

public abstract class Customer {
    private static int idCounter = 0;
    int IDNumber;
    String name;
    String address;
    String phone;
    int age;

    protected Customer(String name, String address, String phone, int age) {
        this.IDNumber = ++idCounter;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.age = age;
    }

    public int getIDNumber() { return IDNumber; }
    public String getIDString() { return String.valueOf(IDNumber); }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public int getAge() { return age; }

    public void setIDNumber(int IDNumber) { this.IDNumber = IDNumber; }
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAge(int age) { this.age = age; }

    /**
     * Returns the type of account
     * @return A string identifier for the account
     */
    public abstract String getAccountType();

    /**
     * Returns the amount of interest savings accounts generate
     * @return a percentage from 0-1
     */
    public abstract double getSavingInterest();

    /**
     * Returns the amount of interest checking accounts generate
     * @return a percentage from 0-1
     */
    public abstract double getCheckInterest();

    /**
     * Returns the amount of interest retirement accounts generate
     * @return a percentage from 0-1
     */
    public abstract double getRetirementInterest();

    /**
     * Returns any fee associated with causing an overdraft
     * @return a dollar amount fee for overdraft
     */
    public abstract double checkOverdraftFees();

    /**
     * Returns any fees associated with an early withdrawal
     * @return a percentage from 0-1
     */
    public abstract double checkEarlyWithdrawalFees();

    public String toString() { return "ID: " + getIDString() + " Name: " + name + " Address: " + address + " Phone: " + phone + " Age: " + age; }
}
