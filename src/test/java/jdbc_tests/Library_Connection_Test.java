package jdbc_tests;

import org.junit.jupiter.api.Test;
import utilities.DBUtils;

import java.sql.*;

public class Library_Connection_Test {

    @Test
    public void test1() throws SQLException {
        //                                  @IPADDRESS :PORT_NUMBER
        String dbUrl="jdbc:mysql://34.230.35.214:3306/library1";
        String dbUsername="library1_client";
        String dbPassword="WVF4NdGXCKHeE6VQ";

        // creating a connection to the database
        Connection connection= DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery("select * from books");

resultSet.next();

        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getString(2));

        // close the connection
        resultSet.close();
        statement.close();
        connection.close();
    }


    @Test
    public void test2(){
//                                  @IPADDRESS :PORT_NUMBER
        String dbUrl="jdbc:mysql://34.230.35.214:3306/library1";
        String dbUsername="library1_client";
        String dbPassword="WVF4NdGXCKHeE6VQ";

        DBUtils.createConnection(dbUrl, dbUsername, dbPassword);
        DBUtils.destroy();

    }




}
