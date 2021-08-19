<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
    String clientno = request.getParameter("clietno");
    String driver = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/";
    String database = "loan";
    String userid = "root";
    String password = "";
    try {
        Class.forName(driver);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body>

<h1>LOAN RECORDS</h1>

<h3>The following are the loan records:</h3>
<table border="1">
    <tr>
        <td>Client Number</td>
        <td>Client Name</td>
        <td>Loan Amount</td>
        <td>Number of Years</td>
        <td>Loan Type</td>

    </tr>
    <%
        try{
            connection = DriverManager.getConnection(connectionUrl+database, userid, password);
            statement=connection.createStatement();
            String sql ="select * from loan";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
    %>
    <tr>
        <td><%=resultSet.getString("clientno") %></td><td><a type="button" class="btn btn-primary" href="/update-todo?id=${todo.clientno}">Edit</a> </td><td><a type="button" class="btn btn-primary" href="/delete-todo?id=${todo.clientno}">Delete</a> </td>
        <td><%=resultSet.getString("clientname") %></td></td><td><a type="button" class="btn btn-primary" href="/update-todo?id=${todo.clientno}">Edit</a> </td><td><a type="button" class="btn btn-primary" href="/delete-todo?id=${todo.clientno}">Delete</a> </td>
        <td><%=resultSet.getDouble("loanamount") %></td></td><td><a type="button" class="btn btn-primary" href="/update-todo?id=${todo.clientno}">Edit</a> </td><td><a type="button" class="btn btn-primary" href="/delete-todo?id=${todo.clientno}">Delete</a> </td>
        <td><%=resultSet.getInt("years") %></td></td><td><a type="button" class="btn btn-primary" href="/update-todo?id=${todo.clientno}">Edit</a> </td><td><a type="button" class="btn btn-primary" href="/delete-todo?id=${todo.clientno}">Delete</a> </td>
        <td><%=resultSet.getString("loantype") %></td></td><td><a type="button" class="btn btn-primary" href="/update-todo?id=${todo.clientno}">Edit</a> </td><td><a type="button" class="btn btn-primary" href="/delete-todo?id=${todo.clientno}">Delete</a> </td>
    </tr>
    <%
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</table>
</body>
</html>