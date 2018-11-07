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

import com.sun.xml.internal.ws.util.UtilException;

import domain.DataMeta;

public class DatabaseUtil {

    private static final String URL = PropertiesLoader.get("jdbc.url");
    private static final String USERNAME = PropertiesLoader.get("jdbc.username");
    private static final String PASSWORD = PropertiesLoader.get("jdbc.password");

    private static final String SQL = "SELECT * FROM ${tableName} where 1=2";// ���ݿ����

    /**
     * ��ȡ���ݿ�����
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
     * �ر����ݿ�����
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new UtilException("close connection failure", e);
            }
        }
    }

    /**
     * ��ȡ���ݿ��µ����б���
     */
    public static List<String> getTableNames() {
        List<String> tableNames = new ArrayList<String>();
        Connection conn = getConnection();
        ResultSet rs = null;
        try {
            //��ȡ���ݿ��Ԫ����
            DatabaseMetaData db = conn.getMetaData();
            //��Ԫ�����л�ȡ�����еı���
            rs = db.getTables(null, null, null, new String[] { "TABLE" });
            while(rs.next()) {
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
     * ��ȡ���������ֶ�����
     * @param tableName ����
     * @return
     */
    public static List<String> getColumnNames(String tableName) {
        List<String> columnNames = new ArrayList<String>();
        //�����ݿ������
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL.replace("${tableName}", tableName);
        try {
            pStemt = conn.prepareStatement(tableSql);
            //�����Ԫ����
            ResultSetMetaData rsmd = pStemt.getMetaData();
            //������
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
                    throw new UtilException("getColumnNames close pstem and connection failure", e);
                }
            }
        }
        return columnNames;
    }

    /**
     * ��ȡ���������ֶ�����
     * @param tableName
     * @return
     */
    public static List<String> getColumnTypes(String tableName) {
        List<String> columnTypes = new ArrayList<String>();
        //�����ݿ������
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL.replace("${tableName}", tableName);
        try {
            pStemt = conn.prepareStatement(tableSql);
            //�����Ԫ����
            ResultSetMetaData rsmd = pStemt.getMetaData();
            //������
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
                    throw new UtilException("getColumnTypes close pstem and connection failure", e);
                }
            }
        }
        return columnTypes;
    }

    /**
     * ��ȡ�����ֶε�����ע��
     * @param tableName
     * @return
     */
    public static List<String> getColumnComments(String tableName) {
//        List<String> columnTypes = new ArrayList<String>();
        //�����ݿ������
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL.replace("${tableName}", tableName);
        List<String> columnComments = new ArrayList<String>();//����ע�ͼ���
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
                    throw new UtilException("getColumnComments close ResultSet and connection failure", e);
                }
            }
        }
        return columnComments;
    }
    public static void main(String[] args) {
        List<String> tableNames = getTableNames();
        System.out.println("tableNames:" + tableNames);
        for (String tableName : tableNames) {
          List<DataMeta> dataMetaList = new ArrayList<DataMeta>();
          
          List<String> columnNames = getColumnNames(tableName);
          List<String> columnTypes = getColumnTypes(tableName);
          List<String> columnComments = getColumnComments(tableName);
          
          for (int i = 0; i < columnNames.size(); i++) {
            DataMeta dataMeta = new DataMeta();
            dataMeta.setColumnName(columnNames.get(i));
            dataMeta.setColumnType(columnTypes.get(i));
            dataMeta.setCommont(columnComments.get(i));
            dataMetaList.add(dataMeta);
            
          }
          System.out.println("dataMetaList>>" + dataMetaList);
        }
    }
}
