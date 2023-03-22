package jdbc_tests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.*;

public class Dynamic_List {


    String dbUrl="jdbc:oracle:thin:@44.200.16.230:1521:XE";
    String dbUsername="hr";
    String dbPassword="hr";

    @Test
    public void test1() throws SQLException {
        // creating a connection to the database
        Connection connection= DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        // to move freely                and read only
        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet= statement.executeQuery("select  * from departments ");

// in order to get column name we need resultsetmetadata
        ResultSetMetaData rsmd= resultSet.getMetaData();

// list of maps to keep all information
List< Map< String, Object>  > queryData= new ArrayList<>();

// number of columns
int colCount= rsmd.getColumnCount();

// loop through each loop
while(resultSet.next()){
    Map<String, Object> row= new LinkedHashMap<>();

// some code to fill dynamically
    for (int i = 1; i <=colCount ; i++) {

        row.put(rsmd.getColumnName(i),resultSet.getString(i) );
    }



// add ready map row to the list
queryData.add(row);


}



// print each row inside the loop:
        for (Map<String, Object> each : queryData) {
            System.out.println(each);
        }


        // close the connection
        resultSet.close();
        statement.close();
        connection.close();


    }



}
