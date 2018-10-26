package generate;

import java.util.HashMap;
import java.util.Map;

/**
 * Results
 * @author wangsihong@hztianque.com
 * @date 2018年10月26日 下午4:08:41 
 *
 */
public class Results {

  public static void main(String[] args) {
    String filePath = "C:\\Users\\n-340\\Desktop\\";
    String author = "wangsihong@hztianque.com";
    String classPath = "com.tianque.tqkeeper.custom";
    String tableName = "zk_custom_info";
    String domainName = "customInfo";
    Map<String, String> columnsMap = new HashMap<String, String>(){
      
      private static final long serialVersionUID = 904293757682197882L;

      {
        //columns    type
        put("id", "Long");
//        put("monitor_type", "String");
        put("ename", "String");
        put("cname", "String");
        put("remark", "String");
//        put("display", "String");
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
