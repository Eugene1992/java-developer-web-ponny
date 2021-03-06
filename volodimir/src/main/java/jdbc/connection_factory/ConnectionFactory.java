package jdbc.connection_factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
    private static Connection connection;
    private static Properties configProperties;

    private static final String HEROKU_DB_PROPERTIES_FILE_PASS = "heroku_db.properties";

    private static final String DRIVER = "driver";

    private static final String URL = "url";

    private static final String USERNAME = "username";

    private static final String PASSWORD = "password";

//    private static final String HEROKU_DB_PROPERTIES_FILE_PASS = "heroku_db.properties",
//            DRIVER = "driver",
//            URL = "url",
//            USERNAME = "username",
//            PASSWORD = "password";

    static {
        configProperties = new Properties();
        try {
            configProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(HEROKU_DB_PROPERTIES_FILE_PASS));
            Class.forName(configProperties.getProperty(DRIVER));
            connection = DriverManager.getConnection(
                    configProperties.getProperty(URL),
                    configProperties.getProperty(USERNAME),
                    configProperties.getProperty(PASSWORD)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    private ConnectionFactory() {
    }
}
