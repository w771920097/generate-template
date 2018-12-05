package generateplus.domain;

import java.util.ArrayList;
import java.util.List;

public class BasicData {

	private String filePath;
	private String classPath;
	private String author;
	private String tableName;

	private String date;
	
	/**
	 * 文件夹名
	 */
	private String folderName;
	
	/**
	 * 后缀
	 */
	private String suffix;
	/**
	 * 首字母小写实体类名
	 */
	private String lowerCaseDomainName;
	/**
	 * 首字母大写实体类名
	 */
	private String upperCaseDomainName;
	/**
	 * 实体类名
	 */
	private String domainName;
	/**
	 * 实体类中文名
	 */
	private String domainCname;
	
	private List<DataMeta> dataMetaList;
	private List<String> columns = new ArrayList<String>();
	private List<String> fields = new ArrayList<String>();
	private List<String> fieldTypes = new ArrayList<String>();
	private List<String> upperCaseFields = new ArrayList<String>();
	
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getClassPath() {
		return classPath;
	}
	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getDomainCname() {
		return domainCname;
	}
	public void setDomainCname(String domainCname) {
		this.domainCname = domainCname;
	}
	public List<DataMeta> getDataMetaList() {
		return dataMetaList;
	}
	public void setDataMetaList(List<DataMeta> dataMetaList) {
		this.dataMetaList = dataMetaList;
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
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	public List<String> getFields() {
		return fields;
	}
	public void setFields(List<String> fields) {
		this.fields = fields;
	}
	public List<String> getUpperCaseFields() {
		return upperCaseFields;
	}
	public void setUpperCaseFields(List<String> upperCaseFields) {
		this.upperCaseFields = upperCaseFields;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public List<String> getFieldTypes() {
		return fieldTypes;
	}
	public void setFieldTypes(List<String> fieldTypes) {
		this.fieldTypes = fieldTypes;
	}
	@Override
	public String toString() {
		return "BasicData [filePath=" + filePath + ", classPath=" + classPath + ", author=" + author + ", tableName="
				+ tableName + ", date=" + date + ", folderName=" + folderName + ", suffix=" + suffix
				+ ", lowerCaseDomainName=" + lowerCaseDomainName + ", upperCaseDomainName=" + upperCaseDomainName
				+ ", domainName=" + domainName + ", domainCname=" + domainCname + ", dataMetaList=" + dataMetaList
				+ ", columns=" + columns + ", fields=" + fields + ", fieldTypes=" + fieldTypes + ", upperCaseFields="
				+ upperCaseFields + "]";
	}
	@Override
	public BasicData clone() throws CloneNotSupportedException {
		BasicData basicData = new BasicData();
		basicData.setAuthor(author);
		basicData.setClassPath(classPath);
		basicData.setColumns(columns);
		basicData.setDataMetaList(dataMetaList);
		basicData.setDate(date);
		basicData.setDomainCname(domainCname);
		basicData.setDomainName(domainName);
		basicData.setFields(fields);
		basicData.setFieldTypes(fieldTypes);
		basicData.setFilePath(filePath);
		basicData.setFolderName(folderName);
		basicData.setLowerCaseDomainName(lowerCaseDomainName);
		basicData.setSuffix(suffix);
		basicData.setTableName(tableName);
		basicData.setUpperCaseDomainName(upperCaseDomainName);
		basicData.setUpperCaseFields(upperCaseFields);
		return basicData;
	}
	
}
