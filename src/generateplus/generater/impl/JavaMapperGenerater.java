package generateplus.generater.impl;

import generateplus.generater.AbstractGenerater;

/**
 * JavaMapperGenerater
 * 
 * @author wangsihong@hztianque.com
 * @date 2018年10月26日 下午1:44:04
 */
public class JavaMapperGenerater extends AbstractGenerater {

  @Override
  protected void setBasicData() {
    basicData.setFolderName("mapper");
    basicData.setSuffix(basicData.getUpperCaseDomainName() + "Mapper.java");
  }

  @Override
  protected String building() {
    StringBuilder sb = new StringBuilder();
    sb.append("package " + basicData.getClassPath() + "." + basicData.getFolderName() + ";\n\n");
    sb.append("import java.util.List;\n\n");
    sb.append("import com.tianque.core.mybatis.MyBatisMapper;\n");
    sb.append("import " + basicData.getClassPath() + ".domain." + basicData.getUpperCaseDomainName()
        + ";\n\n");
    sb.append("/**\n");
    sb.append(" * " + basicData.getUpperCaseDomainName() + "Mapper\n");
    sb.append(" * @author " + basicData.getAuthor() + "\n");
    sb.append(" * @date " + basicData.getDate() + "\n");
    sb.append(" */\n");
    sb.append("@MyBatisMapper\n");
    sb.append("public interface " + basicData.getUpperCaseDomainName() + "Mapper {\n\n");

    // add
    sb.append("\t/**\n");
    sb.append("\t * add" + basicData.getUpperCaseDomainName() + "\n");
    sb.append("\t * @param " + basicData.getLowerCaseDomainName() + "   设定文件 \n");
    sb.append("\t * @return void    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\tvoid add" + basicData.getUpperCaseDomainName() + "("
        + basicData.getUpperCaseDomainName() + " " + basicData.getLowerCaseDomainName() + ");\n\n");

    // update
    sb.append("\t/**\n");
    sb.append("\t * update" + basicData.getUpperCaseDomainName() + "\n");
    sb.append("\t * @param " + basicData.getLowerCaseDomainName() + "   设定文件 \n");
    sb.append("\t * @return void    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\tvoid update" + basicData.getUpperCaseDomainName() + "("
        + basicData.getUpperCaseDomainName() + " " + basicData.getLowerCaseDomainName() + ");\n\n");

    // deleteByIds
    sb.append("\t/**\n");
    sb.append("\t * delete" + basicData.getUpperCaseDomainName() + "ByIds\n");
    sb.append("\t * @param ids\n");
    sb.append("\t * @return Long    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\tLong delete" + basicData.getUpperCaseDomainName() + "ByIds(Long[] ids);\n\n");

    // getById
    sb.append("\t/**\n");
    sb.append("\t * get" + basicData.getUpperCaseDomainName() + "ById\n");
    sb.append("\t * @param id\n");
    sb.append("\t * @return " + basicData.getUpperCaseDomainName() + "    返回类型 \n");
    sb.append("\t */\n");
    sb.append("\t" + basicData.getUpperCaseDomainName() + " get"
        + basicData.getUpperCaseDomainName() + "ById(Long id);\n\n");

    // findForList
    sb.append("\t/**\n");
    sb.append("\t * find" + basicData.getUpperCaseDomainName() + "ForList\n");
    sb.append("\t * @param " + basicData.getLowerCaseDomainName() + "\n");
    sb.append("\t * @return List<" + basicData.getUpperCaseDomainName() + ">    返回类型\n");
    sb.append("\t */\n");
    sb.append("\tList<" + basicData.getUpperCaseDomainName() + "> find"
        + basicData.getUpperCaseDomainName() + "ForList(" + basicData.getUpperCaseDomainName() + " "
        + basicData.getLowerCaseDomainName() + ");\n\n");

    sb.append("}\n");
    return sb.toString();
  }

}
