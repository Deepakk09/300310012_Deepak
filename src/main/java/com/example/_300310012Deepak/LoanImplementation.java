package com.example._300310012Deepak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoanImplementation implements LoanInterface{

    java.sql.Connection con;

    public LoanImplementation(Connection con) {
        this.con = con;
    }


    @Override
    public Loan edit(Loan ClientNo, String ClientName, double LoanAmount, int years, String Loantype) throws SQLException, ClassNotFoundException {

        PreparedStatement query;
        query = con.prepareStatement("Update Loan set clientno=?, clientname=?, loanamount= ?,years=?,loantype=?  where clientno = ?");
        query.setString(1, ClientNo.getClientNo());
        query.setString(2, ClientNo.getClientName());
        query.setString(3, String.valueOf(ClientNo.getLoanAmount()));
        query.setString(4, String.valueOf(ClientNo.getYears()));
        query.setString(5, ClientNo.getLoantype());
        query.setString(6, String.valueOf(ClientNo));
        query.executeUpdate();
        return ClientNo;


    }

    @Override
    public void delete(String ClientNo) throws SQLException {

        String quer1 = "Delete from Loan where clientno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, ClientNo);
        query.executeUpdate();



    }

    @Override
    public List<Loan> display() throws ClassNotFoundException, SQLException {


        List<Loan> Loanlist = new ArrayList<Loan>();
        String quer1 = "Select * from loan";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();
        Loan obj1;


        while (rs.next()) {
            obj1 = new Loan(rs.getString("clientno"), rs.getString("clientname"),
                    rs.getDouble("loanamount"),rs.getInt("years"),rs.getString("loantype"));
            Loanlist.add(obj1);
        }
        return Loanlist;
    }

    @Override
    public void add(Loan clientno) throws ClassNotFoundException, SQLException {

        String quer1 = "INSERT INTO loan VALUES ( ?, ? ,?,?,?)";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, clientno.getClientNo());
        query.setString(2, clientno.getClientName());
        query.setString(3 , String.valueOf(clientno.getLoanAmount()));
        query.setString(4, String.valueOf(clientno.getYears()));
        query.setString(5, clientno.getLoantype());
        query.executeUpdate();
    }

    public Loan search(String clientno) throws SQLException, ClassNotFoundException {

        String quer1 = "Select * from loan where clientno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, clientno);
        ResultSet rs = query.executeQuery();
        if (!rs.first()) {
            System.out.print("Record not existing");
            return null;
        }

        Loan obj1 = null;
        obj1 = new Loan(rs.getString("clientno"), rs.getString("clientname"),
                rs.getDouble("loanamount"),rs.getInt("years"),rs.getString("loantype"));
        return obj1;
    }
}