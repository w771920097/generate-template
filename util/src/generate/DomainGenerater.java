package generate;

import java.util.Map;

/**
 * DomainGenerater
 * @author wangsihong@hztianque.com
 * @date 2018年10月26日 下午4:08:15 
 *
 */
public class DomainGenerater extends AbstractGenerater{
  
  public DomainGenerater(String classPath, String author, String domainName, Map<String, String>columnsMap) {
    setClassPath(classPath);
    setDoMainName(domainName);
    setAuthor(author);
    setColumnsMap(columnsMap);
  }
  
  public String building(){
    StringBuilder sb = new StringBuilder();
    sb.append("package "+getClassPath()+"."+getDomain()+";\n\n");
    sb.append("import com.tianque.base.domain.BaseDomain;\n\n");
    sb.append("/**\n");
    sb.append(" * "+getUpperCaseDomainName()+"\n");
    sb.append(" * @author "+getAuthor()+"\n");
    sb.append(" * @date "+getDate()+"\n");
    sb.append(" */\n");
    sb.append("public class "+getUpperCaseDomainName()+" extends BaseDomain {\n\n");
    sb.append("\t//TODO serialVersionUID\n\n");
    
    Map<String, String> fieldsMap = getFieldsMap();
    for (String field : fieldsMap.keySet()) {
      if ("id".equals(field) || "createDate".equals(field) || "createUser".equals(field) || "updateDate".equals(field) || "updateUser".equals(field)){
        continue;
      }
      sb.append("\t/**\n");
      sb.append("\t * \n");
      sb.append("\t */\n");
      sb.append("\tprivate "+fieldsMap.get(field)+" "+field+";\n\n");
    }


    for (String field : fieldsMap.keySet()) {
      if ("id".equals(field) || "createDate".equals(field) || "createUser".equals(field) || "updateDate".equals(field) || "updateUser".equals(field)){
        continue;
      }
      String type = fieldsMap.get(field);
      sb.append("\tpublic "+type+" get"+Util.toUpperCaseFirstOne(field)+"() {\n");
      sb.append("\t\treturn "+field+"; \n");
      sb.append("\t}\n\n");
      
      sb.append("\tpublic void set"+Util.toUpperCaseFirstOne(field)+"("+type+" "+field+") {\n");
      sb.append("\t\tthis."+field+" = "+field+";\n");
      sb.append("\t}\n\n");
      
    }
    sb.append("\t@Override\n");
    sb.append("\tpublic String toString() {\n");
    sb.append("\t\treturn super.toString()+\""+getUpperCaseDomainName()+" [\"\n");
    sb.append("\t\t\t+ \"");
    for (String field : getFields()) {
      if ("id".equals(field) || "createDate".equals(field) || "createUser".equals(field) || "updateDate".equals(field) || "updateUser".equals(field)){
        continue;
      }
      sb.append(""+field+"=\" + "+field+" + \", ");
    }
    sb.append("\"\n\t\t\t+ \"]\";\n");
    sb.append("\t}\n");
    sb.append("}\n");
    
    return sb.toString();
  }

}
