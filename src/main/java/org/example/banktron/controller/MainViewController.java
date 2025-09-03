package org.example.banktron.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import org.example.banktron.func.BankTransactions;
import org.example.banktron.func.User;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private Label balanceLabel, resultLabel;

    @FXML
    private TextField amountField;

    private User currentUser;
    private BankTransactions bankTransactions;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (balanceLabel != null) {
            balanceLabel.setText("0");
        }
    }

    public void setUser(User user) {
        this.currentUser = user;
        this.bankTransactions = new BankTransactions(currentUser);
        updateBalanceDisplay();
    }

    public void depositMoney() {
        try {
            int amount = Integer.parseInt(amountField.getText().trim());
            boolean isSuccess = bankTransactions.deposit(amount);

            if(isSuccess) {
                resultLabel.setText("Deposit is successful!");
                updateBalanceDisplay();
                amountField.clear();
            } else {
                resultLabel.setText("Deposit failed! Invalid amount.");
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter correct amount!");
        }
    }

    public void withdrawMoney() {
        try {
            int amount = Integer.parseInt(amountField.getText().trim());
            boolean isSuccess = bankTransactions.withdraw(amount);

            if(isSuccess) {
                resultLabel.setText("Withdraw is successful!");
                updateBalanceDisplay();
                amountField.clear();
            } else {
                resultLabel.setText("Withdraw isn't successful! Invalid amount.");
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter correct amount!");
        }
    }

    public void transferMoney() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bilgi");
        alert.setHeaderText("Transfer");
        alert.setContentText("Transfer functionality is not implemented yet.");
        alert.showAndWait();
    }

    private void updateBalanceDisplay() {
        if (currentUser != null && balanceLabel != null) {
            balanceLabel.setText(String.valueOf(currentUser.getBalance()));
        }
    }
}