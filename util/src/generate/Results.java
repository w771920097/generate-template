package generate;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Results
 * @author wangsihong@hztianque.com
 * @date 2018��10��26�� ����4:08:41 
 *
 */
public class Results {

  public static void main(String[] args) {
    String filePath = "C:\\Users\\n-340\\Desktop\\";
    String author = "wangsihong@hztianque.com";
    String classPath = "com.tianque.monitor.metric";
    String tableName = "zk_metric_test";
    String domainName = "metricTest";
    Map<String, String> columnsMap = new LinkedHashMap<String, String>(){
      
      private static final long serialVersionUID = 904293757682197882L;

      {
        //columns    type
        put("id", "Long");
        put("project_type", "String");
        put("metric", "String");
        put("tags", "String");
        put("value", "Double");
        put("cycle", "Long");
        put("project_id", "Long");
        put("collect_timestamp", "Long");
        put("collect_time", "Date");
        put("create_date", "Date");
        put("update_date", "Date");
      }
    };
    String str = null;
    XmlMapperGenerater xmlMapperGenerater = new XmlMapperGenerater(classPath, columnsMap, tableName, domainName);
    str = xmlMapperGenerater.build();
    Util.generateFiles(str, filePath + xmlMapperGenerater.getUpperCaseDomainName() + "Mapper.xml");
    
    JavaMapperGenerater javaMapperGenerater = new JavaMapperGenerater(domainName, classPath, author);
    str = javaMapperGenerater.build();
    Util.generateFiles(str, filePath + javaMapperGenerater.getUpperCaseDomainName() + "Mapper.java");
    
    ServiceImplGenerater serviceImplGenerater = new ServiceImplGenerater(classPath, domainName, author);
    str = serviceImplGenerater.build();
    Util.generateFiles(str, filePath + serviceImplGenerater.getUpperCaseDomainName() + "ServiceImpl.java");
    
    ServcieGenerater servcieGenerater = new ServcieGenerater(classPath, author, domainName);
    str = servcieGenerater.build();
    Util.generateFiles(str, filePath + servcieGenerater.getUpperCaseDomainName() + "Service.java");
    
    DomainGenerater domainGenerater = new DomainGenerater(classPath, author, domainName, columnsMap); 
    str = domainGenerater.build();
    Util.generateFiles(str, filePath + domainGenerater.getUpperCaseDomainName() + ".java");
    
    VoGenerater voGenerater = new VoGenerater(classPath, domainName, author);
    str = voGenerater.build();
    Util.generateFiles(str, filePath + voGenerater.getUpperCaseDomainName() + "VO.java");
    
    ControllerGenerater controllerGenerater = new ControllerGenerater(classPath, author, domainName);
    str = controllerGenerater.build();
    Util.generateFiles(str, filePath + controllerGenerater.getUpperCaseDomainName()+"Controller.java");
    System.out.println(str);
    

  }
}
