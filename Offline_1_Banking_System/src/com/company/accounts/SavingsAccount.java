package com.company.accounts;


public class SavingsAccount extends Account {
    private LoanAccount loan;

    public SavingsAccount(String owner, double amount) {
        super(owner, amount, 10, AccountType.SAVINGS);
    }

    @Override
    public void addInterest() {
        if (loan == null) {
            setAmount(getAmount() + getAmount() * getRate() - 500);
            return;
        }
        setAmount(getAmount() + getAmount() * getRate() - loan.getInterest() - 500);
    }

    @Override
    public boolean deposit(double amount) {
        if (amount < 0) {
            return false;
        }
        // check if there is loan against the person
        if (loan == null) {
            setAmount(getAmount() + amount);
        } else {
            double loanAmount = loan.getAmount();
            if (amount > loanAmount) {
                loan.deposit(loanAmount);
                setAmount(amount - loanAmount);
            } else {
                loan.deposit(amount);
            }
        }
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount < 0 || getAmount() - amount < 1000) {
            return false;
        }
        setAmount(getAmount() - amount);
        return true;
    }

    @Override
    public boolean requestLoan(double amount) {
        if (amount < 0 || amount > 10000) {
            return false;
        }
        if (loan == null) {
            loan = new LoanAccount(getOwner(), amount);
        } else {
            return loan.requestLoan(amount);
        }
        return true;
    }


    @Override
    public double approveLoan() {
        if (this.loan == null) {
            return 0;
        }
        double val = loan.approveLoan();
        setAmount(getAmount() + val);
        return val;
    }

}
