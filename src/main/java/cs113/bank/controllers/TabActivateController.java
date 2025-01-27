package cs113.bank.controllers;

import cs113.bank.Main;

public class TabActivateController {
    public void initialize() {
        BankController bankController = Main.bankSingleton().getGUIController();
        bankController.currentTabProperty().addListener((observable, oldValue, newValue) -> {
            activate();
        });
    }

    public void activate() {}
}
