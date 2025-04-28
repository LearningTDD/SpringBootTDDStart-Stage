package test.commerce;

import java.sql.Connection;
import java.util.Properties;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import static java.sql.DriverManager.getConnection;

public class CheckDatabaseConnection implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        Properties properties = loadProperties();

        String url = properties.getProperty("spring.datasource.url");
        String username = properties.getProperty("spring.datasource.username");
        String password = properties.getProperty("spring.datasource.password");

        try {
            Connection connection = getConnection(url, username, password);
            connection.close();
        } catch (Exception exception) {
            throw new RuntimeException("Cannot connect to " + url);
        }
    }

    private Properties loadProperties() {
        var yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application.yaml"));
        return yaml.getObject();
    }
}
