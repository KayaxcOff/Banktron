package org.example.banktron.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.banktron.func.BankTransactions;
import org.example.banktron.func.User;

public class MainViewController {

    @FXML
    private Label nameLabel, balanceLabel;

    @FXML
    private Button depositButton, withdrawButton, transferButton;

    @FXML
    private TextArea descrpitionArea;

    @FXML
    private TextField amountField;

    User tempraryUser;
    BankTransactions bankTransactions = new BankTransactions(tempraryUser);

    public void depositMoney() {
        //boolean isTrue = bankTransactions.depositMoney(Integer.getInteger(amountField.getText()));
    }

    public void withdrawMoney() {
        //bankTransactions.withdrawMoney(Integer.getInteger(amountField.getText()));
    }

    public void transferMoney() {
        //bankTransactions.transferMoney(Integer.getInteger(amountField.getText()));
    }
}
