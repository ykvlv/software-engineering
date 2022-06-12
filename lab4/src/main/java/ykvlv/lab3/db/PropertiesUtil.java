package ykvlv.lab3.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private PropertiesUtil() { }

    private static void loadProperties() {
        try (InputStream inputStream = PropertiesUtil.class
                .getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("Необходимо инициализировать файл application.properties. Воспользуйтесь application.properties.example", e);
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
