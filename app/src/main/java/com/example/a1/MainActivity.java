package com.example.a1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView out_Account;
    TextView out_MoneyInHand;
    Spinner moneySpinner;
    public Withdraw withdraw = new Withdraw();
    public Deposit deposit = new Deposit();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        out_Account = (TextView) findViewById(R.id.accountOut);
        out_MoneyInHand = (TextView) findViewById(R.id.balanceOut);
        moneySpinner = (Spinner) findViewById(R.id.moneySpinner);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.black));

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

    }

    public void onClickDeposit(View view) {
        out_Account = (TextView) findViewById(R.id.accountOut);
        out_MoneyInHand = (TextView) findViewById(R.id.balanceOut);
        moneySpinner = (Spinner) findViewById(R.id.moneySpinner);

        String outAccount = out_Account.getText().toString();
        String spinnerValue = moneySpinner.getSelectedItem().toString();
        String inHandValue = out_MoneyInHand.getText().toString();

        if (!checkIfPossible(inHandValue, spinnerValue)) {
            return;
        }

        String calculatedHandValue = withdraw.withdraw(inHandValue, spinnerValue);
        String calculatedValue = deposit.deposit(outAccount, spinnerValue);

        out_Account.setText(calculatedValue);
        out_MoneyInHand.setText(calculatedHandValue);

    }


    public void onClickWithdraw(View view) {
        out_Account = (TextView) findViewById(R.id.accountOut);
        out_MoneyInHand = (TextView) findViewById(R.id.balanceOut);
        moneySpinner = (Spinner) findViewById(R.id.moneySpinner);


        String outAccount = out_Account.getText().toString();
        String spinnerValue = moneySpinner.getSelectedItem().toString();
        String inHandValue = out_MoneyInHand.getText().toString();

        if (!checkIfPossible(outAccount, spinnerValue)) {
            return;
        }

        String calculatedHandValue = deposit.deposit(inHandValue, spinnerValue);
        String calculatedValue = withdraw.withdraw(outAccount, spinnerValue);

        out_Account.setText(calculatedValue);
        out_MoneyInHand.setText(calculatedHandValue);

    }

    /**
     * First param send what to WITHDRAW FROM and second the amount
     *
     * @param textField1
     * @param textField2
     * @return
     */
    public boolean checkIfPossible(String textField1, String textField2) {
        int value1 = Integer.parseInt(textField1);
        int value2 = Integer.parseInt(textField2);

        if (value1 <= value2) {
            return false;
        } else {
            return true;
        }

    }


}