You've been tasked with brining a new bank online!

This is a GROUP LAB designed to practice using JavaFX GUI, Scenebuilder, and OOP programming techniques.

Why a group lab? We might as well practice working together right away!

This lab is designed to primarily encourage parallel work, where each member of the team takes on a portion of the overall project. This will require you to depend on each other to complete the lab successfully!

While each of you has an area of responsibility, it's completely okay to ask each other for help!

Part 1: Decide on your bank's identity.

As a group, spend a couple of minutes deciding on a bank name and logo. 
Get as creative as you want and update bank.fxml with your new bank name and logo.

Part 2: Extend the abstract class Customer. Individual work.

Each member of the group must create a child class for the Customer class.

Customer will be extended with: Student, Adult, Senior.
See UML Diagram - Bank for more details. 

NOTE: getCheckCharge is removed.

NOTE: getRetirementInterest is added, and should have values of student:0.07, adult:0.05, senior:0.05

NOTE: checkEarlyWithdrawalFees is added, and should have values of student:0.02, adult:0.05, senior:0.0

You can test the creation of your customer by adding it to the appropriate todo in TabNewCustomerController and then selecting the + Customer tab in the bank interface.

Part 3: Implement the + Account tab. Group work.

You won't all finish part 2 at the same time, and that's okay! If you've finished early, you should look at the method fillAccountList() in TabBalanceController. It takes the existing accounts and uses them to populate a ChoiceBox.

For the + Account tab, you'll want to link all new accounts to existing customers. For that, you'll want to use fillAccountList as a template, and implement a different version in TabNewAccountController that uses Customers instead of Accounts.

As a group, decide how you want to determine what kind of account is going to be created. There are multiple UI methods to implement a selection. A few common ones are: RadioButton and ChoiceBox.

If you need help on how to implement the UI elements, refer to TabNewCustomerController and tab-customer.fxml for reference.

Part 5: Extend the abstract class Account. Individual work.

Each member of the group must create a child class for the Account class.

NOTE: assign retirement account to the team member who wants the biggest challenge!

Account will be extended with: Checking, Savings, Retirement.

This is where we'll start to see the polymorphism come together!

Each account as three abstract methods: withdraw(double amount), addInterest(), toString()

However, each of these classes has different implementation logic!

Let's start with addInterest() since the logic is a little more straight forward. For each account type, first find the appropriate interest type from the accountHolder (Customer). Add the market rate to the customer specific interest.

Since our balance is procedurally calculated, you'll have to use getBalance() to get the current balance. Then you can apply interest to that balance, and submit a new transaction with the interest earned.

Our second method, withdrawal, however, is a little tricker!

Here's are our rules for the withdrawal method:
1) if the customer is a student, it cannot withdraw funds that will result in an overdraft
2) if the account is a savings account, it cannot withdraw funds that will result in an overdraft
3) if the account is a retirement account, check to see if early withdrawal fees need to be applied, add those to the total to withdraw and only allow a withdrawal if the total will not cause an overdraft. Retirement fees are a percentage of the total withdrawal. 
4) withdrawal the money (and any early withdrawal fees)
5) if the account is a checking account and is overdraft, apply overdraft fees
6) Note: the withdrawal and fees should be applied as two separate transactions

If you're unsure how to apply a transaction, see the deposit method in Account for an example.

You can manually create an account and perform transactions in Bank.testAccount() the results will be visible in the balance tab of the bank interface. (Just replace TestAccount and TestCustomer with yours!)

NOTE: Don't check Bank.java in to github or you'll have merge conflicts with your teammates who are also testing this way!

Part 6: Implement deposit, withdrawal, and add interest tabs. Individual work.

Resuming our work in SceneBuilder, each team member must implement one of the three tabs: deposit, withdrawal, or addInterest.

Each of the tabs should have an Account selection box, a TextField for input, and a button to do the operation.

For the tab implement an onSelectAction method that will then launch the appropriate method for the tab with the input data from your TextField. 

Look at TabBalanceController and tab-balance.fxml for reference on how to find an account.

Look at tabNewCustomerController for examples of how to get information from a TextField.

Part 7: Bonus Task! Group work.

For those of you who finish early, begin collaborating on how to complete the Lookup Customer tab.

This tab should find a customer record, then display all information about the customer, including any linked accounts.

No hints on this one as it's a bonus challenge!

Part 8: Bonus Task! Mixed work.

Add error handling to the bank.