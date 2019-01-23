package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


public class PropertiesLoad {

  private static Properties properties = new Properties();

  public static String get(String key) {
    if (properties.isEmpty()) {
      try {
        File propertiesFile = new File(System.getProperty("user.dir") + File.separator + "env"
            + File.separator + "generate.properties");
        InputStream in = new FileInputStream(propertiesFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        properties.load(br);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
    return getKey(key);
  }

  private static String getKey(String key) {
    // String result = properties.getProperty(key);
    // String byte1 = new String(result,"UTF-8");
    return properties.getProperty(key);
  }

}
