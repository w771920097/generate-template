package generateplus.domain;

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
	 * java属性名
	 */
	private String field;

	/**
	 * java类型
	 */
	private String fieldType;

	/**
	 * 注释
	 */
	private String commont;

	/**
	 * 是否可为空
	 */
	private Boolean isNullable;

	private Integer characterMaximumLength;

	private Integer characterOctetLength;

	private Integer numericPrecision;

	private Integer numericScale;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public Boolean getIsNullable() {
		return isNullable;
	}

	public void setIsNullable(Boolean isNullable) {
		this.isNullable = isNullable;
	}

	public Integer getCharacterMaximumLength() {
		return characterMaximumLength;
	}

	public void setCharacterMaximumLength(Integer characterMaximumLength) {
		this.characterMaximumLength = characterMaximumLength;
	}

	public Integer getCharacterOctetLength() {
		return characterOctetLength;
	}

	public void setCharacterOctetLength(Integer characterOctetLength) {
		this.characterOctetLength = characterOctetLength;
	}

	public Integer getNumericPrecision() {
		return numericPrecision;
	}

	public void setNumericPrecision(Integer numericPrecision) {
		this.numericPrecision = numericPrecision;
	}

	public Integer getNumericScale() {
		return numericScale;
	}

	public void setNumericScale(Integer numericScale) {
		this.numericScale = numericScale;
	}

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
		return "DataMeta [columnName=" + columnName + ", columnType=" + columnType + ", field=" + field + ", fieldType="
				+ fieldType + ", commont=" + commont + ", isNullable=" + isNullable + ", characterMaximumLength="
				+ characterMaximumLength + ", characterOctetLength=" + characterOctetLength + ", numericPrecision="
				+ numericPrecision + ", numericScale=" + numericScale + "]";
	}

}
