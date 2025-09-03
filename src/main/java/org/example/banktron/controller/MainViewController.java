package org.example.banktron.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.banktron.func.BankTransactions;
import org.example.banktron.func.User;

public class MainViewController {

    @FXML
    private Label balanceLabel, resultLabel;

    @FXML
    private TextField amountField;

    private User tempraryUser;
    private BankTransactions bankTransactions;

    public void setUser(User user) {
        this.tempraryUser = user;
        this.bankTransactions = new BankTransactions(tempraryUser);
    }

    public void depositMoney() {
        boolean isSuccess = bankTransactions.deposit(Integer.parseInt(amountField.getText()));
        if(isSuccess) {
            resultLabel.setText("Deposited Successfully");
            balanceLabel.setText(String.valueOf(tempraryUser.getBalance()));
        } else {
            resultLabel.setText("Deposit Failed");
        }
    }

    public void withdrawMoney() {
        boolean isSuccess = bankTransactions.withdraw(Integer.parseInt(amountField.getText()));
        if(isSuccess) {
            resultLabel.setText("Withdrawn Successfully");
            balanceLabel.setText(String.valueOf(tempraryUser.getBalance()));
        } else {
            resultLabel.setText("Withdraw Failed");
        }
    }

    public void transferMoney() {
        boolean isSuccess = bankTransactions.transfer(tempraryUser ,Integer.parseInt(amountField.getText()));
        if(isSuccess) {
            resultLabel.setText("Transferred Successfully");
            balanceLabel.setText(String.valueOf(tempraryUser.getBalance()));
        } else {
            resultLabel.setText("Transfer Failed");
        }
    }
}
