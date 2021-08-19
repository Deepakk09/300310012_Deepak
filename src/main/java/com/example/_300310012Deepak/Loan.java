package com.example._300310012Deepak;

public class Loan {

    String ClientNo;
    String ClientName;
    double LoanAmount;
    int years;
    String Loantype;

    public Loan(String clientNo, String clientName, double loanAmount, int years, String loantype) {
        ClientNo = clientNo;
        ClientName = clientName;
        LoanAmount = loanAmount;
        this.years = years;
        Loantype = loantype;
    }

    public String getClientNo() {
        return ClientNo;
    }

    public void setClientNo(String clientNo) {
        ClientNo = clientNo;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public double getLoanAmount() {
        return LoanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        LoanAmount = loanAmount;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getLoantype() {
        return Loantype;
    }

    public void setLoantype(String loantype) {
        Loantype = loantype;
    }
}
