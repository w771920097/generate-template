package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadFile {
	
	
	public static void readForTemplate() {
//		  dlg.txt
			String filePath = "C:\\Users\\n-340\\Desktop\\ApplicationManagementController.java"; //读取的文件夹路径  
	        try {  
	        	//输出的文件夹路径
//	        	FileWriter fw = new FileWriter("C:\\Users\\n-340\\Desktop\\112.txt", true);
//	            BufferedWriter bw = new BufferedWriter(fw);
	            try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8")))//数据流读取文件  
	            {  
	                String temp = null;  
	                while ((temp = bufReader.readLine()) != null) {
	                	temp = temp.replace("\"", "\\\"").replace("\t", "\\t").replace("    ", "\\t");
	                	temp = temp + "\\n";
	                	temp = "\t\tsb.append(\"" + temp + "\");";
	                	System.out.println(temp);
	                }  
	                bufReader.close();
//		            bw.close();
//		            fw.close();
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
		
	}

}
