package generateplus.generater.impl;

import generateplus.generater.AbstractGenerater;

/**
 * VoGenerater
 * 
 * @author wangsihong@hztianque.com
 * @date 2018年10月26日 下午1:44:21
 */
public class VOGenerater extends AbstractGenerater {

  @Override
  protected void setBasicData() {
    basicData.setFolderName("vo");
    basicData.setSuffix(basicData.getUpperCaseDomainName() + "VO.java");
  }

  @Override
  protected String building() {
    StringBuilder sb = new StringBuilder();
    sb.append("package " + basicData.getClassPath() + ".vo;\n\n");

    sb.append("import com.tianque.base.vo.BaseVO;\n");
    sb.append("import " + basicData.getClassPath() + ".domain." + basicData.getUpperCaseDomainName()
        + ";\n\n");

    sb.append("/**\n");
    sb.append(" * " + basicData.getUpperCaseDomainName() + "VO\n");
    sb.append(" * @author " + basicData.getAuthor() + "\n");
    sb.append(" * @date " + basicData.getDate() + " \n");
    sb.append(" */\n");
    sb.append("public class " + basicData.getUpperCaseDomainName() + "VO extends BaseVO{\n\n");
    sb.append("\t//TODO serialVersionUID\n\n");

    sb.append("\tprivate " + basicData.getUpperCaseDomainName() + " "
        + basicData.getLowerCaseDomainName() + ";\n\n");
    sb.append("\tpublic " + basicData.getUpperCaseDomainName() + " get"
        + basicData.getUpperCaseDomainName() + "() {\n");
    sb.append("\t\treturn " + basicData.getLowerCaseDomainName() + ";\n");
    sb.append("\t}\n\n");

    sb.append("\tpublic void set" + basicData.getUpperCaseDomainName() + "("
        + basicData.getUpperCaseDomainName() + " " + basicData.getLowerCaseDomainName() + ") {\n");
    sb.append("\t\tthis." + basicData.getLowerCaseDomainName() + " = "
        + basicData.getLowerCaseDomainName() + ";\n");
    sb.append("\t}\n\n");

    sb.append("\t@Override\n");
    sb.append("\tpublic String toString() {\n");
    sb.append("\t\treturn super.toString() + \"" + basicData.getUpperCaseDomainName() + "VO ["
        + basicData.getLowerCaseDomainName() + "=\" + " + basicData.getLowerCaseDomainName()
        + " + \"]\";\n");
    sb.append("\t}\n");
    sb.append("}\n");
    return sb.toString();
  }

}
