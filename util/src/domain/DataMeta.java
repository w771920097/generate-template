package domain;

public class DataMeta {
  
  /**
   * �ֶ���
   */
  private String columnName;
  
  /**
   * �ֶ�����
   */
  private String columnType;
  
  /**
   * �ֶ�ע��
   */
  private String commont;

  public String getColumnName() {
    return columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  public String getColumnType() {
    return columnType;
  }

  public void setColumnType(String columnType) {
    this.columnType = columnType;
  }

  public String getCommont() {
    return commont;
  }

  public void setCommont(String commont) {
    this.commont = commont;
  }

  @Override
  public String toString() {
    return "DataMeta [columnName=" + columnName + ", columnType=" + columnType
        + ", commont=" + commont + "]";
  }
  
}
