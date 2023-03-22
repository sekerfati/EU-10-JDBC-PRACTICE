package jdbc_tests;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
//                                  @IPADDRESS :PORT_NUMBER
    String dbUrl="jdbc:oracle:thin:@44.200.16.230:1521:XE";
    String dbUsername="hr";
    String dbPassword="hr";

    // creating a connection to the database
Connection connection= DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
 Statement statement= connection.createStatement();
 ResultSet resultSet= statement.executeQuery("select * from regions");


// once you set up connection default pointer looks for 0/zero

 // next() --> move pointer to the first row
 resultSet.next();

 // getting information with column name
System.out.println(resultSet.getString("region_name"));

// getting the information with column index(starts from 1)
        System.out.println(resultSet.getString(2));

/*
get me the result below:
1- Europe
2-Amaricas
 */
System.out.println(resultSet.getInt(1)+" - "+ resultSet.getString(2));

// move to the second  row
resultSet.next();
System.out.println(resultSet.getInt(1)+" - "+ resultSet.getString(2));


// move to the third  row
        resultSet.next();
        System.out.println(resultSet.getInt(1)+" - "+ resultSet.getString(2));


// while    resultSet.next() is true print me   System.out.println(resultSet.getInt(1)+" - "+ resultSet.getString(2)
while (resultSet.next()){
    System.out.println(resultSet.getInt(1)+" - "+ resultSet.getString(2));
}







        // close the connection
        resultSet.close();
        statement.close();
        connection.close();









    }

}
