package generateplus.generater.impl;

import generateplus.generater.AbstractGenerater;

public class DomainNameValidatorGenerater extends AbstractGenerater {

	@Override
	protected void setBasicData() {
		basicData.setFolderName("validate");
		basicData.setSuffix("DomainNameValidator.java");
	}

	//TODO
	@Override
	protected String building() {
		StringBuilder sb = new StringBuilder();

		sb.append("package "+basicData.getClassPath()+"."+basicData.getFolderName()+";\n");
		sb.append("\n");
		sb.append("import org.springframework.stereotype.Component;\n");
		sb.append("\n");
		sb.append("import com.tianque.core.base.util.StringUtil;\n");
		sb.append("import "+basicData.getClassPath()+".domain."+basicData.getUpperCaseDomainName()+";\n");
		sb.append("\n");
		sb.append("@Component(\""+basicData.getLowerCaseDomainName()+"Validator\")\n");
		sb.append("public class "+basicData.getUpperCaseDomainName()+"Validator implements DomainValidator<"+basicData.getUpperCaseDomainName()+"> {\n");
		sb.append("\n");
		sb.append("\t@Override\n");
		sb.append("\tpublic ValidateResult validate("+basicData.getUpperCaseDomainName()+" "+basicData.getLowerCaseDomainName()+", Integer validateMode) {\n");
		sb.append("\t\t\n");
		
		sb.append("\t\tValidateResult result = new ValidateResult();\n");
		sb.append("\t\tif ("+basicData.getLowerCaseDomainName()+" == null) {\n");
		sb.append("\t\t\tresult.addErrorMessage(\"请输入机器信息\");\n");
		sb.append("\t\t\treturn result;\n");
		sb.append("\t\t}\n");
		sb.append("\t\tif (validateMode == 1) {\n");
		sb.append("\t\t\t\n");
		sb.append("\t\t}\n");
		sb.append("\t\tif (StringUtil.isEmpty(machine.getIp())) {\n");
		sb.append("\t\t\tresult.addErrorMessage(\"请输入ip地址\");\n");
		sb.append("\t\t}\n");
		sb.append("\t\tif (StringUtil.isEmpty(machine.getName())) {\n");
		sb.append("\t\t\tresult.addErrorMessage(\"请输入机器名称\");\n");
		sb.append("\t\t}\n");
		sb.append("\t\tif (machine.getUsable() == null) {\n");
		sb.append("\t\t\tmachine.setUsable(false);\n");
		sb.append("\t\t}\n");
		sb.append("\t\treturn result;\n");
		sb.append("\t}\n");
		sb.append("}\n");

		return sb.toString();
	}

}
