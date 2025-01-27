package cs113.bank.controllers;

import cs113.bank.Bank;
import cs113.bank.Main;
import cs113.bank.account.Account;
import cs113.bank.transactions.Transaction;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class TabBalanceController extends TabActivateController {
    @FXML
    private Label customerName;

    @FXML
    private Label customerBalance;

    @FXML
    private ChoiceBox<String> accountList;

    @FXML
    private HBox transactionDisplay;

    @FXML
    private VBox transactionList;

    public void initialize() {
        super.initialize();
        activate();
    }

    @Override
    public void activate() {
        customerName.setText("");
        customerBalance.setText("");
        transactionDisplay.setVisible(false);
        fillAccountList();
    }

    private void copyNodeLayout(Region nodeCopy, Region nodeSource) {
        nodeCopy.setLayoutX(nodeSource.getLayoutX());
        nodeCopy.setLayoutY(nodeSource.getLayoutY());
        nodeCopy.setPrefWidth(nodeSource.getPrefWidth());
        nodeCopy.setPrefHeight(nodeSource.getPrefHeight());
    }

    public void fillAccountList() {
        accountList.getItems().clear();
        ArrayList<Account> accounts = Main.bankSingleton().getAccounts();
        for (Account account : accounts) {
            accountList.getItems().add(Integer.toString(account.getAccountNumber()));
        }
    }

    public Account getSelectedAccount() {
        int accountNumber = Integer.parseInt(this.accountList.getSelectionModel().getSelectedItem().toString());
        Bank bank = Main.bankSingleton();
        return bank.getAccount(accountNumber);
    }

    @FXML
    protected void onLookupAccount() {
        Account account = getSelectedAccount();

        if (account != null) {
            customerName.setText(account.getAccountHolder().getName());
            customerBalance.setText("$" + account.getBalance());

            ArrayList<Transaction> transactions = account.getTransactions();
            for (Transaction t : transactions) {
                HBox transactionBox = new HBox();
                copyNodeLayout(transactionBox, transactionDisplay);

                for (Node node : transactionDisplay.getChildren()) {
                    if (node instanceof Label copyLabel) {
                        Label newLabel = new Label(copyLabel.getText());

                        copyNodeLayout(newLabel, copyLabel);
                        newLabel.setAlignment(copyLabel.getAlignment());

                        String id = copyLabel.getId();
                        if (id != null) {
                            if (id.equals("transactionType")) {
                                newLabel.setText(t.getTransactionDescription());
                            }
                            else if (id.equals("transactionAmount")) {
                                newLabel.setText("$" + t.getAmount());
                            }
                            else if (id.equals("transactionDate")) {
                                newLabel.setText("" + t.getDate());
                            }
                        }
                        transactionBox.setVisible(true);
                        transactionBox.getChildren().add(newLabel);
                    }
                }
                transactionList.getChildren().add(transactionBox);
            }
        }
    }
}
