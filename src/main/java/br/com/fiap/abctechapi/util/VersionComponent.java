package br.com.fiap.abctechapi.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class VersionComponent {

    private final Properties properties;

    public VersionComponent() throws IOException {
        properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.yml");
        properties.load(inputStream);
    }

    public String getVersion(){
        return properties.get("build_name") + " - " + properties.get("build_version");
    }
}

