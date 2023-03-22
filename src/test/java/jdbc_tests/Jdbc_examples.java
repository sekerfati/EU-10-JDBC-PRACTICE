package jdbc_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class Jdbc_examples {

    String dbUrl="jdbc:oracle:thin:@44.200.16.230:1521:XE";
    String dbUsername="hr";
    String dbPassword="hr";
 @Test
 public void test1() throws SQLException {

     // creating a connection to the database
     Connection connection= DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
     Statement statement= connection.createStatement();
     ResultSet resultSet= statement.executeQuery("select * from departments");


// move to first row
//     resultSet.next();
//     System.out.println(resultSet.getString(2));

// display departments table in 10 - Administration - 200 - 1700 format
// code for iterating each row
while (resultSet.next()){
    System.out.println(resultSet.getInt(1) + " - "+ resultSet.getString(2)
            +" - " + resultSet.getString(3)+ " - "+ resultSet.getInt(4));

}

     System.out.println("-------------------------------------------------------------------");
resultSet= statement.executeQuery("select * from regions");
// code for iterating each row
     while (resultSet.next()){
         System.out.println(resultSet.getInt(1) + " - "+ resultSet.getString(2));

     }


     // close the connection
     resultSet.close();
     statement.close();
     connection.close();

    }


 @DisplayName("ResultSet Methods")
 @Test
 public void test2() throws SQLException {

// creating a connection to the database
     Connection connection= DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                                                           // to move freely                and read only
     Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
     ResultSet resultSet= statement.executeQuery("select * from employees");

// how to find    how many rows we have in the query
// move to last row
     resultSet.last();           // goes to the last row

// get the row count
     int rowCount= resultSet.getRow();  // will give the current row number
     System.out.println(rowCount);

     System.out.println("-----------------------------------------------");

// move to the before first column because the pointer was at the last row
     resultSet.beforeFirst();

// print all second column info:
     while (resultSet.next()){
         System.out.println(resultSet.getString(2));
     }




     // close the connection
     resultSet.close();
     statement.close();
     connection.close();

    }


@Test
    public void test3() throws SQLException {

     // creating a connection to the database
    Connection connection= DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    // to move freely                and read only
    Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    ResultSet resultSet= statement.executeQuery("select * from employees");

 //get the    database related data inside the database meta_data object
    DatabaseMetaData dbMetaData= connection.getMetaData();
    System.out.println("dbMetaData.getUserName() = " + dbMetaData.getUserName());
    System.out.println("dbMetaData.getDatabaseProductName() = " + dbMetaData.getDatabaseProductName());
    System.out.println("dbMetaData.getDatabaseProductVersion() = " + dbMetaData.getDatabaseProductVersion());
    System.out.println("dbMetaData.getDriverName() = " + dbMetaData.getDriverName());
    System.out.println("dbMetaData.getDriverVersion() = " + dbMetaData.getDriverVersion());

// get the resultSet metadata=rsmd
    ResultSetMetaData rsMetaData= resultSet.getMetaData();

// how many columns we have in the table:
    int colCount= rsMetaData.getColumnCount();
    System.out.println(colCount);

// getting the column names:
    System.out.println("rsMetaData.getColumnName(1) = " + rsMetaData.getColumnName(1));
    System.out.println("rsMetaData.getColumnName(2) = " + rsMetaData.getColumnName(2));
    System.out.println("rsMetaData.getColumnName(3) = " + rsMetaData.getColumnName(3));

    System.out.println("--------------------------------------------");
//rsMetaData.getColumnName gets column name


// print all the column names dynamically:
    for (int i = 1; i <=rsMetaData.getColumnCount() ; i++) {
        System.out.println( "Column name :" +rsMetaData.getColumnName(i));
    }



    // close the connection
    resultSet.close();
    statement.close();
    connection.close();




}




}
