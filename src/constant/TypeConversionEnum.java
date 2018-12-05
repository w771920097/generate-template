package constant;

/**
 * 类型转换枚举,mysql字段类型与java类型
 * @author wangsihong@hztianque.com   
 * @date 2018年12月1日 下午7:08:22 
 *
 */
public enum TypeConversionEnum {

	VARCHAR("VARCHAR","String"),
	CHAR("CHAR","String"),

	BLOB("BLOB","byte[]"),
	TEXT("TEXT","String"),

	INT ("INT","Integer"),
	INTEGER ("INTEGER","Long"),
	TINYINT ("TINYINT","Integer"),
	SMALLINT ("SMALLINT","Integer"),
	MEDIUMINT ("MEDIUMINT","Integer"),
	
	BIT("BIT","Boolean"),
	
	BIGINT ("BIGINT","Long"),
	FLOAT ("FLOAT","Float"),
	DOUBLE ("DOUBLE","Double"),
	DECIMAL ("DECIMAL","Double"),
	BOOLEAN ("BOOLEAN","Integer"),
	
	ID ("ID","Long"),
	
	DATE("DATE","Date"),
	TIME("TIME","Time"),
	DATETIME("DATETIME","Date"),
	TIMESTAMP("TIMESTAMP","Timestamp"),
	YEAR("YEAR","Date");
	
	
	private String javaType;
	private String mysqlType;
	
	TypeConversionEnum(String mysqlType, String javaType) {
		this.javaType = javaType;
		this.mysqlType = mysqlType;
	}

	public static String getJavaTypeByMysqlType(String MysqlType) {
		for (TypeConversionEnum typeConversionEnum : values()) {
			if (typeConversionEnum.getMysqlType().equals(MysqlType)) {
				return typeConversionEnum.javaType;
			}
		}
		return null;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getMysqlType() {
		return mysqlType;
	}

	public void setMysqlType(String mysqlType) {
		this.mysqlType = mysqlType;
	}
	
}
