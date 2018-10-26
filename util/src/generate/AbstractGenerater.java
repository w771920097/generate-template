package generate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AbstractGenerater
 * @author wangsihong@hztianque.com
 * @date 2018年10月26日 下午1:43:48 
 *
 */
public abstract class AbstractGenerater implements Generater{

  private String classPath;
  private String doMainName;
  private String lowerCaseDomainName;
  private String upperCaseDomainName;
  private List<String> columns;
  private List<String> fields;
  private List<String> upperCaseFields;
  private Map<String, String> columnsMap;
  private Map<String, String> fieldsMap;
  private String tableName;
  private String author;
  private String date;
  private String mapper = "mapper";
  private String domain = "domain";
  private String vo = "vo";
  private String service = "service";
  private String serviceImpl = "serviceImpl";
  
  public abstract String building();
  
  public String build(){
    if (null != this.doMainName){
      this.lowerCaseDomainName = Util.toLowerCaseFirstOne(this.doMainName);
      this.upperCaseDomainName = Util.toUpperCaseFirstOne(this.doMainName);
    }
    if (null != this.columnsMap){
      this.columns = new ArrayList<String>();
      this.fieldsMap = new HashMap<String, String>();
      this.fields = new ArrayList<String>();
      this.upperCaseFields = new ArrayList<String>(); 
      for (String column : columnsMap.keySet()) {
        String field = Util.replaceUnderlineAndfirstToUpper(column);
        columns.add(column);
        fields.add(field);
        upperCaseFields.add(Util.toUpperCaseFirstOne(field));
        fieldsMap.put(field, columnsMap.get(column));
      }
    }else if (null != this.columns){
      fields = new ArrayList<String>();
      for (String column : columns) {
        fields.add(Util.replaceUnderlineAndfirstToUpper(column));
      }
    }
    this.date = getDateString(new Date());
    return building();
  }
  
  private String getDateString(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
    return sdf.format(date);
  }
  
  public String getClassPath() {
    return classPath;
  }

  public void setClassPath(String classPath) {
    this.classPath = classPath;
  }

  public String getDoMainName() {
    return doMainName;
  }

  public void setDoMainName(String doMainName) {
    this.doMainName = doMainName;
  }

  public String getLowerCaseDomainName() {
    return lowerCaseDomainName;
  }

  public void setLowerCaseDomainName(String lowerCaseDomainName) {
    this.lowerCaseDomainName = lowerCaseDomainName;
  }

  public String getUpperCaseDomainName() {
    return upperCaseDomainName;
  }

  public void setUpperCaseDomainName(String upperCaseDomainName) {
    this.upperCaseDomainName = upperCaseDomainName;
  }

  public List<String> getColumns() {
    return columns;
  }

  public List<String> getUpperCaseFields() {
    return upperCaseFields;
  }

  public void setUpperCaseFields(List<String> upperCaseFields) {
    this.upperCaseFields = upperCaseFields;
  }

  public void setColumns(List<String> columns) {
    this.columns = columns;
  }

  public List<String> getFields() {
    return fields;
  }

  public void setFields(List<String> fields) {
    this.fields = fields;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getMapper() {
    return mapper;
  }

  public void setMapper(String mapper) {
    this.mapper = mapper;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getVo() {
    return vo;
  }

  public void setVo(String vo) {
    this.vo = vo;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  public String getServiceImpl() {
    return serviceImpl;
  }

  public void setServiceImpl(String serviceImpl) {
    this.serviceImpl = serviceImpl;
  }

  public Map<String, String> getColumnsMap() {
    return columnsMap;
  }

  public void setColumnsMap(Map<String, String> columnsMap) {
    this.columnsMap = columnsMap;
  }

  public Map<String, String> getFieldsMap() {
    return fieldsMap;
  }

  public void setFieldsMap(Map<String, String> fieldsMap) {
    this.fieldsMap = fieldsMap;
  }

  @Override
  public String toString() {
    return "AbstractGenerater [classPath=" + classPath + ", doMainName="
        + doMainName + ", lowerCaseDomainName=" + lowerCaseDomainName
        + ", upperCaseDomainName=" + upperCaseDomainName + ", columns="
        + columns + ", fields=" + fields + ", UpperCaseFields="
        + upperCaseFields + ", columnsMap=" + columnsMap + ", fieldsMap="
        + fieldsMap + ", tableName=" + tableName + ", author=" + author
        + ", date=" + date + ", mapper=" + mapper + ", domain=" + domain
        + ", vo=" + vo + ", service=" + service + ", serviceImpl="
        + serviceImpl + "]";
  }
}
