package generateplus.generater.impl;

import generateplus.generater.AbstractGenerater;

public class DomainValidatorGenerater extends AbstractGenerater {

	@Override
	protected void setBasicData() {
		basicData.setFolderName("validate");
		basicData.setSuffix("DomainValidator.java");
	}

	@Override
	protected String building() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("package "+basicData.getClassPath()+"."+basicData.getFolderName()+";\n");
		sb.append("\n");
		sb.append("public interface DomainValidator<T> {\n");
		sb.append("\tpublic ValidateResult validate(Integer mode, T domain);\n");
		sb.append("\t\n");
		sb.append("}\n");

		return sb.toString();
	}

}
