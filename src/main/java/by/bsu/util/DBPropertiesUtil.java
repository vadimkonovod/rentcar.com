package by.bsu.util;

import java.io.IOException;
import java.util.Properties;

public class DBPropertiesUtil {

    public static final String DB_PROPERTIES = "db.properties";
private static DBPropertiesUtil instance = new DBPropertiesUtil();
private Properties prop;

    private DBPropertiesUtil() {
        prop = new Properties();
        try {
            prop.load(DBPropertiesUtil.class.getClassLoader()
                    .getResourceAsStream(
                            DB_PROPERTIES));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static DBPropertiesUtil getInstance() {
        return instance;
    }

    public String getPropByName(String name) {
        return prop.getProperty(name);
    }
}
