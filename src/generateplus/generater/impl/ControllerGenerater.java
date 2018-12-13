package generateplus.generater.impl;

import constant.Constant;
import generateplus.generater.AbstractGenerater;

/**
 * ControllerGenerater
 * 
 * @author wangsihong@hztianque.com
 * @date 2018年10月26日 下午1:44:21
 */
public class ControllerGenerater extends AbstractGenerater {

	@Override
	protected void setBasicData() {
		basicData.setFolderName("controller");
		basicData.setSuffix(basicData.getUpperCaseDomainName() + "Controller.java");
	}
	@Override
	protected String building() {
		StringBuilder sb = new StringBuilder();
		sb.append("package " + basicData.getClassPath() + "." + basicData.getFolderName() + ";\n\n");

		sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		sb.append("import org.springframework.stereotype.Controller;\n");
		sb.append("import org.springframework.ui.ModelMap;\n");
		sb.append("import org.springframework.web.bind.annotation.ModelAttribute;\n");
		sb.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
		sb.append("import org.springframework.web.bind.annotation.RequestParam;\n");
		sb.append("import org.springframework.web.bind.annotation.ResponseBody;\n\n");

		sb.append("import com.tianque.base.vo.GridPage;\n");
		sb.append("import " + basicData.getClassPath() + ".constant.DialogMod;\n");
		sb.append("import " + basicData.getClassPath() + ".domain." + basicData.getUpperCaseDomainName() + ";\n");
		sb.append(
				"import " + basicData.getClassPath() + ".service." + basicData.getUpperCaseDomainName() + "Service;\n");
		sb.append("import " + basicData.getClassPath() + ".vo." + basicData.getUpperCaseDomainName() + "VO;\n\n");
		sb.append("/**\n");
		sb.append(" * " + basicData.getUpperCaseDomainName() + "Controller\n");
		sb.append(" * @author " + basicData.getAuthor() + "\n");
		sb.append(" * @date " + basicData.getDate() + "\n");
		sb.append(" */\n");
		sb.append("@Controller\n");
		sb.append("@RequestMapping(value = \"/" + basicData.getLowerCaseDomainName() + "\")\n");
		sb.append("public class " + basicData.getUpperCaseDomainName() + "Controller {\n\n");

		sb.append("\t@Autowired\n");
		sb.append("\tprivate " + basicData.getUpperCaseDomainName() + "Service " + basicData.getLowerCaseDomainName()
				+ "Service;\n\n");

		// dipatch
		sb.append("\t@RequestMapping(value = \"/dispatch\")\n");
		sb.append("\tpublic String dispatch(String mode, Long id, ModelMap modelMap) {\n");
		sb.append("\t\tmodelMap.put(DialogMode.MODE, mode);\n");
		// mode=add
		sb.append("\t\tif (DialogMode.ADD_MODE.equals(mode)) {\n");
		// mode=edit
		sb.append("\t\t}else if(DialogMode.EDIT_MODE.equals(mode) || DialogMode.VIEW_MODE.equals(mode)) {\n");
		sb.append("\t\t\tmodelMap.put(\"" + basicData.getLowerCaseDomainName() + "\", " + basicData.getLowerCaseDomainName()
						+ "Service.get" + basicData.getUpperCaseDomainName() + "ById(id));\n");
		// mode=search
		sb.append("\t\t}else if(DialogMode.SEARCH_MODE.equals(mode)) {\n");
		sb.append("\t\t\t//TODO 设置路径\n");
		sb.append("\t\t\treturn \"/base/" + basicData.getLowerCaseDomainName() + "/search" + basicData.getUpperCaseDomainName()
				+ "Dlg\";\n");
		sb.append("\t\t}\n");
		sb.append("\t\t//TODO 设置路径\n");
		sb.append("\t\treturn \"/base/" + basicData.getLowerCaseDomainName() + "/" + basicData.getLowerCaseDomainName()
				+ "Dlg\";\n");
		sb.append("\t}\n\n");

		// listPage
		sb.append("\t@PermissionFilter(ename = \"" + basicData.getLowerCaseDomainName() + "\")\n");
		sb.append("\t@RequestMapping(value = \"/listPage\")\n");
		sb.append("\tpublic String listPage() {\n");
		sb.append("\t\treturn \"/base/" + basicData.getLowerCaseDomainName() + "/" + basicData.getLowerCaseDomainName()
				+ "List\";\n");
		sb.append("\t}\n");
		sb.append("\n");

		// add
		sb.append("\t@RequestMapping(value = \"/add" + basicData.getUpperCaseDomainName() + "\")\n");
		sb.append("\t@ResponseBody\n");
		sb.append("\tpublic " + basicData.getUpperCaseDomainName() + " add" + basicData.getUpperCaseDomainName()
				+ "(@ModelAttribute " + basicData.getUpperCaseDomainName() + " " + basicData.getLowerCaseDomainName()
				+ ") {\n");
		sb.append("\t\treturn " + basicData.getLowerCaseDomainName() + "Service.add"
				+ basicData.getUpperCaseDomainName() + "(" + basicData.getLowerCaseDomainName() + ");\n");
		sb.append("\t}\n\n");

		// update
		sb.append("\t@RequestMapping(value = \"/update" + basicData.getUpperCaseDomainName() + "\")\n");
		sb.append("\t@ResponseBody\n");
		sb.append("\tpublic " + basicData.getUpperCaseDomainName() + " update" + basicData.getUpperCaseDomainName()
				+ "(@ModelAttribute " + basicData.getUpperCaseDomainName() + " " + basicData.getLowerCaseDomainName()
				+ ") {\n");
		sb.append("\t\treturn " + basicData.getLowerCaseDomainName() + "Service.update"
				+ basicData.getUpperCaseDomainName() + "(" + basicData.getLowerCaseDomainName() + ");\n");
		sb.append("\t}\n\n");

		// deleteByIds
		sb.append("\t@RequestMapping(value = \"/delete" + basicData.getUpperCaseDomainName() + "ByIds\")\n");
		sb.append("\t@ResponseBody\n");
		sb.append("\tpublic Boolean delete" + basicData.getUpperCaseDomainName()
				+ "ByIds(@RequestParam(value = \"ids[]\", required = true) Long[] ids) {\n");
		sb.append("\t\t" + basicData.getLowerCaseDomainName() + "Service.delete" + basicData.getUpperCaseDomainName()
				+ "ByIds(ids);\n");
		sb.append("\t\treturn true;\n");
		sb.append("\t}\n\n");

		// findForPageHelper
		sb.append("\t@RequestMapping(value = \"/find" + basicData.getUpperCaseDomainName() + "List\")\n");
		sb.append("\t@ResponseBody\n");
		sb.append("\tpublic GridPage<" + basicData.getUpperCaseDomainName() + "VO> find"
				+ basicData.getUpperCaseDomainName() + "List(\n");
		sb.append("\t\t\t@ModelAttribute " + basicData.getUpperCaseDomainName() + "VO "
				+ basicData.getLowerCaseDomainName() + "VO) {\n");
		sb.append("\t\tGridPage<" + basicData.getUpperCaseDomainName() + "VO> gridPage = new GridPage<"
				+ basicData.getUpperCaseDomainName() + "VO>(\n");
		sb.append("\t\t\t\t" + basicData.getLowerCaseDomainName() + "Service.find" + basicData.getUpperCaseDomainName()
				+ "ForPageHelper(" + basicData.getLowerCaseDomainName() + "VO));\n");
		sb.append("\t\treturn gridPage;\n");
		sb.append("\t}\n\n");
		sb.append("}\n");

		return sb.toString();
	}

}
