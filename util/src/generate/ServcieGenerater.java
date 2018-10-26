package generate;

/**
 * ServcieGenerater
 * @author wangsihong@hztianque.com
 * @date 2018年10月26日 下午1:43:41 
 *
 */
public class ServcieGenerater extends AbstractGenerater{
  
  public ServcieGenerater(String classPath, String author, String domainName) {
    setClassPath(classPath);
    setAuthor(author);
    setDoMainName(domainName);
  }

  @Override
  public String building() {
    StringBuilder sb = new StringBuilder();
    sb.append("package "+getClassPath()+"."+getService()+";\n\n");
    sb.append("import com.github.pagehelper.PageInfo;\n");
    sb.append("import "+getClassPath()+"."+getDomain()+"."+getUpperCaseDomainName()+";\n");
    sb.append("import "+getClassPath()+"."+getVo()+"."+getUpperCaseDomainName()+"VO;\n\n");
    sb.append("/**\n");
    sb.append(" * "+getUpperCaseDomainName()+"Service\n");
    sb.append(" * @author "+getAuthor()+"\n");
    sb.append(" * @date "+getDate()+"\n");
    sb.append(" */\n");
    sb.append("public interface "+getUpperCaseDomainName()+"Service {\n\n");
    
    //add
    sb.append("\t/**\n");
    sb.append("\t * add"+getUpperCaseDomainName()+"\n");
    sb.append("\t * @param "+getLowerCaseDomainName()+"\n");
    sb.append("\t * @return "+getUpperCaseDomainName()+"    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\t"+getUpperCaseDomainName()+" add"+getUpperCaseDomainName()+"("+getUpperCaseDomainName()+" "+getLowerCaseDomainName()+");\n\n");
    
    //update
    sb.append("\t/**\n");
    sb.append("\t * update"+getUpperCaseDomainName()+"\n");
    sb.append("\t * @param "+getLowerCaseDomainName()+"\n");
    sb.append("\t * @return "+getUpperCaseDomainName()+"    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\t"+getUpperCaseDomainName()+" update"+getUpperCaseDomainName()+"("+getUpperCaseDomainName()+" "+getLowerCaseDomainName()+");\n\n");
    
    //deleteByIds
    sb.append("\t/**\n");
    sb.append("\t * delete"+getUpperCaseDomainName()+"ByIds\n");
    sb.append("\t * @param ids\n");
    sb.append("\t * @return Boolean    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\tBoolean delete"+getUpperCaseDomainName()+"ByIds(Long[] ids);\n\n");
    
    //getById
    sb.append("\t/**\n");
    sb.append("\t * get"+getUpperCaseDomainName()+"ById\n");
    sb.append("\t * @param id\n");
    sb.append("\t * @return "+getUpperCaseDomainName()+"    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\t"+getUpperCaseDomainName()+" get"+getUpperCaseDomainName()+"ById(Long id);  \n\n");
    
    //findForPageHelper
    sb.append("\t/**\n");
    sb.append("\t * find"+getUpperCaseDomainName()+"ForPageHelper\n");
    sb.append("\t * @param "+getLowerCaseDomainName()+"VO\n");
    sb.append("\t * @return PageInfo<"+getUpperCaseDomainName()+">    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\tPageInfo<"+getUpperCaseDomainName()+"> find"+getUpperCaseDomainName()+"ForPageHelper("+getUpperCaseDomainName()+"VO "+getLowerCaseDomainName()+"VO);\n\n");
    
    sb.append("}\n");
    return sb.toString();
  }
  

}
