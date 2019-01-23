package generateplus.generater.impl;

import generateplus.generater.AbstractGenerater;
/**
 * BaseJavaMapperGenerater 
 * @author wangsihong@hztianque.com   
 * @date 2019年1月23日 下午5:49:01 
 */
public class BaseJavaMapperGenerater  extends AbstractGenerater {

  @Override
  protected void setBasicData() {
    basicData.setFolderName("mapper");
    basicData.setSuffix(basicData.getUpperCaseDomainName() + "Mapper.java");
  }

  @Override
  protected String building() {
    StringBuilder sb = new StringBuilder();

    sb.append("package " + basicData.getClassPath() + "." + basicData.getFolderName() + ";\n\n");
    sb.append("\n");
    sb.append("import " + basicData.getClassPath() + ".domain." + basicData.getUpperCaseDomainName()
    + ";\n\n");
    sb.append("import " + basicData.getClassPath() + ".vo." + basicData.getUpperCaseDomainName()
    + "VO;\n\n");
    sb.append("import com.tianque.core.base.mapper.BaseMapper;\n");
    sb.append("import com.tianque.core.mybatis.MyBatisMapper;\n");
    sb.append("\n");

    sb.append("/**\n");
    sb.append(" * " + basicData.getUpperCaseDomainName() + "Mapper\n");
    sb.append(" * @author " + basicData.getAuthor() + "\n");
    sb.append(" * @date " + basicData.getDate() + "\n");
    sb.append(" */\n");
    sb.append("@MyBatisMapper\n");
    sb.append("public interface " + basicData.getUpperCaseDomainName() + "Mapper {\n\n");
    sb.append("\textends BaseMapper<" + basicData.getUpperCaseDomainName() + ", " + basicData.getUpperCaseDomainName() + "VO> {\n");
    sb.append("\n");
    sb.append("}\n");

    return sb.toString();
  }

}
