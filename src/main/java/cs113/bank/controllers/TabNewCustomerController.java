package cs113.bank.controllers;

import cs113.bank.Main;
import cs113.bank.customer.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class TabNewCustomerController extends TabActivateController {
    @FXML
    private TextField customerName;

    @FXML
    private TextField customerAddress;

    @FXML
    private TextField customerPhone;

    @FXML
    private TextField customerAge;

    @FXML
    private CheckBox isSenior;

    @FXML
    private CheckBox isStudent;

    @FXML
    public void onCreateAccount() {
        String name = customerName.getText();
        String address = customerAddress.getText();
        String phone = customerPhone.getText();
        int age = Integer.parseInt(customerAge.getText());

        Customer newCustomer = null;

        if (isSenior.isSelected()) {
            // todo: create a senior customer
        }
        else if (isStudent.isSelected()) {
            // todo: create a student customer
        }
        else {
            // todo: create an adult customer
        }

        customerName.clear();
        customerAddress.clear();
        customerPhone.clear();
        customerAge.clear();
        isSenior.setSelected(false);
        isStudent.setSelected(false);

        if (newCustomer != null) {
            Main.bankSingleton().getCustomers().add(newCustomer);
        }
    }
}
