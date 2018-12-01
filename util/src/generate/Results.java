package generate;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Results
 * @author wangsihong@hztianque.com
 * @date 2018年10月26日 下午1:44:21 
 *
 */
public class Results {

  public static void main(String[] args) {
    
    //E:\\tq-alicloud-omp-mysql-delivery\\src\\main\\java\\com\\tianque\\ome\\application
    //C:\\Users\\n-340\\Desktop\\businessLine\\
    String filePath = "C:\\Users\\Administrator\\Desktop\\jobState";
//    String filePath = "E:\\tq-alicloud-omp-mysql-delivery\\src\\main\\java\\com\\tianque\\ome\\application";
//    String jspPath ="E:\\tq-alicloud-omp-mysql-delivery\\src\\main\\webapp";
    String jspPath ="C:\\Users\\Administrator\\Desktop\\jobState";
    String author = "wangsihong@hztianque.com";
    String classPath = "com.tianque.ome";
    //zk_custom_info    deploy_sys_
    
    String tableName = "deploy_config_job";
    String domainName = "jobState";
    String domainCname = "任务状态";
    Map<String, String> columnsMap = new LinkedHashMap<String, String>(){
      
      
      private static final long serialVersionUID = 904293757682197882L;

      {
        //columns    type
          put("id", "Long");
          put("job_id", "Long");
          put("create_date", "Date");
          put("update_date", "Date");
          put("has_been_reset", "Integer");
        
      }
    };
    
    /*String filePath = PropertiesLoad.get("filePath");
    String author = PropertiesLoad.get("author");
    String classPath = PropertiesLoad.get("classPath");
    String tableName = PropertiesLoad.get("tableName");
    String domainName = PropertiesLoad.get("domainName");
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
    };*/
    
    jspPath = jspPath + File.separator;
    filePath = filePath + File.separator;
    
    String str = null;
    XmlMapperGenerater xmlMapperGenerater = new XmlMapperGenerater(classPath, columnsMap, tableName, domainName);
    str = xmlMapperGenerater.build();
    String path = filePath + "mapper" +File.separator;
    generaterPath(path);
    Util.generateFiles(str, path + xmlMapperGenerater.getUpperCaseDomainName() + "Mapper.xml");
    
    JavaMapperGenerater javaMapperGenerater = new JavaMapperGenerater(domainName, classPath, author);
    str = javaMapperGenerater.build();
    path = filePath + "mapper" +File.separator;
    generaterPath(path);
    Util.generateFiles(str, path + javaMapperGenerater.getUpperCaseDomainName() + "Mapper.java");
    
    ServiceImplGenerater serviceImplGenerater = new ServiceImplGenerater(classPath, domainName, author, domainCname);
    str = serviceImplGenerater.build();
    path = filePath + "service" +File.separator + "impl" +File.separator;
    generaterPath(path);
    Util.generateFiles(str, path + serviceImplGenerater.getUpperCaseDomainName() + "ServiceImpl.java");
    
    ServcieGenerater servcieGenerater = new ServcieGenerater(classPath, author, domainName);
    str = servcieGenerater.build();
    path = filePath + "service" +File.separator;
    generaterPath(path);
    Util.generateFiles(str, path + servcieGenerater.getUpperCaseDomainName() + "Service.java");
    
    DomainGenerater domainGenerater = new DomainGenerater(classPath, author, domainName, columnsMap); 
    str = domainGenerater.build();
    path = filePath + "domain" +File.separator;
    generaterPath(path);
    Util.generateFiles(str, path + domainGenerater.getUpperCaseDomainName() + ".java");
    
    VoGenerater voGenerater = new VoGenerater(classPath, domainName, author);
    str = voGenerater.build();
    path = filePath + "vo" +File.separator;
    generaterPath(path);
    Util.generateFiles(str, path + voGenerater.getUpperCaseDomainName() + "VO.java");
    
    ControllerGenerater controllerGenerater = new ControllerGenerater(classPath, author, domainName);
    str = controllerGenerater.build();
    path = filePath + "controller" +File.separator;
    generaterPath(path);
    Util.generateFiles(str, path + controllerGenerater.getUpperCaseDomainName()+"Controller.java");
    
    ListJspGenerater ListJspGenerater = new ListJspGenerater(domainName, domainCname, columnsMap);
    str = ListJspGenerater.build();
    //jspPath
    path = jspPath + ListJspGenerater.getDoMainName() +File.separator;
    generaterPath(path);
    Util.generateFiles(str, path + ListJspGenerater.getDoMainName()+"List.jsp");
    
    
    //DlgJspGenerater
    DlgJspGenerater dlgJspGenerater = new DlgJspGenerater(domainName, domainCname, columnsMap);
    str = dlgJspGenerater.build();
    path = jspPath + dlgJspGenerater.getDoMainName() +File.separator;
    generaterPath(path);
    Util.generateFiles(str, path + dlgJspGenerater.getDoMainName()+"Dlg.jsp");
    
    System.out.println("输出路径> " + filePath);
    

  }

  private static void generaterPath(String path) {
    File file = new File(path);
    if (!file.exists()){
      file.mkdirs();
    }
  }
  
  
}
