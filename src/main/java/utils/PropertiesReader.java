package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
        private static PropertiesReader instance = null;
        private static String dirName = "src/main/resources/config.properties";
        private final Properties properties;

        public PropertiesReader (String _dirName){
            properties = new Properties();
            dirName = _dirName;
            try {
                InputStream inputstream = new FileInputStream(dirName);
                properties.load(inputstream);
            } catch (IOException e){
                e.printStackTrace();
                throw new IllegalArgumentException(String.format("The file with relative path '%s' is not found", dirName));
            }
        }
        public static synchronized PropertiesReader getInstance(){
            if(instance==null){
                instance = new PropertiesReader(dirName);
            }
            return instance;
        }
        public static synchronized PropertiesReader getInstance(String _dirName){
            if(instance==null){
                instance = new PropertiesReader(_dirName);
            }
            return instance;
        }
        public String getValue(String key){
            return this.properties.getProperty(key, String.format("The key %s does not exists!", key));
        }
    }
