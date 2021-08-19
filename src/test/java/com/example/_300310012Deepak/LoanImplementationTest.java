package com.example._300310012Deepak;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;


import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class LoanImplementationTest {

    @InjectMocks
    private LoanImplementation panelDao;

    @Mock
    private java.sql.Connection connection;

    @Mock
    private ResultSet result;

    @Mock
    private Connection cc;

    @Mock
    private PreparedStatement stmt;

    Loan No;

    @BeforeEach
    void setUp() throws SQLException {

        MockitoAnnotations.openMocks(this);

        when(connection.prepareStatement(any(String.class))).thenReturn(stmt);
        when(cc).thenReturn(connection);

        No= new Loan("1157","Joy Ramirez",100000.0,5,"Business");


    }

    @Test
    void edit() throws SQLException, ClassNotFoundException {

        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("clientno")).thenReturn("1157");
        Mockito.when(result.getString("clientname")).thenReturn("Joy Ramirez");
        Mockito.when(result.getString("loanamount")).thenReturn(String.valueOf(100000.0));
        Mockito.when(result.getString("years")).thenReturn(String.valueOf(5));
        Mockito.when(result.getString("loantype")).thenReturn("Business");
        Mockito.when(result.first()).thenReturn(true);
        Mockito.when(stmt.executeQuery()).thenReturn(result);


        No = new Loan("1157","Joy Ramirez",100000.0,5,"Business");
        Loan pp =  panelDao.edit(No,"Joy Ramirez",100000.0,5,"Business");

        assertEquals("Joy Ramirez",pp.getClientName());

    }

    @Test
    void delete() throws SQLException {

        Mockito.when(connection.prepareStatement((any(String.class)))).thenReturn((PreparedStatement) stmt);

        panelDao.delete(No.ClientNo);
        Mockito.verify(stmt.executeUpdate());


    }


    @Test
    void add() throws SQLException, ClassNotFoundException {

        Mockito.when(connection.prepareStatement(("INSERT INTO loan VALUES ( ?, ? ,?,?,?)"))).thenReturn((PreparedStatement) stmt);

        panelDao.add(No);

        Mockito.verify(stmt).executeUpdate();
    }

    @Test
    void search() throws SQLException, ClassNotFoundException {


        Mockito.when(connection.prepareStatement("Select * from loan where clientno = ?")).thenReturn(stmt);

        Mockito.when(stmt.executeQuery()).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true);
        Mockito.when(result.getString("clientno")).thenReturn("1157");
        Mockito.when(result.getString("clientname")).thenReturn("Joy Ramirez");
        Mockito.when(result.getString("loanamount")).thenReturn(String.valueOf(100000.0));
        Mockito.when(result.getString("years")).thenReturn(String.valueOf(5));
        Mockito.when(result.getString("loantype")).thenReturn("Business");
        Mockito.when(result.first()).thenReturn(true);

        Loan l1 = panelDao.search("1157");
        assertEquals("1157", l1.getClientNo());

    }
}