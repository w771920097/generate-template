package domain;

public class DataMeta {
  
  /**
   * 字段名
   */
  private String columnName;
  
  /**
   * 字段类型
   */
  private String columnType;
  
  /**
   * 注释
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
