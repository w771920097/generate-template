package util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;
import com.sun.xml.internal.ws.util.UtilException;
import constant.Constant;
import generateplus.domain.DataMeta;

public class DatabaseUtil {

  private static final String URL = Constant.JDBC_URL;
  private static final String USERNAME = Constant.JDBC_USERNAME;
  private static final String PASSWORD = Constant.JDBC_PASSWORD;

  private static final String SQL = "SELECT * FROM ${tableName} where 1=2";// 数据库操作

  private static final String QUERY_DATA_META_SQL =
      " SELECT \r\n" + "   TABLE_SCHEMA AS `databaseName`,\r\n"
          + "   TABLE_NAME AS `tableName`,\r\n" + "   COLUMN_NAME AS `columnName`,\r\n"
          + "   DATA_TYPE AS `columnType`,\r\n" + "   COLUMN_COMMENT AS `columnComment`, \r\n"
          + "   CHARACTER_MAXIMUM_LENGTH  AS `characterMaximumLength`,\n" + "   IS_NULLABLE  AS `isNullable`,\n"
          + "   NUMERIC_PRECISION AS `numericPrecision` \n"
          + " FROM\r\n" + "   `information_schema`.`COLUMNS` \r\n"
          + " WHERE `TABLE_SCHEMA` = '${DBName}' \r\n" + "   AND `TABLE_NAME` = '${tableName}'";

  /**
   * 获取数据库连接
   *
   * @return
   */
  public static Connection getConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (SQLException e) {
      throw new UtilException("get connection failure", e);
    }
    return conn;
  }

  /**
   * 关闭数据库连接
   * 
   * @param conn
   */
  public static void closeConnection(Connection conn) {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        throw new UtilException("close connection failure", e);
      }
    }
  }

  /**
   * 获取数据库下的所有表名
   */
  public static List<String> getTableNames() {
    List<String> tableNames = new ArrayList<String>();
    Connection conn = getConnection();
    ResultSet rs = null;
    try {
      // 获取数据库的元数据
      DatabaseMetaData db = conn.getMetaData();
      // 从元数据中获取到所有的表名
      rs = db.getTables(null, null, null, new String[] {"TABLE"});
      while (rs.next()) {
        tableNames.add(rs.getString(3));
      }
    } catch (SQLException e) {
      throw new UtilException("getTableNames failure", e);
    } finally {
      try {
        rs.close();
        closeConnection(conn);
      } catch (SQLException e) {
        throw new UtilException("close ResultSet failure", e);
      }
    }
    return tableNames;
  }

  /**
   * 获取表中所有字段名称
   * 
   * @param tableName 表名
   * @return
   */
  public static List<String> getColumnNames(String tableName) {
    List<String> columnNames = new ArrayList<String>();
    // 与数据库的连接
    Connection conn = getConnection();
    PreparedStatement pStemt = null;
    String tableSql = SQL.replace("${tableName}", tableName);
    try {
      pStemt = conn.prepareStatement(tableSql);
      // 结果集元数据
      ResultSetMetaData rsmd = pStemt.getMetaData();
      // 表列数
      int size = rsmd.getColumnCount();
      for (int i = 0; i < size; i++) {
        columnNames.add(rsmd.getColumnName(i + 1));
      }
    } catch (SQLException e) {
      throw new UtilException("getColumnNames failure", e);
    } finally {
      if (pStemt != null) {
        try {
          pStemt.close();
          closeConnection(conn);
        } catch (SQLException e) {
          throw new UtilException("获取字段名   关闭结果集和jdbc连接失败", e);
        }
      }
    }
    return columnNames;
  }

  /**
   * 获取表中所有字段类型
   * 
   * @param tableName
   * @return
   */
  public static List<String> getColumnTypes(String tableName) {
    List<String> columnTypes = new ArrayList<String>();
    // 与数据库的连接
    Connection conn = getConnection();
    PreparedStatement pStemt = null;
    String tableSql = SQL.replace("${tableName}", tableName);
    try {
      pStemt = conn.prepareStatement(tableSql);
      // 结果集元数据
      ResultSetMetaData rsmd = pStemt.getMetaData();
      // 表列数
      int size = rsmd.getColumnCount();
      for (int i = 0; i < size; i++) {
        columnTypes.add(rsmd.getColumnTypeName(i + 1));
      }
    } catch (SQLException e) {
      throw new UtilException("getColumnTypes failure", e);
    } finally {
      if (pStemt != null) {
        try {
          pStemt.close();
          closeConnection(conn);
        } catch (SQLException e) {
          throw new UtilException("获取字段类型  关闭结果集和jdbc连接失败", e);
        }
      }
    }
    return columnTypes;
  }

  /**
   * 获取表中字段的所有注释
   * 
   * @param tableName
   * @return
   */
  public static List<String> getColumnComments(String tableName) {
    // List<String> columnTypes = new ArrayList<String>();
    // 与数据库的连接
    Connection conn = getConnection();
    PreparedStatement pStemt = null;
    String tableSql = SQL.replace("${tableName}", tableName);
    List<String> columnComments = new ArrayList<String>();// 列名注释集合
    ResultSet rs = null;
    try {
      pStemt = conn.prepareStatement(tableSql);
      rs = pStemt.executeQuery("show full columns from " + tableName);
      while (rs.next()) {
        columnComments.add(rs.getString("Comment"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (rs != null) {
        try {
          rs.close();
          closeConnection(conn);
        } catch (SQLException e) {
          throw new UtilException("获取字段注释 关闭结果集和jdbc连接失败", e);
        }
      }
    }
    return columnComments;
  }


  public static List<DataMeta> getDataMetaListByTableName(String tableName) {
    List<String> columnNames = new ArrayList<String>(); // 列名
    List<String> columnTypes = new ArrayList<String>(); // 列类型
    List<String> columnComments = new ArrayList<String>();// 列注释
    List<DataMeta> list = new ArrayList<DataMeta>(); // 数据元
    // 与数据库的连接
    Connection conn = getConnection();
    PreparedStatement pStemt = null;
    String tableSql = SQL.replace("${tableName}", tableName);
    ResultSet rs = null;
    try {
      pStemt = conn.prepareStatement(tableSql);
      rs = pStemt.executeQuery("show full columns from " + tableName);

      while (rs.next()) {
        columnComments.add(rs.getString("Comment"));
      }

      // 结果集元数据
      ResultSetMetaData rsmd = pStemt.getMetaData();
      // 表列数
      int size = rsmd.getColumnCount();
      for (int i = 0; i < size; i++) {
        columnTypes.add(rsmd.getColumnTypeName(i + 1));
        columnNames.add(rsmd.getColumnName(i + 1));
      }
      // 封装到DataMeta
      for (int i = 0; i < columnNames.size(); i++) {
        DataMeta dataMeta = new DataMeta();
        columnNames.get(i);
        dataMeta.setColumnType(columnTypes.get(i));
        dataMeta.setColumnName(columnNames.get(i));
        dataMeta.setCommont(columnComments.get(i));
        list.add(dataMeta);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (rs != null) {
        try {
          rs.close();
          closeConnection(conn);
        } catch (SQLException e) {
          throw new UtilException("获取数据元 关闭结果集和jdbc连接失败", e);
        }
      }
    }
    return list;
  }
  
  public static List<DataMeta> getDataMetaByTableNameAndDBName(String tableName, String DBName){

	    List<DataMeta> list = new ArrayList<DataMeta>(); // 数据元
	    // 与数据库的连接
	    Connection conn = getConnection();
	    PreparedStatement pStemt = null;
	    
	  String sql = QUERY_DATA_META_SQL.replace("${tableName}", tableName).replace("${DBName}", DBName);
	  

//	  System.out.println("sql>"+sql);
	    ResultSet rs = null;
	    try {
	      pStemt = conn.prepareStatement(sql);
	      rs = pStemt.executeQuery();

	      while (rs.next()) {
          System.out.print(rs.getString("databaseName") + "\t");
          System.out.print(rs.getString("tableName") + "\t");
          System.out.print(rs.getString("columnName") + "\t");
          System.out.print(rs.getString("columnType") + "\t");
          System.out.print(rs.getString("columnComment") + "\t");
          System.out.print(rs.getString("characterMaximumLength") + "\t");
          System.out.print(rs.getString("numericPrecision") + "\t");
          System.out.print(rs.getString("isNullable") + "\t");
	    	  System.out.println();

          String columnType = rs.getString("columnType");
          String columnName = rs.getString("columnName");
          String columnComment = rs.getString("columnComment");
          String characterMaximumLength = rs.getString("characterMaximumLength");
          String numericPrecision = rs.getString("numericPrecision");
          String isNullable = rs.getString("isNullable");
	    	  
          DataMeta dataMeta = new DataMeta();
          
          dataMeta.setColumnType(columnType);
          dataMeta.setColumnName(columnName);
          dataMeta.setCommont(columnComment);
          
          if(!StringUtils.isNullOrEmpty(characterMaximumLength)) {
            dataMeta.setCharacterMaximumLength(Integer.valueOf(characterMaximumLength));
          }else if(!StringUtils.isNullOrEmpty(numericPrecision)) {
            dataMeta.setCharacterMaximumLength(Integer.valueOf(numericPrecision));
          }
          
          if(!StringUtils.isNullOrEmpty(isNullable) && isNullable.equals("YES")) {
            dataMeta.setIsNullable(true);
          }else {
            dataMeta.setIsNullable(false);
          }
          list.add(dataMeta);
	      }
	    }catch (Exception e) {
	        e.printStackTrace();
		}


	  return list;
  }

  public static void main(String[] args) {


    String tableName = Constant.TABLE_NAME;
    List<DataMeta> dataMetaList = getDataMetaByTableNameAndDBName(tableName, "usercenter");
    // List<String> tableNames = getTableNames();
    // System.out.println("tableNames:" + tableNames);
    for (DataMeta dataMeta : dataMetaList) {
      System.out.print("," + dataMeta.getColumnName());
    }
    /*
     * for (String tableName : tableNames) { List<DataMeta> dataMetaList = new
     * ArrayList<DataMeta>();
     * 
     * List<String> columnNames = getColumnNames(tableName); List<String> columnTypes =
     * getColumnTypes(tableName); List<String> columnComments = getColumnComments(tableName);
     * 
     * for (int i = 0; i < columnNames.size(); i++) { DataMeta dataMeta = new DataMeta();
     * dataMeta.setColumnName(columnNames.get(i)); dataMeta.setColumnType(columnTypes.get(i));
     * dataMeta.setCommont(columnComments.get(i)); dataMetaList.add(dataMeta);
     * 
     * } System.out.println("dataMetaList>>" + dataMetaList); }
     */
  }
}
