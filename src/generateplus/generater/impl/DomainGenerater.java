package generateplus.generater.impl;

import java.util.List;
import generateplus.domain.DataMeta;
import generateplus.generater.AbstractGenerater;
import util.CommentUtil;

/**
 * DomainGenerater
 * 
 * @author wangsihong@hztianque.com
 * @date 2018年10月26日 下午1:08:15
 */
public class DomainGenerater extends AbstractGenerater {

  @Override
  protected void setBasicData() {
    basicData.setFolderName("domain");
    basicData.setSuffix(basicData.getUpperCaseDomainName() + ".java");
  }

  @Override
  public String building() {
    StringBuilder sb = new StringBuilder();
    sb.append("package " + basicData.getClassPath() + "." + basicData.getFolderName() + ";\n\n");
    sb.append("import com.tianque.base.domain.BaseDomain;\n\n");
    sb.append("/**\n");
    sb.append(" * " + basicData.getUpperCaseDomainName() + "\n");
    sb.append(" * @author " + basicData.getAuthor() + "\n");
    sb.append(" * @date " + basicData.getDate() + "\n");
    sb.append(" */\n");
    sb.append("public class " + basicData.getUpperCaseDomainName() + " extends BaseDomain {\n\n");
    sb.append("\t//TODO serialVersionUID\n\n");

    List<DataMeta> dataMetaList = basicData.getDataMetaList();
    for (int i = 0; i < dataMetaList.size(); i++) {
      DataMeta dataMeta = dataMetaList.get(i);
      String field = basicData.getFields().get(i);
      String fieldType = basicData.getFieldTypes().get(i);


      if ("id".equals(field) || "createDate".equals(field) || "createUser".equals(field)
          || "updateDate".equals(field) || "updateUser".equals(field)) {
        continue;
      }
      sb.append("\t/**\n");
      sb.append("\t * " + dataMeta.getCommont() + "\n");
      sb.append("\t */\n");
      sb.append("\tprivate " + fieldType + " " + field + ";\n\n");
    }

    for (int i = 0; i < basicData.getFields().size(); i++) {
      String field = basicData.getFields().get(i);
      String type = basicData.getFieldTypes().get(i);

      if ("id".equals(field) || "createDate".equals(field) || "createUser".equals(field)
          || "updateDate".equals(field) || "updateUser".equals(field)) {
        continue;
      }
      sb.append("\tpublic " + type + " get" + CommentUtil.toUpperCaseFirstOne(field) + "() {\n");
      sb.append("\t\treturn " + field + "; \n");
      sb.append("\t}\n\n");

      sb.append("\tpublic void set" + CommentUtil.toUpperCaseFirstOne(field) + "(" + type + " "
          + field + ") {\n");
      sb.append("\t\tthis." + field + " = " + field + ";\n");
      sb.append("\t}\n\n");

    }

    sb.append("\t@Override\n");
    sb.append("\tpublic String toString() {\n");
    sb.append("\t\treturn super.toString()+\"" + basicData.getUpperCaseDomainName() + " [\"\n");
    sb.append("\t\t\t+ \"");


    for (String field : basicData.getFields()) {
      if ("id".equals(field) || "createDate".equals(field) || "createUser".equals(field)
          || "updateDate".equals(field) || "updateUser".equals(field)) {
        continue;
      }
      sb.append("" + field + "=\" + " + field + " + \", ");
    }
    sb.append("\"\n\t\t\t+ \"]\";\n");
    sb.append("\t}\n");
    sb.append("}\n");

    return sb.toString();
  }

}
