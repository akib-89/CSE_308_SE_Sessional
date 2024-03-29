package com.company.roles;

import com.company.accounts.Account;
import com.company.accounts.AccountType;

import java.util.List;

public class ManagingDirector extends Officer {
    public void changeInterestRate(List<Account> accounts, AccountType accountType, double newRate) {
        for (Account account : accounts) {
            if (account.getType().equals(accountType)) {
                account.setRate(newRate);
            }
        }
        System.out.println("Interest rate changed for " + accountType.name() + " types of account");
    }

    public void seeFund(double internalFund) {
        System.out.println("Total internal fund of the bank is: " + internalFund);
    }
}
