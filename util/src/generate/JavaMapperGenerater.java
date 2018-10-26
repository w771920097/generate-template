package generate;



/**
 * JavaMapperGenerater
 * @author wangsihong@hztianque.com
 * @date 2018年10月26日 下午1:44:04 
 *
 */
public class JavaMapperGenerater extends AbstractGenerater{

  public JavaMapperGenerater(String domainName, String classPath, String author) {
    setDoMainName(domainName);
    setClassPath(classPath);
    setAuthor(author);
  }
  
  public String building(){
    StringBuilder sb = new StringBuilder();
    sb.append("package "+getClassPath()+"."+getMapper()+";\n\n");
    sb.append("import java.util.List;\n\n");
    sb.append("import com.tianque.core.mybatis.MyBatisMapper;\n");
    sb.append("import "+getClassPath()+"."+getDomain()+"."+getUpperCaseDomainName()+";\n\n");
    sb.append("/**\n");
    sb.append(" * "+getUpperCaseDomainName()+"Mapper\n");
    sb.append(" * @author "+getAuthor()+"\n");
    sb.append(" * @date "+getDate()+"\n");
    sb.append(" */\n");
    sb.append("@MyBatisMapper\n");
    sb.append("public interface "+getUpperCaseDomainName()+"Mapper {\n\n");
    
    //add
    sb.append("\t/**\n");
    sb.append("\t * add"+getUpperCaseDomainName()+"\n");
    sb.append("\t * @param "+getLowerCaseDomainName()+"   设定文件 \n");
    sb.append("\t * @return void    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\tvoid add"+getUpperCaseDomainName()+"("+getUpperCaseDomainName()+" "+getLowerCaseDomainName()+");\n\n");
    
    //update
    sb.append("\t/**\n");
    sb.append("\t * update"+getUpperCaseDomainName()+"\n");
    sb.append("\t * @param "+getLowerCaseDomainName()+"   设定文件 \n");
    sb.append("\t * @return void    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\tvoid update"+getUpperCaseDomainName()+"("+getUpperCaseDomainName()+" "+getLowerCaseDomainName()+");\n\n");
    
    //deleteByIds
    sb.append("\t/**\n");
    sb.append("\t * delete"+getUpperCaseDomainName()+"ByIds\n");
    sb.append("\t * @param ids\n");
    sb.append("\t * @return Long    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\tLong delete"+getUpperCaseDomainName()+"ByIds(Long[] ids);\n\n");
    
    //getById
    sb.append("\t/**\n");
    sb.append("\t * get"+getUpperCaseDomainName()+"ById\n");
    sb.append("\t * @param id\n");
    sb.append("\t * @return "+getUpperCaseDomainName()+"    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\t"+getUpperCaseDomainName()+" get"+getUpperCaseDomainName()+"ById(Long id);\n\n");
    
    //findForList
    sb.append("\t/**\n");
    sb.append("\t * find"+getUpperCaseDomainName()+"ForList\n");
    sb.append("\t * @param "+getLowerCaseDomainName()+"\n");
    sb.append("\t * @return List<"+getUpperCaseDomainName()+">    返回类型\n");
    sb.append("\t */\n");
    sb.append("\tList<"+getUpperCaseDomainName()+"> find"+getUpperCaseDomainName()+"ForList("+getUpperCaseDomainName()+" "+getLowerCaseDomainName()+");\n\n");

    sb.append("}\n");
    return sb.toString();
  }

}
