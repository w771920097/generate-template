package generate;


/**
 * VoGenerater
 * @author wangsihong@hztianque.com
 * @date 2018年10月26日 下午3:52:18 
 */
public class VoGenerater extends AbstractGenerater{
  
  public VoGenerater(String classPath, String domainName, String author) {
    setClassPath(classPath);
    setDoMainName(domainName);
    setAuthor(author);
  }

  @Override
  public String building() {
    StringBuilder sb = new StringBuilder();
    sb.append("package "+getClassPath()+".vo;\n\n");
    
    sb.append("import com.tianque.base.vo.BaseVO;\n");
    sb.append("import "+getClassPath()+"."+getDomain()+"."+getUpperCaseDomainName()+";\n\n");

    sb.append("/**\n");
    sb.append(" * "+getUpperCaseDomainName()+"VO\n");
    sb.append(" * @author "+getAuthor()+"\n");
    sb.append(" * @date "+getDate()+" \n");
    sb.append(" */\n");
    sb.append("public class "+getUpperCaseDomainName()+"VO extends BaseVO{\n\n");
    sb.append("\t//TODO serialVersionUID\n\n");
    
    sb.append("\tprivate "+getUpperCaseDomainName()+" "+getLowerCaseDomainName()+";\n\n");
    sb.append("\tpublic "+getUpperCaseDomainName()+" get"+getUpperCaseDomainName()+"() {\n");
    sb.append("\t\treturn "+getLowerCaseDomainName()+";\n");
    sb.append("\t}\n\n");
    
    sb.append("\tpublic void set"+getUpperCaseDomainName()+"("+getUpperCaseDomainName()+" "+getLowerCaseDomainName()+") {\n");
    sb.append("\t\tthis."+getLowerCaseDomainName()+" = "+getLowerCaseDomainName()+";\n");
    sb.append("\t}\n\n");
    
    
    sb.append("\t@Override\n");
    sb.append("\tpublic String toString() {\n");
    sb.append("\t\treturn super.toString() + \""+getUpperCaseDomainName()+"VO ["+getLowerCaseDomainName()+"=\" + "+getLowerCaseDomainName()+" + \"]\";\n");
    sb.append("\t}\n");
    sb.append("}\n");
    return sb.toString();
  }

}
