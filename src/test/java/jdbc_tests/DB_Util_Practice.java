package jdbc_tests;

import org.junit.jupiter.api.Test;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class DB_Util_Practice {
  @Test
  public void test1(){
// create connection
      DBUtils.createConnection();

      String query="select  FIRST_NAME, LAST_NAME, SALARY, JOB_ID\n" +
              "from EMPLOYEES\n" +
              "where ROWNUM<6";

      List<Map<String, Object>> queryData = DBUtils.getQueryResultMap(query);

      // print the result
      for (Map<String, Object> eachRow : queryData) {
          System.out.println(eachRow);
      }

      // close the connection
      DBUtils.destroy();

  }


  @Test
    public void test2(){

      // create connection
      DBUtils.createConnection();

      String query="select  FIRST_NAME, LAST_NAME, SALARY, JOB_ID\n" +
              "from EMPLOYEES\n" +
              "where ROWNUM<2";

      Map<String, Object> rowMap = DBUtils.getRowMap(query);

      // print the result
      System.out.println(rowMap);

      // close the connection
      DBUtils.destroy();

  }












}
