package generateplus.generater.impl;

import java.util.List;

import constant.Constant;
import generateplus.domain.DataMeta;
import generateplus.generater.AbstractGenerater;

/**
 * 增改查dlg页面 DlgJspGenerater
 * 
 * @author wangsihong@hztianque.com
 * @date 2018年12月1日 下午1:55:40
 */
public class DlgJspGenerater extends AbstractGenerater {

	@Override
	protected void setBasicData() {
		basicData.setFilePath(Constant.JSP_PATH);
		basicData.setFolderName(basicData.getDomainName());
		basicData.setSuffix(basicData.getDomainName() + "Dlg.jsp");
	}

	@Override
	protected String building() {
		StringBuilder sb = new StringBuilder();

		sb.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n");
		sb.append("\tpageEncoding=\"UTF-8\"%>\n");
		sb.append("<%@ taglib uri=\"http://java.sun.com/jsp/jstl/core\" prefix=\"c\"%>\n");
		sb.append("<div class=\"container_24\">\n");
		sb.append("\t<form id=\"maintainForm\" method=\"post\" action=\"\">\n");

		// <input>
		sb.append("\t\t<input id=\"id\" name=\"id\" type=\"hidden\" value=\"${" + basicData.getDomainName() + ".id}\" />\n");
		sb.append("\t\t<input id=\"mode\" name=\"mode\" type=\"hidden\" value=\"${mode}\" />\n");

		// 字段属性输入
		List<String> fields = basicData.getFields();
		List<DataMeta> dataMetaList = basicData.getDataMetaList();
		for (int i = 0; i < dataMetaList.size(); i++) {
			String field = fields.get(i);
			DataMeta dataMeta = dataMetaList.get(i);

			if ("id".equals(field) || "updateDate".equals(field) || "updateUser".equals(field)
					|| "createDate".equals(field) || "createUser".equals(field)) {
				continue;
			}
			
			String commont = dataMeta.getCommont();
			if (commont == null || "".equals(commont)) {
				commont = field;
			}
			
			String maxlength = "20";
			//数字的最大长度
			Integer precision = dataMeta.getNumericPrecision();
			//字符串的最大长度
			Integer characterMaximumLength = dataMeta.getCharacterMaximumLength();
			if (precision != null && precision != 0) {
				maxlength = precision.toString();
			}else if(characterMaximumLength != null && characterMaximumLength != 0) {
				maxlength = characterMaximumLength.toString();
			}
			
			if (field.endsWith("Date")) {

			} else {
				sb.append("\t\t<div class=\"grid_5 label-right\">\n");
				sb.append("\t\t\t<em class=\"form-req\">*</em> <label class=\"form-lb1\">" + commont + "：</label>\n");
				sb.append("\t\t</div>\n");
				sb.append("\t\t<div class=\"grid_7\">\n");
				sb.append("\t\t\t<input type=\"text\" name=\"" + field + "\" id=\"" + field + "\" maxlength=\""+maxlength+"\"\n");
				sb.append("\t\t\t\tvalue=\"${" + basicData.getDomainName() + "." + field + "}\"\n");
				sb.append("\t\t\t\tclass=\"text-input {required:true,messages:{required:'请输入" + commont + "'}}\">\n");
				sb.append("\t\t</div>\n");
				sb.append("\n");
			}
			
		}
		for (String field : fields) {
			if ("id".equals(field) || "updateDate".equals(field) || "updateUser".equals(field)
					|| "createDate".equals(field) || "createUser".equals(field)) {
				continue;
			}
			if (field.endsWith("Date")) {

			} else {
				sb.append("\t\t<div class=\"grid_5 label-right\">\n");
				sb.append("\t\t\t<em class=\"form-req\">*</em> <label class=\"form-lb1\">" + field + "：</label>\n");
				sb.append("\t\t</div>\n");
				sb.append("\t\t<div class=\"grid_7\">\n");
				sb.append("\t\t\t<input type=\"text\" name=\"" + field + "\" id=\"" + field + "\" maxlength=\"20\"\n");
				sb.append("\t\t\t\tvalue=\"${" + basicData.getDomainName() + "." + field + "}\"\n");
				sb.append("\t\t\t\tclass=\"text-input {required:true,messages:{required:'请输入" + field + "'}}\">\n");
				sb.append("\t\t</div>\n");
				sb.append("\n");
			}
		}

		sb.append("\t\t<div class=\"clearLine\">&nbsp;</div>\n");
		sb.append("\t</form>\n");
		sb.append("</div>\n");
		sb.append("\n");

		// ready 方法
		sb.append("<script type=\"text/javascript\">\n");
		sb.append("\t$(document).ready(\n");
		sb.append("\t\t\tfunction() {\n");
		sb.append("\t\t\t\tvar mode = $(\"#mode\").val();\n");
		sb.append("\t\t\t\tif (mode == \"add\") {\n");
		sb.append("\t\t\t\t\t$(\"#maintainForm\").attr(\"action\",\n");
		sb.append("\t\t\t\t\t\t\t\"/" + basicData.getDomainName() + "/add" + basicData.getUpperCaseDomainName() + "\");\n");
		sb.append("\t\t\t\t} else if (mode == \"update\") {\n");
		sb.append("\t\t\t\t\t$(\"#maintainForm\").attr(\"action\",\n");
		sb.append("\t\t\t\t\t\t\t\"/" + basicData.getDomainName() + "/update" + basicData.getUpperCaseDomainName() + "\");\n");
		sb.append("\t\t\t\t} else if (mode == \"view\") {\n");
		sb.append("\t\t\t\t\t$(\".form-txt\").attr(\"disabled\", true);\n");
		sb.append("\t\t\t\t\t$(\".form-checkBox\").attr(\"disabled\", true);\n");
		sb.append("\t\t\t\t}\n");
		sb.append("\t\t\t\t$(\"#maintainForm\").formValidate(\n");
		sb.append("\t\t\t\t\t\t{\n");
		sb.append("\t\t\t\t\t\t\trules : {},\n");
		sb.append("\t\t\t\t\t\t\tmessages : {},\n");
		sb.append("\t\t\t\t\t\t\tsubmitHandler : function(form) {\n");
		sb.append("\t\t\t\t\t\t\t\t$(form).ajaxSubmit(\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t{\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\tsuccess : function(data) {\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\tif (data.message != undefined) {\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\t$.messageBox({\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\tmessage : data,\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\tlevel : \"error\"\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\t});\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\treturn;\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t}\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\tif (mode == \"add\") {\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\t$.messageBox({\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\tmessage : \"新增" + basicData.getDomainCname() + "成功!\"\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\t});\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t} else if (mode == \"update\") {\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\t$.messageBox({\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\tmessage : \"修改" + basicData.getDomainCname() + "成功!\"\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\t});\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t}\n");
		sb.append("\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t$(\"#" + basicData.getDomainName() + "List\").trigger(\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"reloadGrid\");\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t$(\"#" + basicData.getDomainName() + "Dialog\").dialog(\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"close\");\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t},\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\terror : function(XMLHttpRequest,\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\ttextStatus, errorThrown) {\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t\talert(\"提交数据时发生错误\");\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t\t}\n");
		sb.append("\t\t\t\t\t\t\t\t\t\t});\n");
		sb.append("\t\t\t\t\t\t\t}\n");
		sb.append("\t\t\t\t\t\t});\n");
		sb.append("\t\t\t});\n");
		sb.append("</script>\n");

		return sb.toString();
	}

}
