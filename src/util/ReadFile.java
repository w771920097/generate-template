package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadFile {

  public static void main(String[] args) {
    String filePath = "C:\\Users\\Administrator\\Desktop\\AuthenticationInfoService.java"; // 读取的文件夹路径
    readForTemplate(filePath);
  }

  public static void readForTemplate(String filePath) {
    // dlg.txt
    try {
      // 输出的文件夹路径
      // FileWriter fw = new FileWriter("C:\\Users\\n-340\\Desktop\\112.txt", true);
      // BufferedWriter bw = new BufferedWriter(fw);
      try (BufferedReader bufReader =
          new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8")))// 数据流读取文件
      {
        String temp = null;
        while ((temp = bufReader.readLine()) != null) {
          temp = temp.replace("\"", "\\\"").replace("\t", "\\t").replace("    ", "\\t");
          temp = temp + "\\n";
          temp = "\t\tsb.append(\"" + temp + "\");";
          System.out.println(temp);
        }
        bufReader.close();
        // bw.close();
        // fw.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }


}
