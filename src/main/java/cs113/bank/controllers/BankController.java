package cs113.bank.controllers;

import cs113.bank.Main;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BankController {
    private IntegerProperty tab = new SimpleIntegerProperty(this, "tab");
    public Integer getTab() { return tab.get(); }
    public void setTab(Integer tab) { this.tab.set(tab); }
    public IntegerProperty currentTabProperty() {
        return tab;
    }

    @FXML
    private TabPane tabPane;

    public BankController() {
        Main.bankSingleton().setGUIController(this);
    }

    public void initialize() {
        // tabPane listener from ChatGPT
        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if (newTab != null) {
                // This is called when a new tab is selected
                onTabChanged(newTab);
            }
        });
    }

    private void onTabChanged(Tab selectedTab) {
        setTab(tabPane.getTabs().indexOf(selectedTab));
    }
}