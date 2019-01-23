package generateplus.generater.impl;

import java.io.File;
import generateplus.generater.AbstractGenerater;

/**
 * ServiceImplGenerater
 * 
 * @author wangsihong@hztianque.com
 * @date 2018年10月26日 下午1:44:21
 *
 */
public class ServiceImplGenerater extends AbstractGenerater {

  @Override
  protected void setBasicData() {
    basicData.setFolderName("service" + File.separator + "impl");
    basicData.setSuffix(basicData.getUpperCaseDomainName() + "ServiceImpl.java");
  }

  @Override
  protected String building() {
    StringBuilder sb = new StringBuilder();
    sb.append("package " + basicData.getClassPath() + ".service.impl;\n\n");
    sb.append("import java.util.List;\n\n");
    sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
    sb.append("import org.springframework.stereotype.Service;\n\n");
    sb.append("import com.github.pagehelper.PageHelper;\n");
    sb.append("import com.github.pagehelper.PageInfo;\n");
    sb.append("import com.tianque.core.base.util.StringUtil;\n");
    sb.append("import com.tianque.exception.base.BusinessValidationException;\n");
    sb.append("import com.tianque.exception.base.ServiceValidationException;\n");
    sb.append("import " + basicData.getClassPath() + ".domain." + basicData.getUpperCaseDomainName()
        + ";\n");
    sb.append("import " + basicData.getClassPath() + ".mapper." + basicData.getUpperCaseDomainName()
        + "Mapper;\n");
    sb.append("import " + basicData.getClassPath() + ".service."
        + basicData.getUpperCaseDomainName() + "Service;\n");
    sb.append("import " + basicData.getClassPath() + ".vo." + basicData.getUpperCaseDomainName()
        + "VO;\n\n");
    sb.append("/**\n");
    sb.append(" * " + basicData.getUpperCaseDomainName() + "ServiceImpl\n");
    sb.append(" * @author " + basicData.getAuthor() + "\n");
    sb.append(" * @date " + basicData.getDate() + "\n");
    sb.append(" */\n");
    sb.append("@Service(\"" + basicData.getLowerCaseDomainName() + "Service\")\n");
    sb.append("public class " + basicData.getUpperCaseDomainName() + "ServiceImpl implements "
        + basicData.getUpperCaseDomainName() + "Service {\n\n");

    sb.append("\t@Autowired\n");
    sb.append("\tprivate " + basicData.getUpperCaseDomainName() + "Mapper "
        + basicData.getLowerCaseDomainName() + "Mapper;\n\n");

    // add
    sb.append("\t@Override\n");
    sb.append("\tpublic " + basicData.getUpperCaseDomainName() + " add"
        + basicData.getUpperCaseDomainName() + "(" + basicData.getUpperCaseDomainName() + " "
        + basicData.getLowerCaseDomainName() + ") {\n");
    sb.append("\t\tif (" + basicData.getLowerCaseDomainName() + " == null) {\n");
    sb.append("\t\t\tthrow new BusinessValidationException(\"新增" + basicData.getDomainCname()
        + "参数为空\");\n");
    sb.append("\t\t}\n");
    sb.append("\t\ttry {\n");
    sb.append("\t\t\t" + basicData.getLowerCaseDomainName() + "Mapper.add"
        + basicData.getUpperCaseDomainName() + "(" + basicData.getLowerCaseDomainName() + ");\n");
    sb.append("\t\t\treturn " + basicData.getLowerCaseDomainName() + ";\n");
    sb.append("\t\t} catch (Exception e) {\n");
    sb.append("\t\t\tthrow new ServiceValidationException(\"新增" + basicData.getDomainCname()
        + "出错\"+" + basicData.getLowerCaseDomainName() + ", e);\n");
    sb.append("\t\t}\n");
    sb.append("\t}\n\n");

    // update
    sb.append("\t@Override\n");
    sb.append("\tpublic " + basicData.getUpperCaseDomainName() + " update"
        + basicData.getUpperCaseDomainName() + "(" + basicData.getUpperCaseDomainName() + " "
        + basicData.getLowerCaseDomainName() + ") {\n");
    sb.append("\t\tif (" + basicData.getLowerCaseDomainName() + " == null || "
        + basicData.getLowerCaseDomainName() + ".getId() == null) {\n");
    sb.append("\t\t\tthrow new BusinessValidationException(\"更新" + basicData.getDomainCname()
        + "参数为空\");\n");
    sb.append("\t\t}\n");
    sb.append("\t\ttry {\n");
    sb.append("\t\t\t" + basicData.getLowerCaseDomainName() + "Mapper.update"
        + basicData.getUpperCaseDomainName() + "(" + basicData.getLowerCaseDomainName() + ");\n");
    sb.append("\t\t\treturn " + basicData.getLowerCaseDomainName() + ";\n");
    sb.append("\t\t} catch (Exception e) {\n");
    sb.append("\t\t\tthrow new ServiceValidationException(\"更新" + basicData.getDomainCname()
        + "出错\"+" + basicData.getLowerCaseDomainName() + ", e);\n");
    sb.append("\t\t}\n");
    sb.append("\t}\n\n");

    // deleteByIds
    sb.append("\t@Override\n");
    sb.append(
        "\tpublic Boolean delete" + basicData.getUpperCaseDomainName() + "ByIds(Long[] ids) {\n");
    sb.append("\t\tif (null == ids || ids.length == 0) {\n");
    sb.append("\t\t\tthrow new BusinessValidationException(\"删除" + basicData.getDomainCname()
        + "参数有误\");\n");
    sb.append("\t\t}\n");
    sb.append("\t\ttry {\n");
    sb.append("\t\t\tLong count = " + basicData.getLowerCaseDomainName() + "Mapper.delete"
        + basicData.getUpperCaseDomainName() + "ByIds(ids);\n");
    sb.append("\t\t\tif (count > 0) {\n");
    sb.append("\t\t\t\treturn true;\n");
    sb.append("\t\t\t} else {\n");
    sb.append("\t\t\t\treturn false;\n");
    sb.append("\t\t\t}\n");
    sb.append("\t\t} catch (Exception e) {\n");
    sb.append("\t\t\tthrow new ServiceValidationException(\"删除" + basicData.getDomainCname()
        + "出错\", e);\n");
    sb.append("\t\t}\n");
    sb.append("\t}\n\n");

    // getById
    sb.append("\t@Override\n");
    sb.append("\tpublic " + basicData.getUpperCaseDomainName() + " get"
        + basicData.getUpperCaseDomainName() + "ById(Long id) {\n");
    sb.append("\t\tif (null == id) {\n");
    sb.append("\t\t\tthrow new BusinessValidationException(\"查询" + basicData.getDomainCname()
        + "参数错误\");\n");
    sb.append("\t\t}\n");
    sb.append("\t\ttry {\n");
    sb.append("\t\t\treturn " + basicData.getLowerCaseDomainName() + "Mapper.get"
        + basicData.getUpperCaseDomainName() + "ById(id);\n");
    sb.append("\t\t} catch (Exception e) {\n");
    sb.append("\t\t\tthrow new ServiceValidationException(\"查询" + basicData.getDomainCname()
        + "出错\", e);\n");
    sb.append("\t\t}\n");
    sb.append("\t}\n\n");

    // findForPageHelper
    sb.append("\t@Override\n");
    sb.append("\tpublic PageInfo<" + basicData.getUpperCaseDomainName() + "> find"
        + basicData.getUpperCaseDomainName() + "ForPageHelper(\n");
    sb.append("\t\t\t" + basicData.getUpperCaseDomainName() + "VO "
        + basicData.getLowerCaseDomainName() + "VO) {\n");
    sb.append("\t\tif (null == " + basicData.getLowerCaseDomainName() + "VO || null == "
        + basicData.getLowerCaseDomainName() + "VO.get" + basicData.getUpperCaseDomainName()
        + "()) {\n");
    sb.append("\t\t\tthrow new BusinessValidationException(\"查询" + basicData.getDomainCname()
        + "列表参数错误\");\n");
    sb.append("\t\t}\n");
    sb.append("\t\tPageHelper.startPage(" + basicData.getLowerCaseDomainName() + "VO.getPage(),"
        + basicData.getLowerCaseDomainName() + "VO.getRows(), \n");
    sb.append("\t\t\t\tStringUtil.joinSortFieldOrder(" + basicData.getLowerCaseDomainName()
        + "VO.getSidx()," + basicData.getLowerCaseDomainName() + "VO.getSord()));\n");
    sb.append("\t\ttry {\n");
    sb.append("\t\t\tList<" + basicData.getUpperCaseDomainName() + "> list = "
        + basicData.getLowerCaseDomainName() + "Mapper.find" + basicData.getUpperCaseDomainName()
        + "ForList(" + basicData.getLowerCaseDomainName() + "VO.get"
        + basicData.getUpperCaseDomainName() + "());\n");
    sb.append("\t\t\treturn new PageInfo<" + basicData.getUpperCaseDomainName() + ">(list);\n");
    sb.append("\t\t} catch (Exception e) {\n");
    sb.append("\t\t\tthrow new ServiceValidationException(\"查询" + basicData.getDomainCname()
        + "出错\"+" + basicData.getLowerCaseDomainName() + "VO, e);\n");
    sb.append("\t\t}\n");
    sb.append("\t}\n\n");

    sb.append("}\n");
    return sb.toString();
  }

}
