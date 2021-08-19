package com.example._300310012Deepak;

import java.sql.SQLException;
import java.util.List;

public interface LoanInterface {


    public Loan edit(Loan ClientNo, String ClientName, double LoanAmount ,int years,String Loantype) throws SQLException, ClassNotFoundException;
    public void delete(String ClientNo) throws SQLException;
    public List<Loan> display() throws ClassNotFoundException, SQLException;
    public void add(Loan ClientNo) throws ClassNotFoundException, SQLException;


}
