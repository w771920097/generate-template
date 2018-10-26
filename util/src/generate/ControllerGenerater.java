package generate;





public class ControllerGenerater extends AbstractGenerater{

  public ControllerGenerater(String classPath, String author, String domainName) {
    setClassPath(classPath);
    setAuthor(author);
    setDoMainName(domainName);
  }
  
  @Override
  public String building() {
    StringBuilder sb = new StringBuilder();
    sb.append("package "+getClassPath()+".controller;\n\n");
    
    sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
    sb.append("import org.springframework.stereotype.Controller;\n");
    sb.append("import org.springframework.ui.ModelMap;\n");
    sb.append("import org.springframework.web.bind.annotation.ModelAttribute;\n");
    sb.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
    sb.append("import org.springframework.web.bind.annotation.RequestParam;\n");
    sb.append("import org.springframework.web.bind.annotation.ResponseBody;\n\n");
    
    sb.append("import com.tianque.base.vo.GridPage;\n");
    sb.append("import "+getClassPath()+".domain."+getUpperCaseDomainName()+";\n");
    sb.append("import "+getClassPath()+".service."+getUpperCaseDomainName()+"Service;\n");
    sb.append("import "+getClassPath()+".vo."+getUpperCaseDomainName()+"VO;\n\n");
    sb.append("/**\n");
    sb.append(" * "+getUpperCaseDomainName()+"Controller\n");
    sb.append(" * @author "+getAuthor()+"\n");
    sb.append(" * @date "+getDate()+"\n");
    sb.append(" */\n");
    sb.append("@Controller\n");
    sb.append("@RequestMapping(value = \"/"+getLowerCaseDomainName()+"\")\n");
    sb.append("public class "+getUpperCaseDomainName()+"Controller {\n\n");
    sb.append("\tprivate static final String LIST = \"list\";\n");
    sb.append("\tprivate static final String ADD = \"add\";\n");
    sb.append("\tprivate static final String UPDATE = \"update\";\n\n");
    
    sb.append("\t@Autowired\n");
    sb.append("\tprivate "+getUpperCaseDomainName()+"Service "+getLowerCaseDomainName()+"Service;\n\n");
    
    //add
    sb.append("\t@RequestMapping(value = \"/add"+getUpperCaseDomainName()+"\")\n");
    sb.append("\t@ResponseBody\n");
    sb.append("\tpublic "+getUpperCaseDomainName()+" add"+getUpperCaseDomainName()+"(@ModelAttribute "+getUpperCaseDomainName()+" "+getLowerCaseDomainName()+") {\n");
    sb.append("\t\treturn "+getLowerCaseDomainName()+"Service.add"+getUpperCaseDomainName()+"("+getLowerCaseDomainName()+");\n");
    sb.append("\t}\n\n");
    
    //update
    sb.append("\t@RequestMapping(value = \"/update"+getUpperCaseDomainName()+"\")\n");
    sb.append("\t@ResponseBody\n");
    sb.append("\tpublic "+getUpperCaseDomainName()+" update"+getUpperCaseDomainName()+"(@ModelAttribute "+getUpperCaseDomainName()+" "+getLowerCaseDomainName()+") {\n");
    sb.append("\t\treturn "+getLowerCaseDomainName()+"Service.update"+getUpperCaseDomainName()+"("+getLowerCaseDomainName()+");\n");
    sb.append("\t}\n\n");
    
    //dipatch
    sb.append("\t@RequestMapping(value = \"/dispatch\")\n");
    sb.append("\tpublic String dispatch(String mode, Long id, ModelMap modelMap) {\n");
    sb.append("\t\tif (ADD.equals(mode)) {\n");
    sb.append("\t\t//TODO 设置路径\n");
    sb.append("\t\treturn \"/"+getLowerCaseDomainName()+"/add"+getUpperCaseDomainName()+"Dlg\";\n");
    sb.append("\t}else if(UPDATE.equals(mode)) {\n");
    sb.append("\t\tmodelMap.put(\""+getLowerCaseDomainName()+"\", "+getLowerCaseDomainName()+"Service.get"+getUpperCaseDomainName()+"ById(id));\n");
    sb.append("\t\t//TODO 设置路径\n");
    sb.append("\t\treturn \"/"+getLowerCaseDomainName()+"/update"+getUpperCaseDomainName()+"Dlg\";\n");
    sb.append("\t}else if(LIST.equals(mode)) {\n");
    sb.append("\t\t//TODO 设置路径\n");
    sb.append("\t\treturn \"/"+getLowerCaseDomainName()+"/"+getLowerCaseDomainName()+"List\";\n");
    sb.append("\t}\n");
    sb.append("\t//TODO 设置路径\n");
    sb.append("\treturn \"/"+getLowerCaseDomainName()+"/add"+getUpperCaseDomainName()+"Dlg\";\n");
    sb.append("\t}\n\n");

//  deleteByIds
    sb.append("\t@RequestMapping(value = \"/delete"+getUpperCaseDomainName()+"ByIds\")\n");
    sb.append("\t@ResponseBody\n");
    sb.append("\tpublic Boolean delete"+getUpperCaseDomainName()+"ByIds(@RequestParam(value = \"ids[]\", required = true) Long[] ids) {\n");
    sb.append("\t\t"+getLowerCaseDomainName()+"Service.delete"+getUpperCaseDomainName()+"ByIds(ids);\n");
    sb.append("\t\treturn true;\n");
    sb.append("\t}\n\n");
    
//  findForPageHelper
    sb.append("\t@RequestMapping(value = \"/find"+getUpperCaseDomainName()+"List\")\n");
    sb.append("\t@ResponseBody\n");
    sb.append("\tpublic GridPage<"+getUpperCaseDomainName()+"VO> find"+getUpperCaseDomainName()+"List(\n");
    sb.append("\t\t\t@ModelAttribute "+getUpperCaseDomainName()+"VO "+getLowerCaseDomainName()+"VO) {\n");
    sb.append("\t\tGridPage<"+getUpperCaseDomainName()+"VO> gridPage = new GridPage<"+getUpperCaseDomainName()+"VO>(\n");
    sb.append("\t\t\t\t"+getLowerCaseDomainName()+"Service.find"+getUpperCaseDomainName()+"ForPageHelper("+getLowerCaseDomainName()+"VO));\n");
    sb.append("\t\treturn gridPage;\n");
    sb.append("\t}\n\n");
    sb.append("}\n");
    
    return sb.toString();
  }

}
