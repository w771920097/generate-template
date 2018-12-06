package generateplus.generater.impl;

import generateplus.generater.AbstractGenerater;

public class DialogModeGenerater extends AbstractGenerater {

	@Override
	protected void setBasicData() {
		basicData.setFolderName("constant");
		basicData.setSuffix("DialogMode.java");
	}

	@Override
	protected String building() {

		StringBuilder sb = new StringBuilder();
		sb.append("package "+basicData.getClassPath()+"."+basicData.getFolderName()+";\n");
		sb.append("\n");
		sb.append("public interface DialogMode {\n");
		sb.append("\t\n");
		sb.append("\tString ADD = \"add\";\n");
		sb.append("\tString EDIT = \"edit\";\n");
		sb.append("\tString VIEW = \"view\";\n");
		sb.append("\tString SEARCH = \"search\";\n");
		sb.append("}\n");
		
		return sb.toString();
	}

}
