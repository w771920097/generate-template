package generateplus.generater.impl;

import java.util.List;
import constant.Constant;
import generateplus.domain.DataMeta;
import generateplus.generater.AbstractGenerater;

/**
 * ListJspGenerater
 * 
 * @author wangsihong@hztianque.com
 * @date 2018年12月1日 下午2:39:18
 */
public class ListJspGenerater extends AbstractGenerater {

  @Override
  protected void setBasicData() {
    if (basicData != null) {
      basicData.setFilePath(Constant.JSP_PATH);
      basicData.setFolderName(basicData.getDomainName());
      basicData.setSuffix(basicData.getDomainName() + "List.jsp");
    }
  }

  @Override
  protected String building() {
    StringBuilder sb = new StringBuilder();

    sb.append(
        "<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>\n");
    sb.append("<%@ include file=\"/includes/baseInclude.jsp\"%>\n");
    sb.append("<%@ taglib uri=\"/permissionTag\" prefix=\"pop\"%>\n");
    sb.append("<div id=\"" + basicData.getDomainName() + "\">\n");
    sb.append("\t<div class=\"manage-area\">\n");
    sb.append("\t\t<div class=\"manage-area-title\">\n");

    // h2 标题
    sb.append("\t\t\t<h2>" + basicData.getDomainCname() + "列表</h2>\n");
    sb.append("\t\t</div>\n");
    sb.append("\t\t<div class=\"manage-area-main\">\n");
    sb.append("\t\t\t<div id=\"" + basicData.getDomainName() + "Button\">\n");
    sb.append("\t\t\t\t<div class=\"tc-15-action-panel\">\n");
    sb.append(
        "\t\t\t\t\t<div data-role=\"qc-search\" style=\"\" class=\"tc-15-search tc-15-multi-search\">\n");

    sb.append("\t\t\t\t\t\t<div class=\"iv-search\">\n");
    sb.append(
        "\t\t\t\t\t\t\t<input id=\"searchText\" data-input=\"\" type=\"text\" class=\"text-input\" placeholder=\"请输入关键词\"/>\n");
    sb.append(
        "\t\t\t\t\t\t\t<button  id=\"serach\" data-search=\"\" class=\"iv-search-btn\"></button>\n");
    sb.append("\t\t\t\t\t\t</div>\n");
    sb.append("\t\t\t\t\t</div>\n");

    // 按钮
    sb.append(
        "\t\t\t\t\t<pop:permissionTag ename=\"add" + basicData.getUpperCaseDomainName() + "\">\n");
    sb.append(
        "\t\t\t\t\t\t<button id=\"add\" type=\"button\" class=\"default-button\">新增</button>\n");
    sb.append("\t\t\t\t\t</pop:permissionTag>\n");
    sb.append("\t\t\t\t\t<pop:permissionTag ename=\"delete" + basicData.getUpperCaseDomainName()
        + "\">\n");
    sb.append(
        "\t\t\t\t\t\t<button id=\"delete\" type=\"button\" class=\"default-button\">删除</button>\n");
    sb.append("\t\t\t\t\t</pop:permissionTag>\n");
    sb.append("\t\t\t\t\t<pop:permissionTag ename=\"update" + basicData.getUpperCaseDomainName()
        + "\">\n");
    sb.append(
        "\t\t\t\t\t\t<button id=\"update\" type=\"button\" class=\"default-button\">修改</button>\n");
    sb.append("\t\t\t\t\t</pop:permissionTag>\n");
    sb.append(
        "\t\t\t\t\t<button id=\"view\" type=\"button\" class=\"default-button\">查看</button>\n");
    sb.append(
        "\t\t\t\t\t<button id=\"reload\" type=\"button\" class=\"default-button\">刷新</button>\n");
    sb.append("\t\t\t\t</div>\n");
    sb.append("\t\t\t</div>\n");
    sb.append("\t\t\t<div style=\"width: 100%;\">\n");
    sb.append("\t\t\t\t<table id=\"" + basicData.getDomainName() + "List\"> </table>\n");
    sb.append("\t\t\t\t<div id=\"" + basicData.getDomainName() + "ListPager\"></div>\n");
    sb.append("\t\t\t</div>\n");
    sb.append("\t\t\t<div id=\"" + basicData.getDomainName() + "Dialog\"></div>\n");
    sb.append("\t\t</div>\n");
    sb.append("\t</div>\n");
    sb.append("</div>\n");
    sb.append("<script type=\"text/javascript\">\n");
    sb.append("\t$(document).ready(function(){\n");

    sb.append("\t\tvar width = 400; \n");
    sb.append("\t\tvar height = 300;\n");

    sb.append("\t\tdocument.onkeydown=function(event){\n");
    sb.append("\t\t\tvar e = event || window.event || arguments.callee.caller.arguments[0];\t  \n");
    sb.append("\t\t\t if(e && e.keyCode==13){ // enter 键\n");
    sb.append("\t\t\t\t onLoad();\n");
    sb.append("\t\t\t}\n");
    sb.append("\t\t};\n");
    sb.append("\t\t$(\"#" + basicData.getDomainName() + "List\").jqGridFunction({\n");
    sb.append("\t\t\tdatatype : \"local\",\n");

    sb.append("\t\t\tcolModel : [ ");

    // jqGrid 表格
    List<String> fields = basicData.getFields();
    List<String> columns = basicData.getColumns();

    if (fields.contains("id")) {
      sb.append("{name : \"id\",index : \"id\", sortable : false,hidden : true, frozen : true},\n");
    }
    List<DataMeta> dataMetaList = basicData.getDataMetaList();
    for (int i = 0; i < columns.size(); i++) {
      DataMeta dataMeta = dataMetaList.get(i);
      String field = fields.get(i);

      String commont = dataMeta.getCommont();
      if (commont == null || "".equals(commont)) {
        commont = field;
      }

      if (!"id".equals(field)) {
        String column = columns.get(i);
        sb.append("\t\t\t\t\t\t {name : \"" + field + "\",index : \"" + column + "\",label:'"
            + commont + "',sortable : true,align : 'center'},\n");
      }
    }
    sb.append("\t\t\t],\n");

    sb.append("\t\t\tmultiselect : true,\n");
    sb.append("\t\t\theight:$(document).height()-$(\"div.manage-area-title\").height()-$(\"#"
        + basicData.getDomainName() + "Button\").height()-138,\n");
    sb.append("\t\t\tonSelectRow : function() {\n");
    sb.append("\t\t\t},\n");
    sb.append("\t\t\tondblClickRow: show" + basicData.getUpperCaseDomainName() + "\n");
    sb.append("\t\t});\n");

    // 查看 方法
    sb.append("\t\tfunction show" + basicData.getUpperCaseDomainName() + "(rowId){\n");
    sb.append("\t\t\t$('#" + basicData.getDomainName() + "Dialog').createDialog({\t  \n");
    sb.append("\t\t\t\twidth: width,\t\t\t\t\t\t\t\n");
    sb.append("\t\t\t\theight: height,\n");
    sb.append("\t\t\t\ttitle:'查看" + basicData.getDomainCname() + "',\n");
    sb.append(
        "\t\t\t\turl:'/" + basicData.getDomainName() + "/dispatch?mode=view&id='+rowId,\t \n");
    sb.append("\t\t\t\tbuttons: {\n");
    sb.append("\t\t\t\t\t\"关闭\" : function(){\n");
    sb.append("\t\t\t\t\t\t$(this).dialog(\"close\");\n");
    sb.append("\t\t\t\t   }\n");
    sb.append("\t\t\t\t}\n");
    sb.append("\t\t\t});\n");
    sb.append("\t\t}\n");
    sb.append("\t\t\t\t\n");

    // onLoad方法
    sb.append("\t\tfunction onLoad(){\n");
    sb.append("\t\t\tvar text = $('#searchText').val();\n");
    sb.append("\t\t\tif(text==\"请输入关键词\"){\n");
    sb.append("\t\t\t\ttext=\"\";\n");
    sb.append("\t\t\t}\n");
    sb.append("\t\t\tvar initParam = {\n");

    boolean hasName = false;
    for (String field : fields) {
      if ("name".equals(field)) {
        sb.append("\t\t\t\t\"" + basicData.getDomainName() + ".name\":text\n");
        hasName = true;
      }
    }
    if (!hasName) {
      sb.append("\t\t\t\t\"" + basicData.getDomainName() + ".id\":1\n");
    }

    sb.append("\t\t\t}\n");
    sb.append("\t\t\t$(\"#" + basicData.getDomainName() + "List\").setGridParam({\n");
    sb.append("\t\t\t\turl:\"/" + basicData.getDomainName() + "/find"
        + basicData.getUpperCaseDomainName() + "List\",\n");
    sb.append("\t\t\t\tdatatype: \"json\",\n");
    sb.append("\t\t\t\tpage:1\n");
    sb.append("\t\t\t});\n");
    sb.append("\t\t\t$(\"#" + basicData.getDomainName() + "List\").setPostData(initParam);\n");
    sb.append("\t\t\t$(\"#" + basicData.getDomainName() + "List\").trigger(\"reloadGrid\");\n");
    sb.append("\t\t}\n");
    sb.append("\t\t\n");
    sb.append("\t\tonLoad();\n");
    sb.append("\t\t\n");

    // 刷新按钮
    sb.append("\t\t$(\"#reload\").click(function(){\n");
    sb.append("\t\t\t$('#searchText').val(\"\");\n");
    sb.append("\t\t\tonLoad();\n");
    sb.append("\t\t});\n");
    sb.append("\t\t\n");

    // 搜索按钮
    sb.append("\t\t$('#serach').click(function(){\n");
    sb.append("\t\t\tvar text = $('#searchText').val();\n");
    sb.append("\t\t\tif(text==\"请输入用户名\"){\n");
    sb.append("\t\t\t\treturn;\n");
    sb.append("\t\t\t}\n");
    sb.append("\t\t\tonLoad();\n");
    sb.append("\t\t});\n");
    sb.append("\t\t\n");

    // 新增按钮
    sb.append("\t\t$(\"#add\").click(function(){\n");
    sb.append("\t\t\t$('#" + basicData.getDomainName() + "Dialog').createDialog({\t  \n");
    sb.append("\t\t\t\twidth: width,\t\t\t\t\t\t\t\n");
    sb.append("\t\t\t\theight: height,\n");
    sb.append("\t\t\t\ttitle:'新增" + basicData.getDomainCname() + "',\n");
    sb.append("\t\t\t\turl:'/" + basicData.getDomainName() + "/dispatch?mode=add',\t \n");
    sb.append("\t\t\t\tbuttons: {\n");
    sb.append("\t\t\t\t\t\"保存\" : function(){\n");
    sb.append("\t\t\t\t\t\t$(\"#maintainForm\").submit();\n");
    sb.append("\t\t\t\t\t},\n");
    sb.append("\t\t\t\t\t\"关闭\" : function(){\n");
    sb.append("\t\t\t\t\t\t$(this).dialog(\"close\");\n");
    sb.append("\t\t\t\t   }\n");
    sb.append("\t\t\t\t}\n");
    sb.append("\t\t\t});\n");
    sb.append("\t\t});\n");

    // 查看按钮
    sb.append("\t\t$(\"#view\").click(function(){\n");
    sb.append("\t\t\tvar selectedIds = $(\"#" + basicData.getDomainName()
        + "List\").jqGrid(\"getGridParam\", \"selarrrow\");\n");
    sb.append("\t\t\tif (selectedIds.length !== 1) {\n");
    sb.append("\t\t\t\t$.messageBox({\n");
    sb.append("\t\t\t\t\tlevel : 'warn',\n");
    sb.append("\t\t\t\t\tmessage : '能且只能选择一条数据进行操作！'\n");
    sb.append("\t\t\t\t});\n");
    sb.append("\t\t\t\treturn;\n");
    sb.append("\t\t\t}\n");
    sb.append("\t\t\tshow" + basicData.getUpperCaseDomainName() + "(selectedIds);\n");
    sb.append("\t\t});\n");
    sb.append("\t\t\n");

    // 更新按钮
    sb.append("\t\t$(\"#update\").click(function(){\n");
    sb.append("\t\t\tvar selectedIds = $(\"#" + basicData.getDomainName()
        + "List\").jqGrid(\"getGridParam\", \"selarrrow\");\n");
    sb.append("\t\t\tif (selectedIds.length !== 1) {\n");
    sb.append("\t\t\t\t$.messageBox({\n");
    sb.append("\t\t\t\t\tlevel : 'warn',\n");
    sb.append("\t\t\t\t\tmessage : '能且只能选择一条数据进行操作！'\n");
    sb.append("\t\t\t\t});\n");
    sb.append("\t\t\t\treturn;\n");
    sb.append("\t\t\t}\n");
    sb.append("\t\t\t$('#" + basicData.getDomainName() + "Dialog').createDialog({\t  \n");
    sb.append("\t\t\t\twidth: width,\t\t\t\t\t\t\t\n");
    sb.append("\t\t\t\theight: height,\n");
    sb.append("\t\t\t\ttitle:'修改" + basicData.getDomainCname() + "',\n");
    sb.append("\t\t\t\turl:'/" + basicData.getDomainName()
        + "/dispatch?mode=edit&id='+selectedIds,\t \n");
    sb.append("\t\t\t\tbuttons: {\n");
    sb.append("\t\t\t\t\t\"保存\" : function(){\n");
    sb.append("\t\t\t\t\t\t$(\"#maintainForm\").submit();\n");
    sb.append("\t\t\t\t\t},\n");
    sb.append("\t\t\t\t\t\"关闭\" : function(){\n");
    sb.append("\t\t\t\t\t\t$(this).dialog(\"close\");\n");
    sb.append("\t\t\t\t   }\n");
    sb.append("\t\t\t\t}\n");
    sb.append("\t\t\t});\n");
    sb.append("\t   });\n");
    sb.append("\t\t\n");

    // 删除按钮
    sb.append("\t\t$(\"#delete\").click(function(){\n");
    sb.append("\t\t\tif(!hasRowSelected()){\n");
    sb.append("\t\t\t\t$.messageBox({level:'warn',message:\"请选择一条数据再进行操作！\"});\n");
    sb.append("\t\t\t\treturn;\n");
    sb.append("\t\t\t}\n");
    sb.append("\t\t\t$.confirm({\n");
    sb.append("\t\t\t\ttitle:\"确认删除\",\n");
    sb.append("\t\t\t\tmessage:\"该条信息删除后,将无法恢复,您确认删除该条信息吗?\",\n");
    sb.append("\t\t\t\twidth:400,\n");
    sb.append("\t\t\t\tokFunc:function(){\n");
    sb.append("\t\t\t\t\tdeleteData();\n");
    sb.append("\t\t\t\t}\n");
    sb.append("\t\t\t});\n");
    sb.append("\t\t});\n");
    sb.append("\t\t\n");
    sb.append("\t\tfunction deleteData(){\n");
    sb.append("\t\t\t$.ajax({\n");
    sb.append("\t\t\t\turl:'/" + basicData.getDomainName() + "/delete"
        + basicData.getUpperCaseDomainName() + "ByIds',\n");
    sb.append("\t\t\t\tdata:{\n");
    sb.append("\t\t\t\t\t\"ids\":getSelectedIds()\n");
    sb.append("\t\t\t\t},\n");
    sb.append("\t\t\t\ttype: 'POST',\n");
    sb.append("\t\t\t\tsuccess:function(data){\n");
    sb.append("\t\t\t\t\tif(data != null && data){\n");
    sb.append("\t\t\t\t\t\t$.messageBox({message:\"删除成功！\"});\n");
    sb.append("\t\t\t\t\t\tonLoad();\n");
    sb.append("\t\t\t\t\t}else{\n");
    sb.append("\t\t\t\t\t\t$.messageBox({message:data});\n");
    sb.append("\t\t\t\t\t}\n");
    sb.append("\t\t\t\t}\n");
    sb.append("\t\t\t});\n");
    sb.append("\t\t}\n");
    sb.append("\t\t\n");

    // hasRowSelected
    sb.append("\t\tfunction hasRowSelected(){\n");
    sb.append("\t\t\tif(null != $(\"#" + basicData.getDomainName()
        + "List\").getGridParam(\"selrow\")){\n");
    sb.append("\t\t\t\treturn true;\n");
    sb.append("\t\t\t}\n");
    sb.append("\t\t\treturn false;\n");
    sb.append("\t\t}\n");
    sb.append("\t\t\n");

    // getSelectedIds
    sb.append("\t\tfunction getSelectedIds(){\n");
    sb.append("\t\t\treturn $(\"#" + basicData.getDomainName()
        + "List\").jqGrid(\"getGridParam\", \"selarrrow\");\n");
    sb.append("\t\t}\n");
    sb.append("\t});\n");
    sb.append("</script>\n");

    return sb.toString();
  }

}
