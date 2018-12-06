package generateplus.generater.impl;

import generateplus.generater.AbstractGenerater;

public class ValidateResultGenerater extends AbstractGenerater {

	@Override
	protected void setBasicData() {
		basicData.setFolderName("validate");
		basicData.setSuffix("ValidateResult.java");
	}

	@Override
	protected String building() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("package "+basicData.getClassPath()+"."+ basicData.getFolderName()+";\n");
		sb.append("\n");
		sb.append("import java.io.Serializable;\n");
		sb.append("import java.util.ArrayList;\n");
		sb.append("import java.util.List;\n");
		sb.append("\n");
		sb.append("public class ValidateResult implements Serializable {\n");
		sb.append("\n");
		sb.append("\t//设置serialVersionUID\n");
		sb.append("\t\n");
		sb.append("\tprivate static final String EMPTY_MESSAGE = \"\";\n");
		sb.append("\tprivate static final String DEFAULT_MSG_SEPERATOR = \"\\n\";\n");
		sb.append("\tprivate List<String> messages = new ArrayList<String>();\n");
		sb.append("\n");
		sb.append("\tpublic void addErrorMessage(String msg) {\n");
		sb.append("\t\tthis.messages.add(msg);\n");
		sb.append("\t}\n");
		sb.append("\t\n");
		sb.append("\tpublic boolean hasError() {\n");
		sb.append("\t\treturn messages.size() > 0;\n");
		sb.append("\t}\n");
		sb.append("\t\n");
		sb.append("\tpublic String getErrorMessages() {\n");
		sb.append("\t\tif (!hasError()) {\n");
		sb.append("\t\t\treturn EMPTY_MESSAGE;\n");
		sb.append("\t\t}\n");
		sb.append("\t\tStringBuilder sb = new StringBuilder();\n");
		sb.append("\t\tfor (String message : messages) {\n");
		sb.append("\t\t\tsb.append(message);\n");
		sb.append("\t\t\tsb.append(DEFAULT_MSG_SEPERATOR);\n");
		sb.append("\t\t}\n");
		sb.append("\t\treturn sb.toString();\n");
		sb.append("\t}\n");
		sb.append("}\n");

		return sb.toString();
	}

}
