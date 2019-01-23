package generateplus.generater.impl;

import generateplus.generater.AbstractGenerater;

/**
 * BaseServiceGenerater 
 * @author wangsihong@hztianque.com   
 * @date 2019年1月23日 下午5:48:46 
 */
public class BaseServiceGenerater   extends AbstractGenerater {

  @Override
  protected void setBasicData() {
    basicData.setFolderName("service");
    basicData.setSuffix(basicData.getUpperCaseDomainName() + "Service.java");
  }

  @Override
  protected String building() {
    StringBuilder sb = new StringBuilder();

    sb.append("package " + basicData.getClassPath() + "." + basicData.getFolderName() + ";\n\n");
    
    sb.append("import com.github.pagehelper.PageInfo;\n");
    sb.append("import " + basicData.getClassPath() + ".domain." + basicData.getUpperCaseDomainName()
    + ";\n");
    sb.append("import " + basicData.getClassPath() + ".vo." + basicData.getUpperCaseDomainName()
    + "VO;\n\n");

    sb.append("/**\n");
    sb.append(" * " + basicData.getUpperCaseDomainName() + "Service\n");
    sb.append(" * @author " + basicData.getAuthor() + "\n");
    sb.append(" * @date " + basicData.getDate() + "\n");
    sb.append(" */\n");
    sb.append("public interface " + basicData.getUpperCaseDomainName() + "Service {\n\n");

    // add
    sb.append("\t/**\n");
    sb.append("\t * add" + basicData.getUpperCaseDomainName() + "\n");
    sb.append("\t * @param " + basicData.getLowerCaseDomainName() + "\n");
    sb.append("\t * @return " + basicData.getUpperCaseDomainName() + "    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\t" + basicData.getUpperCaseDomainName() + " add"
        + basicData.getUpperCaseDomainName() + "(" + basicData.getUpperCaseDomainName() + " "
        + basicData.getLowerCaseDomainName() + ");\n\n");


    // update
    sb.append("\t/**\n");
    sb.append("\t * update" + basicData.getUpperCaseDomainName() + "\n");
    sb.append("\t * @param " + basicData.getLowerCaseDomainName() + "\n");
    sb.append("\t * @return " + basicData.getUpperCaseDomainName() + "    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\t" + basicData.getUpperCaseDomainName() + " update"
        + basicData.getUpperCaseDomainName() + "(" + basicData.getUpperCaseDomainName() + " "
        + basicData.getLowerCaseDomainName() + ");\n\n");

    // getById
    sb.append("\t/**\n");
    sb.append("\t * get" + basicData.getUpperCaseDomainName() + "ById\n");
    sb.append("\t * @param id\n");
    sb.append("\t * @return " + basicData.getUpperCaseDomainName() + "    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\t" + basicData.getUpperCaseDomainName() + " get"
        + basicData.getUpperCaseDomainName() + "ById(Long id);  \n\n");

    // deleteByIds
    sb.append("\t/**\n");
    sb.append("\t * delete" + basicData.getUpperCaseDomainName() + "\n");
    sb.append("\t * @param ids\n");
    sb.append("\t * @return Boolean    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\tBoolean delete" + basicData.getUpperCaseDomainName() + "(Long... ids);\n\n");

    // findForPageHelper
    sb.append("\t/**\n");
    sb.append("\t * find" + basicData.getUpperCaseDomainName() + "ForPageHelper\n");
    sb.append("\t * @param " + basicData.getLowerCaseDomainName() + "VO\n");
    sb.append("\t * @return PageInfo<" + basicData.getUpperCaseDomainName() + ">    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\tPageInfo<" + basicData.getUpperCaseDomainName() + "> find"
        + basicData.getUpperCaseDomainName() + "ForPageHelper(" + basicData.getUpperCaseDomainName()
        + "VO " + basicData.getLowerCaseDomainName() + "VO);\n\n");

    sb.append("}\n");
    
    return sb.toString();
  }

}
