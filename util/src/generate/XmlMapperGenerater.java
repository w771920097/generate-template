package generate;

import java.util.List;
import java.util.Map;

/**
 * GenerateXmlMapper
 * @author wangsihong@hztianque.com
 * @date 2018年10月26日 下午1:44:11 
 */
public class XmlMapperGenerater extends AbstractGenerater{    
  
  public XmlMapperGenerater(String classPath, Map<String, String> columnsMap, String tableName, String domainName) {
    setColumnsMap(columnsMap);
    setTableName(tableName);
    setClassPath(classPath);
    setDoMainName(domainName);
  }
  
  public String building(){
    StringBuilder sb = new StringBuilder();
    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n\n");
    
    sb.append("<!DOCTYPE mapper  PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"  \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n\n");
    
    String namespace = String.format("%s.mapper.%sMapper", getClassPath(),getUpperCaseDomainName());
    sb.append("<mapper namespace=\"").append(namespace).append("\">\n");
    sb.append("\t<resultMap id=\"").append(getLowerCaseDomainName()).append("Result\" type=\"").append(getClassPath()).append(".domain.").append(getUpperCaseDomainName()).append("\">\n");
    for (String column : getColumns()) {
      sb.append("\t\t<result property=\""+Util.replaceUnderlineAndfirstToUpper(column)+"\" column=\""+column+"\"/>\n");
    }
    sb.append("\t</resultMap>\n\n");
    sb.append("\t<sql id=\"columns\">\n");
    sb.append("\t\t"+String.join(",", getColumns())+"\n");
    sb.append("\t</sql>\n\n");
    
    //add
    sb.append("\t<insert id=\"add"+getUpperCaseDomainName()+"\" parameterType=\""+getClassPath()+".domain."+getUpperCaseDomainName()+"\"\n");
    sb.append("\t\tuseGeneratedKeys=\"true\" keyProperty=\"id\">\n");
    sb.append("\t\tINSERT INTO "+getTableName()+"\n");
    List<String> list = getColumns();
    for(int i=0;i<list.size();i++){
      if(list.get(i).equals("id"))
          list.remove(i);
    }
    sb.append("\t\t("+String.join(",", list)+")\n");
    sb.append("\t\tVALUES\n");
    list = getFields();
    for(int i=0;i<list.size();i++){
      if(list.get(i).equals("id"))
          list.remove(i);
    }
    sb.append("\t\t(#{"+String.join("},#{", list)+"})\n");
    sb.append("\t</insert>\n\n");
    
    //getById
    sb.append("\t<select id=\"get"+getUpperCaseDomainName()+"ById\" parameterType=\"java.lang.Long\" resultMap=\""+getLowerCaseDomainName()+"Result\">\n");
    sb.append("\t\tSELECT\n");
    sb.append("\t\t<include refid=\"columns\" />\n");
    sb.append("\t\tFROM "+getTableName()+" WHERE id=#{value}\n");
    sb.append("\t</select>\n\n");
    
    //deleteByIds
    sb.append("\t<delete id=\"delete"+getUpperCaseDomainName()+"ByIds\">\n");
    sb.append("\t\tDELETE FROM "+getTableName()+" WHERE id IN\n");
    sb.append("\t\t<foreach collection=\"array\" item=\"item\" open=\"(\" separator=\",\"\n");
    sb.append("\t\t\tclose=\")\">\n");
    sb.append("\t\t\t#{item}\n");
    sb.append("\t\t</foreach>\n");
    sb.append("\t</delete>\n\n");
    
    //update
    sb.append("\t<update id=\"update"+getUpperCaseDomainName()+"\" parameterType=\""+getClassPath()+".domain."+getUpperCaseDomainName()+"\">\n");
    sb.append("\tUPDATE "+getTableName()+"\n");
    sb.append("\t\t<set>\n");
    for (int i = 0; i < getColumns().size(); i++) {
      String column = getColumns().get(i);
      if ("id".equals(column)){
        continue;
      }
      String field = getFields().get(i);
      if ("String".equals(getColumnsMap().get(column))){
        sb.append("\t\t\t<if test=\""+field+" != null and "+field+" != ''\"> \n");
      }else{
        sb.append("\t\t\t<if test=\""+field+" != null\"> \n");
      }
      sb.append("\t\t\t\t"+column+" = #{"+field+"},\n");
      sb.append("\t\t\t</if>\n");
    }
    sb.append("\t\t</set>\n");
    sb.append("\t\tWHERE id=#{id}\n");
    sb.append("\t</update>\n\n");
    
    //findForList
    sb.append("\t<select id=\"find"+getUpperCaseDomainName()+"ForList\" resultMap=\""+getLowerCaseDomainName()+"Result\"\n");
    sb.append("\t\tparameterType=\""+getClassPath()+".domain."+getUpperCaseDomainName()+"\">\n");
    sb.append("\t\tSELECT\n");
    sb.append("\t\t<include refid=\"columns\" />\n");
    sb.append("\t\tFROM "+getTableName()+"\n");
    sb.append("\t\t<where>\n");
    for (int i = 0; i < getColumns().size(); i++) {
      String column = getColumns().get(i);
      String field = getFields().get(i);
      if ("String".equals(getColumnsMap().get(column))){
        sb.append("\t\t\t<if test=\""+field+" != null and "+field+" != ''\">\n");
        sb.append("\t\t\t\tand "+column+" = #{"+field+"}\n");
        sb.append("\t\t\t</if>\n");
      }else{
        sb.append("\t\t\t<if test=\""+field+" != null \">\n");
        sb.append("\t\t\t\tand "+column+" = #{"+field+"}\n");
        sb.append("\t\t\t</if>\n");
      }
    }
    sb.append("\t\t</where>\n");
    sb.append("\t</select>\n\n");
    sb.append("</mapper>\n");
    return sb.toString();
  }
}
