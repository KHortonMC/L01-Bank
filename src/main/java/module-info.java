module cs113.bank {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jshell;
    requires java.desktop;


    opens cs113.bank to javafx.fxml;
    exports cs113.bank;
    exports cs113.bank.customer;
    opens cs113.bank.customer to javafx.fxml;
    exports cs113.bank.account;
    opens cs113.bank.account to javafx.fxml;
    exports cs113.bank.controllers;
    opens cs113.bank.controllers to javafx.fxml;
    exports cs113.bank.transactions;
    opens cs113.bank.transactions to javafx.fxml;
}