package jdbc_tests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.*;

public class ListOfMapExample {

    String dbUrl="jdbc:oracle:thin:@44.200.16.230:1521:XE";
    String dbUsername="hr";
    String dbPassword="hr";

 @Test
 public void test1() throws SQLException {


// creating  list for keeping all the row maps
     List< Map<String, Object> >   queryData=new ArrayList<>();

// putting the first row in a map
Map<String, Object> row1= new HashMap<>();
row1.put("first_name", "Steven");
row1.put("last_name", "King");
row1.put("salary", 24000);
row1.put("job_id", "AD_PRES");
 System.out.println(row1);

     // putting the second row in a map
     Map<String, Object> row2= new HashMap<>();
     row2.put("first_name", "Neena");
     row2.put("last_name", "Kochar");
     row2.put("salary", 17000);
     row2.put("job_id", "AD_VP");
     System.out.println(row2);

     // adding rows one by one to list:
     queryData.add(row1);
     queryData.add(row2);

     System.out.println(queryData);

// get Steven's lastname directly from the list
     System.out.println(queryData.get(0).get("last_name"));


 }



 @Test
    public void test2() throws SQLException {
     // creating a connection to the database
     Connection connection= DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
     // to move freely                and read only
     Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
     ResultSet resultSet= statement.executeQuery("select  FIRST_NAME, LAST_NAME, SALARY, JOB_ID\n" +
             "from EMPLOYEES\n" +
             "where ROWNUM <6");

// in order to get column name we need resultsetmetadata
     ResultSetMetaData rsmd= resultSet.getMetaData();

// move to the first row
resultSet.next();

// creating  list for keeping all the row maps
     List< Map<String, Object> >   queryData=new ArrayList<>();

// putting the first row in a map
     Map<String, Object> row1= new HashMap<>();
     row1.put(rsmd.getColumnName(1),resultSet.getString(1) );
     row1.put(rsmd.getColumnName(2),resultSet.getString(2) );
     row1.put(rsmd.getColumnName(3),resultSet.getInt(3) );
     row1.put(rsmd.getColumnName(4),resultSet.getString(4) );

    System.out.println(row1);

    // move to the second row
resultSet.next();

     // putting the second row in a map
     Map<String, Object> row2= new HashMap<>();
     row2.put(rsmd.getColumnName(1),resultSet.getString(1) );
     row2.put(rsmd.getColumnName(2),resultSet.getString(2) );
     row2.put(rsmd.getColumnName(3),resultSet.getInt(3) );
     row2.put(rsmd.getColumnName(4),resultSet.getString(4) );
     System.out.println(row2);

     // adding rows one by one to list:
     queryData.add(row1);
     queryData.add(row2);







     // close the connection
     resultSet.close();
     statement.close();
     connection.close();


 }






}
