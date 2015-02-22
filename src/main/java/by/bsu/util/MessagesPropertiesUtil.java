package by.bsu.util;

import java.io.IOException;
import java.util.Properties;

public class MessagesPropertiesUtil {

    public static final String MESSAGES_PROPERTIES = "messages.properties";
    private static MessagesPropertiesUtil instance = new MessagesPropertiesUtil();
    private Properties prop;

    private MessagesPropertiesUtil() {
        prop = new Properties();
        try {
            prop.load(MessagesPropertiesUtil.class.getClassLoader()
                    .getResourceAsStream(
                            MESSAGES_PROPERTIES));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static MessagesPropertiesUtil getInstance() {
        return instance;
    }

    public String getPropByName(String name) {
        return prop.getProperty(name);
    }
}
