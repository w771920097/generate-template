package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesLoader {
  
  
  public static void main(String[] args) {
    String a = PropertiesLoader.get("a");
    System.out.println("a" + a);
  }
    private static Properties properties = new Properties();

    public static String get(String key) {
        if (properties.isEmpty()) {
            try {
                File propertiesFile = new File(System.getProperty("user.dir")+File.separator+"env/generate.properties");
                InputStream in = new FileInputStream(propertiesFile);
                properties.load(in);
            } catch (FileNotFoundException e) {
              e.printStackTrace();
            } catch (IOException e) {
              e.printStackTrace();
            }

        }
        return properties.getProperty(key);
    }
}
